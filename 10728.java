import java.util.*;

public class Main {
	static int N, res;
	static int[] dp;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0){
			N = sc.nextInt();
			dp = new int[1<<N+1];
			res = 0;
			q.clear();
			
			Arrays.fill(dp, -1);
			ArrayList<Integer> path = new ArrayList<>();
			solve(1, 0, path);
			
			System.out.println(res);
			while(!q.isEmpty())
				System.out.print(q.poll() + " ");
			System.out.println();
		}
	}
	private static void solve(int idx, int chk, ArrayList<Integer> path) {
		if(path.size() > res){
			boolean flag = true;
			if(path.size() >= 3){
				loop:for(int i = 0; i < path.size(); i++)
					for(int j = i + 1; j < path.size(); j++)
						for(int k = j + 1; k < path.size(); k++)
							if((path.get(i) ^ path.get(j) ^ path.get(k)) == 0){
								flag = false;
								break loop;
							}
			}
			else if(path.size() == 2 && (path.get(0) ^ path.get(1)) == 0) flag = false;
			if(flag){
				res = path.size();
				q.clear();
				for(int i : path) q.offer(i);
			}
		}
		
		if(dp[chk] != -1) return;
		
		for(int i = idx; i <= N; i++)
			if((chk&(1<<i)) == 0){
				path.add(i);
				solve(i + 1, chk|(1<<i), path);
				path.remove(path.size()-1);
			}
		
		dp[chk] = 1;
	}
}