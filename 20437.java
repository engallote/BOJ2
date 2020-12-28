import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList['z' + 1];
		
		for(int i = 'a'; i <= 'z'; i++)
			arr[i] = new ArrayList<>();
		
		while(--T >= 0) {
			char[] ch = sc.next().toCharArray();
			int K = sc.nextInt();
			
			for(int i = 'a'; i <= 'z'; i++)
				arr[i].clear();
			
			for(int i = 0; i < ch.length; i++)
				arr[ch[i]].add(i);
			
			int min = Integer.MAX_VALUE, max = -1;
			
			if(K == 1) {
				System.out.println("1 1");
				continue;
			}
			
			for(int i = 'a'; i <= 'z'; i++) {
				if(arr[i].isEmpty()) continue;
				
				int s = arr[i].get(0), cnt = 1, idx = 1;
				for(int j = 1; j < arr[i].size(); j++) {
					++cnt;
					if(cnt >= K) {
						int e = arr[i].get(j);
						
						min = Math.min(min, e - s + 1);
						max = Math.max(max, e - s + 1);
						s = arr[i].get(idx++);
					}
				}
			}
			
			if(min == Integer.MAX_VALUE) min = -1;
			if(min == -1 && max == -1) System.out.println(-1);
			else System.out.println(min + " " + max);
		}
	}
}