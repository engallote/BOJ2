import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new char[N][M];
    	int n = 10000, m = 10000;
    	
    	for(int i = 0; i < N; i++)
    		map[i] = sc.next().toCharArray();
    	
    	StringBuilder sb = new StringBuilder();
    	for(int a = 1; a <= N; a++) {
    		if(N % a != 0) continue;
    		for(int b = 1; b <= M; b++) {
    			if(M % b != 0) continue;
    			boolean flag = true;
    			
    			loop:for(int i = 0; i < N; i+=a) {
    				for(int j = 0; j < M; j+=b) {
    					char c = map[i][j];		
    					
    					for(int k = i; k < i + a; k++)
    						for(int l = j; l < j + b; l++)
    							if(c != map[k][l]) {
    								flag = false;
    								break loop;
    							}
    				}
    			}
    			
    			if(flag) {
    				if((N / a) * (M / b) < n * m) {
    					n = N / a;
    					m = M / b;
    					sb = new StringBuilder();
    					
    					for(int i = 0; i < N; i+=a) {
    						for(int j = 0; j < M; j+=b)
    	    					sb.append(map[i][j]);
    	    				sb.append("\n");
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.println(n + " " + m);
    	System.out.println(sb.toString());
	}
}