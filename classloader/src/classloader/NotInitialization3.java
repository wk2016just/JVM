package classloader;
//常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
class ConstClass {  
    
    static {  
        System.out.println("ConstClass init!");  
    }  
      
    //编译阶段常量的传播优化：final常量与文本字符串直接存入NotInitialization类常量池，对ConstClass.HELLOWORLD的引用
    //转化为了NotInitialization类对自身常量池的引用，其class文件中并没有了ConstClass类的符号引用入口
    public static final int value = 123;  
  
}  

public class NotInitialization3 {  
      
    public static void main(String[] args) {  
        int x = ConstClass.value;  
    }  
  
}  
