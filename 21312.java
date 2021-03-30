import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        long res = 1;
        Queue<Long> odd = new LinkedList<>(), even = new LinkedList<>();
        
        if(A % 2 == 0) even.offer(A);
        else odd.offer(A);
        if(B % 2 == 0) even.offer(B);
        else odd.offer(B);
        if(C % 2 == 0) even.offer(C);
        else odd.offer(C);
        
        if(!odd.isEmpty()) {
        	while(!odd.isEmpty()) res *= odd.poll();
        }
        else {
        	while(!even.isEmpty()) res *= even.poll();
        }
        
        System.out.println(res);
    }
}