package classloader;
//���������������β�������
public class InitiativeReference {
	
	public static void main(String[] args) throws Exception {  
		//ʹ��java.lang.reflect���ķ���������з������
		Class<?> classB = Class.forName("classloader.ReflectClass"); 
		//���ʼ����ʱ����������丸�໹û�г�ʼ��������Ҫ�ȶ��丸����г�ʼ����
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