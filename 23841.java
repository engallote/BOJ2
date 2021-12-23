import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	char[][] ch = new char[N][M];
    	
    	for(int i = 0; i < N; i++)
    		ch[i] = sc.next().toCharArray();

    	for(int i = 0; i < N; i++) {
    		int l = M / 2 - 1, r = M / 2;
    		while(l >= 0 && r < M) {
    			if(ch[i][l] != '.') ch[i][r] = ch[i][l];
    			else if(ch[i][r] != '.') ch[i][l] = ch[i][r];
    			--l;
    			++r;
    		}
    		
    		System.out.println(new String(ch[i]));
    	}
    }
}