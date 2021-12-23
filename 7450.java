import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int L = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	
    	int l = 0, r = N - 1, res = 0;
    	while(l <= r) {
    		if(arr[l] + arr[r] <= L) {
    			res += 1;
    			l += 1;
    			r -= 1;
    		}
    		else {
    			res += 1;
    			r -= 1;
    		}
    	}
    	
    	System.out.println(res);
    }
}