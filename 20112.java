import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		boolean flag = true;
		loop:for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(arr[i][j] != arr[j][i]) {
					flag = false;
					break loop;
				}
		
		System.out.println(flag ? "YES" : "NO");
	}
}