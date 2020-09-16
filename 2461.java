import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int min = Integer.MAX_VALUE, max = -10, res = 0;
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
			Arrays.sort(arr[i]);
			pq.offer(new Pair(arr[i][0], i, 0));
			min = Math.min(min, arr[i][0]);
			max = Math.max(max, arr[i][0]);
		}
		
		res = max - min;
		while(true){
			Pair p = pq.poll();
//			System.out.println(p.num + " 삭제");
			if(p.c + 1 == M) break;
			pq.offer(new Pair(arr[p.idx][p.c+1], p.idx, p.c + 1));
//			System.out.println(arr[p.idx][p.c+1] + " 삽입");
			
			min = pq.peek().num;
			max = Math.max(max, arr[p.idx][p.c+1]);
//			System.out.println("min : " + min + ", max : " + max);
			
			res = Math.min(res, max - min);
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int num, idx, c;
	Pair(int num, int idx, int c){
		this.num = num;
		this.idx = idx;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return o.num > this.num ? -1 : (o.num == this.num ? 0 : 1);
	}
}