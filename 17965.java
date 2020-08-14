import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N], arr2 = new int[N];
        int min = 0;
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        
        for(int i = 0; i < N; i++)
        	arr2[i] = sc.nextInt();
        
        for(int i = 0; i < N; i++){
        	int tmp = Integer.MAX_VALUE;
        	for(int j = 0; j < N; j++)
        		tmp = Math.min(tmp, Math.abs(arr[i]-arr2[j]));
        	min = Math.max(min, tmp);
        }
        
        System.out.println(min);
	}
}