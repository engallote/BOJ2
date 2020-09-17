import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][M+1];
        chk = new boolean[N+1][M+1];
        boolean[] visit = new boolean[1000001];
        visit[0] = visit[1] = true;
        for(int i = 2; i <= 1000000; i++){
        	if(visit[i]) continue;
        	for(int j = i + i; j <= 1000000; j+=i) visit[j] = true;
        }
        
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= M; j++)
        		arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(1, 1));
        chk[1][1] = true;
        int size;
        
        while(!q.isEmpty()){
        	size = q.size();
        	while(--size >= 0){
        		Pair p = q.poll();
        		
        		if(p.x == N && p.y == M){
        			bw.write("yes");
        			bw.flush();
        			return;
        		}
        		if(arr[p.x][p.y] == 1) continue;
        		
        		int num = arr[p.x][p.y];
        		if(!visit[num]){//소수
        			if(num <= N && !chk[num][1]){
    					chk[num][1] = true;
    					q.offer(new Pair(num, 1));
    				}
    				if(num <= M && !chk[1][num]){
    					chk[1][num] = true;
    					q.offer(new Pair(1, num));
    				}
        		}
        		else{
        			for(int i = 1; i * i <= num; i++){
            			if(num % i == 0){
            				if(i <= N && num / i <= M && !chk[i][num/i]){
            					chk[i][num/i] = true;
            					q.offer(new Pair(i, num/i));
            				}
            				if(num / i <= N && i <= M && !chk[num/i][i]){
            					chk[num/i][i] = true;
            					q.offer(new Pair(num/i, i));
            				}
            			}
            		}
        		}
        	}
        }
        bw.write("no");
        bw.flush();
    }
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}