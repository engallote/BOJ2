import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String pre = sc.next();
		
		for(int i = 0; i < N; i++){
			String str = sc.next();
			
			if(order(pre, str)) System.out.println("+");
			else System.out.println("-");
		}
	}
	private static boolean order(String str1, String str2) {
		int len = Math.min(str1.length(), str2.length());
		int sum1 = 0, sum2 = 0;
		char[] a = str1.toCharArray(), b = str2.toCharArray();
		
		for(int i = 0; i < len; i++){			
			if(a[i] >= '0' && a[i] <= '9' && b[i] >= '0' && b[i] <= '9'){
				int idx1 = i;
				while(idx1 < a.length && (a[idx1] >= '0' && a[idx1] <= '9')){
					sum1 *= 10;
					sum1 += a[idx1] - '0';
					++idx1;
				}
				int idx2 = i;
				while(idx2 < b.length && (b[idx2] >= '0' && b[idx2] <= '9')){
					sum2 *= 10;
					sum2 += b[idx2] - '0';
					++idx2;
				}
				
				if(sum1 > sum2) return false;
				if(sum1 < sum2) return true;
				sum1 = sum2 = 0;
				if(idx1 >= a.length || idx2 >= b.length) break;
			}
			if(a[i] < b[i]) return true;
			if(a[i] > b[i]) return false;
		}
		
		if(a.length <= b.length) return true;
		return false;
	}
}