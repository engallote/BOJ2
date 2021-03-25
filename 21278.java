import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        chk = new int[N + 1];
        arr = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	arr[a].add(b);
        	arr[b].add(a);
        }
        
        int res = 1000000000, a = 0, b = 0;
        for(int i = 1; i < N; i++)
        	for(int j = i + 1; j <= N; j++) {
        		int tmp = bfs(i, j);
        		if(tmp < res) {
        			res = tmp;
        			a = i;
        			b = j;
        		}
        		else if(tmp == res && i < a) {
        			a = i;
        			b = j;
        		}
        		else if(tmp == res && i == a && j < b) {
        			a = i;
        			b = j;
        		}
        	}
        
        System.out.println(a + " " + b + " " + res);
    }
	private static int bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();		
		Arrays.fill(chk, 1000000000);
		q.offer(a);
		q.offer(b);
		chk[a] = chk[b] = 0;
		int size, sum = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				for(int next : arr[x])
					if(chk[next] > chk[x] + 1) {
						chk[next] = chk[x] + 1;
						q.offer(next);
					}
			}
		}
		
		for(int i = 1; i <= N; i++)
			if(i != a && i != b) sum += chk[i] * 2;
		return sum;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}