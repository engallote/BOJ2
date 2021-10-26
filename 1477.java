import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int L = sc.nextInt();
    	ArrayList<Integer> aly = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++)
    		aly.add(sc.nextInt());
    	
    	aly.add(0);
    	aly.add(L);
    	
    	Collections.sort(aly);
    	
    	int l = 1, r = L, mid;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		int cnt = 0;
    		if(mid == 0) {
    			l = mid + 1;
    			continue;
    		}
    		
    		for(int i = 1; i < aly.size(); i++)
    			cnt += (aly.get(i) - aly.get(i - 1) - 1) / mid;
    		
    		if(cnt > M) l = mid + 1;
    		else r = mid - 1;
    	}
    	
    	System.out.println(l);
	}
}