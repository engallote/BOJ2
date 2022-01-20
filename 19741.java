import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	
    	int idx = 1, cnt = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			cnt = 0;
    			for(int k = 1; k <= idx; k++)
    				if(idx % k == 0) ++cnt;
    			
    			if(cnt <= K) System.out.print("*");
    			else System.out.print(".");
    			
    			++idx;
    		}
    		System.out.println();
    	}
    }
}