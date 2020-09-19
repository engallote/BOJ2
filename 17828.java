import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        if(N > X || 26 * N < X){
        	bw.write("!");
        	bw.flush();
        	return;
        }
        
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        Arrays.fill(arr, 1);
        X -= N;
        
        
        for(int i = N - 1; i >= 0; i--){
        	int tmp = Math.min(X, 25);
        	arr[i] += tmp;
        	sb.append((char)(arr[i]-1+'A'));
        	X -= tmp;
        }
        
        bw.write(sb.reverse().toString()+"");
        bw.flush();
    }
}