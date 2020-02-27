import java.util.*;

public class Main {
	static int C, D, d, len1, len2;
	static int[] arr1 = new int[102], arr2 = new int[102];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0){
			C = sc.nextInt();
			D = sc.nextInt();
			d = sc.nextInt();
			
			int idx = 0;
			Arrays.fill(arr1, 0);
			Arrays.fill(arr2, 0);
			
			while(true){
				int num = sc.nextInt();
				if(num == 0) break;
				arr1[idx] = num;
				++idx;
			}
			
			len1 = idx;
			idx = 0;
			while(true){
				int num = sc.nextInt();
				if(num == 0) break;
				arr2[idx] = num;
				++idx;
			}
			len2 = idx;
			
			int res = solve(0, 0, 0, 0);
			System.out.println(res);
		}
	}
	private static int solve(int idx1, int idx2, int r1, int r2) {
		if(idx1 >= len1 && idx2 >= len2) return 0;
		if(idx1 >= len1){
			int tmp = D + (len2 - idx2) * d + (len2 - idx2) * C;
			return tmp;
		}
		if(idx2 >= len2){
			int tmp = D + (len1 - idx1) * d + (len1 - idx1) * C;
			return tmp;
		}
		int ret = 1000000000;
		
		if(arr1[idx1] == arr2[idx2])//둘 다 연습 
			ret = Math.min(ret, solve(idx1 + 1, idx2 + 1, 0, 0) + C);
		
		//2번 팀 휴식
		int cost = (r2 > 0) ? d : D + d;
		ret = Math.min(ret, solve(idx1 + 1, idx2, 0, r2 + 1) + cost + C);
		//1번 팀 휴식
		cost = (r1 > 0) ? d : D + d;
		ret = Math.min(ret, solve(idx1, idx2 + 1, r1 + 1, 0) + cost + C);
		//둘 다 연습
		ret = Math.min(ret, solve(idx1 + 1, idx2 + 1, 0, 0) + (C * 2));
		
		return ret;
	}
}