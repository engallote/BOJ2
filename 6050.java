import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        int res = 0;
        
        for(int i = 0; i < N; i++) {
        	int sum = 0;
        	boolean down = false;
        	for(int j = i + 1; j < N; j++) {
        		if(arr[j - 1] <= arr[j]) {
        			if(down && arr[j - 1] < arr[j]) break;
        			++sum;
        		}
        		else if(arr[j - 1] >= arr[j]) {
        			down = true;
        			++sum;
        		}
        	}
        	
        	res = Math.max(res, sum + 1);
        }
        System.out.println(res);
	}
}