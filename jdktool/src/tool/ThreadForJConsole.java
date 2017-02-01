package tool;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
  
public class ThreadForJConsole {  
  
    /** 
     * �߳���ѭ�� 
     */  
    public static void createBusyThread() {  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                // Runnable״̬���̻߳ᱻ��������ʱ�䣬����û�й黹�߳�ִ�����ƵĶ�����  
                // ���ڿ�ѭ�����þ�ȫ��ִ��ʱ��ֱ���߳��л������ֵȴ������ĺܶ��CPU��Դ��  
                while (true);  
            }  
        }, "testBusyThread").start();  
    }  
    /** 
     * �߳����ȴ���ʾ
     */  
    public static void createLockThread(final Object lock) {  
        Thread thread = new Thread(new Runnable() {  
            @Override  
            public void run() {  
            	synchronized(lock){
	            	try {  
	                    // Runnable״̬���߳��ڵȴ���lock�����notify��notifyAll�����ĳ��֣�  
	                    // �߳���ʱ����WAITING״̬���ڱ�����ǰ���ᱻ����ִ��ʱ�䡣  
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
  
        // Runnable״̬���̻߳ᱻ��������ʱ�䣬��readBytes������鵽��û�и���ʱ�����̹黹ִ�����ƣ�  
        // ���ֵȴ�ֻ���ĺ�С��CPU��Դ��  
        br.readLine();  
        createBusyThread();  
  
        br.readLine();  
        createLockThread(new Object());  
    }  
}  

//��ջ׷�ٿ��Կ���BufferedReader��readBytes�����еȴ�System.in�����루��main�߳����Ҳ���Կ�����״̬����runnable��