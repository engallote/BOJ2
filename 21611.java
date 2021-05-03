import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] map;
	static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1}, nd = {3, 2, 4, 1};
	static Queue<Integer> arr = new LinkedList<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new int[N][N];
    	res = 0;
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++)
    			map[i][j] = sc.nextInt();
    	
    	while(--M >= 0) {
    		int d = sc.nextInt();
    		int s = sc.nextInt();
    		arr.clear();
    		
    		//구슬 파괴
    		remove(d, s);
    		
    		//arr 만들기
    		makeArr();
    		
    		//구슬 폭발
    		while(true) {
    			boolean flag = bomb();
    			if(!flag) break;
    		}
    		
    		//구슬 그룹
    		group();
    	}
    	
    	System.out.println(res);
	}
	private static void makeArr() {
		int x = N / 2, y = N / 2, cnt = 0, jump = 1, d = 0;
    	while(true) {
    		for(int i = 0; i < jump; i++) {
    			if(x == 0 && y == 0) break;
    			x += dx[nd[d]];
    			y += dy[nd[d]];
    			if(map[x][y] == 0) continue;
    			arr.offer(map[x][y]);
    		}
    		
    		if(x == 0 && y == 0) break;
    		
    		++cnt;
    		if(cnt == 2) {
    			cnt = 0;
    			++jump;
    		}
    		d = (d + 1) % 4;
    	}
	}
	private static void group() {
		int pre = 0, count = 0;
		Queue<Pair> q = new LinkedList<>();
    	while(!arr.isEmpty()) {
    		int num = arr.poll();
    		if(pre == num) ++count;
    		else {
    			if(pre != 0) q.offer(new Pair(count, pre));
    			pre = num;
    			count = 1;
    		}
    	}
    	q.offer(new Pair(count, pre));
    	
    	//그룹을 맵에 적용
    	Queue<Integer> num = new LinkedList<>();
    	while(!q.isEmpty()) {
			Pair p = q.poll();
			num.offer(p.x);
			num.offer(p.y);
		}
    	
    	makeMap(num);
	}
	private static void makeMap(Queue<Integer> num) {
		for(int i = 0; i < N; i++)
			Arrays.fill(map[i], 0);
		
		int x = N / 2, y = N / 2, cnt = 0, jump = 1, d = 0;
    	while(true) {
    		for(int i = 0; i < jump; i++) {
    			if(x == 0 && y == 0) break;
    			x += dx[nd[d]];
    			y += dy[nd[d]];
    			if(num.isEmpty()) break;
    			map[x][y] = num.poll();
    		}
    		
    		if((x == 0 && y == 0) || num.isEmpty()) break;
    		
    		++cnt;
    		if(cnt == 2) {
    			cnt = 0;
    			++jump;
    		}
    		d = (d + 1) % 4;
    	}
	}
	private static boolean bomb() {
		boolean flag = false;
		Deque<Integer> dq = new LinkedList<>();
		int pre = -1, cnt = 0;
		while(!arr.isEmpty()) {
			int num = arr.poll();
			if(pre == num) ++cnt;
			else {
				if(cnt >= 4) {
					flag = true;
					for(int i = 0; i < cnt; i++)
						dq.pollLast();
					res += cnt * pre;
				}
				pre = num;
				cnt = 1;
			}
			dq.offer(num);
		}
		
		if(cnt >= 4) {
			flag = true;
			for(int i = 0; i < cnt; i++)
				dq.pollLast();
			
			res += cnt * pre;
		}
		
		arr.addAll(dq);
    	return flag;
	}
	private static void remove(int d, int s) {
		int x = N / 2, y = N / 2;
		for(int i = 0; i < s; i++) {
			x += dx[d];
			y += dy[d];
			map[x][y] = 0;
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}