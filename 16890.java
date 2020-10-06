import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] k = sc.next().toCharArray();
		char[] c = sc.next().toCharArray();
		
		Arrays.sort(k);
		Arrays.sort(c);
		
		char[] res = new char[k.length];
		int l = 0, r = k.length - 1, sw = 1, kl = 0, kr = (k.length + 1) / 2 - 1, cl = (k.length + 1) / 2, cr = k.length - 1;
		while(l <= r) {
			if(sw == 1) {
				if(k[kl] < c[cr]) {
					res[l] = k[kl];
					++l;
					++kl;
				}
				else {
					res[r] = k[kr];
					--r;
					--kr;
				}
			}
			else {
				if(k[kl] < c[cr]) {
					res[l] = c[cr];
					++l;
					--cr;
				}
				else {
					res[r] = c[cl];
					--r;
					++cl;
				}
			}
			sw *= -1;
		}
		
		System.out.println(new String(res));
	}
}