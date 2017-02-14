package concurrency;

public class VolatileFit {
	
	volatile boolean shutdownRequested;
	
	public void shutdown(){
		shutdownRequested = true;
	}
	
	public void doWork(){
		while(!shutdownRequested){
			System.out.println("use expression,so can volatile ");
		}
	}
}
