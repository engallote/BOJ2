import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        Queue<Integer> q = new LinkedList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		arr[i][j] = sc.nextInt();
        
        while(N > 1){
        	for(int i = 0; i < N; i+=2){
        		for(int j = 0; j < N; j+=2){
        			pq.clear();
        			pq.offer(arr[i][j]);
        			pq.offer(arr[i][j+1]);
        			pq.offer(arr[i+1][j]);
        			pq.offer(arr[i+1][j+1]);
        			
        			pq.poll();
        			q.offer(pq.poll());
        		}
        	}
        	
        	N /= 2;
        	arr = new int[N][N];
        	int r = 0, c = 0;
        	while(!q.isEmpty()){
        		arr[r][c] = q.poll();
        		++c;
        		if(c == N){
        			c = 0;
        			++r;
        		}
        	}
        }
        
        System.out.println(arr[0][0]);
    }
}