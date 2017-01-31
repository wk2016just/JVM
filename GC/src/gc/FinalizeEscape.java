package gc;

public class FinalizeEscape {  
	//判定对象需要执行finalize（）方法则会加入F-Queue队列，线程Finalizer处理；（但不会等待他执行完）
	//不需要执行情况是没有覆盖finalize或执行过finalize了。
	//第一次gc时候已经没有引用指向此对象了，但是对象自己把自己的this指针（地址）赋给类静态对象量，成功自救。
	//第二次已经执行过所以不会
	
    public static FinalizeEscape SAVE_HOOK = null;  
  
    @Override  
    protected void finalize() throws Throwable {  
        super.finalize();  
        System.out.println("finalize method invoke");  
        SAVE_HOOK = this;  
    }  
      
    public static void main(String[] args) throws Exception {  
    	SAVE_HOOK = new FinalizeEscape();  
          
    	SAVE_HOOK = null;  
        System.gc();  
        Thread.sleep(500);  
        if(SAVE_HOOK != null)  
            System.out.println("i am alive");  
        else   
            System.out.println("i am dead");  
          
        SAVE_HOOK = null;  
        System.gc();  
        Thread.sleep(500);  
        if(SAVE_HOOK != null)  
            System.out.println("i am alive");  
        else   
            System.out.println("i am dead");  
    }  
}  


