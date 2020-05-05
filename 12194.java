import java.util.*;

public class Main {
	static int N;
	static int[] arr = new int[10];
	static ArrayList<Integer> aly = new ArrayList<>();
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	aly.clear();
        	hs.clear();
            for(int i = 0; i < 10; i++)
            	arr[i] = sc.nextInt();
            N = sc.nextInt();
            
            findNum(0);
            hs.clear();
            
            System.out.print("Case #" + test_case + ": ");
            int res = bfs();
            if(res == -1) System.out.println("Impossible");
            else System.out.println(res);
        }
    }
	private static void findNum(int num) {
		if(num > N) return;
		if(num <= N){
			if(!hs.contains(num))
				aly.add(num);
		}
		hs.add(num);
		for(int i = 0; i < 10; i++)
			if(arr[i] == 1 && !hs.contains(num * 10 + i)) 
				findNum(num * 10 + i);
	}
	private static int bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0));
		hs.add(0);
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			if(p.num == N) return p.cnt + 1;
			
			//그냥 쓰기
			if(p.num == 0){
				for(int num : aly){
					if(hs.contains(num) || num > N) continue;
					pq.offer(new Pair(num, Integer.toString(num).length()));
				}
			}
			
			//곱하기
			for(int num : aly)
				if(p.num * num <= N && p.num * num > 0 && !hs.contains(p.num * num)){
					hs.add(p.num * num);
					pq.offer(new Pair(p.num * num, p.cnt + 1 + Integer.toString(num).length()));
				}
		}
		return -1;
	}
}
class Pair implements Comparable<Pair>{
	int num, cnt;
	Pair(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}