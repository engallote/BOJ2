import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] arr = new Pair[N];
		int[] he = new int[10001];
		
		for(int i = 0; i < N; i++){
			int h = sc.nextInt();
			int s = sc.nextInt();
			int e = sc.nextInt() - 1;
			arr[i] = new Pair(s, e, h);
		}
		
		Arrays.sort(arr);
		
		int res = 0;
		
		for(int i = 0; i < N; i++){
			res += arr[i].h * 2 - he[arr[i].s] - he[arr[i].e];
			for(int j = arr[i].s; j <= arr[i].e; j++)
				he[j] = arr[i].h;
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int s, e, h;
	Pair(int s, int e, int h){
		this.s = s;
		this.e = e;
		this.h = h;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.h > this.h) return -1;
		else if(o.h == this.h){
			if(o.s > this.s) return -1;
			else if(o.s == this.s) return o.e > this.e ? 1 : -1;
			else return 1;
		}
		else return 1;
	}
}