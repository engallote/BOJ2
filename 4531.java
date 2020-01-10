import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> hs = new HashMap<>();
		hs.put('I', 1);
		hs.put('V', 5);
		hs.put('X', 10);
		hs.put('L', 50);
		hs.put('C', 100);
		hs.put('D', 500);
		hs.put('M', 1000);
		
		int T = sc.nextInt();
		while(--T >= 0) {
			char[] ch = sc.next().toCharArray();
			
			int sum = 0;
			for(int i = 0; i < ch.length; i++){
				if(i + 1 < ch.length && hs.get(ch[i]) < hs.get(ch[i+1])) sum -= hs.get(ch[i]);
				else sum += hs.get(ch[i]);
			}
			
			System.out.println(sum);
		}
	}
}