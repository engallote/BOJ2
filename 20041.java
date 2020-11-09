import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] arr = new Pair[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(goUp(x, y, arr)) System.out.println("YES");
		else if(goDown(x, y, arr)) System.out.println("YES");
		else if(goRight(x, y, arr)) System.out.println("YES");
		else if(goLeft(x, y, arr)) System.out.println("YES");
		else System.out.println("NO");
	}

	private static boolean goLeft(int x, int y, Pair[] arr) {
		for(Pair p : arr) {
			if(x <= p.x) continue;
			if(x - p.x >= Math.abs(p.y - y)) return false;
		}
		return true;
	}

	private static boolean goRight(int x, int y, Pair[] arr) {
		for(Pair p : arr) {
			if(x >= p.x) continue;
			if(p.x - x >= Math.abs(p.y - y)) return false;
		}
		return true;
	}

	private static boolean goDown(int x, int y, Pair[] arr) {
		for(Pair p : arr) {
			if(y <= p.y) continue;
			if(y - p.y >= Math.abs(p.x - x)) return false;
		}
		return true;
	}

	private static boolean goUp(int x, int y, Pair[] arr) {
		for(Pair p : arr) {
			if(y >= p.y) continue;
			if(p.y - y >= Math.abs(p.x - x)) return false;
		}
		return true;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}