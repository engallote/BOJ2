import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        PriorityQueue<Integer> a = new PriorityQueue<>(), b = new PriorityQueue<>(), c = new PriorityQueue<>();
        
        for(int i = 0; i < A; i++)
        	a.offer(sc.nextInt());
        
        for(int i = 0; i < B; i++)
        	b.offer(sc.nextInt());
        
        for(int i = 0; i < C; i++)
        	c.offer(sc.nextInt());
        
        int res = Integer.MAX_VALUE, aa = a.poll(), bb = b.poll(), cc = c.poll();
        int tmp, tmp1, tmp2, tmp3, ret, min;
        while(true){
        	tmp = Math.max(aa, Math.max(bb, cc)) - Math.min(aa, Math.min(bb, cc));
        	if(tmp < res) res = tmp;
        	else{
        		ret = 0;
        		tmp1 = Integer.MAX_VALUE;
        		tmp2 = Integer.MAX_VALUE;
        		tmp3 = Integer.MAX_VALUE;
        		
        		if(!a.isEmpty()){
        			ret = a.peek();
        			tmp1 = Math.max(ret, Math.max(bb, cc)) - Math.min(ret, Math.min(bb, cc));
        		}
        		if(!b.isEmpty()){
        			ret = b.peek();
        			tmp2 = Math.max(aa, Math.max(ret, cc)) - Math.min(aa, Math.min(ret, cc));
        		}
        		if(!c.isEmpty()){
        			ret = c.peek();
        			tmp3 = Math.max(aa, Math.max(bb, ret)) - Math.min(aa, Math.min(bb, ret));
        		}
        		
        		min = Math.min(tmp1, Math.min(tmp2, tmp3));
        		
        		if(min == tmp1) aa = a.poll();
        		if(min == tmp2) bb = b.poll();
        		if(min == tmp3) cc = c.poll();
        	}
        	
        	if(a.isEmpty() && b.isEmpty() && c.isEmpty()) break;
        }
        
        System.out.println(res);
    }
}