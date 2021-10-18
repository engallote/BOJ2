import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	BigDecimal bd;
    	
    	for(int i = 0; i < N; i++) {
    		long num = sc.nextLong();
    		bd = new BigDecimal(num+"");
    		bd = bd.sqrt(MathContext.DECIMAL128);
    		
    		if(bd.multiply(bd).compareTo(new BigDecimal(num+"")) == 0) System.out.print("1 ");
    		else System.out.print("0 ");
    	}
	}
}