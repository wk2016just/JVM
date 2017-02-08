package classloader;

import java.util.Date;

class A {  
    static{  
        System.out.println(Thread.currentThread().getName()  
                +" "+new Date());  
        try {  
            Thread.sleep(5000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}  

class T implements Runnable {  
    public void run() {  
        A a = new A();  
        System.out.println(Thread.currentThread().getName()  
                +" "+new Date());  
    }  
}       

public class FieldAnalyze {
//ֻ��һ���߳�ִ����A���о�̬�����еĴ���,<clinit>�Ķ��߳�����
    public static void main(String[] args){  
        T t1 = new T();  
        T t2 = new T();  
        Thread thread1 = new Thread(t1);  
        Thread thread2 = new Thread(t2);  
        thread1.start();  
        thread2.start();  
    }  
    
}
