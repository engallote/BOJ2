import java.util.*;

public class Main {
	static int N, A, B, ans = Integer.MAX_VALUE;
	static int[][] arr1, arr2;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        arr1 = new int[N+1][30];
        arr2 = new int[N+1][30];
        
        for(int i = 1; i <= N; i++){
        	Arrays.fill(arr1[i], -1);
        	Arrays.fill(arr2[i], -1);
        }
        
        bfsF();
        bfsS();
        
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
	private static void bfsF() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(A);
		arr1[A][0] = 0;
		int d = 0, size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int p = q.poll();
				
				int am = p - (int)Math.pow(2, d), ap = p + (int)Math.pow(2, d);
				
				if(am >= 1 && arr1[am][d + 1] == -1){
					arr1[am][d + 1] = d + 1;
					q.offer(am);
				}
				if(ap <= N && arr1[ap][d + 1] == -1){
					arr1[ap][d + 1] = d + 1;
					q.offer(ap);
				}
			}
			++d;
		}
	}
	private static void bfsS() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(B);
		arr2[B][0] = 0;
		int d = 0, size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int p = q.poll();
				
				if(arr2[p][d] != -1 && arr1[p][d] == arr2[p][d]){
					ans = d;
					return;
				}
				int bm = p - (int)Math.pow(2, d), bp = p + (int)Math.pow(2, d);
				
				if(bm >= 1 && arr2[bm][d + 1] == -1){
					arr2[bm][d + 1] = d + 1;
					q.offer(bm);
				}
				if(bp <= N && arr2[bp][d + 1] == -1){
					arr2[bp][d + 1] = d + 1;
					q.offer(bp);
				}
			}
			++d;
		}
	}
}