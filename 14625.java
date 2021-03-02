import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H1 = sc.nextInt();
        int M1 = sc.nextInt();
        
        int H2 = sc.nextInt();
        int M2 = sc.nextInt();
        
        int N = sc.nextInt();
        
        int res = 0;
        while(H1 < H2) {
        	if(M1 / 10 == N || M1 % 10 == N || H1 / 10 == N || H1 % 10 == N) ++res;
    		++M1;
    		
    		if(M1 == 60) {
    			M1 = 0;
    			++H1;
    		}
    	}
    	while(M1 <= M2) {
    		if(M1 / 10 == N || M1 % 10 == N || H1 / 10 == N || H1 % 10 == N) ++res;
    		++M1;
    	}
        System.out.println(res);
    }
}