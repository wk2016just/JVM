
public class RuntimeConstantPoolOOM2 {
	
	public static void main(String[] args){
		String str1 = new StringBuilder("中科大").append("软院").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
}
//运行结果true false
//java中中科大，软院这种不属于运行时常量池，而算是一种对象的实例数据的范围。
//所以这种在jdk1.7只要符合首次出现原则即可返回同一个引用。