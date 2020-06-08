import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> prime = new ArrayList<>(), arr = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();
		boolean[] chk = new boolean[N+1];
		chk[0] = chk[1] = true;
		arr.add(1);
		
		for(int i = 2; i <= N; i++){
			if(N % i == 0){
				arr.add(i);
				hs.add(i);
			}
			if(chk[i]) continue;
			prime.add(i);
			for(int j = i + i; j <= N; j+=i)
				chk[j] = true;
		}
		long sum = 0;
		
		//A
		for(int i = N - 2; i > 0; i-= 2)
			sum += i;
		
		System.out.println(sum);
		
		//B
		sum = 0;
		for(int i = 0; i < arr.size(); i++){
			for(int j = i; j < arr.size(); j++){
				int a = arr.get(i), b = arr.get(j);
				if(hs.contains(a + b)) ++sum;
			}
		}
			
		System.out.println(sum);
		
		//C
		sum = 0;
		boolean flag = false;
		for(int i = 0; i < prime.size(); i++){
			flag = false;
			for(int j = i + 1; j < prime.size(); j++){
				if(prime.get(j) > N) break;
				if(prime.get(i) + prime.get(j) <= N && !chk[prime.get(i) + prime.get(j)]){
					flag = true;
					++sum;
				}
			}
			if(!flag) break;
		}
		
		System.out.println(sum);
	}
}