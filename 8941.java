import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		HashMap<Character, Double> hs = new HashMap<>();
		
		hs.put('C', 12.01);
		hs.put('H', 1.008);
		hs.put('O', 16.00);
		hs.put('N', 14.01);
		
		while(--T >= 0)
		{
			char[] ch = sc.next().toCharArray();
			if(ch.length == 1)
			{
				System.out.printf("%.3f\n", hs.get(ch[0]));
				continue;
			}

			char what = ch[0];
			int num = 0;
			double res = 0;

			for(int i = 1; i < ch.length; i++)
			{
				if(ch[i] >= '0' && ch[i] <= '9')
					num = num * 10 + (ch[i] - '0');
				else{
					res += hs.get(what) * (num == 0 ? 1 : num);
					num = 0;
					what = ch[i];
				}
			}

			res += hs.get(what) * (num == 0 ? 1 : num);
			System.out.printf("%.3f\n", res);
		}
	}
}