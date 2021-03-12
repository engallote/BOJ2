import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[40][40];
        arr[0][0] = 1;
        
        for(int i = 1; i < 40; i++)
        	for(int j = 0; j <= i; j++) {
        		if(j == 0) arr[i][j] = 1;
        		else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
        	}
        
        int R = sc.nextInt()-1;
        int C = sc.nextInt()-1;
        int W = sc.nextInt();
        int res = 0, c = C;
        
        for(int i = R; i < R + W; i++) {
        	for(int j = C; j <= c; j++)
        		res += arr[i][j];
        	++c;
        }
        
        System.out.println(res);
    }
}