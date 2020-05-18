import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
        	int D = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int f = N;
            int pre = 0;
            Queue<Integer> ans = new LinkedList<Integer>();
            boolean flag = true;
            
            for(int i = 0; i < M; i++){
            	int num = sc.nextInt();
            	if(num - pre <= f) f -= num - pre;//현재 연료로 도착 가능
            	else{//현재 연료로 부족
            		if(N < num - pre) flag = false;//연료 채워도 못 감
            		ans.offer(pre);
            		f = N - (num - pre);
            	}
            	pre = num;
            }
            
            if(D - pre > f){
            	if(N < D - pre) flag = false;
            	ans.offer(pre);
            }
            
            System.out.print("Case #" + test_case +": ");
            if(!flag) System.out.println("out of petrol");
            else{
            	while(!ans.isEmpty()) System.out.print(ans.poll() + " ");
            	System.out.println();
            }
        }
    }
}
