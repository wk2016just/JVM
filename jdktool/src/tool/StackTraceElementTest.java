package tool;

import java.util.Map;

public class StackTraceElementTest {  
    
    public static void main(String [] args) {  
        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {  
            Thread thread = stackTrace.getKey();  
            StackTraceElement [] stackTraceElements = stackTrace.getValue();  
  
            if (thread.equals(Thread.currentThread())) {  
                continue;  
            }  
  
            System.out.println("Ïß³Ì£º" + thread.getName());  
            for(StackTraceElement element : stackTraceElements) {  
                System.out.println("\t" + element);  
            }  
        }  
    }  
}  