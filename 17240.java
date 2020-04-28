import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static ArrayList<Integer>[] aly = new ArrayList[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			
		N = sc.nextInt();
		arr = new int[N][5];
		PriorityQueue<Pair>[] pq = new PriorityQueue[5];
		
		for(int i = 0; i < 5; i++)
			pq[i] = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < 5; j++){
				arr[i][j] = sc.nextInt();
				pq[j].offer(new Pair(i, arr[i][j]));
			}
		}
		
		for(int i = 0; i < 5; i++){
			aly[i] = new ArrayList<>();
			for(int j = 0; j < 5 && !pq[i].isEmpty(); j++){
				aly[i].add(pq[i].poll().idx);
			}
		}
		
		int res = 0;
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i : aly[0])
			for(int j : aly[1])
				for(int k : aly[2])
					for(int l : aly[3])
						for(int p : aly[4]){
							hs.clear();
							hs.add(i);
							hs.add(j);
							hs.add(k);
							hs.add(l);
							hs.add(p);
							if(hs.size() == 5)
								res = Math.max(res, arr[i][0] + arr[j][1] + arr[k][2] + arr[l][3] + arr[p][4]);
						}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return o.num > this.num ? 1 : (o.num == this.num ? 0 : -1);
	}
}