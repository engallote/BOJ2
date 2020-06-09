import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr, res;
	static boolean[][] chk;
	static PriorityQueue<Pair> pq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		res = new char[102][102];
		chk = new boolean[102][102];
		pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			Arrays.fill(res[i], '.');
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++)
				if(!chk[i][j] && arr[i][j] == '+')
					find(i, j);
		}
		
		int r = 0, c = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int div = p.c - 2 - p.name.length(), idx = 0;
			div /= 2;
			
			//가로선
			boolean first = true;
			for(int i = c; i < c + p.c; i++){
				if(first){
					res[r][i] = '+';
					first = false;
				}
				else if(i == c + p.c - 1) res[r][i] = '+';
				else{
					if(div == 0){
						if(idx < p.name.length()){
							res[r][i] = p.name.charAt(idx);
							++idx;
						}
						else res[r][i] = '-';
					}
					else{
						--div;
						res[r][i] = '-';
					}
				}
			}
			
			for(int i = r + 1; i < r + p.r; i++){
				for(int j = c; j < c + p.c; j++){
					if(j == c || j == c + p.c - 1) res[i][j] = '|';
					else res[i][j] = '.';
				}
			}
			
			for(int i = c; i < c + p.c; i++){
				if(i == c || i == c + p.c - 1) res[r + p.r][i] = '+';
				else res[r + p.r][i] = '-';
			}
			++r;
			++c;
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++)
				System.out.print(res[i][j]);
			System.out.println();
		}
	}
	private static void find(int x, int y) {
		boolean name = false;
		int r = 0, c = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = y + 1; i < M; i++){
			++c;
			if(arr[x][i] == '+') break;
			if(arr[x][i] >= 'a' && arr[x][i] <= 'z'){
				sb.append(arr[x][i]);
				name = true;
			}
			else if(arr[x][i] == '|') sb.append(arr[x][i]);
		}
		
		for(int i = x + 1; i < N; i++){
			++r;
			chk[i][y] = true;
			if(arr[i][y] == '+') break;
		}
		
		if(!name) return;
		pq.offer(new Pair(sb.toString(), r, c));
	}
}
class Pair implements Comparable<Pair>{
	String name;
	int r, c;
	Pair(String name, int r, int c){
		this.name = name;
		this.r = r;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		char[] a = o.name.substring(1, o.name.length()-1).toCharArray(), b = this.name.substring(1, this.name.length()-1).toCharArray();
		
		for(int i = 0; i < Math.min(a.length, b.length); i++){
			if(a[i] > b[i]){
				return -1;
			}
			else if(a[i] < b[i]){
				return 1;
			}
		}
		
		if(a.length > b.length) return -1;
		else if(a.length == b.length) return 0;
		else return 1;
	}
}