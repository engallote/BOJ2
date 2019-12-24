import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = (N * (N + 1)) / 2, sum = 0;
		for(int i = 0; i < N - 1; i++)
		{
			int num = sc.nextInt();
			sum += num;
		}
		
		System.out.println(res-sum);
	}
}