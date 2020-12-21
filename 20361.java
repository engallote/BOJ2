import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int K = sc.nextInt();
		
		while(--K >= 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a == X) X = b;
			else if(b == X) X = a;
		}
		
		System.out.println(X);
	}
}