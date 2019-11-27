import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int res = 0;
		while(--T >= 0)
		{
			double A = sc.nextDouble();
			double B = sc.nextDouble();
			double C = sc.nextDouble();
			double W = sc.nextDouble();
			if(((A <= 56 && B <= 45 && C <= 25) || A + B + C <= 125) && W <= 7)
			{
				++res;
				System.out.println(1);
			}
			else System.out.println(0);
		}
		System.out.println(res);
	}
}