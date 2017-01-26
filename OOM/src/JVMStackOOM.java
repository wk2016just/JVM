
public class JVMStackOOM {
	
	private void dontStop(){
		while(true){}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable(){
				public void run(){
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) throws Throwable{
		JVMStackOOM jso = new JVMStackOOM();
		jso.stackLeakByThread();
	}
}

//-Xss216k
//多线程利用无限创建线程造成OOM异常，因为jvm以栈帧为单位保存线程的运行状态。每当启动一个新线程的时候,
//java虚拟机都会为它分配一个java栈。虚拟机只会对java栈执行两种操作：
//以栈帧为单位的压栈或者出栈。也就是说个数由线程的上线决定。
//还有就是栈帧由三部分组成的，局部变量区，操作数栈和帧数据区。 局部变量区和操作数栈要视对应的方法而定，
//它们是按照字长计算的。