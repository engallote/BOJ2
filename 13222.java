import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int d = (int) Math.sqrt((H * H) + (W * W));
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			if(num <= W || num <= H || num <= d) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}