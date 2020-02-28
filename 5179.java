import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			int P = sc.nextInt();
			int[] arr = new int[P+1], pass = new int[P+1];
			int[][] arr2 = new int[P+1][N+1];
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			
			while(--M >= 0){
				int p = sc.nextInt();
				int m = sc.next().charAt(0)-'A';
				int t = sc.nextInt();
				int j = sc.nextInt();
				
				if(arr2[p][m] > 0) continue;
				
				if(j == 0) arr2[p][m] -= 1;
				else{
					arr[p] += t + (arr2[p][m] * -1) * 20;
					arr2[p][m] = 1;
					++pass[p];
				}
			}
			
			for(int i = 1; i <= P; i++) pq.offer(new Pair(i, pass[i], arr[i]));
			
			System.out.println("Data Set " + test_case + ":");
			while(!pq.isEmpty())
				System.out.println(pq.peek().idx + " " + pq.peek().pass + " " + pq.poll().cost);
			System.out.println();
		}
	}
}
class Pair implements Comparable<Pair>{
	int idx, pass, cost;
	Pair(int idx, int pass, int cost){
		this.idx = idx;
		this.pass = pass;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.pass > this.pass) return 1;
		else if(o.pass == this.pass){
			if(o.cost > this.cost) return -1;
			else return 1;
		}
		else return -1;
	}
}