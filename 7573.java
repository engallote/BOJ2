import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int I = sc.nextInt();
    	int M = sc.nextInt();
    	ArrayList<Pair> fish = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt() - 1;
    		int b = sc.nextInt() - 1;
    		fish.add(new Pair(a, b));
    	}
    	
    	int res = 0;
    	for(Pair p : fish) {
    		int a = 1, b = (I - 2) / 2, sum;
    		
			while(true) {				
				for(int i = p.x - a; i <= p.x; i++)
					for(int j = p.y - b; j <= p.y; j++) {
						sum = 0;
						for(int k = 0; k < M; k++) {
							Pair next = fish.get(k);
							if(next.x >= i && next.x <= i + a && next.y >= j && next.y <= j + b)
								++sum;
						}
						res = Math.max(res, sum);
					}
				
				++a;
				--b;
				if(b < 1) break;
			}
    	}
    	
    	System.out.println(res);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}