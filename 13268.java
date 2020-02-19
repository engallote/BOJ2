import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = {10, 20, 30, 40};
        int idx = 0;
        
        while(N / 100 > 0) N %= 100;//콘 다 돌기
        
        while(true){
        	if(N >= arr[idx]) N -= arr[idx];
        	else {
        		int cnt = 0, sw = 1;
        		while(--N >= 0){
        			if(cnt == arr[idx] / 2) sw *= -1;
        			cnt += sw;
        		}
        		
        		if(cnt == 0) System.out.println(0);
        		else if(cnt <= 5) System.out.println(1);
        		else if(cnt <= 10) System.out.println(2);
        		else if(cnt <= 15) System.out.println(3);
        		else System.out.println(4);
        		
        		break;
        	}
        	++idx;
        	idx %= 4;
        }
    }
}