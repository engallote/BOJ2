import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	char[][] arr = new char[N][];
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = sc.next().toCharArray();
    	
    	int res = 0;
    	HashSet<String> hs = new HashSet<>();
    	StringBuilder sb = new StringBuilder();
    	
    	int l = 0, r = N - 1, mid;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
    		boolean flag = true;
    		
    		hs.clear();
    		for(int j = 0; j < M; j++) {
    			sb = new StringBuilder();
    			for(int i = mid; i < N; i++)
    				sb.append(arr[i][j]);
    			
    			hs.add(sb.toString());
    		}
    			
    		if(hs.size() != M) flag = false;
    		
    		if(!flag) r = mid - 1;
    		else {
    			res = Math.max(res, mid);
    			l = mid + 1;
    		}
    	}
    	
    	System.out.println(res);
	}
}