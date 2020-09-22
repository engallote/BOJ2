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
        int N = Integer.parseInt(br.readLine());
        long res = 0;
        ArrayList<Pair> aly = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) aly.add(new Pair(Long.parseLong(st.nextToken()), 0));
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) aly.get(i).day = Long.parseLong(st.nextToken());
        
        for(int i = 0; i < N; i++){
        	if(aly.get(i).day <= aly.get(i).cur) continue;
        	long sub = aly.get(i).day - aly.get(i).cur;
        	long num = sub / 30 * 30 + (sub % 30 > 0 ? 30 : 0);
    		res += sub / 30 + (sub % 30 > 0 ? 1 : 0);
        	
        	aly.get(i).cur += num;
        }
        	
        Collections.sort(aly);
        
        long pre = 0, max = 0;
        for(int i = 0; i < N; i++){
        	if(i > 0 && aly.get(i).day != aly.get(i-1).day){
        		pre = Math.max(pre, max);
        		max = 0;
        	}
        	if(pre > aly.get(i).cur){
        		long sub = pre - aly.get(i).cur;
        		res += sub / 30 + (sub % 30 > 0 ? 1 : 0);
        		aly.get(i).cur = aly.get(i).cur + sub / 30 * 30 + (sub % 30 > 0 ? 30 : 0);
        	}
        	max = Math.max(max, aly.get(i).cur);
        }
        
        bw.write(res+"");
        bw.flush();
    }
}
class Pair implements Comparable<Pair>{
	long cur, day;
	Pair(long cur, long day){
		this.cur = cur;
		this.day = day;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.day > this.day) return -1;
		else if(o.day == this.day) return o.cur > this.cur ? -1 : (o.cur == this.cur ? 0 : 1);
		else return 1;
	}
}