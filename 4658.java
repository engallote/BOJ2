import java.util.*;

public class Main {
	static int res;
	static int[][] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		arr = new int[6][3];
    		res = 0;
    		
    		for(int i = 0; i < 6; i++)
    			for(int j = 0; j < 3; j++) arr[i][j] = sc.nextInt();
    		
    		solve(1, (1<<0), arr[0][0], arr[0][1], arr[0][2]);
    		solve(1, (1<<0), arr[0][1], arr[0][2], arr[0][0]);
    		solve(1, (1<<0), arr[0][2], arr[0][0], arr[0][1]);
    		
    		System.out.println(res == 0 ? "none" : res);
    		
    		String str = sc.next();
    		if(str.equals("$")) break;
    	}
    }
	private static void solve(int idx, int chk, int sum, int left, int pr) {
		if(idx == 5) {
			for(int i = 1; i < 6; i++)
				if((chk&(1<<i)) == 0) {
					if(arr[i][0] == pr && arr[i][1] == left) res = Math.max(res, sum + arr[i][2]);
					if(arr[i][1] == pr && arr[i][2] == left) res = Math.max(res, sum + arr[i][0]);
					if(arr[i][2] == pr && arr[i][0] == left) res = Math.max(res, sum + arr[i][1]);
				}
			
			return;
		}
		
		for(int i = 1; i < 6; i++) {
			if((chk&(1<<i)) != 0) continue;
			if(arr[i][0] == left) {//오른쪽으로 한바퀴 돌려
//				arr[i][2]   arr[i][0]
//						arr[idx][1]
				solve(idx + 1, chk|(1<<i), sum + arr[i][1], arr[i][2], pr);
			}
			if(arr[i][1] == left) {//그대로 붙여
//				arr[idx][0] arr[idx][1]
//						arr[idx][2]
				solve(idx + 1, chk|(1<<i), sum + arr[i][2], arr[i][0], pr);
			}
			if(arr[i][2] == left) {//왼쪽으로 한바퀴 돌려
//				arr[idx][1] arr[idx][2]
//						arr[idx][0]
				solve(idx + 1, chk|(1<<i), sum + arr[i][0], arr[i][1], pr);
			}
		}
	}
}