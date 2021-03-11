import java.util.*;

public class Main {
	static int[][] arr = new int[3][3];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;
        
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++) {
        		arr[i][j] = sc.nextInt();
        		if(arr[i][j] == 1) ++a;
        		else if(arr[i][j] == 2) ++b;
        	}
        
        int res = 0;
        if(a > b)//bÂ÷·Ê
        	res = dfs(2);
        else//aÂ÷·Ê
        	res = dfs(1);
        
        if(res == 0) System.out.println("D");
        else if(res == 1) System.out.println("W");
        else System.out.println("L");
    }
	private static int dfs(int who) {
		if(check(who == 1 ? 2 : 1)) return -1;
		int ret = 2;
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = who;
					ret = Math.min(ret, dfs(who == 1 ? 2 : 1));
					arr[i][j] = 0;
				}
			}
		
		if(ret == 2 || ret == 0) return 0;
		return -ret;
	}
	private static boolean check(int who) {
		for(int i = 0; i < 3; i++) {
			if(arr[i][0] == who && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) return true;
			if(arr[0][i] == who && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) return true;
		}
		if(arr[0][0] == who && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) return true;
		if(arr[0][2] == who && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) return true;
		return false;
	}
}