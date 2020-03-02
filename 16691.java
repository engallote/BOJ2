import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] sum = new long[10000001];
        for(int i = 1; i <= 10000000; i++)
        	sum[i] = sum[i-1] + i;
        
        int m = sc.nextInt();
        
        for(int i = m + 1; i < 10000000; i++){
        	long num = sum[i - 1] - sum[m - 1];
        	
        	int l = i + 1, r = 10000000, mid;
        	while(l <= r){
        		mid = (l + r) / 2;
        		if(mid <= i) break;
        		
        		if(sum[mid] - sum[i] > num) r = mid - 1;
        		else if(sum[mid] - sum[i] == num){
        			System.out.println(m + " " + i + " " + mid);
        			return;
        		}
        		else l = mid + 1;
        	}
        }
    }
}