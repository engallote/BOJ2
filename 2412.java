import java.util.*;

public class Main {
	static int N, T;
	static Pair[] arr;
	static boolean[] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        arr = new Pair[N];
        chk = new boolean[N];
        
        for(int i = 0; i < N; i++)
        	arr[i] = new Pair(i, sc.nextInt(), sc.nextInt());
        
        Arrays.sort(arr);
        
        bfs();
    }
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0, 0));
		int size, time = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.y == T){
					System.out.println(time);
					return;
				}
				
				for(int i = p.idx; i < N; i++){
					if(chk[i]) continue;
					
					int nx = Math.abs(arr[i].x - p.x), ny = Math.abs(arr[i].y - p.y);
					if(nx <= 2 && ny <= 2){
						chk[i] = true;
						q.offer(new Pair(i, arr[i].x, arr[i].y));
					}
					else if(nx > 2 && ny > 2) break;
				}
				
				for(int i = p.idx; i >= 0; i--){
					if(chk[i]) continue;
					
					int nx = Math.abs(arr[i].x - p.x), ny = Math.abs(arr[i].y - p.y);
					if(nx <= 2 && ny <= 2){
						chk[i] = true;
						q.offer(new Pair(i, arr[i].x, arr[i].y));
					}
					else if(nx > 2 && ny > 2) break;
				}
			}
			++time;
		}
		
		System.out.println(-1);
	}
}
class Pair implements Comparable<Pair>{
	int idx, x, y;
	Pair(int idx, int x, int y){
		this.idx = idx;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.y > this.y) return -1;
		else if(o.y == this.y) return o.x > this.x ? -1 : (o.x == this.x ? 0 : 1);
		else return 1;
	}
}