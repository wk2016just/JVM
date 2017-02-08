package classloader;
import java.lang.*;

//双亲加载机制
public class ParentClassLoader {
	
    public static void main(String[] args) {  
        // 当前对象的类加载器  
        java.lang.ClassLoader loader = new ParentClassLoader().getClass().getClassLoader();  
        // 从当前对象的类加载器想上找他的各个祖先  
        while (loader != null) {  
            System.out.println(loader.getClass().getName());  
            loader = loader.getParent();  
        }  
        // 知道找到最后的祖先是null  
        System.out.println(loader);  
    }  
	
}
//
//自定义类加载器的父亲是AppClassLoader
//AppClassLoader的父亲是ExtClassLoader
//ExtClassLoader的父亲是BooststrapClassLoader