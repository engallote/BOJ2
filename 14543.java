import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++) {
        	String[] str = sc.nextLine().split(" ");
        	
        	BigDecimal A = new BigDecimal(str[0].substring(0, str[0].length() - 1));
        	BigDecimal B = new BigDecimal(str[2]);
        	BigDecimal C = new BigDecimal(str[4]);
        	
        	C = C.subtract(B);
        	
        	System.out.println("Equation " + test_case);
        	
        	if(A.compareTo(new BigDecimal("0")) != 0) {
        		BigDecimal res = C.divide(A, MathContext.DECIMAL128).setScale(6, BigDecimal.ROUND_DOWN);
        		
        		System.out.println("x = " + res);
        	}
        	else {
        		if(C.compareTo(new BigDecimal("0")) == 0) System.out.println("More than one solution.");
        		else System.out.println("No solution.");
        	}
        	
        	System.out.println();
        }
	}
}