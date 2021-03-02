import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int W = sc.nextInt();
        int M = sc.nextInt();
        
        int sub = W - K;
        
        if(sub <= 0) System.out.println(0);
        else System.out.println(sub/M + (sub%M != 0 ? 1 : 0));
    }
}