import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] chk = new boolean[100000000];
		ArrayList<Integer> prime = new ArrayList<>();
		
		for(int i = 2; i < 100000000; i++) {
			if(chk[i]) continue;
			prime.add(i);
			
			for(int j = i + i; j < 100000000; j+=i)
				chk[j] = true;
		}
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			
			if(N % 2 == 0) {
				if(N < 8) {
					System.out.println("Impossible.");
					continue;
				}
				System.out.print("2 2 ");
				N -= 4;
			}
			else if(N % 2 != 0) {
				if(N < 9) {
					System.out.println("Impossible.");
					continue;
				}
				System.out.print("2 3 ");
				N -= 5;
			}
			
			for(int i = 2; i < N; i++)
				if(!chk[i] && !chk[N - i]) {
					System.out.println(i + " " + (N - i));
					break;
				}
		}
	}
}