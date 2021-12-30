import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	int[][] arr = new int[M][N];
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++)
    			arr[i][j] = Integer.parseInt(st.nextToken());
    	}
    	
    	int res = 0;
    	for(int i = 0; i < M - 1; i++) {
    		for(int j = i + 1; j < M; j++) {
    			if(isTrue(N, arr[i], arr[j])) ++res;
    		}
    	}
    	System.out.println(res);
    }

	private static boolean isTrue(int N, int[] a, int[] b) {
		for(int i = 0; i < N - 1; i++)
			for(int j = i + 1; j < N; j++) {
				if(a[i] > a[j]) {
					if(b[i] <= b[j]) return false;
				}
				else if(a[i] == a[j]) {
					if(b[i] != b[j]) return false;
				}
				else if(a[i] < a[j]) {
					if(b[i] >= b[j]) return false;
				}
			}
		return true;
	}
}