import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] have = new int[N + 1], change = new int[1000001];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= N; i++)
    		have[i] = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= N; i++)
    		change[Integer.parseInt(st.nextToken())] += 1;
    	
    	int res = 0;
    	for(int i = 1; i <= N; i++) {
    		if(change[have[i]] > 0) --change[have[i]];
    		else res += 1;
    	}
    	
    	System.out.println(res);
	}
}