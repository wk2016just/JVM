package tool;

//-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:+UnlockDiagnosticVMOptions -Xcomp -XX:CompileCommand=dontinline,*Bar.sum -XX:CompileCommand=compileonly,*Bar.sum
/* 虚拟机参数： 
 * -XX:+PrintAssembly：输出反汇编内容； 
 * -Xcomp：是让虚拟机以编译模式执行代码； 
 * -XX:CompileCommand=dontinline,*Bar.sum：让编译器不要内联sum()； 
 * -XX:CompileCommand=compileonly,*Bar.sum：只编译sum()； 
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