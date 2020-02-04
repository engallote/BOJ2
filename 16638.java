import java.util.*;

public class Main {
	static int N;
	static long res = Long.MIN_VALUE;
	static char[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ch = sc.next().toCharArray();
		
		ArrayList<String> path = new ArrayList<>();
		solve(0, path);
		System.out.println(res);
	}
	private static void solve(int idx, ArrayList<String> path) {
		if(idx >= N){
			Stack<String> st = new Stack<>();//곱하기 먼저 계산
			boolean[] chk = new boolean[N];
			for(int i = 0; i < path.size(); i++){
				if(chk[i]) continue;
				if(path.get(i).equals("*")){
					long tmp = Long.parseLong(st.pop()) * Long.parseLong(path.get(i+1));
					chk[i+1] = true;//스택에 넣지 않고 패스하기 위해 체크
					st.push(tmp+"");
				}
				else st.push(path.get(i)+"");
			}
			//남은 식 계산
			long sum = Long.parseLong(st.get(0));
			boolean plus = true;
			
			for(int i = 1; i < st.size(); i++){
				String tmp = st.get(i);
				
				if(tmp.equals("+") || tmp.equals("-")){
					if(tmp.equals("+")) plus = true;
					else plus = false;
				}
				else{
					if(plus) sum += Long.parseLong(tmp);
					else sum -= Long.parseLong(tmp);
				}
			}
			res = Math.max(res, sum);
			return;
		}
		if(ch[idx] >= '0' && ch[idx] <= '9'){//숫자
			//그냥 넘어감
			int num = ch[idx] - '0';
			path.add(num+"");
			solve(idx + 1, path);
			path.remove(path.size()-1);
			
			//계산하고 넘어감
			if(idx + 2 < N){
				if(ch[idx+1] == '+') num += ch[idx+2]-'0';
				else if(ch[idx+1] == '-') num -= ch[idx+2]-'0';
				else num *= ch[idx+2]-'0';
				
				path.add(num+"");
				solve(idx + 3, path);
				path.remove(path.size()-1);
			}
		}
		else{
			//그냥 넘어감
			path.add(ch[idx]+"");
			solve(idx + 1, path);
			path.remove(path.size()-1);
			
			//계산하고 넘어감
			if(idx + 3 < N){
				int num = (ch[idx+1]-'0');
				if(ch[idx+2] == '+') num += ch[idx+3]-'0';
				else if(ch[idx+2] == '-') num -= ch[idx+3]-'0';
				else if(ch[idx+2] == '*') num *= ch[idx+3]-'0';
				else num /= ch[idx+3]-'0';
				
				path.add(ch[idx]+"");
				path.add(num+"");
				solve(idx + 4, path);
				path.remove(path.size()-1);
				path.remove(path.size()-1);
			}
		}
	}
}