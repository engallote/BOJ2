import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	long[] arr = new long[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextLong();
    	
    	Arrays.sort(arr);
    	
    	double avg = 0.0, res = 0.0;
    	for(int i = 0; i < N - 2; i++) {
    		avg = (arr[i] + arr[i + 1] + arr[N - 1]) / 3.0;
			res = Math.max(res, Math.abs(arr[i + 1] - avg) * 3.0);
    	}
    	
    	for(int i = 1; i < N - 1; i++) {
    		avg = (arr[0] + arr[i] + arr[i + 1]) / 3.0;
			res = Math.max(res, Math.abs(arr[i] - avg) * 3.0);
    	}
    	
    	System.out.println(Math.round(res));
    }
}