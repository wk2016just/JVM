package classloader;
//ͨ���������ø���ĵľ�̬�ֶΣ����ᵼ�������ʼ��
//class�ļ����ֶα��಻��������ͳ�����ֶ�
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
 

