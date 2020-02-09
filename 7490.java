import java.util.*;

public class Main {
	static int N;
	static PriorityQueue<String> pq = new PriorityQueue<>();
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(--T >= 0){
        	N = sc.nextInt();
        	
        	hs.clear();
        	pq.clear();
        	
        	solve(2, "1");
        	
        	while(!pq.isEmpty())
        		System.out.println(pq.poll());
        	
        	System.out.println();
        }
    }
	private static void solve(int idx, String str) {
		if(idx > N){
			if(!hs.contains(str) && sum(str)){
				hs.add(str);
				pq.offer(str);
			}
			return;
		}
		
		solve(idx + 1, str+"+"+idx);
		solve(idx + 1, str+"-"+idx);
		solve(idx + 1, str+" "+idx);
	}
	private static boolean sum(String str) {
		char[] ch = str.toCharArray();
		int sum = 0, num = ch[0]-'0', idx = 0;
		char c = '+';
		
		for(int i = 1; i < ch.length; i++){
			if(ch[i] == '+' || ch[i] == '-'){
				if(c == '+') sum += num;
				else sum -= num;
				
				c = ch[i];
				num = 0;
			}
			else{
				if(ch[i] == ' ') continue;
				else{
					num *= 10;
					num += (ch[i] - '0');
				}
			}
		}
		
		if(c == '+') sum += num;
		else sum -= num;
//		System.out.println(str + " = " + sum);
		return sum == 0 ? true : false;
	}
}