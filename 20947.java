import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        boolean[][] chk = new boolean[N][N];
        
        for(int i = 0; i < N; i++)
        	map[i] = br.readLine().trim().toCharArray();
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		if(map[i][j] == 'O') {
        			for(int d = 0; d < 4 ; d++) {
        				int nx = i + dx[d], ny = j + dy[d];
        				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        				
        				while(nx >= 0 && ny >= 0 && nx < N && ny < N) {
        					if(map[nx][ny] == 'O' || map[nx][ny] == 'X') break;
        					chk[nx][ny] = true;
        					nx += dx[d];
        					ny += dy[d];
        				}
        			}
        		}
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(chk[i][j]) bw.write(map[i][j]);
        		else {
        			if(map[i][j] == '.') bw.write('B');
        			else bw.write(map[i][j]);
        		}
        	}
        	bw.newLine();
        }
        bw.flush();
    }
}