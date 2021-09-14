import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	int[] d = new int[N], p = new int[N], res = new int[N];
    	
    	for(int i = 0; i < N; i++) p[i] = sc.nextInt();
    	for(int i = 0; i < N; i++) d[i] = sc.nextInt();
    	
    	while(--K >= 0) {
    		for(int i = 0; i < N; i++) {
        		int idx = d[i] - 1;
        		
        		
        		res[idx] = p[i];
        	}
    		
    		for(int i = 0; i < N; i++)
    			p[i] = res[i];
    	}
    	
    	for(int i = 0; i < N; i++)
    		System.out.print(res[i] + " ");
	}
}