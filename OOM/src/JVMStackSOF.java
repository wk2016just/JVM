
public class JVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JVMStackSOF obj = new JVMStackSOF();
		try{
			obj.stackLeak();
		}catch(Throwable e){
			System.out.println("stacklength:"+obj.stackLength);
			throw e;
		}
	}
}

//localΪ2������this��stackLengthֵ��max_stackΪ1������Ϊstacklength������
//����ջ֡����ѹ��stackLeak�����Կ���������Ϊhotspot������ջ�϶�Ϊһ��
//����hotspot��-Xoss������Ч��ջ����ֻ��-Xss�趨.
//���߳��£�������ջ̫֡����ջ����С�����׳�SOF�쳣

/*���н��
 * Exception in thread "main" stacklength:994
java.lang.StackOverflowError
	at JVMStackSOF.stackLeak(JVMStackSOF.java:7)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
	at JVMStackSOF.stackLeak(JVMStackSOF.java:8)
 */