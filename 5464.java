import java.util.*;

public class Main {
	static int N, M;
	static int[] space, cost, car, weight;
	static Queue<Integer> wait = new LinkedList<Integer>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();//주차 공간
    	M = sc.nextInt();
    	space = new int[N + 1];
    	car = new int[M + 1];
    	weight = new int[M + 1];
    	cost = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) cost[i] = sc.nextInt();
    	
    	for(int i = 1; i <= M; i++) weight[i] = sc.nextInt();
    	
    	int res = 0;
    	for(int i = 0; i < M * 2; i++) {
    		int num = sc.nextInt();
    		
    		if(num > 0) {
    			res += rotate();
    			
    			boolean flag = false;   			
    			for(int j = 1; j <= N; j++)
        			if(space[j] == 0) {
        				space[j] = num;
        				car[num] = j;
        				res += cost[j] * weight[num];
        				flag = true;
        				break;
        			}
        		
        		if(!flag) wait.offer(num);
    		}
    		else {
    			num *= -1;
    			space[car[num]] = 0;
    			car[num] = 0;
    			
    			res += rotate();
    		}
    	}
    	
    	res += rotate();
    	System.out.println(res);
	}
	private static int rotate() {
		int sum = 0;
		boolean flag;
		while(!wait.isEmpty()) {
			flag = false;
			int num2 = wait.peek();
			for(int j = 1; j <= N; j++)
    			if(space[j] == 0) {
    				space[j] = num2;
    				car[num2] = j;
//    				System.out.println(j + "에 " + num2 + " 주차");
    				sum += cost[j] * weight[num2];
    				flag = true;
    				break;
    			}
			if(flag) wait.poll();
			else break;
		}
		return sum;
	}
}