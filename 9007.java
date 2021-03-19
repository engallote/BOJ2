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
        int T = Integer.parseInt(br.readLine());
        ArrayList<Long> a = new ArrayList<>(), b = new ArrayList<>();
        StringTokenizer st;
        
        while(--T >= 0) {
        	st = new StringTokenizer(br.readLine());
        	long k = Long.parseLong(st.nextToken());
        	int n = Integer.parseInt(st.nextToken());
        	long[][] arr = new long[4][n];
        	
        	a.clear();
        	b.clear();
        	
        	for(int i = 0; i < 4; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < n; j++)
        			arr[i][j] = Long.parseLong(st.nextToken());
        	}
        	
        	for(int i = 0; i < n; i++)
        		for(int j = 0; j < n; j++) {
        			a.add(arr[0][i] + arr[1][j]);
        			b.add(arr[2][i] + arr[3][j]);
        		}
        	
        	Collections.sort(b);
        	
        	long res = a.get(0) + b.get(0), abs = Math.abs(k - res);
        	loop:for(int i = 0; i < a.size(); i++) {
        		int l = 0, r = b.size() - 1, mid;
        		while(l <= r) {
        			mid = (l + r) / 2;
        			
        			if(a.get(i) + b.get(mid) < k) l = mid + 1;
        			else if(a.get(i) + b.get(mid) == k) {
        				abs = 0;
        				res = k;
        				break loop;
        			}
        			else r = mid - 1;
        			
        			if(Math.abs(k - (a.get(i) + b.get(mid))) <= abs) {
        				if(Math.abs(k - (a.get(i) + b.get(mid))) == abs)
        					res = Math.min(res, a.get(i) + b.get(mid));
        				else res = a.get(i) + b.get(mid);
        				abs = Math.abs(k - (a.get(i) + b.get(mid)));
        			}
        		}
        	}
        	
        	bw.write(res+"\n");
        }
        bw.flush();
    }
}