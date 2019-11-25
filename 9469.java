import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0)
		{
			int N = sc.nextInt();
			double D = sc.nextDouble();
			double A = sc.nextDouble();
			double B = sc.nextDouble();
			double F = sc.nextDouble();
			
			double res = D / (A + B) * F;
			System.out.printf("%d %.6f\n", N, res);
		}
	}
}