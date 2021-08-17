import java.util.*;

public class Main {
	static int N, sx, sy, ex, ey, res;
	static String ans = "";
	static char[][] map;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new char[N][N];
    	ArrayList<Pair> j = new ArrayList<>(), c = new ArrayList<>(), b = new ArrayList<>(), w = new ArrayList<>();
    	res = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < N; i++) {
    		map[i] = sc.next().toCharArray();
    		for(int jj = 0; jj < N; jj++) {
    			if(map[i][jj] == '#') {
    				ex = i;
    				ey = jj;
    			}
    			else if(map[i][jj] == 'H') {
    				sx = i;
    				sy = jj;
    			}
    			else if(map[i][jj] == 'J') j.add(new Pair(i, jj));
    			else if(map[i][jj] == 'C') c.add(new Pair(i, jj));
    			else if(map[i][jj] == 'B') b.add(new Pair(i, jj));
    			else if(map[i][jj] == 'W') w.add(new Pair(i, jj));
    		}
    	}
    	
    	solve(j, "Assassin");
    	solve(c, "Healer");
    	solve(b, "Mage");
    	solve(w, "Tanker");
    	
    	System.out.println(ans);
	}
	private static void solve(ArrayList<Pair> aly, String str) {
		int sum = 0;
    	for(int i = 0; i < 3; i++)
    		for(int j = 0; j < 3; j++) {
    			if(i == j) continue;
    			for(int k = 0; k < 3; k++) {
    				if(i == k || j == k) continue;
//    				System.out.println(i + " " + j + " " + k + " " + str);
                    sum = 0;
    				sum += getD(sx, sy, aly.get(i).x, aly.get(i).y);
    				
    				sum += getD(aly.get(i).x, aly.get(i).y, aly.get(j).x, aly.get(j).y);
    				
    				sum += getD(aly.get(j).x, aly.get(j).y, aly.get(k).x, aly.get(k).y);
    				
    				sum += getD(aly.get(k).x, aly.get(k).y, ex, ey);
    				
    				if(res > sum) {
    					res = sum;
    					ans = str;
    				}
    			}
    		}
	}
	private static int getD(int x, int y, int x2, int y2) {
		return Math.abs(x - x2) + Math.abs(y - y2);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}