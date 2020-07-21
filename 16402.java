import java.util.*;

public class Main {
	static int[] king = new int[3000], par = new int[501];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Arrays.fill(king, -1);
		sc.nextLine();
		HashMap<String, Integer> hs = new HashMap<>();
		
		for(int i = 0; i < N; i++){
			par[i] = i;
			String str = sc.nextLine();
			str = str.replace("Kingdom of ", "");
			hs.put(str, i);
		}
		
		while(--M >= 0){
			String[] str = sc.nextLine().split(",");
			String A = str[0].replace("Kingdom of ", "");
			String B = str[1].replace("Kingdom of ", "");
			int w = Integer.parseInt(str[2]);
			
			if(w == 1) merge(hs.get(A), hs.get(B));
			else merge(hs.get(B), hs.get(A));
		}
		
		String add = "Kingdom of ";
		PriorityQueue<String> pq = new PriorityQueue<>();
		Iterator<String> it = hs.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			int value = hs.get(key);
			if(par[value] == value) pq.offer(add + key);
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty())
			System.out.println(pq.poll());
	}

	private static void merge(int a, int b) {
		if(a == find(b)) return;
		else if(find(a) == b){
			par[a] = a;
			par[b] = a;
			return;
		}
		
		a = find(a);
		b = find(b);
		par[b] = a;
	}

	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}