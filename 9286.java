import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int tc = 1; tc <= T; tc++) {
    		System.out.println("Case " + tc + ":");
    		
    		int N = sc.nextInt();
    		for(int i = 0; i < N; i++) {
    			int num = sc.nextInt();
    			if(num == 6) continue;
    			System.out.println(num+1);
    		}
    	}
	}
}