import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] map = new int[N*N];
		ArrayList<Integer> arr = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < N * N; i++){
			int num = sc.nextInt();
			map[i] = num;
			if(hm.containsKey(num)) hm.replace(num, hm.get(num) + 1);
			else hm.put(num, 1);
		}
		
		Arrays.sort(map);
		
		for(int k = N * N - 1; k >= 0; k--){
			int key = map[k];
			if(!hm.containsKey(key)) continue;
			int value = hm.get(key);
			
			if(value - 1 == 0) hm.remove(key);
			else hm.replace(key, value - 1);
			
			for(int i = 0; i < arr.size(); i++){
				int g = gcd(arr.get(i), key);
				if(hm.containsKey(g)){
					if(hm.get(g) - 2 <= 0) hm.remove(g);
					else hm.replace(g, hm.get(g) - 2);
				}
			}
			arr.add(key);
		}
		
		for(int num : arr)
			System.out.print(num + " ");
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		if(a < b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}