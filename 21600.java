import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = sc.nextInt();
    	
    	int l = 0, r = 1, res = 1;
    	
    	while(l <= r) {
    		if(r < N && arr[r] >= r - l + 1) ++r;
    		else ++l;
    		if(res < r - l) res = r - l;
    	}
    	
    	System.out.println(res);
	}
}