import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[][] arr = new int[N + 1][2];
    	int[][] time = new int[N + 1][2];
    	
    	for(int i = 0; i < M; i++) {
    		int num = sc.nextInt();
    		String str = sc.next();
    		int h = sc.nextInt();
    		int m = sc.nextInt();
    		
    		if(str.equals("START")) {
    			arr[num][0] = h;
    			arr[num][1] = m;
    		}
    		else {
    			while(arr[num][1] != m) {
    				time[num][1] += 1;
    				++arr[num][1];
    				if(arr[num][1] == 60) {
    					arr[num][1] = 0;
    					arr[num][0] += 1;
    				}
    			}
    			time[num][0] += Math.abs(arr[num][0] - h);
    			time[num][0] %= 24;
    		}
    	}
    	
    	for(int i = 1; i <= N; i++)
    		System.out.println((time[i][0] + time[i][1] / 60) % 24 + " " + (time[i][1] % 60));
    }
}