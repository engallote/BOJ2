import java.util.*;

public class Main {
	static int N, res;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][10];
		res = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 1; j <= 9; j++)
				arr[i][j] = sc.nextInt();
		
		ArrayList<Integer> path = new ArrayList<>();
		solve(1, 0, path);
		
		System.out.println(res);
	}
	private static void solve(int cnt, int idx, ArrayList<Integer> path) {
		if(cnt == 10){
			sum(path);
			return;
		}
		if(cnt != 4){
			for(int i = 2; i <= 9; i++)
				if((idx&(1<<i)) == 0){
					path.add(i);
					solve(cnt + 1, idx|(1<<i), path);
					path.remove(path.size()-1);
				}
		}
		else{
			path.add(1);
			solve(cnt + 1, idx|(1<<1), path);
			path.remove(path.size()-1);
		}
	}
	private static void sum(ArrayList<Integer> path) {
		int out = 0, sum = 0, idx = 0;
		int[] tmp = new int[4];
		
		for(int e = 0; e < N; e++){
			out = 0;
			Arrays.fill(tmp, 0);
			while(true){
				int num = path.get(idx);
				if(arr[e][num] == 0){
					++out;
					++idx;
					idx %= 9;
					if(out == 3) break;
					continue;
				}
				else sum += getScore(tmp, arr[e][num]);
				++idx;
				idx %= 9;
			}
		}
		
		res = Math.max(res, sum);
	}
	private static int getScore(int[] tmp, int num) {
		int ret = 0;
		for(int i = 3; i >= 1; i--){
			if(tmp[i] > 0){
				if(i + num > 3){
					tmp[i] = 0;
					++ret;
				}
				else{
					tmp[i] = 0;
					++tmp[i+num];
				}
			}
		}
		
		if(num < 4) tmp[num] = 1;
		else ++ret;
		
		return ret;
	}
}