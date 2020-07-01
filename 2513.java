import java.util.*;

public class Main {
	static int N, K, M, cur;
	static Pair[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		M = sc.nextInt();
		arr = new Pair[N + 1];
		
		for(int i = 0; i < N; i++){
			int x = sc.nextInt();
			int num = sc.nextInt();
			arr[i] = new Pair(x, num);
		}
		arr[N] = new Pair(M, 0);
		
		Arrays.sort(arr);
		
		cur = K;
		int res = Math.abs(arr[0].x - M);
		res += left();
		
		//right
		cur = K;
		res += Math.abs(arr[N].x - M);
		res += right();
		
		System.out.println(res);
	}
	private static int right() {
		int sum = 0;
		
		for(int i = N; i >= 0 && arr[i].x != M;){
			if(arr[i].num <= cur){
				cur -= arr[i].num;
				arr[i].num = 0;
			}
			else{
				arr[i].num -= cur;
				cur = 0;
			}
			
			if(cur == 0 && arr[i].num > 0){
				cur = K;
				sum += Math.abs(arr[i].x - M) * 2;
			}
			if(arr[i].num == 0){
				if(i - 1 >= 0) sum += arr[i].x - arr[i - 1].x;
				i--;
			}
		}
		
		return sum;
	}
	private static int left() {
		int sum = 0;
		
		for(int i = 0; i <= N && arr[i].x != M;){
			if(arr[i].num <= cur){
				cur -= arr[i].num;
				arr[i].num = 0;
			}
			else{
				arr[i].num -= cur;
				cur = 0;
			}
			
			if(cur == 0 && arr[i].num > 0){
				cur = K;
				sum += Math.abs(arr[i].x - M) * 2;
			}
			if(arr[i].num == 0){
				if(i + 1 <= N) sum += arr[i + 1].x - arr[i].x;
				i++;
			}
		}
		
		return sum;
	}
}
class Pair implements Comparable<Pair>{
	int x, num;
	Pair(int x, int num){
		this.x = x;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return o.x > this.x ? -1 : 1;
	}
}