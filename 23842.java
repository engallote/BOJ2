import java.util.*;

public class Main {
	static int N;
	static boolean flag = false;
	static int[] arr = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt() - 4;// +, = »©±â
    	
    	ArrayList<Integer> path = new ArrayList<>();
    	solve(0, 0, path);
    	
    	if(!flag) System.out.println("impossible");
    }
	private static void solve(int idx, int cnt, ArrayList<Integer> path) {
		if(flag) return;
		if(idx == 6) {
			if(cnt != N) return;
			
			int a = path.get(0) * 10 + path.get(1);
			int b = path.get(2) * 10 + path.get(3);
			int r = path.get(4) * 10 + path.get(5);
			
			if(a + b == r) {
				flag = true;
				System.out.println(path.get(0)+""+path.get(1)+"+"+path.get(2)+""+path.get(3)+"="+path.get(4)+""+path.get(5));
			}
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			path.add(i);
			solve(idx + 1, cnt + arr[i], path);
			path.remove(path.size() - 1);
		}
	}
}