package classloader;
//�����ڱ���׶λ���������ĳ������У�������û��ֱ�����õ����峣�����࣬��˲��ᴥ�����峣������ĳ�ʼ��
class ConstClass {  
    
    static {  
        System.out.println("ConstClass init!");  
    }  
      
    //����׶γ����Ĵ����Ż���final�������ı��ַ���ֱ�Ӵ���NotInitialization�ೣ���أ���ConstClass.HELLOWORLD������
    //ת��Ϊ��NotInitialization����������ص����ã���class�ļ��в�û����ConstClass��ķ����������
    public static final int value = 123;  
  
}  

public class NotInitialization3 {  
      
    public static void main(String[] args) {  
        int x = ConstClass.value;  
    }  
  
}  
