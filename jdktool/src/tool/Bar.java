package tool;

//-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:+UnlockDiagnosticVMOptions -Xcomp -XX:CompileCommand=dontinline,*Bar.sum -XX:CompileCommand=compileonly,*Bar.sum
/* ����������� 
 * -XX:+PrintAssembly�������������ݣ� 
 * -Xcomp������������Ա���ģʽִ�д��룻 
 * -XX:CompileCommand=dontinline,*Bar.sum���ñ�������Ҫ����sum()�� 
 * -XX:CompileCommand=compileonly,*Bar.sum��ֻ����sum()�� 
 */  
public class Bar {  
    int a = 1;  
    static int b = 2;  
  
    public int sum(int c) {  
        return a + b + c;  
    }  
  
    public static void main(String [] args) {  
        new Bar().sum(3);  
    }  
}  