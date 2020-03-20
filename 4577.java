import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true){
			N = sc.nextInt();
			M = sc.nextInt();
			if(N == 0 && M == 0) break;
			arr = new char[N][M];
			
			int x = 0, y = 0, cnt = 0, all = 0;
			for(int i = 0; i < N; i++){
				arr[i] = sc.next().toCharArray();
				for(int j = 0; j < M; j++){
					if(arr[i][j] == 'w'){
						arr[i][j] = '.';
						x = i;
						y = j;
					}
					else if(arr[i][j] == 'W'){
						arr[i][j] = '+';
						x = i;
						y = j;
					}
					else if(arr[i][j] == 'b') ++all;
					else if(arr[i][j] == 'B'){
						++all;
						++cnt;
					}
				}
			}
			
			char[] order = sc.next().toCharArray();
			
			for(char c : order){
				if(c == 'U'){
					if(range(x - 1, y)){
						if(arr[x - 1][y] == 'b' && range(x - 2, y)){
							if(arr[x-2][y] == 'b' || arr[x-2][y] == 'B') continue;
							arr[x - 2][y] = arr[x - 2][y] == '+' ? 'B' : 'b';
							if(arr[x-2][y] == 'B') ++cnt;
							arr[x - 1][y] = '.';
						}
						else if(arr[x - 1][y] == 'B' && range(x - 2, y)){
							if(arr[x-2][y] == 'b' || arr[x-2][y] == 'B') continue;
							arr[x - 2][y] = arr[x - 2][y] == '+' ? 'B' : 'b';
							if(arr[x-2][y] == 'b') --cnt;
							arr[x - 1][y] = '+';
						}
						x -= 1;
					}
				}
				else if(c == 'L'){
					if(range(x, y - 1)){
						if(arr[x][y-1] == 'b' && range(x, y - 2)){
							if(arr[x][y-2] == 'b' || arr[x][y-2] == 'B') continue;
							arr[x][y - 2] = arr[x][y - 2] == '+' ? 'B' : 'b';
							if(arr[x][y-2] == 'B') ++cnt;
							arr[x][y - 1] = '.';
						}
						else if(arr[x][y - 1] == 'B' && range(x, y - 2)){
							if(arr[x][y-2] == 'b' || arr[x][y-2] == 'B') continue;
							arr[x][y - 2] = arr[x][y - 2] == '+' ? 'B' : 'b';
							if(arr[x][y-2] == 'b') --cnt;
							arr[x][y - 1] = '+';
						}
						y -= 1;
					}
				}
				else if(c == 'D'){
					if(range(x + 1, y)){
						if(arr[x + 1][y] == 'b' && range(x + 2, y)){
							if(arr[x + 2][y] == 'b' || arr[x + 2][y] == 'B') continue;
							arr[x + 2][y] = arr[x + 2][y] == '+' ? 'B' : 'b';
							if(arr[x+2][y] == 'B') ++cnt;
							arr[x + 1][y] = '.';
						}
						else if(arr[x + 1][y] == 'B' && range(x + 2, y)){
							if(arr[x + 2][y] == 'b' || arr[x + 2][y] == 'B') continue;
							arr[x + 2][y] = arr[x + 2][y] == '+' ? 'B' : 'b';
							if(arr[x+2][y] == 'b') --cnt;
							arr[x + 1][y] = '+';
						}
						x += 1;
					}
				}
				else{
					if(range(x, y + 1)){
						if(arr[x][y+1] == 'b' && range(x, y + 2)){
							if(arr[x][y+2] == 'b' || arr[x][y+2] == 'B') continue;
							arr[x][y + 2] = arr[x][y + 2] == '+' ? 'B' : 'b';
							if(arr[x][y+2] == 'B') ++cnt;
							arr[x][y + 1] = '.';
						}
						else if(arr[x][y + 1] == 'B' && range(x, y + 2)){
							if(arr[x][y+2] == 'b' || arr[x][y+2] == 'B') continue;
							arr[x][y + 2] = arr[x][y + 2] == '+' ? 'B' : 'b';
							if(arr[x][y+2] == 'b') --cnt;
							arr[x][y + 1] = '+';
						}
						y += 1;
					}
				}
				if(all == cnt) break;
			}
			
			arr[x][y] = arr[x][y] == '+' ? 'W' : 'w';
			
			if(all != cnt) System.out.println("Game " + tc + ": incomplete");
			else System.out.println("Game " + tc + ": complete");
			
			for(int i = 0; i < N; i++)
				System.out.println(new String(arr[i]));
			
			++tc;
		}
	}

	private static boolean range(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M || arr[x][y] == '#') return false;
		return true;
	}
}