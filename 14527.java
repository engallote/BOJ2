import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] arr = new Pair[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		Arrays.sort(arr);
		
		int l = 0, r = N - 1, max = -1;
		while(l <= r){
			if(l != r){
				max = Math.max(max, arr[l].num + arr[r].num);
				arr[l].cnt -= 1;
				arr[r].cnt -= 1;
				
				if(arr[l].cnt == 0) ++l;
				if(arr[r].cnt == 0) --r;
			}
			else{
				if(arr[l].cnt == 1) break;
				max = Math.max(max, arr[l].num * 2);
				break;
			}
		}
		
		System.out.println(max);
	}
}
class Pair implements Comparable<Pair>{
	int cnt, num;
	Pair(int cnt, int num){
		this.cnt = cnt;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return o.num > this.num ? -1 : (o.num == this.num ? 0 : 1);
	}
}