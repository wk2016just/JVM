package classloader;
import java.lang.*;

//˫�׼��ػ���
public class ParentClassLoader {
	
    public static void main(String[] args) {  
        // ��ǰ������������  
        java.lang.ClassLoader loader = new ParentClassLoader().getClass().getClassLoader();  
        // �ӵ�ǰ���������������������ĸ�������  
        while (loader != null) {  
            System.out.println(loader.getClass().getName());  
            loader = loader.getParent();  
        }  
        // ֪���ҵ�����������null  
        System.out.println(loader);  
    }  
	
}
//
//�Զ�����������ĸ�����AppClassLoader
//AppClassLoader�ĸ�����ExtClassLoader
//ExtClassLoader�ĸ�����BooststrapClassLoader