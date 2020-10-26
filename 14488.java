import java.math.BigDecimal;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double T = sc.nextDouble();
		int[] arr = new int[N];
		BigDecimal max = new BigDecimal(Double.MAX_VALUE), min = new BigDecimal(Double.MIN_VALUE);
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int res = 1;
		for(int i = 0; i < N; i++) {
			BigDecimal num = new BigDecimal(sc.next());
			num = num.multiply(new BigDecimal(T+""));
			
			if(res == 0) continue;
			
			BigDecimal left = new BigDecimal(arr[i]+""), right = new BigDecimal(arr[i]+"");
			left = left.subtract(num);
			right = right.add(num);
			
			if(left.compareTo(max) == 1 || right.compareTo(min) == -1) {
				res = 0;
				continue;
			}
			
			if(right.compareTo(max) == -1) max = right;
			if(left.compareTo(min) == 1) min = left;
		}
		
		System.out.println(res);
	}
}