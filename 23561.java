import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt() * 3;
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	
    	int mid = N / 3;
    	System.out.println(arr[N - mid - 1] - arr[mid]);
    }
}