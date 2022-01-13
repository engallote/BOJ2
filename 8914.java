import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	while(--T >= 0) {
    		int K = sc.nextInt();
    		HashSet<Character>[] hs = new HashSet[5], con = new HashSet[5];
    		ArrayList<Character>[] aly = new ArrayList[5];
    		
    		for(int i = 0; i < 5; i++) {
    			hs[i] = new HashSet<>();
    			con[i] = new HashSet<>();
    			aly[i] = new ArrayList<>();
    		}
    		
    		for(int i = 0; i < 6; i++) {
    			char[] ch = sc.next().toCharArray();
    			for(int j = 0; j < 5; j++) hs[j].add(ch[j]);
    		}
    		for(int i = 0; i < 6; i++) {
    			char[] ch = sc.next().toCharArray();
    			for(int j = 0; j < 5; j++) {
    				if(hs[j].contains(ch[j])) {//만약 있다면 두 스냅샷에 모두 있는 알파벳
    					if(con[j].contains(ch[j])) continue;
    					else {
    						aly[j].add(ch[j]);
    						con[j].add(ch[j]);
    					}
    				}
    			}
    		}
    		
    		for(int i = 0; i < 5; i++)
    			Collections.sort(aly[i]);
    		
    		int cnt = 0;
    		loop:for(int a = 0; a < aly[0].size(); a++)
    			for(int b = 0; b < aly[1].size(); b++)
    				for(int c = 0; c < aly[2].size(); c++)
    					for(int d = 0; d < aly[3].size(); d++)
    						for(int e = 0; e < aly[4].size(); e++) {
    							++cnt;
    							if(cnt == K) {
    								System.out.println(aly[0].get(a) + "" + aly[1].get(b) + "" + aly[2].get(c) + "" + aly[3].get(d) + "" + aly[4].get(e));
    								break loop;
    							}
    						}
    							
    		if(cnt < K) System.out.println("NO");
    	}
    }
}