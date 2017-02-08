package classloader;

import java.io.InputStream;

//总之，class文件和类加载器唯一确定一个类

public class ClassLoader {
 
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{  
        ClassLoader loader = new ClassLoader() {  
            public Class<?> loadClass(String name) throws ClassNotFoundException {  
                try {  
                    String className = name.substring(name.lastIndexOf(".")+1)+".class";  
                    InputStream is = getClass().getResourceAsStream(className);  
                    if(is ==null){  
                        return super.loadClass(name);  
                    }  
                    byte[] buffer =  new byte[is.available()];  
                    is.read(buffer);  
                    return defineClass(name, buffer, 0, buffer.length);  
                } catch (Exception e) {  
                    throw new ClassNotFoundException(name);  
                }  
              
            }  
        };  
        Object object  = loader.loadClass("classloader.ClassLoader").newInstance();  
        System.out.println(object.getClass());  
        System.out.println(object instanceof classloader.ClassLoader);  
        //输出false
    }  
   
}
