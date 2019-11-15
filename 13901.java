import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int x, y;
		int[][] arr = new int[1000][1000];
		
		for(int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x][y] = -1;
		}
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		arr[x][y] = 1;
		int[] order = new int[4];
		int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1};
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			order[i] = Integer.parseInt(st.nextToken());
		
		int idx = 0, cnt = 0, i;
		boolean flag = true;
		while(flag)
		{
			flag = false;
			cnt = 0;
			i = idx;
			while(cnt < 4)
			{
				if(range(x + dx[order[i]], y + dy[order[i]]) && arr[x+dx[order[i]]][y+dy[order[i]]] == 0)
				{
					x += dx[order[i]];
					y += dy[order[i]];
					idx = i;
					arr[x][y] = 1;
					flag = true;
					break;
				}
				i = (i + 1) % 4;
				++cnt;
			}
		}
		bw.write(x + " " + y);	
		bw.flush();
	}

	private static boolean range(int x, int y) {
		if(x >= 0 && y >= 0 && x < N && y < M) return true;
		return false;
	}
}