import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	int C = sc.nextInt();
    	
    	int max = Math.max(A, Math.max(B, C));
    	int res = (max - A) + (max - B) + (max - C);
    	
    	System.out.println(res);
	}
}