import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Z = sc.nextInt();
		int M = sc.nextInt();
		int num;
		int[] arr = new int[N + 1];
		boolean[] chk = new boolean[N + 1];
		boolean flag;
		for(int i = 0; i < M; i++)
			arr[sc.nextInt()] = 1;
		
		for(int k = 1; k <= N-1; k++) {
			num = 1;
			Arrays.fill(chk, false);
			flag = true;
			chk[1] = true;
			
			while(true){
				num += k;
				if(num > N) num -= N;
				
				if(num == Z) break;
				if(chk[num] || arr[num] == 1) {
					flag = false;
					break;
				}
				
				chk[num] = true;
			}
			
			if(flag){
				System.out.println(k);
				break;
			}
		}
	}
}