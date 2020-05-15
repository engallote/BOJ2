import java.util.*;

public class Main {
	static int N, count = 0;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        int res = 0;
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.next().toCharArray();
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		if(arr[i][j] == '1'){
        			for(int k = 1;;k++){
        				if(range(i, j, k) && fillZero(i, j, k)) ++res;
        				else break;
        			}
        		}
        
        System.out.println(res);
    }
	private static boolean fillZero(int x, int y, int k) {
		for(int i = x - k; i <= x + k; i++){
			if(i == x) continue;
			for(int j = y - k; j <= y + k; j++)
				if(j != y && arr[i][j] == '1') return false;
		}
		
		return true;
	}
	private static boolean range(int x, int y, int k) {
		if(x - k < 0 || y - k < 0 || x + k >= N || y + k >= N || arr[x+k][y] == '0' 
		|| arr[x-k][y] == '0' || arr[x][y-k] == '0' || arr[x][y+k] == '0') return false;
		return true;
	}
}