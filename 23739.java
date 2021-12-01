import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	int res = 0, time = 30;
    	for(int i = 0; i < N; i++) {
    		int num = sc.nextInt();
    		if(time >= num) {
    			time -= num;
    			++res;
    			if(time == 0) time = 30;
    		}
    		else {
    			if(num / 2.0 <= time) ++res;
    			time = 30;
    		}
    	}
    	
    	System.out.println(res);
    }
}