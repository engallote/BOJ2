import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[N+1];
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	arr[a].add(b);
        	arr[b].add(a);
        }
        
        int K = sc.nextInt();
        for(int i = 0; i < K; i++)
        	hs.add(sc.nextInt());
        
        find(hs);
    }
	private static void find(HashSet<Integer> hs) {
		HashSet<Integer> chk = new HashSet<>();
		Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++){
        	if(!hs.contains(i)) continue;
        	boolean flag = true;
        	for(int next : arr[i])
        		if(!hs.contains(next)){
        			flag = false;
        			break;
        		}
        	
        	if(flag){
        		int cnt = 0;
        		if(chk.contains(i)) ++cnt;
    			for(int next : arr[i]){
    				if(chk.contains(next)) ++cnt;
    				else chk.add(next);
    			}
    			if(cnt == arr[i].size() + 1) continue;
    			
    			chk.add(i);
        		q.offer(i);
        	}
        }
        
        if(chk.size() != hs.size()) System.out.println(-1);
        else{
        	System.out.println(q.size());
        	while(!q.isEmpty()) System.out.print(q.poll() + " ");
        }
	}
}