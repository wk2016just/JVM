package classloader;
//通过子类引用父类的的静态字段，不会导致子类初始化
//class文件的字段表本类不包含父类和超类的字段
class SuperClass1 {  
      
	public static int value = 123; 
	
    static {  
        System.out.println("SuperClass init!");  
    }  
}  

class SubClass1 extends SuperClass {  
      
    static {  
        System.out.println("SubClass init!");  
        }  
 }  

public class NotInitialization1 {  
      
    public static void main(String[] args) {  
        int x = SubClass1.value;  
    }  
  
}  
 

