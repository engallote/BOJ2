import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        double[] arr = new double[N + 1];
        boolean[] chk = new boolean[N + 1];
        ArrayList<Integer>[] aly = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++){
        	arr[i] = sc.nextDouble();
        	aly[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N - 1; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	aly[b].add(a);
        	aly[a].add(b);
        }
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(K, arr[K]));
        int size = 0;
        chk[K] = true;
        
        while(!q.isEmpty()){
        	size = q.size();
        	while(--size >= 0){
        		Pair p = q.poll();
        		
        		if(p.v != K && arr[p.v] >= p.jump){
        			System.out.println(1);
        			return;
        		}
        		
        		for(int next : aly[p.v])
            		if(!chk[next]){
            			double jump = p.jump * 2.0 - arr[next];
            			chk[next] = true;
            			q.offer(new Pair(next, jump));
            		}
        	}//while size
        }//while q
        
        System.out.println(0);
    }
}
class Pair implements Comparable<Pair>{
	int v;
	double jump;
	Pair(int v, double jump){
		this.v = v;
		this.jump = jump;
	}
	@Override
	public int compareTo(Pair o) {
		return o.jump > this.jump ? 1 : (o.jump == this.jump ? 0 : -1);
	}
}