import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] prime = new long[1000001], perma = new long[1000001];
		boolean[] chk = new boolean[1000001];
		
		for(int i = 2; i <= 1000000; i++){
			if(chk[i]){
				prime[i] = prime[i-1];
				perma[i] = perma[i-1];
				continue;
			}
			prime[i] = prime[i-1] + 1;
			if(i == 2 || i % 4 == 1) perma[i] = perma[i-1] + 1;
			else perma[i] = perma[i-1];
			
			for(int j = i + i; j <= 1000000; j+=i)
				chk[j] = true;
		}
		
		while(true){
			int L = sc.nextInt();
			int U = sc.nextInt();
			
			if(L == -1 && U == -1) break;
			
			System.out.printf("%d %d %d %d\n", L, U, (prime[Math.max(0, U)] - prime[Math.max(L-1, 0)]), (perma[Math.max(0, U)] - perma[Math.max(L-1, 0)]));
		}
	}
}