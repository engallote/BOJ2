import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        int L = sc.nextInt();
        
        int r = W / L;
        int c = H / L;
        
        System.out.println(Math.min(N, r * c));
    }
}