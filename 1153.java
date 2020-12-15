import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] chk = new boolean[N];
		chk[0] = chk[1] = true;
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 2; i < N; i++) {
			if(chk[i]) continue;
			arr.add(i);
			for(int j = i + i; j < N; j+=i)
				chk[j] = true;
		}
		
		if(N < 8) {
			System.out.println(-1);
			return;
		}
		PriorityQueue<Integer> res = new PriorityQueue<>();
		if(N % 2 == 0) {
			N -= 4;
			res.offer(2);
			res.offer(2);
		}
		else {
			N -= 5;
			res.offer(2);
			res.offer(3);
		}
		
		boolean flag = true;
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) >= N) {
				flag = false;
				break;
			}
			if(!chk[N-arr.get(i)]) {
				res.offer((N - arr.get(i)));
				res.offer(arr.get(i));
				break;
			}
		}
		
		if(flag) {
			while(!res.isEmpty())
				System.out.print(res.poll() + " ");
		}
		else System.out.println(-1);
	}
}