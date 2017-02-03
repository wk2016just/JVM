package classfile;

public class testclass2 {
	final static int m = 123;
	
	public int inc(){
		return m+1;
	}
	
	public class inner{
		
	}
}

//要结合class内部文件和javap命令一起来观察
/*具体看图片1和2
利用好winhex右侧的UTF-8翻译表来迅速定位到常量池结束。
pic2图中是常量池结束，接着00 21是访问标志，00 01 00 03 00 是三项索引
接着是00 01表示一项  00 18 表示final static 00 05表示常量池索引为m 00 06返回值为int 
00 01有1项属性，00 07看到常量池为ConstantValue  u4的固定值2,00 08说明常量值为123
*/