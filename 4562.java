import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	for(int i = 0; i < N; i++) {
    		int x = sc.nextInt();
    		int y = sc.nextInt();
    		
    		if(x < y) System.out.println("NO BRAINS");
    		else System.out.println("MMM BRAINS");
    	}
	}
}