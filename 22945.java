import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	 int N = sc.nextInt();
    	 int[] arr = new int[N];
    	 
    	 for(int i = 0; i < N; i++)
    		 arr[i] = sc.nextInt();
    	 
    	 int l = 0, r = N - 1, res = 0;
    	 
    	 while(l < r) {
    		 int sum = Math.min(arr[l], arr[r]) * (r - l - 1);
    		 
    		 res = Math.max(res, sum);
    		 
    		 if(arr[l] < arr[r]) l += 1;
    		 else r -= 1;
    	 }
    	 
    	 System.out.println(res);
	}
}