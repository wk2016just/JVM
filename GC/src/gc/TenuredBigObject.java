package gc;
//-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
public class TenuredBigObject {
	public static void main(String[] args){
		byte[] allocation1;
		allocation1 = new byte[4 * 1024 * 1024]; 
	}
}

//��ע����ǣ��˲���ֻ��serial��Parnew�����ռ�����Ч��
//Ȼ�����ȴ���Ǵ����ֱ�ӽ��룬˵������gc�����иģ�����ȫ���Ƴ����ô���JDK 8.HotSpot JVM��ʼʹ�ñ��ػ����ڴ������Ԫ���ݣ�����ռ����Ԫ�ռ�
