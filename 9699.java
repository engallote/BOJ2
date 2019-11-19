import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		for(int i = 1; i <= N; i++)
		{
			max = 0;
			for(int j = 0; j < 5; j++)
				max = Math.max(max, sc.nextInt());
			System.out.println("Case #" + i + ": " + max);
		}
	}
}