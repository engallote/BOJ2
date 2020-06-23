import java.util.*;

public class Main {
	static int N, M;
	static char[] ch1, ch2;
	static int[] arr1, arr2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ch1 = sc.next().toCharArray();
		ch2 = sc.next().toCharArray();
		arr1 = new int[300];
		arr2 = new int[300];
		int s = 0, e = N, res = 0;
		
		for(int i = 0; i < N; i++){
			++arr1[ch1[i]];
			++arr2[ch2[i]];
		}
		
		res += find();
		
		while(e < M){
			--arr2[ch2[s]];
			++s;
			++arr2[ch2[e]];
			++e;
			
			res += find();
		}
		
		System.out.println(res);
	}
	private static int find() {
		for(char i = 'a'; i <= 'z'; i++)
			if(arr1[i] != arr2[i]) return 0;
		
		for(char i = 'A'; i <= 'Z'; i++)
			if(arr1[i] != arr2[i]) return 0;
		
		return 1;
	}
}