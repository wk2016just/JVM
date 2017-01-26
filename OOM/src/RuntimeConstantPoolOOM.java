import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		int i =0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}

}

//-XX:PermSize=10M -XX:MaxPermSize=10M
//jdk1.7开始去永久代，会一直运行而不出现OOM PermGen space，提示方法区溢出