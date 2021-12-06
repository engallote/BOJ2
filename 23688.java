import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] aly;
	static int[] chk;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int Q = Integer.parseInt(st.nextToken());
    	aly = new ArrayList[N + 1];
    	chk = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		aly[i] = new ArrayList<>();
    		chk[i] = -1;
    	}
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= N; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			aly[j].add(num);
    		}
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	for(int i = 1; i <= N; i++) {
    		if(chk[i] != -1) continue;
    		q.offer(i);
    		chk[i] = i;
    		while(!q.isEmpty()) {
    			int x = q.poll();
    			
    			for(int next : aly[x])
    				if(chk[next] != i) {
    					chk[next] = i;
    					q.offer(next);
    				}
    		}
    	}

    	while(--Q >= 0) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		if(chk[a] == chk[b]) bw.write("DA\n");
    		else bw.write("NE\n");
    	}
    	bw.flush();
    }
}