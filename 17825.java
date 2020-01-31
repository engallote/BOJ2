import java.util.*;

public class Main {
	static int idx;
	static int[] order = new int[10];
	static int[][] arr = new int[4][22], chk = new int[4][22];
	static int[][] jump = new int[4][22];
	static boolean[][] end = new boolean[4][22];
	static Queue<Pair> q = new LinkedList<Pair>();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		arrInit();
		for(int i = 0; i < 10; i++)
			order[i] = sc.nextInt();
		
		idx = 0;
		int size = 0, res = 0;
		
		q.offer(new Pair(new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0), 0));
		
		while(!q.isEmpty() && idx < 10){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				Point a = p.a, b = p.b, c = p.c, d = p.d;
				move(a, b, c, d, p.sum);
			}
			++idx;
		}
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			res = Math.max(res, p.sum);
		}
		System.out.println(res);
	}
	private static void move(Point a, Point b, Point c, Point d, int sum) {
		int num = order[idx];
		boolean flag = false;
		//A move
		int x = a.x, y = a.y;
		if(!end[x][y]){
			flag = false;
			while(--num >= 0){
				if(end[x][y]) break;
				flag = true;
				y += 1;
			}
			
			if(jump[x][y] != 0){
				x = jump[x][y];
				y = 0;
			}
			if(isThere(new Point(x, y), b, c, d))
				q.offer(new Pair(new Point(x, y), b, c, d, sum + arr[x][y]));
		}
		
		//B move
		num = order[idx];
		x = b.x;
		y = b.y;
		if(!end[x][y]){
			flag = false;
			while(--num >= 0){
				if(end[x][y]) break;
				flag = true;
				y += 1;
			}
			
			if(jump[x][y] != 0){
				x = jump[x][y];
				y = 0;
			}
			if(isThere(a, new Point(x, y), c, d))
				q.offer(new Pair(a, new Point(x, y), c, d, sum + arr[x][y]));
		}
		//C move
		num = order[idx];
		x = c.x;
		y = c.y;
		if(!end[x][y]){
			flag = false;
			while(--num >= 0){
				if(end[x][y]) break;
				flag = true;
				y += 1;
			}
			if(jump[x][y] != 0){
				x = jump[x][y];
				y = 0;
			}
			if(isThere(a, b, new Point(x, y), d))
				q.offer(new Pair(a, b, new Point(x, y), d, sum + arr[x][y]));
		}
		//D move
		num = order[idx];
		x = d.x;
		y = d.y;
		if(!end[x][y]){
			flag = false;
			while(--num >= 0){
				if(end[x][y]) break;
				flag = true;
				y += 1;
			}
			if(jump[x][y] != 0){
				x = jump[x][y];
				y = 0;
			}
			if(isThere(a, b, c, new Point(x, y)))
				q.offer(new Pair(a, b, c, new Point(x, y), sum + arr[x][y]));	
		}
	}
	private static boolean isThere(Point a, Point b, Point c, Point d) {
		if(arr[a.x][a.y] != 0 && !end[a.x][a.y]
			&& ((a.x == b.x && a.y == b.y) || (chk[a.x][a.y] == chk[b.x][b.y])
			|| (a.x == c.x && a.y == c.y) || (chk[a.x][a.y] == chk[c.x][c.y])
			|| (a.x == d.x && a.y == d.y) || (chk[a.x][a.y] == chk[d.x][d.y]))){
//			System.out.println(arr[a.x][a.y] + ", " + arr[b.x][b.y] + ", " + arr[c.x][c.y] + ", " + arr[d.x][d.y]);
//			System.out.println(chk[a.x][a.y] + ", " + chk[b.x][b.y] + ", " + chk[c.x][c.y] + ", " + chk[d.x][d.y]);
			return false;
		}
		
		if(arr[b.x][b.y] != 0 && !end[b.x][b.y]
			&& ((b.x == a.x && b.y == a.y) || (chk[b.x][b.y] == chk[a.x][a.y])
			|| (b.x == c.x && b.y == c.y) || (chk[b.x][b.y] == chk[c.x][c.y])
			|| (b.x == d.x && b.y == d.y) || (chk[b.x][b.y] == chk[d.x][d.y]))) return false;
		
		if(arr[c.x][c.y] != 0 && !end[c.x][c.y]
			&& ((c.x == a.x && c.y == a.y) || (chk[c.x][c.y] == chk[a.x][a.y])
			|| (c.x == b.x && c.y == b.y) || (chk[c.x][c.y] == chk[b.x][b.y])
			|| (c.x == d.x && c.y == d.y) || (chk[c.x][c.y] == chk[d.x][d.y]))) return false;
		
		if(arr[d.x][d.y] != 0 && !end[d.x][d.y]
			&& ((d.x == a.x && d.y == a.y) || (chk[d.x][d.y] == chk[a.x][a.y])
			|| (d.x == b.x && d.y == b.y) || (chk[d.x][d.y] == chk[b.x][b.y])
			|| (d.x == c.x && d.y == c.y) || (chk[d.x][d.y] == chk[c.x][c.y]))) return false;
		
		return true;
	}
	private static String pointToString(Point a, Point b, Point c, Point d) {
		return a.x+","+a.y+","+b.x+","+b.y+","+c.x+","+c.y+","+d.x+","+d.y;
	}
	private static void arrInit() {
		jump[0][5] = 1;//10
		jump[0][10] = 2;//20
		jump[0][15] = 3;//30
		int cnt = 21;
		for(int i = 1; i <= 20; i++){
			arr[0][i] = arr[0][i-1] + 2;
			chk[0][i] = i;
		}
		
		arr[1][0] = 10;
		arr[1][1] = 13;
		arr[1][2] = 16;
		arr[1][3] = 19;
		arr[1][4] = 25;
		arr[1][5] = 30;
		arr[1][6] = 35;
		arr[1][7] = 40;
		
		chk[1][0] = chk[0][5];
		chk[1][7] = chk[0][20];
		for(int i = 1; i < 7; i++)
			chk[1][i] = cnt++;
		
		arr[2][0] = 20;
		arr[2][1] = 22;
		arr[2][2] = 24;
		arr[2][3] = 25;
		arr[2][4] = 30;
		arr[2][5] = 35;
		arr[2][6] = 40;
		
		chk[2][0] = chk[0][10];
		chk[2][1] = cnt++;
		chk[2][2] = cnt++;
		chk[2][3] = chk[1][4];
		chk[2][4] = chk[1][5];
		chk[2][5] = chk[1][6];
		chk[2][6] = chk[1][7];
		
		arr[3][0] = 30;
		arr[3][1] = 28;
		arr[3][2] = 27;
		arr[3][3] = 26;
		arr[3][4] = 25;
		arr[3][5] = 30;
		arr[3][6] = 35;
		arr[3][7] = 40;
		
		chk[3][0] = chk[0][15];
		chk[3][1] = cnt++;
		chk[3][2] = cnt++;
		chk[3][3] = cnt++;
		chk[3][4] = chk[1][4];
		chk[3][5] = chk[1][5];
		chk[3][6] = chk[1][6];
		chk[3][7] = chk[1][7];
		
		end[0][21] = end[1][8] = end[2][7] = end[3][8] = true;
	}
}
class Pair{
	Point a, b, c, d;
	int sum;
	Pair(Point a, Point b, Point c, Point d, int sum){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.sum = sum;
	}
}
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}