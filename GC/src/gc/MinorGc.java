package gc;
//-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
public class MinorGc {

	public static void main(String[] args){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 = new byte[2 * 1024 * 1024]; //2*1MB
		allocation2 = new byte[2 * 1024 * 1024];
		allocation3 = new byte[2 * 1024 * 1024];
		allocation3 = null;
		allocation4 = new byte[2 * 1024 * 1024];
	}
}
/*-Xms -Xmx限制java堆，-Xmn分配给新生代，剩下分配老年代。
-XX:SurvivorRatio 决定了新生代中eden和survivor比例
结果4M进入老年代，6M进入DefNew区
分配a4之前发生minorgc：可以看出monorgc发生时，从7127k（6m）变为4864k（6m），
也能推断出来这是在老年代分配了4m，然后新的a4直接分配进eden
同时验证了null的作用！
 * 
*/

//[GC (Allocation Failure) [PSYoungGen: 7127K->760K(9216K)] 7127K->4864K(19456K), 0.0045266 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
//Heap
// PSYoungGen      total 9216K, used 2890K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
//  eden space 8192K, 26% used [0x00000000ff600000,0x00000000ff814930,0x00000000ffe00000)
//  from space 1024K, 74% used [0x00000000ffe00000,0x00000000ffebe030,0x00000000fff00000)
//  to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
// ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
//  object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
// Metaspace       used 2592K, capacity 4486K, committed 4864K, reserved 1056768K
//  class space    used 288K, capacity 386K, committed 512K, reserved 1048576K