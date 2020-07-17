import java.util.*;

public class Main {
	static int N, L, C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		C = sc.nextInt();
		C -= L;
		
		if(C <= L){
			System.out.println(N);
			return;
		}
		
		int div = C / (L + 1) + 1, res = N;
		if(div % 13 == 0) --div;
		
		int tmp = N / div;
		int mod = N % div;
		
		if(mod != 0){
			if(mod % 13 == 0){
				if((div - 1) % 13 != 0 && (mod + 1) <= div && (mod + 1) % 13 != 0) tmp += 1;
				else tmp += 2;
			}
			else tmp += 1;
		}
		
		res = Math.min(res, tmp);
		System.out.println(res);
	}
}