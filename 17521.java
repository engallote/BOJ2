import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long W = sc.nextLong();
		long[] arr = new long[N];
		char[] chk = new char[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for(int i = N - 1; i >= 0; i--)
		{
			if(chk[i] == '.') continue;
			long min = arr[i];
			int idx = i;
			for(int j = i - 1; j >= 0; j--){
				if(min > arr[j]){
					chk[idx] = '.';
					min = arr[j];
					idx = j;
				}
				else break;
			}
			if(idx != i){
				chk[i] = 's';
				chk[idx] = 'b';
			}
		}
		
		long b = 0;
		for(int i = 0; i < N; i++)
		{
			if(chk[i] == 'b'){
				b += W / arr[i];
				W = W % arr[i];
			}
			else if(chk[i] == 's'){
				W += arr[i] * b;
				b = 0;
			}
		}
		
		System.out.println(W);
	}
}