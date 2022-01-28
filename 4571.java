import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int t = 1;
    	while(true) {
    		long N = sc.nextLong();
    		long M = sc.nextLong();
    		
    		if(N == 0 && M == 0) break;
    		
    		long res = N * M;
    		char[] a = Long.toString(N).toCharArray();
    		char[] b = Long.toString(M).toCharArray();
    		char[] c = Long.toString(res).toCharArray();
    		
    		int len = c.length;
    		
    		System.out.println("Problem " + t++);
    		
    		for(int i = 0; i < len - a.length; i++) System.out.print(" ");
    		System.out.println(new String(a));
    		for(int i = 0; i < len - b.length; i++) System.out.print(" ");
    		System.out.println(new String(b));
    		for(int i = 0; i < len; i++) System.out.print("-");
    		System.out.println();
    		
    		int cnt = 0, round = 0, zero = 0;
			for(int i = b.length - 1; i >= 0; i--) {
				long tmp = Long.parseLong(new String(a)) * (long)(b[i] - '0');
				if(tmp == 0) {
					++cnt;
					++zero;
					continue;
				}
				if(i == 0 && round == 0) continue;
				String str = Long.toString(tmp);
				for(int k = 0; k < len - str.length() - cnt; k++) System.out.print(" ");
				System.out.print(str);
				for(int k = 0; k < zero; k++) System.out.print("0");
				System.out.println();
				zero = 0;
				++cnt;
				++round;
			}
			if(round != 0) {
				for(int i = 0; i < len; i++) System.out.print("-");
				System.out.println();
			}
    		System.out.println(res);
    	}
    }
}