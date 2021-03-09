import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int G = sc.nextInt();
        boolean[] chk = new boolean[N + 1];
        ArrayList<HashSet<Integer>> aly = new ArrayList<>();
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        for(int g = 0; g < G; g++) {
        	int S = sc.nextInt();
        	
        	HashSet<Integer> tmp = new HashSet<>();
        	for(int i = 0; i < S; i++) {
        		int num = sc.nextInt();
        		tmp.add(num);
        		arr[num].add(g);
        	}
        	aly.add(tmp);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        chk[1] = true;
        int res = 0;
        
        while(!q.isEmpty()) {
        	int x = q.poll();
        	++res;
        	
        	for(int i = 0; i < arr[x].size(); i++) {
        		int num = arr[x].get(i);
        		aly.get(num).remove(x);
        		
        		if(aly.get(num).size() == 1) {
        			Iterator<Integer> it = aly.get(num).iterator();
        			while(it.hasNext()) {
        				int num2 = it.next();
        				if(!chk[num2]) {
        					chk[num2] = true;
        					q.offer(num2);
        				}
        			}
        		}
        	}
        }
        
        System.out.println(res);
    }
}