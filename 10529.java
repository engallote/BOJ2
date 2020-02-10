import java.util.*;

public class Main {
	static int N;
	static int[] alp = new int['Z'+1];
	static char[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][];
        Arrays.fill(alp, -1);
        ArrayList<Character> path = new ArrayList<>();
        for(int i = 0; i < N; i++){
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < arr[i].length; j++)
        		if(!path.contains(arr[i][j])) path.add(arr[i][j]);
        }
        
        int res = solve(0, 0, path);
        System.out.println(res);
    }
	private static int solve(int idx, int chk, ArrayList<Character> path) {
		if(idx == path.size()){
			int sum = 0, num = 0;
			for(int i = 0; i < N - 1; i++){
				num = 0;
				if(alp[arr[i][0]] == 0) return 0;
				for(int j = 0; j < arr[i].length; j++){
					num *= 10;
					num += alp[arr[i][j]];
				}
				sum += num;
			}

			if(alp[arr[N-1][0]] == 0) return 0;
			num = 0;
			for(int i = 0; i < arr[N-1].length; i++){
				num *= 10;
				num += alp[arr[N-1][i]];
			}
			
			if(sum == num) return 1;
			return 0;
		}
		int ret = 0;
		
		for(int i = 0; i < 10; i++)
			if((chk&(1<<i)) == 0){
				alp[path.get(idx)] = i;
				ret += solve(idx + 1, chk|(1<<i), path);
				alp[path.get(idx)] = -1;
			}
		
		return ret;
	}
}