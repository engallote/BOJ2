import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] w = new int[N], chk = new int[N], chk2 = new int[N];
		ArrayList<Pair>[] arr = new ArrayList[N];
		
		for(int i = 0; i < N; i++){
			w[i] = sc.nextInt();
			chk[i] = Integer.MAX_VALUE;
			chk2[i] = Integer.MAX_VALUE;
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++){
				int num = sc.nextInt();
				if(num != 0) arr[i].add(new Pair(j, num));
			}
		
		Queue<Pair> q = new LinkedList<Pair>();
		int time = 0, re = Integer.MAX_VALUE, size = 0;
		chk[0] = chk2[0] = 0;
		q.offer(new Pair(0, 0, 0));
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.v == M){
					if(p.r < re){
						re = p.r;
						time = p.t;
					}
					else if(p.r == re) time = Math.min(p.t, time);
				}
				
				for(Pair next : arr[p.v]){
					if(w[p.v] == w[next.v]){
						if(chk[next.v] > p.r || (chk[next.v] == p.r && chk2[next.v] > p.t + next.t)){
							chk[next.v] = p.r;
							chk2[next.v] = p.t + next.t;
							q.offer(new Pair(next.v, p.r, chk2[next.v]));
						}
					}
					else{
						if(chk[next.v] > p.r + 1 || (chk[next.v] == p.r + 1 && chk2[next.v] > p.t + next.t)){
							chk[next.v] = p.r + 1;
							chk2[next.v] = p.t + next.t;
							q.offer(new Pair(next.v, p.r + 1, chk2[next.v]));
						}
					}
				}
			}
		}
		System.out.println(re + " " + time);
	}
}
class Pair{
	int v, r, t;
	Pair(int v, int t){
		this.v = v;
		this.t = t;
	}
	Pair(int v, int r, int t){
		this.v = v;
		this.r = r;
		this.t = t;
	}
}