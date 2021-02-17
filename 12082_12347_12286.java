import java.util.*;

public class Main {
	static int N;
	static int[] par;
	static ArrayList<Pair> arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++) {
        	N = sc.nextInt();
        	par = new int[N * 10 + 100];
        	arr = new ArrayList<>();
        	HashMap<String, Integer> hs = new HashMap<>();
        	
        	for(int i = 0; i < N * 10 + 100; i++)
        		par[i] = i;
        	
        	int idx = 0;
        	for(int i = 0; i < N; i++) {
        		String a = sc.next();
        		String b = sc.next();
        		
        		if(!hs.containsKey(a)) {
        			hs.put(a, idx);
        			++idx;
        		}
        		if(!hs.containsKey(b)) {
        			hs.put(b, idx);
        			++idx;
        		}
        		
        		arr.add(new Pair(hs.get(a), hs.get(b)));
        	}
        	
        	for(Pair p : arr) {
        		int ap = find(p.a + 100), bp = find(p.b);
        		if(ap != bp) par[bp] = ap;
        		
        		ap = find(p.a);
        		bp = find(p.b + 100);
        		
        		if(ap != bp) par[bp] = ap; 
        	}
        	boolean res = true;
        	for(int i = 0; i < idx; i++)
        		if(find(i) == find(i + 100)) {
        			res = false;
        			break;
        		}
        	
        	System.out.println("Case #" + test_case + ": " + (res ? "Yes" : "No"));
        }
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair {
	int a, b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}