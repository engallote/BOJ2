import java.util.*;

public class Main {
	static int N;
	static long res;
	static char[][] arr;
	static long[] num = new long[10];
	static boolean[] chk = new boolean[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][];
		res = 0;
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		findMax(0);
		System.out.println(res);
	}
	private static void findMax(int idx) {
		if(idx == 10){
			cal();
			return;
		}
		
		for(int i = 0; i <= 9; i++)
			if(!chk[i]){
				chk[i] = true;
				num[idx] = i;
				findMax(idx + 1);
				num[idx] = 0;
				chk[i] = false;
			}
	}
	private static void cal() {
		long sum = 0;
		
		for(int i = 0; i < N; i++){
			long tmp = 0;
			if(num[arr[i][0]-'A'] == 0) return;
			for(int j = 0; j < arr[i].length; j++){
				tmp *= 10;
				tmp += num[arr[i][j]-'A'];
			}
			sum += tmp;
		}
		
		res = Math.max(res, sum);
	}
}