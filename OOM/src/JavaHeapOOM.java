import java.util.ArrayList;
import java.util.List;

//-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
public class JavaHeapOOM {
	
	static class OOMObject{
		
	}
	
	public static void main(String[] args){
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
//phrof文件过大，所以只保存了一章截图
/*运行结果
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid37084.hprof ...
Heap dump file created [27952882 bytes in 0.088 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Unknown Source)
	at java.util.Arrays.copyOf(Unknown Source)
	at java.util.ArrayList.grow(Unknown Source)
	at java.util.ArrayList.ensureExplicitCapacity(Unknown Source)
	at java.util.ArrayList.ensureCapacityInternal(Unknown Source)
	at java.util.ArrayList.add(Unknown Source)
	at JavaHeapOOM.main(JavaHeapOOM.java:14)


MAT快照分析:见HEAPOOM.PNG
Shortest Paths To the Accumulation Point



Class Name

Shallow Heap

Retained Heap


java.lang.Object[810325] @ 0xff183100
 3,241,320 16,206,520 
+<Java Local> java.lang.Thread @ 0xff875378 Thread
 120 16,207,184 
+elementData java.util.ArrayList @ 0xff823c38 »
 24 24 
\Total: 2 entries
   

 Accumulated Objects



Class Name

Shallow Heap

Retained Heap

Percentage


java.lang.Thread @ 0xff875378
 120 16,207,184 97.38% 
\java.lang.Object[810325] @ 0xff183100
 3,241,320 16,206,520 97.37% 
.+JavaHeapOOM$OOMObject @ 0xfec18c00
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c10
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c20
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c30
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c40
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c50
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c60
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c70
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c80
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18c90
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18ca0
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18cb0
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18cc0
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18cd0
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18ce0
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18cf0
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18d00
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18d10
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18d20
 16 16 0.00% 
.+JavaHeapOOM$OOMObject @ 0xfec18d30
 16 16 0.00% 
.\Total: 20 entries
 320 320 0 

 Accumulated Objects by Class



Label

Number of Objects

Used Heap Size

Retained Heap Size


JavaHeapOOM$OOMObject
First 10 of 810,325 objects 810,325 12,965,200 12,965,200 


*/