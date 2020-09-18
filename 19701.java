import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int V, E;
	static long[][] chk;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        chk = new long[V + 1][2];
        arr = new ArrayList[V + 1];
        
        for(int i = 1; i <= V; i++){
        	arr[i] = new ArrayList<>();
        	Arrays.fill(chk[i], Long.MAX_VALUE);
        }
        
        for(int i = 0; i < E; i++){
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int t = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	arr[x].add(new Pair(y, t, k));
        	arr[y].add(new Pair(x, t, k));
        }
        
        chk[1][1] = chk[1][0] = 0;
        dijk();
        
        for(int i = 2; i <= V; i++)
        	bw.write(Math.min(chk[i][0], chk[i][1])+"\n");
        bw.flush();
    }
	private static void dijk() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(1, 0l, 1));
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(Pair next : arr[p.x]){
					if(p.k == 1 && chk[next.x][0] > p.y + next.y - next.k){
						chk[next.x][0] = p.y + next.y - next.k;
						q.offer(new Pair(next.x, chk[next.x][0], 0));
					}
					if(chk[next.x][p.k] > p.y + next.y){
						chk[next.x][p.k] = p.y + next.y;
						q.offer(new Pair(next.x, chk[next.x][p.k], p.k));
					}
				}
			}
		}
	}
}
class Pair{
	int x, k;
	long y;
	Pair(int x, long y, int k){
		this.x = x;
		this.y = y;
		this.k = k;
	}
}