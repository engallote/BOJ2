import java.util.*;

public class Main {
	static int N, res;
	static Pair[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	N = sc.nextInt();
        	arr = new Pair[N];
        	res = 0;
        	for(int i = 0; i < N; i++)
        		arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        	
        	Arrays.sort(arr);
        	
        	solve(0, 0);
        	System.out.println("Case #" + test_case + ": " + res);
        }
    }
	private static void solve(int chk, int s) {
		res = Math.max(res, s);
		
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0 && s <= arr[i].x)
				solve(chk|(1<<i), s + arr[i].y);
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return -1;
		else if(o.x == this.x){
			if(o.y > this.y) return 1;
			else if(o.y == this.y) return 0;
			else return -1;
		}
		else return 1;
	}
}