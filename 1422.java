import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt() - K;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] arr = new int[K];
        int idx = 0, max = 0;;
        
        for(int i = 0; i < K; i++)
        	pq.offer(new Pair(sc.nextInt()));
        
        while(!pq.isEmpty()){
        	arr[idx] = pq.peek().num;
        	++idx;
        	max = Math.max(max, pq.poll().num);
        }
        
        for(int i = 0; i < K; i++){
        	System.out.print(arr[i]);
        	
        	if(max == arr[i]){
        		while(--N >= 0) System.out.print(max);
        		max = -1;//같은 숫자가 나와도 다시 반복하지 않도록
        	}
        }
        System.out.println();
    }
}
class Pair implements Comparable<Pair>{
	int num;
	Pair(int num){
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		String a = String.valueOf(o.num), b = String.valueOf(this.num);
		String str1 = a + "" + b;
		String str2 = b + "" + a;
		
		BigInteger A = new BigInteger(str1), B = new BigInteger(str2);
		if(A.compareTo(B) < 0)
			return -1;
		else if(A.compareTo(B) == 0)
			return 0;
		else return 1;
	}
}