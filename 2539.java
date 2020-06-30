import java.util.*;

public class Main {
	static int R, C, N, M;
	static Pair[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new Pair[M];
		int max = 0;
		
		for(int i = 0; i < M; i++){
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
			max = Math.max(max, arr[i].x);
		}
		
		Arrays.sort(arr);
		
		int l = max, r = 1000000, mid, res = r;
		while(l <= r){
			mid = (l + r) / 2;
			
			int sum = find(mid);
			
			if(sum <= N){
				res = Math.min(res, mid);
				r = mid - 1;
			}
			else l = mid + 1;
		}
		
		System.out.println(res);
	}
	private static int find(int mid) {
		int cnt = 1;
		int y = arr[0].y + mid - 1;
		
		for(int i = 1; i < M; i++){
			if(arr[i].y <= y) continue;
			else{
				++cnt;
				y = arr[i].y + mid - 1;
			}
		}
		
		return cnt;
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.y > this.y) return -1;
		else if(o.y == this.y) return o.x > this.x ? -1 : 1;
		else return 1;
	}
}