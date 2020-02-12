import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Pair[] arr2 = new Pair[N+1];
        arr = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++){
        	arr2[i] = new Pair(sc.nextInt(), sc.nextInt());
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= N; i++){
        	for(int j = 1; j <= N; j++)
        		if(i != j){
        			if(arr2[i].x >= arr2[j].x && arr2[i].y <= arr2[j].y)//i가 포함됨 
        				arr[i].add(j);
        			else if(arr2[i].x <= arr2[j].x && arr2[j].y <= arr2[i].y)//j가 포함됨 
        				arr[i].add(j);
        			else if(arr2[i].x >= arr2[j].x && arr2[i].x <= arr2[j].y)//x쪽 겹침
        				arr[i].add(j);
        			else if(arr2[i].y >= arr2[j].x && arr2[i].x <= arr2[j].x)//y쪽 겹침
        				arr[i].add(j);
        		}
        }
        
        int Q = sc.nextInt();
        while(--Q >= 0){
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	int res = bfs(x, y);
        	System.out.println(res);
        }
    }
	private static int bfs(int x, int y) {
		boolean[] chk = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		chk[x] = true;
		int time = 0, size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int nx = q.poll();
				
				if(nx == y) return time;
				
				for(int next : arr[nx])
					if(!chk[next]){
						chk[next] = true;
						q.offer(next);
					}
			}
			++time;
		}
		
		return -1;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}