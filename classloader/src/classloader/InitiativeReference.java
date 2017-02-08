package classloader;
//主动引用五种情形部分例子
public class InitiativeReference {
	
	public static void main(String[] args) throws Exception {  
		//使用java.lang.reflect包的方法对类进行反射调用
		Class<?> classB = Class.forName("classloader.ReflectClass"); 
		//类初始化的时候，如果发现其父类还没有初始化，则需要先对其父类进行初始化。
		new SubClass();  
	}  
}


class ReflectClass {  
    
    static {  
        System.out.println("ReflectClass init!\n");  
    }  
  
}  

class SuperClass {  
    
    static {  
        System.out.println("SuperClass init!");  
    }  
      
    public static int value = 123;  
  
}  

class SubClass extends SuperClass {  
    
    static {  
        System.out.println("SubClass init!");  
    }  
  
}  