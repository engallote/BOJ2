import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[M+1];
        
        for(int i = 1; i <= M; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 1; i <= M; i++){
        	int num = sc.nextInt();
        	while(--num >= 0)
        		arr[i].add(sc.nextInt());
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        int res = solve(1, path);
        if(res == 1000000000) res = -1;
        
        System.out.println(res);
    }
	private static int solve(int idx, ArrayList<Integer> path) {
		if(idx > M){
			HashSet<Integer> hs = new HashSet<>();
			for(int i : path){
				find(i, hs);
			}
			
			if(hs.size() == N) return path.size();
			return 1000000000;
		}
		int ret = 1000000000;
		
		path.add(idx);
		ret = Math.min(ret, solve(idx + 1, path));
		path.remove(path.size()-1);
		
		ret = Math.min(ret, solve(idx + 1, path));
		
		return ret;
	}
	private static void find(int i, HashSet<Integer> hs) {
		for(int next : arr[i]){
			hs.add(next);
		}
	}
}
