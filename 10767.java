import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static HashMap<String, String> hm;
	static HashSet<String> hs2;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new char[N][N];
    	hm = new HashMap<>();
    	hs2 = new HashSet<>();
    	
    	for(int i = 0; i < N; i++)
    		map[i] = sc.next().toCharArray();
    	
    	if(map[0][0] != map[N - 1][N - 1]) System.out.println(0);
    	else {
    		ArrayList<Character> path = new ArrayList<>();
    		solveF(0, 0, 0, path);
    		solveE(0, N - 1, N - 1, path);
    		System.out.println(hs2.size());
    	}
    }
	private static void solveE(int cnt, int x, int y, ArrayList<Character> path) {
		if(cnt == N - 1) {
			if(hm.containsKey(path.toString())) {
				String val = hm.get(path.toString());
				
				if(val.contains(Integer.toString(x * 10000 + y))) hs2.add(path.toString());
			}
			return;
		}
		
		if(x - 1 >= 0) {
			char a = map[x - 1][y];
			path.add(a);
			solveE(cnt + 1, x - 1, y, path);
			path.remove(path.size() - 1);
		}
		if(y - 1 >= 0) {
			char a = map[x][y - 1];
			path.add(a);
			solveE(cnt + 1, x, y - 1, path);
			path.remove(path.size() - 1);
		}
	}
	private static void solveF(int cnt, int x, int y, ArrayList<Character> path) {
		if(cnt == N - 1) {
			if(hm.containsKey(path.toString()))
				hm.replace(path.toString(), hm.get(path.toString()) + (x * 10000 + y) + " ");
			else hm.put(path.toString(), (x * 10000 + y) + " ");
			return;
		}
		
		if(x + 1 < N) {
			char a = map[x + 1][y];
			path.add(a);
			solveF(cnt + 1, x + 1, y, path);
			path.remove(path.size() - 1);
		}
		if(y + 1 < N) {
			char a = map[x][y + 1];
			path.add(a);
			solveF(cnt + 1, x, y + 1, path);
			path.remove(path.size() - 1);
		}
	}
}