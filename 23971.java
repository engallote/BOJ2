import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int H = sc.nextInt();
    	int W = sc.nextInt();
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	int h = H / (N + 1) + (H % (N + 1) > 0 ? 1 : 0);
    	int w = W / (M + 1) + (W % (M + 1) > 0 ? 1 : 0);
    	
    	System.out.println(h * w);
    }
}