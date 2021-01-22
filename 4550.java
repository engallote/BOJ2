import java.util.*;

public class Main {
	static int res, num;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char[][] map = new char[5][5];
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(--T >= 0) {
            num = 0;
            hs.clear();
        	for(int i = 0; i < 5; i++){
                map[i] = sc.next().toCharArray();
                for(int j = 0; j < 5; j++)
        			if(map[i][j] == 'o') ++num;
            }
        		
        	res = num;
        	dfs();
        	
        	System.out.println("The best case ends with " + res + " pegs.");
        }
    }
	private static void dfs() {
		if(res > num) res = num;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 5; i++) 
			sb.append(new String(map[i]));
		
		if(hs.contains(sb.toString())) return;
		
		hs.add(sb.toString());
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				if(map[i][j] == 'o') {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k], ny = j + dy[k];
						if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || map[nx][ny] != 'o') continue;
						if(nx + dx[k] < 0 || nx + dx[k] >= 5 || ny + dy[k] < 0 || ny + dy[k] >= 5 || map[nx+dx[k]][ny+dy[k]] != '.') continue;
						map[nx][ny] = '.';
						map[i][j] = '.';
						map[nx+dx[k]][ny+dy[k]] = 'o';
						--num;
						dfs();
						++num;
						map[i][j] = 'o';
						map[nx+dx[k]][ny+dy[k]] = '.';
						map[nx][ny] = 'o';
					}
				}
	}
}