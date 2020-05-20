import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0; i < N; i++){
        	int num = sc.nextInt();
        	q.offer(num);
        	hs.add(num);
        }
        
        int size = 0;
        long time = 1, res = 0;
        while(!q.isEmpty()){
        	size = q.size();
        	while(--size >= 0){
        		int x = q.poll();
        		
        		if(!hs.contains(x + 1)){
        			hs.add(x + 1);
        			++cnt;
        			res += time;
        			q.offer(x + 1);
        		}
        		if(cnt == K){
        			q.clear();
        			break;
        		}
        		if(!hs.contains(x - 1)){
        			hs.add(x - 1);
        			++cnt;
        			res += time;
        			q.offer(x - 1);
        		}
        		if(cnt == K){
        			q.clear();
        			break;
        		}
        	}
        	++time;
        }
        
        System.out.println(res);
    }
}