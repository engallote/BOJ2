import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int pre = -1;
    	boolean up = true;
    	
    	for(int i = 0; i < N; i++) {
    		int num = sc.nextInt();
    		
    		if(up && pre < num) pre = num;
    		else if(pre > num) {
    			up = false;
    			pre = num;
    		}
    		else {
    			System.out.println("NO");
    			return;
    		}
    	}
    	
    	System.out.println("YES");
	}
}