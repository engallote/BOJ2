import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//전체 메뉴 수
        int[] cost = new int[N+1];
        int[] arr = new int[N+1];
        HashSet<Integer> hs = new HashSet<>();
        int res = 0;
        
        for(int i = 1; i <= N; i++)
        	cost[i] = sc.nextInt();
        
        int M = sc.nextInt();//세트메뉴 가격
        for(int i = 0; i < 4; i++)
        	hs.add(sc.nextInt());
        
        int T = sc.nextInt();//주문한 메뉴 수
        for(int i = 0; i < T; i++){
        	int num = sc.nextInt();
        	arr[num] += 1;
        	res += cost[num];
        }
        
        int sum = 0;
        boolean flag = true;
        while(flag){//세트메뉴 확인
        	flag = false;
        	for(int i = 1; i <= N; i++)
        		if(hs.contains(i) && arr[i] > 0){
        			arr[i] -= 1;
        			flag = true;
        		}
        	
        	if(flag){
        		sum += M;
        		int tmp = 0;
        		
        		for(int i = 1; i <= N; i++)
        			if(arr[i] > 0) tmp += cost[i] * arr[i];
        		
        		res = Math.min(res, sum + tmp);
        	}
        }
        
        System.out.println(res);
	}
}