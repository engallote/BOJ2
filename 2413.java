import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		chk = new boolean[N + 1];
		HashMap<Integer, Integer> hs = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			hs.put(num, i);
		}
		
		for(int i = 0; i < N; i++) {
			if(arr[i] == 1)
				chk[1] = true;
			else if(chk[arr[i]] || chk[arr[hs.get(arr[i] - 1)]]) 
				chk[arr[i]] = true;
			else {
				chk[arr[i]] = chk[arr[hs.get(arr[i] - 1)]] = true;
				int tmp = arr[i], idx = hs.get(arr[i] - 1);
				arr[i] = arr[idx];
				arr[idx] = tmp;
			}
			
			System.out.print(arr[i] + " ");
		}
	}
}