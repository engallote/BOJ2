import java.util.*;

public class Main {
	static int N, res;
	static HashMap<String, Integer> hm = new HashMap<>();
	static String[] arr;
	static ArrayList<String>[] aly;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int test_case = 1; test_case <= T; test_case++) {
    		N = sc.nextInt();
    		arr = new String[N];
    		aly = new ArrayList[N];
    		res = 100000;
    		hm.clear();
    		
    		for(int i = 0; i < N; i++) aly[i] = new ArrayList<>();
    		
    		int idx = 0;
    		
    		for(int i = 0; i < N; i++) {
    			String name = sc.next();
    			int num = sc.nextInt();
    			int nIdx = idx;
    			if(hm.containsKey(name)) nIdx = hm.get(name);
    			else {
    				hm.put(name, idx);
    				arr[idx] = name;
    				++idx;
    			}
    			for(int j = 0; j < num; j++) {
    				String ing = sc.next();
    				
    				if('A' <= ing.charAt(0) && ing.charAt(0) <= 'Z')
    					aly[nIdx].add(ing); 
    			}
    		}
    		
    		ArrayList<Integer> path = new ArrayList<>();
    		solve(0, 0, path);
    		System.out.println("Case #" + test_case + ": " + res);
    	}
    }
	private static void solve(int cnt, int chk, ArrayList<Integer> path) {
		if(cnt == N) {
			find(path);
			return;
		}
		
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0) {
				path.add(i);
				solve(cnt + 1, chk | (1<<i), path);
				path.remove(path.size() - 1);
			}
	}
	private static void find(ArrayList<Integer> path) {
		int[] ready = new int[N];
		HashSet<String> hs = new HashSet<>();
		int size = 0;
		
		for(int cur : path) {
			for(int j = 0; j < aly[cur].size(); j++) {
				if(ready[hm.get(aly[cur].get(j))] == 0) return;
			}
			
			hs.add(arr[cur]);
			size = Math.max(size, hs.size());
			
			for(int j = 0; j < aly[cur].size(); j++) hs.remove(aly[cur].get(j));
			ready[cur] = 1;
		}
		
		res = Math.min(res, size);
	}
}