import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(--T >= 0) {
        	int tc = sc.nextInt();
        	int N = sc.nextInt();
        	arr = new int[10];
        	
        	for(int i = 0; i < 10; i++)
        		arr[i] = sc.nextInt();
        	
        	boolean res = solve(0, 0, N);
        	if(res) System.out.println(tc + " YES");
        	else System.out.println(tc + " NO");
        }
	}
	private static boolean solve(int idx, int sum, int N) {
		if(sum == N) return true;
		if(sum > N || idx == 10) return false;
		
		boolean ret = false;
		
		ret |= solve(idx + 1, sum, N);
		ret |= solve(idx + 1, sum + arr[idx], N);
		
		return ret;
	}
}