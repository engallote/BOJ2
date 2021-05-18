import java.util.*;

public class Main {
	static int[] chk;
	static int cnt;
	static String[] name;
	static boolean[] finish;
	static Stack<Integer> st;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	boolean end = false;
    	HashMap<String, Integer> hm = new HashMap<>();
    	chk = new int[300];
    	finish = new boolean[300];
    	name = new String[300];
    	aly = new ArrayList[300];
    	st = new Stack<>();
    	for(int i = 0; i < 300; i++)
    		aly[i] = new ArrayList<>();
    	
    	int idx = 1, tc = 1;
    	
    	while(true) {
    		String str = sc.nextLine();
    		if(str.equals("#")) {
    			if(end) break;
    			end = true;
    			st.clear();
    			
    			System.out.println("Party number " + tc);
    			
    			++tc;
    			
    			cnt = 0;
    			ArrayList<Integer> res = new ArrayList<>();
    			for(int i = 1; i < idx; i++)
    				if(!finish[i]) findCycle(i, i, 1, res);
    			
    			for(int i = 0; i < 300; i++) {
    				aly[i].clear();
    				chk[i] = 0;
    				finish[i] = false;
    				name[i] = "";
    			}
    			
    			hm.clear();
    			idx = 1;
    			System.out.println();
    			continue;
    		}
    		
    		String[] strArr = str.split(" ");
    		int a = 0, b = 0;
    		if(hm.containsKey(strArr[0])) a = hm.get(strArr[0]);
    		else {
    			hm.put(strArr[0], idx);
    			name[idx] = strArr[0];
    			a = idx;
    			++idx;
    		}
    		if(hm.containsKey(strArr[1])) b = hm.get(strArr[1]);
    		else {
    			hm.put(strArr[1], idx);
    			name[idx] = strArr[1];
    			b = idx;
    			++idx;
    		}
    		
    		aly[a].add(b);
    		
    		end = false;
    	}
	}
	private static void findCycle(int p, int idx, int cnt, ArrayList<Integer> res) {
		if(p == idx && cnt > 1) {
			System.out.print(name[res.get(res.size() - 1)] + " to ");
			for(int i = 0; i < res.size(); i++) {
				finish[res.get(i)] = true;
				if(i == res.size() - 1) System.out.println(name[res.get(i)] + ".");
				else System.out.print(name[res.get(i)] + " to ");
			}
			return;
		}
		
		for(int next : aly[idx]) {
			res.add(next);
			findCycle(p, next, cnt + 1, res);
			res.remove(res.size() - 1);
		}
	}
}