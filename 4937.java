import java.util.*;

public class Main {
	static boolean[] chk = new boolean[1000000];
	static ArrayList<Integer> prime = new ArrayList<>();
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chk[0] = chk[1] = true;
		
		for(int i = 2; i < 1000000; i++){
			if(chk[i]) continue;
			if(i % 10 == 3){
				hs.add(i);
				prime.add(i);
			}
			for(int j = i + i; j < 1000000; j+=i)
				chk[j] = true;
		}
		
		while(true){
			int num = sc.nextInt();
			if(num == -1) break;
			
			System.out.print(num + " ");
			
			if(!chk[num]){
				if(num % 10 == 3) System.out.println("YES");
				else System.out.println("NO");
			}
			else{
				if(dis(num)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	private static boolean dis(int num) {
		int tmp = num;
		boolean flag = false;
		while(tmp > 1){
			flag = false;
			for(int i : prime)
				if(tmp % i == 0){
					tmp /= i;
					flag = true;
					break;
				}
			if(!flag) return false;
		}
		return true;
	}
}