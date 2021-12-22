import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		int R = sc.nextInt();
    		int C = sc.nextInt();
    		
    		if(R == 0 && C == 0) break;
    		
    		int[][] arr = new int[R][C];
    		int M = sc.nextInt();
    		
    		while(--M >= 0) {
    			int x = sc.nextInt();
    			int y = sc.nextInt();
    			arr[x][y] += 1;
    		}
    		
    		int N = sc.nextInt();
    		int res = 0;
    		while(--N >= 0) {
    			int x = sc.nextInt();
    			int y = sc.nextInt();
    			res += arr[x][y];
    		}
    		
    		System.out.println(res);
    	}
    }
}