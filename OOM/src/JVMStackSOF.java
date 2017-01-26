
public class JVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JVMStackSOF obj = new JVMStackSOF();
		try{
			obj.stackLeak();
		}catch(Throwable e){
			System.out.println("stacklength:"+obj.stackLength);
			throw e;
		}
	}
}

//local为2，包含this和stackLength值，max_stack为1，仅仅为stacklength操作，
//这里栈帧不断压入stackLeak。可以看出由于因为hotspot把两个栈合二为一，
//对于hotspot，-Xoss参数无效，栈容量只有-Xss设定.
//单线程下，无论是栈帧太大还是栈容量小，都抛出SOF异常

/*运行结果
 * Exception in thread "main" stacklength:994
java.lang.StackOverflowError
	at JVMStackSOF.stackLeak(JVMStackSOF.java:7)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
 */