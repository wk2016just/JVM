
public class RuntimeConstantPoolOOM2 {
	
	public static void main(String[] args){
		String str1 = new StringBuilder("�пƴ�").append("��Ժ").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
}
//���н��true false
//java���пƴ���Ժ���ֲ���������ʱ�����أ�������һ�ֶ����ʵ�����ݵķ�Χ��
//����������jdk1.7ֻҪ�����״γ���ԭ�򼴿ɷ���ͬһ�����á�