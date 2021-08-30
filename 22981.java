import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static long K;
	static long[] arr;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Long.parseLong(st.nextToken());
    	arr = new long[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++)
    		arr[i] = Long.parseLong(st.nextToken());
    	
    	Arrays.sort(arr);
    	
    	long res = Long.MAX_VALUE;
    	
    	for(int i = N - 1; i > 0; i--) {
    		long v1 = arr[0] * i;
    		long v2 = arr[i] * (N - i);
    		long sum = K / (v1 + v2) + (K % (v1 + v2) > 0 ? 1 : 0);
    		res = Math.min(sum, res);
    	}
    	
    	System.out.println(res);
	}
}