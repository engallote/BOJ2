import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] arr = new long[N][2];
        long[] xx = new long[100001], yy = new long[100001];
        long res = 0;
        
        for(int i = 0; i < N; i++) {
        	arr[i][0] = sc.nextLong();
        	arr[i][1] = sc.nextLong();
        	++xx[(int)arr[i][0]];
        	++yy[(int)arr[i][1]];
        }
        
        for(int i = 0; i < N; i++)
        	res += (xx[(int)arr[i][0]] - 1) * (yy[(int)arr[i][1]] - 1);
        
        System.out.println(res);
    }
}