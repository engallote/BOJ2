import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        
        Arrays.sort(arr);
        int sum = 0;
        
        for(int i = N - 1; i >= 0 && K > 0; i--) {
        	sum += arr[i];
        	--K;
        }
        
        System.out.println(sum);
    }
}