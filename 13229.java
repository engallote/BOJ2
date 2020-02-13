import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N], sum = new int[N];
        
        for(int i = 0; i < N; i++){
        	arr[i] = sc.nextInt();
        	if(i == 0) sum[i] = arr[i];
        	else sum[i] = sum[i-1] + arr[i];
        }
        
        int Q = sc.nextInt();
        while(--Q >= 0){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	if(a == 0) System.out.println(sum[b]);
        	else System.out.println(sum[b]-sum[a-1]);
        }
    }
}