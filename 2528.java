import java.util.*;

public class Main {
	static int N, L;
	static Pair[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		arr = new Pair[N];
		
		for(int i = 0; i < N; i++){
			int x = sc.nextInt();
			int d = sc.nextInt();
			
			if(d == 1) arr[i] = new Pair(L - x, L, d);
			else arr[i] = new Pair(0, x, d);
		}
		
		int idx = 0, time = 0;
		while(idx < N - 1){
			for(int i = idx; i < N; i++){
				if(arr[i].x == 0 && arr[i].y == L) continue;
				if(arr[i].d == 0){
					if(arr[i].y + 1 <= L){
						arr[i].x += 1;
						arr[i].y += 1;
					}
					else{
						arr[i].x -= 1;
						arr[i].y -= 1;
						arr[i].d = 1;
					}
				}
				else{
					if(arr[i].x - 1 >= 0){
						arr[i].x -= 1;
						arr[i].y -= 1;
					}
					else{
						arr[i].x += 1;
						arr[i].y += 1;
						arr[i].d = 0;
					}
				}
			}
			
			++time;
			while((arr[idx].x <= arr[idx+1].y && arr[idx].y >= arr[idx+1].y)
					|| (arr[idx].x <= arr[idx+1].x && arr[idx+1].y <= arr[idx].y)
					|| (arr[idx].y >= arr[idx+1].x && arr[idx+1].x >= arr[idx].x)
					|| (arr[idx].x >= arr[idx+1].x && arr[idx].y <= arr[idx+1].y)){
						++idx;
						if(idx >= N - 1) break;
					}
		}
		
		System.out.println(time);
	}
}
class Pair{
	int x, y, d;
	Pair(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}