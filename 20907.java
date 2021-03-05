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
		StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[][][] arr = new int[8][H + 2][W + 2];
        int[][] chk = new int[H + 2][W + 2];
        int[] h = new int[W + 1];
        
        for(int i = 0; i <= H + 1; i++)
        	Arrays.fill(chk[i], -1);
        
        int who = 0, res = -1, resWho = 0;
        boolean flag = false;
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < H * W; t++) {
        	int c = Integer.parseInt(st.nextToken());
        	
        	if(flag) continue;
        	
        	int r = ++h[c];
        	chk[r][c] = t % 2;    
        	
        	for(int i = 0; i < 8; i++) {
        		int nx1 = r + dx[i], ny1 = c + dy[i], nx2 = r - dx[i], ny2 = c - dy[i];
        		int a = chk[nx1][ny1] == chk[r][c] ? arr[i][nx1][ny1] : 0;
        		int b = chk[nx2][ny2] == chk[r][c] ? arr[7-i][nx2][ny2] : 0;
        		int sum = a + b + 1;
        		
        		arr[7 - i][r + a * dx[i]][c + a * dy[i]] = sum;
        		if(!flag && sum >= K) {
        			flag = true;
        			resWho = who;
        			res = t + 1;
        		}
        	}
        	
        	who = (who + 1) % 2;
        }
        
        if(flag) bw.write((resWho == 0 ? "A" : "B") + " " + res);
        else bw.write("D");
        bw.flush();
    }
}