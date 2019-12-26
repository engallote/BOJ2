import java.util.*;

public class Main {
	static int N, M, cnt, max, sum;
	static String res;
	static HashSet<String> hs = new HashSet<>();
	static char[][] dic, map;
	static boolean[][] chk;
	static boolean flag;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[26];
		dic = new char[N][];
		map = new char[4][4];
		chk = new boolean[4][4];
		for(int i = 0; i < 26; i++) arr[i] = new ArrayList<>();
		for(int i = 0; i < N; i++)
		{
			dic[i] = sc.next().toCharArray();
			arr[dic[i][0]-'A'].add(i);
		}
		
		M = sc.nextInt();
		for(int t = 0; t < M; t++)
		{
			for(int i = 0; i < 4; i++)
			{
				map[i] = sc.next().toCharArray();
				Arrays.fill(chk[i], false);
			}
			
			hs.clear();
			res = "";
			cnt = 0;
			max = 0;
			sum = 0;
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++)
					for(int k = 0; k < arr[map[i][j]-'A'].size(); k++)
						if(!hs.contains(new String(dic[arr[map[i][j]-'A'].get(k)])))
						{
							flag = false;
							dfs(i, j, 1, new String(dic[arr[map[i][j]-'A'].get(k)]));
						}
			
			System.out.println(sum + " " + res + " " + cnt);
		}
	}
	private static void dfs(int x, int y, int idx, String str) {
		if(flag) return;
		if(idx == str.length())
		{
			flag = true;
			hs.add(str);
			++cnt;
			if(max < idx)
			{
				max = idx;
				res = str;
			}
			else if(max == idx)
				res = findFirst(res, str);
			
			if(idx <= 2) sum += 0;
			else if(idx <= 4) sum += 1;
			else if(idx == 5) sum += 2;
			else if(idx == 6) sum += 3;
			else if(idx == 7) sum += 5;
			else if(idx == 8) sum += 11;
			
			return;
		}
		chk[x][y] = true;
		for(int i = 0; i < 8; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || chk[nx][ny] || map[nx][ny] != str.charAt(idx))
				continue;
			dfs(nx, ny, idx + 1, str);
		}
		chk[x][y] = false;
		
	}
	private static String findFirst(String a, String b) {
		for(int i = 0; i < a.length(); i++)
		{
			if(a.charAt(i) > b.charAt(i)) return b;
			else if(a.charAt(i) < b.charAt(i)) return a;
		}
		return a;
	}
}