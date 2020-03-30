import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] arr = new Pair[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		Arrays.sort(arr);
		
		int l = 0, r = arr[0].y, mid, res = 0;
		while(l <= r){
			mid = (l + r) / 2;
			int start = mid;
			
			for(int i = 0; i < N; i++){
				if(start + arr[i].x <= arr[i].y)
					start += arr[i].x;
				else{
					start = -1;
					break;
				}
			}
			
			if(start == -1) r = mid - 1;
			else{
				res = Math.max(res, mid);
				l = mid + 1;
			}
		}
		
		System.out.println(res);
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
		else if(o.y == this.y){
			if(o.x > this.x) return 1;
			else if(o.x == this.x) return 0;
			else return -1;
		}
		else return 1;
	}
}