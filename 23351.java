import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	int[] arr = new int[N];
    	Arrays.fill(arr, K);
    	
    	int day = 1, idx = 0;
    	while(true) {
    		//water
    		int cnt = 0;
    		while(cnt < A) {
    			arr[idx] += B;
    			idx += 1;
    			idx %= N;
    			++cnt;
    		}
    		
    		//remove
    		int zero = 0;
    		for(int i = 0; i < N; i++) {
    			arr[i] -= 1;
    			if(arr[i] <= 0) {
    				zero = 1;
    				break;
    			}
    		}
    		
    		if(zero > 0) break;
    		++day;
    	}
    	
    	System.out.println(day);
	}
}