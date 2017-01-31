package gc;
//-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
public class TeuringThreshold {
	 private static final int _1MB = 1024 * 1024;

     @SuppressWarnings("unused")
     public static void main(String[] args){
     	byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
     	allocation1 = new byte[ _1MB/4];
     	allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
	 }
}

/*allocation1，allocation2被优先分配到eden区中，此时eden区为256k+4m，allocation3申请内存不够（因为eden区一共8m此时有了allocation1和2所以放不进去，而survivor区只有1m不够放---所以eden区和survivor区不能连用！），触发Minor GC，

allocation1 被移入Survivor中（所以见书，先是利用copying算法复制到survivor！不是直接就去老年代），内存还不够allocation2移入老年代(minorgc过程是这样；根据copying算法首先把对方放入to survivor区.如果不够则放入老年代、所以在第一次eden优先分配时因为都放不入survivor所以只能放入老年代.但这个例子中allocation1是可以放入的)
（将allocation3置为null.并不会触发gc。局部变量表的引用消失但是java堆依然有4M的allocation3的对象所以之后继续allocation3=4MB。在gc时候内存的容量会变成从8M至4m.回收了之前取消引用的allocation3的堆对象）allocation3再次申请内存，allocation1会被移入老年代
最终新生代为allocation3  老年代为allocation1，allocation2 */

//Heap
//PSYoungGen      total 9216K, used 5500K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
// eden space 8192K, 67% used [0x00000000ff600000,0x00000000ffb5f098,0x00000000ffe00000)
// from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
// to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
//ParOldGen       total 10240K, used 8192K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
// object space 10240K, 80% used [0x00000000fec00000,0x00000000ff400020,0x00000000ff600000)
//Metaspace       used 2592K, capacity 4486K, committed 4864K, reserved 1056768K
// class space    used 288K, capacity 386K, committed 512K, reserved 1048576K
