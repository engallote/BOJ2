import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextLong();
        
        Arrays.sort(arr);
        
        long res = Long.MAX_VALUE;
        for(int i = 0; i < N; i++)
        	for(int j = i + 1; j < N; j++) {
        		long num = arr[i] + arr[j];
        		
        		int l = i + 1, r = N - 1;
        		while(l < r) {
        			while(l == j) ++l;
        			while(r == i || r == j) --r;
        			
        			if(l >= r) break;
        			
        			if(num < arr[l] + arr[r]) {
        				res = Math.min(res, (arr[l] + arr[r]) - num);
        				--r;
        			}
        			else {
        				res = Math.min(res, num - (arr[l] + arr[r]));
        				++l;
        			}
        		}
        	}
        
        System.out.println(res);
	}
}