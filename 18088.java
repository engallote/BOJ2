import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N], sortedArr = new int[N];
        
        for(int i = 0; i < N; i++) {
        	int num = sc.nextInt();
        	arr[i] = num;
        	sortedArr[i] = num;
        }
        
        Arrays.sort(sortedArr);
        	
        int s = 0, e = 0;
        for(int i = 0; i < N; i++) 
        	if(arr[i] != sortedArr[i]) {
        		s = i;
        		break;
        	}
        for(int i = N - 1; i >= 0; i--)
        	if(arr[i] != sortedArr[i]) {
        		e = i;
        		break;
        	}
        
        int l = s, r = e;
        while(l <= r) {
        	int tmp = arr[l];
        	arr[l] = arr[r];
        	arr[r] = tmp;
        	++l;
        	--r;
        }
        
        for(int i = 0; i < N; i++)
        	if(arr[i] != sortedArr[i]) {
        		System.out.println("impossible");
        		return;
        	}
        
        System.out.println((s + 1) + " " + (e + 1));
    }
}