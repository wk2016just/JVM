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
//jdk1.7��ʼȥ���ô�����һֱ���ж�������OOM PermGen space����ʾ���������