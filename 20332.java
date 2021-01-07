import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		
		for(int i = 0; i < N; i++)
			sum += sc.nextInt();
		
		if(sum % 3 == 0) System.out.println("yes");
		else System.out.println("no");
	}
}