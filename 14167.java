import java.util.*;

public class Main {
	static int N;
	static int[] par;
	static boolean[] chk;
	static Pair[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new Pair[N];
        par = new int[N];
        chk = new boolean[N];
        
        for(int i = 0; i < N; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	arr[i] = new Pair(a, b);
        }
        
        int l = 0, r = 1000000000, mid, res = r;
        while(l <= r) {
        	mid = (l + r) / 2;
        	
        	clean();
        	
        	solve(0, mid);
        	boolean flag = true;
        	
        	for(int i = 0; i < N; i++)
        		if(!chk[i]) {
        			flag = false;
        			break;
        		}
        	
        	if(flag) {
        		r = mid - 1;
        		res = mid;
        	}
        	else l = mid + 1;
        }
        
        System.out.println(res);
    }
	private static void solve(int idx, int mid) {
		chk[idx] = true;
		for(int i = 0; i < N; i++)
			if(idx != i && !chk[i]) {
				int dist = (arr[idx].x - arr[i].x) * (arr[idx].x - arr[i].x) + (arr[idx].y - arr[i].y) * (arr[idx].y - arr[i].y);
				if(dist <= mid) {
					chk[i] = true;
					solve(i, mid);
				}
			}
	}
	private static void clean() {
		for(int i = 0; i < N; i++) {
			par[i] = i;
			chk[i] = false;
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}