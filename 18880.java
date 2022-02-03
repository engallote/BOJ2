import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	boolean flag = true;
    	for(char c : ch)
    		if(c == '1') {
    			flag = false;
    			break;
    		}
    	
    	if(flag) {
    		System.out.println(N - 1);
    		return;
    	}
    	
    	ArrayList<Integer> aly = new ArrayList<>();
    	for(int i = 0; i < N; i++)
    		if(ch[i] == '1') aly.add(i + 1);
    	
    	int l = 0, r = N, mid, res = 0;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
    		int cnt = 0;
    		
    		for(int i = 0; i < aly.size(); i++) {
    			if(i == 0) cnt += (aly.get(i) - 1) / mid;
    			else cnt += (aly.get(i) - aly.get(i - 1)) / mid > 0 ? (aly.get(i) - aly.get(i - 1)) / mid - 1 : 0;
    		}
    		
    		cnt += (N - aly.get(aly.size() - 1)) / mid > 0 ? (N - aly.get(aly.size() - 1)) / mid : 0;
    		
    		if(cnt >= 2) {
    			res = Math.max(res, mid);
    			l = mid + 1;
    		}
    		else r = mid - 1;
    	}
    	
    	for(int i = 1; i < aly.size(); i++) res = Math.min(res, aly.get(i) - aly.get(i - 1));
    	
    	System.out.println(res);
    }
}