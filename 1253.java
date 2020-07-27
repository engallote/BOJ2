import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		HashSet<Integer> hs = new HashSet<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
			hm.put(arr[i], i);
		}
		
		int res = 0;
		for(int i = 0; i < N; i++)
			for(int j = i + 1; j < N; j++){
				if(hm.containsKey(arr[i] + arr[j])){
					if(hm.get(arr[i] + arr[j]) == i || hm.get(arr[i] + arr[j]) == j)
						continue;
					hs.add(arr[i] + arr[j]);
				}
			}
		
		for(int i = 0; i < N; i++)
			if(hs.contains(arr[i])) ++res;
		System.out.println(res);
	}
}