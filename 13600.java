import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int res = 0, root = (int)Math.sqrt(N);
        
        for(int i = root; i >= 1; i--) {
        	int num = fac(i);
        	while(true) {
        		if(num <= N) {
        			N -= num;
        			++res;
        		}
        		else break;
        	}
        	if(N <= 0) break;
        }
        
        System.out.println(res);
    }

	private static int fac(int x) {
		int sum = 1;
		for(int i = x; i >= 2; i--){
			sum *= i;
			if(sum > N) {
				sum = 1000000;
				break;
			}
		}
		
		return sum;
	}
}