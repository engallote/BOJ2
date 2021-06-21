import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	if(25 >= N) System.out.println(new String(ch));
    	else {
    		int end = N - 12;
    		boolean two = false;
    		int cnt = 0;
    		for(int i = 11; i <= end; i++) {
    			if(ch[i] == '.') two = true;
    			else if(two) ++cnt;
    		}
    		
    		if(two && cnt > 0) {//µŒ πÆ¿Â
    			System.out.print(new String(ch).substring(0, 9));
    			System.out.print("......");
    			System.out.println(new String(ch).substring(N-10));
    		}
    		else {
    			System.out.print(new String(ch).substring(0, 11));
    			System.out.print("...");
    			System.out.println(new String(ch).substring(N-11));
    		}
    	}
	}
}