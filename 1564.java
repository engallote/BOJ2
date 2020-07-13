import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long res = 1;
		
		for(long i = N; i >= 1; i--){
			res *= i;
			while(res % 10 == 0) res /= 10;
			res %= 1000000000000l;
		}
		
		while(res % 10 == 0) res /= 10;
		res %= 100000;
		String str = Long.toString(res);
		
		for(int i = 0; i < 5-str.length(); i++)
			System.out.print("0");
		
		System.out.println(res);
	}
}