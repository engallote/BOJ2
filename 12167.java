import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int S = sc.nextInt();
			char[] ch = sc.next().toCharArray();
			int[] sum = new int[S + 1];
			
			for(int i = 0; i <= S; i++)
				sum[i] = ch[i] - '0';
			
			int cur = sum[0], add = 0;
			for(int i = 1; i <= S; i++) {
				if(cur >= i) cur += sum[i];
				else {
					while(cur < i) {
						++add;
						cur += 1;
					}
					cur += sum[i];
				}
			}
			
			System.out.println("Case #" + test_case + ": " + add);
		}
	}
}