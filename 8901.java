import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0){
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			
			int AB = sc.nextInt();
			int BC = sc.nextInt();
			int CA = sc.nextInt();
			
			int res = 0;
			int min = Math.min(A, B);
			
			for(int i = 0; i <= min; i++){
				int min2 = Math.min(B-i, C);
				for(int j = 0; j <= min2; j++){
					int tmp = Math.min(A-i, C-j);
					res = Math.max(res, AB * i + BC * j + CA * tmp); 
				}
			}
			
			System.out.println(res);
		}
	}
}