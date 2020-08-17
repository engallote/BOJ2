import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[] indgree, h, ans, chk;
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        indgree = new int[N+1];
        h = new int[N+1];
        chk = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
        	h[i] = Integer.parseInt(st.nextToken());
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++){
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(h[a] < h[b]){
        		arr[b].add(a);
        		++indgree[a];
        	}
        	else{
        		arr[a].add(b);
        		++indgree[b];
        	}
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++)
        	if(indgree[i] == 0) q.offer(i);
        
        while(!q.isEmpty()){
        	int x = q.poll();
        	
        	for(int next : arr[x])
        		if(chk[next] <= chk[x] + 1){
        			chk[next] = chk[x] + 1;
        			--indgree[next];
        			if(indgree[next] == 0) q.offer(next);
        		}
        }
        
        for(int i = 1; i <= N; i++)
        	bw.write((chk[i]+1)+"\n");
        bw.flush();
	}
}