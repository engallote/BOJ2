import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	boolean[] chk = new boolean[N + 1];
    	chk[0] = chk[1] = true;
    	ArrayList<Integer> aly = new ArrayList<>();
    	
    	for(int i = 2; i <= N; i++) {
    		if(chk[i]) continue;
    		aly.add(i);
    		for(int j = i + i; j <= N; j += i) chk[j] = true;
    	}
    	
    	long res = 1, mod = (long)1 << 32;
    	for(int num : aly) {
    		if(num > N) break;
    		long sum = 1;
    		
    		while(true) {
    			if(sum * (long)num > N) break;
    			sum *= (long)num;
    		}
    		
    		res *= sum;
    		res %= mod;
    	}
    	
    	System.out.println(res);
	}
}