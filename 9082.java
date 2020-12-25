import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static char[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			arr = new int[N];
			ch = sc.next().toCharArray();
			
			for(int i = 0; i < N; i++)
				arr[i] = ch[i] - '0';
			
			ch = sc.next().toCharArray();
			
			int res = 0;
			
			for(char c : ch)
				if(c == '*') ++res;
			
			for(int i = 0; i < N; i++) {
				int need = arr[i];
				if(arr[i] >= 1 && arr[i] <= 9) {
					if(need > 0 && i + 1 < N && ch[i + 1] == '*') --need;
					if(need > 0 && ch[i] == '*') --need;
					if(need > 0 && i - 1 >= 0 && ch[i - 1] == '*') --need;
					
					if(need == 0) continue;
					
					if(need > 0 && i + 1 < N && ch[i + 1] == '#') {
						ch[i + 1] = '*';
						++res;
						--need;
					}
					if(need > 0 && ch[i] == '#') {
						ch[i] = '*';
						++res;
						--need;
					}
					if(need > 0 && i - 1 >= 0 && ch[i - 1] == '#') {
						ch[i - 1] = '*';
						++res;
						--need;
					}
				}
			}
			
			System.out.println(res);
		}
	}
}