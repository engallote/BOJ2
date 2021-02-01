import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        while(--T >= 0) {
        	int N = Integer.parseInt(br.readLine());
        	int[] order = new int[N];
        	int[][] path = new int[N][N];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < N; i++)
        		order[i] = Integer.parseInt(st.nextToken());
        	
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++){
        			path[i][j] = Integer.parseInt(st.nextToken());
        			if(path[i][j] == -1) path[i][j] = 1000000000;
        		}
        	}
        	
        	for(int k = 0; k < N; k++)
        		for(int i = 0; i < N; i++)
        			for(int j = 0; j < N; j++)
        				if(path[i][k] + path[k][j] < path[i][j])
        					path[i][j] = path[i][k] + path[k][j];
        	
        	long res = 0;
        	for(int i = 0; i < N; i++)
        		res += path[order[i]][order[(i + 1) % N]];
        	
        	if(res >= 1000000000) bw.write("impossible\n");
        	else bw.write(res + "\n");
        }
        bw.flush();
	}
}