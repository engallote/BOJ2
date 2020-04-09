import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[N+2];
		for(int i = 0; i <= N + 1; i++)
			arr[i] = new ArrayList<>();
		
		int idx = 1;
		while(--N >= 0){
			char c = sc.next().charAt(0);
			
			if(c == 'a'){
				for(int next : arr[idx-1]) arr[idx].add(next);
				arr[idx].add(sc.nextInt());
			}
			else if(c == 's'){
				for(int next : arr[idx-1]) arr[idx].add(next);
				if(!arr[idx].isEmpty())
					arr[idx].remove(arr[idx].size()-1);
			}
			else{
				int num = sc.nextInt();
				arr[idx].clear();
				for(int next : arr[num-1]) arr[idx].add(next);
			}
			
			if(arr[idx].isEmpty()) System.out.println(-1);
			else System.out.println(arr[idx].get(arr[idx].size()-1));
			++idx;
		}
	}
}