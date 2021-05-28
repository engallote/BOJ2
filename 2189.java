import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int tc = 1;
    	while(true) {
    		int N = sc.nextInt();
    		
    		if(N == 0) break;
    		
    		int[][] arr = new int[N][N];
    		
    		System.out.print("Square " + tc + ": ");
    		++tc;
    		
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < N; j++)
    				arr[i][j] = sc.nextInt();
    		
    		HashSet<Integer> hs = new HashSet<>();
    		//가로세로 검사
    		for(int i = 0; i < N; i++) {
    			int sum = 0, sum2 = 0;
    			for(int j = 0; j < N; j++) {
    				sum += arr[i][j];
    				sum2 += arr[j][i];
    			}
    			hs.add(sum);
    			hs.add(sum2);
    		}
    		
    		if(hs.size() != 1) {
    			System.out.println("Not a Magick Square");
    			continue;
    		}
    		
    		//가로세로는 합이 같음
    		//대각선도 합이 같은지 검사
    		
    		int sum1 = 0, sum2 = 0;
    		for(int i = 0; i < N; i++) {
    			sum1 += arr[i][i];
    			sum2 += arr[i][N - i - 1];
    		}
    		
    		if(!hs.contains(sum1) || !hs.contains(sum2)) {
    			System.out.println("Semi-Magick Square");
    			continue;
    		}
    		
    		//대각선도 합이 같음
    		//숫자가 구별되는지 검사
    		hs.clear();
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < N; j++)
    				hs.add(arr[i][j]);
    		
    		if(hs.size() < N * N) {
    			System.out.println("Weakly-Magick Square");
    			continue;
    		}
    		
    		//숫자가 구별된다면 연속적인지 검사
    		Iterator<Integer> it = hs.iterator();
    		PriorityQueue<Integer> pq = new PriorityQueue<>();
    		while(it.hasNext()) pq.offer(it.next());
    		
    		int pre = pq.poll();
    		while(!pq.isEmpty()) {
    			if(pq.peek() != pre + 1) break;
    			pre = pq.poll();
    		}
    		
    		if(pq.isEmpty()) System.out.println("Magically-Magick Square");
    		else System.out.println("Strongly-Magick Square");
    	}
	}
}