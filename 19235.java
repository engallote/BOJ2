import java.util.*;

public class Main {
	static int res = 0, number;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] green = new int[6][4], blue = new int[4][6];
	static Queue<ArrayList<Pair>> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		number = 1;
		
		while(--N >= 0){
			int t = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			//블록 옮기기
			moveGreen(t, x, y);
			moveBlue(t, x, y);
			++number;
			
			//블록 당기기
			downGreen();
			downBlue();
			
			//행.열에 걸쳤는가
			removeGreen();
			removeBlue();
		}
		int cnt = 0;
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 4; j++){
				if(green[i][j] != 0) ++cnt;
				if(blue[j][i] != 0) ++cnt;
			}
		
		System.out.println(res);
		System.out.println(cnt);
	}
	private static void downBlue() {
		boolean flag = true;
		
		while(flag){
			flag = false;
			
			//열 검사
			for(int i = 0; i < 6; i++){
				int sum = 0;
				for(int j = 0; j < 4; j++)
					if(blue[j][i] != 0) ++sum;
				
				if(sum == 4){
					++res;
					blue[0][i] = blue[1][i] = blue[2][i] = blue[3][i] = 0;
					flag = true;
				}
			}
			
			q.clear();
			//덩어리 만들기
			for(int i = 5; i >= 0; i--)
				for(int j = 0; j < 4; j++){
					if(blue[j][i] == 0) continue;
					ArrayList<Pair> aly = new ArrayList<>();
					aly.add(new Pair(j, i, blue[j][i]));
					for(int k = 0; k < 4; k++){
						int nx = j + dx[k], ny = i + dy[k];
						if(nx < 0 || ny < 0 || nx >= 4 || ny >= 6 || blue[nx][ny] != blue[j][i])
							continue;
						aly.add(new Pair(nx, ny, blue[j][i]));
						blue[nx][ny] = 0;
						break;
					}
					
					blue[j][i] = 0;
					q.offer(aly);
				}
			
			//내리기
			while(!q.isEmpty()){
				ArrayList<Pair> aly = q.poll();
				
				int cnt = Integer.MAX_VALUE, tmp;
				
				for(int i = 0; i < aly.size(); i++){
					int x = aly.get(i).x, y = aly.get(i).y;
					tmp = 0;
					while(y < 6){
						if(blue[x][y] != 0){
							--y;
							break;
						}
						++tmp;
						++y;
					}
					--tmp;
					cnt = Math.min(cnt, tmp);
				}
				
				for(Pair p : aly)
					blue[p.x][p.y + cnt] = p.num;
			}
		}
	}
	private static void downGreen() {
		boolean flag = true;
		
		while(flag){
			flag = false;
			
			//행 검사
			for(int i = 0; i < 6; i++){
				int sum = 0;
				for(int j = 0; j < 4; j++)
					if(green[i][j] != 0) ++sum;
				
				if(sum == 4){
					Arrays.fill(green[i], 0);
					++res;
					flag = true;
				}
			}
			
			q.clear();
			//덩어리 만들기
			for(int i = 5; i >= 0; i--)
				for(int j = 0; j < 4; j++){
					if(green[i][j] == 0) continue;
					ArrayList<Pair> aly = new ArrayList<>();
					aly.add(new Pair(i, j, green[i][j]));
					for(int k = 0; k < 4; k++){
						int nx = i + dx[k], ny = j + dy[k];
						if(nx < 0 || ny < 0 || nx >= 6 || ny >= 4 || green[nx][ny] != green[i][j])
							continue;
						aly.add(new Pair(nx, ny, green[i][j]));
						green[nx][ny] = 0;
						break;
					}
					green[i][j] = 0;
					q.offer(aly);
				}
			
			//내리기
			while(!q.isEmpty()){
				ArrayList<Pair> aly = q.poll();
				
				int cnt = Integer.MAX_VALUE, tmp;
				
				for(int i = 0; i < aly.size(); i++){
					int x = aly.get(i).x, y = aly.get(i).y;
					tmp = 0;
					while(x < 6){
						if(green[x][y] != 0){
							--x;
							break;
						}
						++tmp;
						++x;
					}
					--tmp;
					cnt = Math.min(cnt, tmp);
				}
				
				for(Pair p : aly)
					green[p.x + cnt][p.y] = p.num;
			}
		}
	}
	private static void removeGreen() {
		int count = 0;
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 4; j++)
				if(green[i][j] != 0){
					++count;
					break;
				}
		
		for(int i = 5; i >= 0; i--){
			for(int j = 0; j < 4; j++){
				if(i - count >= 0) green[i][j] = green[i - count][j];
				else green[i][j] = 0;
			}
		}
	}
	private static void removeBlue() {
		int count = 0;
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 4; j++)
				if(blue[j][i] != 0){
					++count;
					break;
				}
		
		for(int i = 5; i >= 0; i--){
			for(int j = 0; j < 4; j++){
				if(i - count >= 0) blue[j][i] = blue[j][i-count];
				else blue[j][i] = 0;
			}
		}
	}
	private static void moveBlue(int t, int x, int y) {
		y = 0;
		if(t == 1){//ㅁ
			while(y < 6 && blue[x][y] == 0) ++y;
			blue[x][y - 1] = number;
		}
		else if(t == 2){//ㅡ
			while(y + 1 < 6 && blue[x][y] == 0 && blue[x][y + 1] == 0) ++y;
			blue[x][y - 1] = blue[x][y] = number;
		}
		else{//ㅣ
			while(y < 6 && blue[x][y] == 0 && blue[x + 1][y] == 0) ++y;
			blue[x][y - 1] = blue[x + 1][y - 1] = number;
		}
	}
	private static void moveGreen(int t, int x, int y) {
		x = 0;
		if(t == 1){//ㅁ
			while(x < 6 && green[x][y] == 0) ++x;
			green[x - 1][y] = number;
		}
		else if(t == 2){//ㅡ
			while(x < 6 && green[x][y] == 0 && green[x][y + 1] == 0) ++x;
			green[x - 1][y] = green[x - 1][y + 1] = number;
		}
		else{//ㅣ
			while(x + 1 < 6 && green[x][y] == 0 && green[x + 1][y] == 0) ++x;
			green[x - 1][y] = green[x][y] = number;
		}
	}
}
class Pair{
	int x, y, num;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}