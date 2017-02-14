package concurrency;

public class VolatileDCL {
	
	private volatile static VolatileDCL instance;
	
	public static VolatileDCL getInstance(){
		if(instance == null){
			synchronized(VolatileDCL.class){
				if(instance == null){
					instance = new  VolatileDCL();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args){
		VolatileDCL.getInstance();
	}

}
