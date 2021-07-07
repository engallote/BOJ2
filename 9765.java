import java.util.*;

public class Main {
	static long c1, c2, c3, c4, c5, c6;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	c1 = sc.nextLong();
    	c2 = sc.nextLong();
    	c3 = sc.nextLong();
    	c4 = sc.nextLong();
    	c5 = sc.nextLong();
    	c6 = sc.nextLong();
    	
    	ArrayList<Long> x1 = new ArrayList<>(), x2 = new ArrayList<>(), x3 = new ArrayList<>(), x5 = new ArrayList<>(), x6 = new ArrayList<>(), x7 = new ArrayList<>();
    	
    	getNum(c1, x1, x2);
    	getNum(c3, x6, x7);
    	getNum(c5, x2, x3);
    	getNum(c6, x5, x6);
    	
    	for(int a = 0; a < x1.size(); a++) {
    		for(int b = 0; b < x2.size(); b++)
    			for(int c = 0; c < x3.size(); c++)
    				for(int d = 0; d < x5.size(); d++)
    					for(int e = 0; e < x6.size(); e++)
    						for(int f = 0; f < x7.size(); f++) {
    							if(find(x1.get(a), x2.get(b), x3.get(c), x5.get(d), x6.get(e), x7.get(f))) {
    								System.out.println(x1.get(a) + " " + x2.get(b) + " " + x3.get(c) + " " + x5.get(d) + " " + x6.get(e) + " " + x7.get(f));
    								return;
    							}
    						}
    	}
	}
	private static void getNum(long c, ArrayList<Long> a, ArrayList<Long> b) {
		for(long i = 2; i < c; i++)
			if(c % i == 0) {
				a.add(i);
				a.add(c / i);
				b.add(i);
				b.add(c / i);
				break;
			}
	}
	private static boolean find(Long a, Long b, Long c, Long d, Long e, Long f) {
		if(a * b != c1) return false;
		if(b * c != c5) return false;
		if(d * e != c6) return false;
		if(e * f != c3) return false;
		
		return true;
	}
}