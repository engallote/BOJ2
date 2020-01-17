import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		HashMap<Long, Long> hs = new HashMap<>();
		
		for(long i = 1; i <= 100000; i++)
			hs.put(i*i, i);
		boolean flag = false;
		for(long i = 1; i < 100000; i++){
			long num = i * i;
			if(hs.containsKey(num+G)){
				flag = true;
				System.out.println(hs.get(num+G));
			}
		}
		
		if(!flag) System.out.println(-1);
	}
}