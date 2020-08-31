import java.util.*;

public class Main {
	static boolean flag;
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr.add(1);
		arr.add(1);
		arr.add(2);
		
		while(true){
			int num = arr.get(arr.size()-1) + arr.get(arr.size()-2);
			if(num > 1000000000) break;
			arr.add(num);
		}
		
		ArrayList<Integer> path = new ArrayList<>();
		for(int i = 0; i < N; i++){
			int num = sc.nextInt();
			
			flag = false;
			solve(arr.size()-1, num, 0, path);
			System.out.println();
		}
	}
	private static void solve(int idx, int num, int sum, ArrayList<Integer> path) {
		if(flag) return;
		if(sum == num){
			flag = true;
			for(int i = path.size() - 1; i >= 0; i--)
				System.out.print(path.get(i) + " ");
			return;
		}
		
		for(int i = idx; i >= 0; i--)
			if(arr.get(i) + sum <= num){
				path.add(arr.get(i));
				solve(i - 1, num, sum + arr.get(i), path);
				path.remove(path.size()-1);
			}
	}
}