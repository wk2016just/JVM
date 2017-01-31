package gc;

public class GCRoots {
	private static GCRoots t = new GCRoots();
	private final int i = new Integer(1);
	
	public static void main(String[] args){
		System.out.println("what can be the gc roots?");
	}
}
