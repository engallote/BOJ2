import java.util.*;

public class Main {
	static int N, M;
	static HashMap<String, Integer> hm = new HashMap<>();
	static String[] name;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	name = new String[N * 2];
    	aly = new ArrayList[N * 2];
    	
    	for(int i = 0; i < N * 2; i++) aly[i] = new ArrayList<>();
    	
    	int idx = 0;
    	for(int i = 0; i < N; i++) {
    		String a = sc.next();
    		String b = sc.next();
    		
    		if(!hm.containsKey(a)) {
    			hm.put(a, idx);
    			name[idx] = a;
    			idx += 1;
    		}
    		if(!hm.containsKey(b)) {
    			hm.put(b, idx);
    			name[idx] = b;
    			idx += 1;
    		}
    		
    		aly[hm.get(a)].add(hm.get(b));
    		aly[hm.get(b)].add(hm.get(a));
    	}
    	
    	for(int i = 0; i < M; i++) {
    		String s = sc.next();
    		String e = sc.next();
    		
    		bfs(hm.get(s), hm.get(e));
    	}
    }
	private static void bfs(int s, int e) {
		int[] chk = new int[N * 2], par = new int[N * 2];
		Arrays.fill(chk, Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		chk[s] = -1;
		par[s] = -1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				if(x == e) {
					q.clear();
					break;
				}
				
				for(int next : aly[x])
					if(chk[next] > chk[x] + 1) {
						chk[next] = chk[x] + 1;
						par[next] = x;
						q.offer(next);
					}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int idx = e;
		while(idx != -1) {
			sb.append(name[idx].charAt(0));
			idx = par[idx];
		}
		
		System.out.println(sb.reverse());
	}
}