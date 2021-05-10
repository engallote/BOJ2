import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	while(--N >= 0) {
    		char[] ch = sc.next().toCharArray();
    		
    		System.out.println(next_permutation(ch));
    	}
	}

	private static String next_permutation(char[] ch) {
		int i = ch.length - 1, j = ch.length - 1, k = ch.length - 1;
		
		while(i > 0 && ch[i-1] >= ch[i]) i -= 1;
		
		if(i == 0) return new String(ch);
		
		while(ch[i - 1] >= ch[j]) j -= 1;
		
		char tmp = ch[i - 1];
		ch[i - 1] = ch[j];
		ch[j] = tmp;
		
		while(i < k) {
			tmp = ch[i];
			ch[i] = ch[k];
			ch[k] = tmp;
			
			i += 1;
			k -= 1;
		}
		
		return new String(ch);
	}
}