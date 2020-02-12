import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();//나라 수
        int P = sc.nextInt();//교류 수
        int X = sc.nextInt();//나의 나라
        int L = sc.nextInt();//떠난 나라 숫자
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(L);
        int[] chk = new int[C+1], m = new int[C+1];
        ArrayList<Integer>[] arr = new ArrayList[C+1];
        
        for(int i = 1; i <= C; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < P; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	arr[a].add(b);
        	arr[b].add(a);
        }
        
        for(int i = 1; i <= C; i++)
        	m[i] = arr[i].size();
        
        m[L] = -1;
        
        boolean stay = true;
        int size = 0;
        while(!q.isEmpty()){
        	size = q.size();
        	while(--size >= 0){
        		int x = q.poll();
            	if(x == X){
            		stay = false;
            		break;
            	}
            	for(int next : arr[x])
            		if(m[next] != -1){
            			++chk[next];
            			if(chk[next] >= (double)m[next] / 2.0) {
            				q.offer(next);
            				m[next] = -1;
            			}
            		}
        	}
        }
        
        if(stay) System.out.println("stay");
        else System.out.println("leave");
    }
}