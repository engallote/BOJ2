import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int K = sc.nextInt();
    	int N = sc.nextInt();
    	
    	if(N == 1) {
    		System.out.println(-1);
    		return;
    	}
    	
    	BigInteger l = BigInteger.ONE, r = new BigInteger(Long.toString(Long.MAX_VALUE)), mid = BigInteger.ZERO, res = r;
    	while(l.compareTo(r) <= 0) {
    		mid = BigInteger.ZERO;
    		mid = mid.add(l);
    		mid = mid.add(r);
    		mid = mid.divide(new BigInteger("2"));
    		BigInteger a = mid, b = mid;
    		a = a.multiply(new BigInteger(Integer.toString(N)));
    		b = b.add(new BigInteger(Integer.toString(K)));
    		
    		if(a.compareTo(b) >= 0) {
    			if(res.compareTo(mid) > 0) res = mid;
    			r = mid;
    			r = r.subtract(BigInteger.ONE);
    		}
    		else {
    			l = mid;
    			l = l.add(BigInteger.ONE);
    		}
    	}
    	
    	res = res.add(new BigInteger(Integer.toString(K)));
    	System.out.println(res);
    }
}