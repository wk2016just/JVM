package gc;
//-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
public class TenuredBigObject {
	public static void main(String[] args){
		byte[] allocation1;
		allocation1 = new byte[4 * 1024 * 1024]; 
	}
}

//需注意的是：此参数只对serial和Parnew两款收集器有效。
//然而结果却不是大对象直接进入，说明现在gc机制有改，且完全的移除永久代，JDK 8.HotSpot JVM开始使用本地化的内存存放类的元数据，这个空间叫做元空间
