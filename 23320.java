import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	Arrays.sort(arr);
    	
    	int X = sc.nextInt();
    	int Y = sc.nextInt();
    	int cnt = 0;
    	
    	for(int i = 0; i < N; i++)
    		if(arr[i] >= Y) {
    			cnt = N - i;
    			break;
    		}
    	
    	System.out.println((int)(N * (X * 0.01)) + " " + cnt);
	}
}