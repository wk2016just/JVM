package tool;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
  
public class ThreadForJConsole {  
  
    /** 
     * 线程死循环 
     */  
    public static void createBusyThread() {  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                // Runnable状态的线程会被分配运行时间，而且没有归还线程执行令牌的动作，  
                // 会在空循环上用尽全部执行时间直到线程切换，这种等待会消耗很多的CPU资源。  
                while (true);  
            }  
        }, "testBusyThread").start();  
    }  
    /** 
     * 线程锁等待演示
     */  
    public static void createLockThread(final Object lock) {  
        Thread thread = new Thread(new Runnable() {  
            @Override  
            public void run() {  
            	synchronized(lock){
	            	try {  
	                    // Runnable状态的线程在等待着lock对象的notify或notifyAll方法的出现，  
	                    // 线程这时候处于WAITING状态，在被唤醒前不会被分配执行时间。  
	                    lock.wait();  
	                } catch (InterruptedException e) {  
	                    e.printStackTrace();  
	                }  
            	}
            }  
        }, "testLockThread");
        thread.start();  
    }  
  
    public static void main(String [] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
  
        // Runnable状态的线程会被分配运行时间，但readBytes方法检查到流没有更新时会立刻归还执行令牌，  
        // 这种等待只消耗很小的CPU资源。  
        br.readLine();  
        createBusyThread();  
  
        br.readLine();  
        createLockThread(new Object());  
    }  
}  

//堆栈追踪可以看到BufferedReader在readBytes方法中等待System.in的输入（在main线程栏右侧可以看到，状态还是runnable）