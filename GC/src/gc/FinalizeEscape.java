package gc;

public class FinalizeEscape {  
	//�ж�������Ҫִ��finalize��������������F-Queue���У��߳�Finalizer������������ȴ���ִ���꣩
	//����Ҫִ�������û�и���finalize��ִ�й�finalize�ˡ�
	//��һ��gcʱ���Ѿ�û������ָ��˶����ˣ����Ƕ����Լ����Լ���thisָ�루��ַ�������ྲ̬���������ɹ��Ծȡ�
	//�ڶ����Ѿ�ִ�й����Բ���
	
    public static FinalizeEscape SAVE_HOOK = null;  
  
    @Override  
    protected void finalize() throws Throwable {  
        super.finalize();  
        System.out.println("finalize method invoke");  
        SAVE_HOOK = this;  
    }  
      
    public static void main(String[] args) throws Exception {  
    	SAVE_HOOK = new FinalizeEscape();  
          
    	SAVE_HOOK = null;  
        System.gc();  
        Thread.sleep(500);  
        if(SAVE_HOOK != null)  
            System.out.println("i am alive");  
        else   
            System.out.println("i am dead");  
          
        SAVE_HOOK = null;  
        System.gc();  
        Thread.sleep(500);  
        if(SAVE_HOOK != null)  
            System.out.println("i am alive");  
        else   
            System.out.println("i am dead");  
    }  
}  


