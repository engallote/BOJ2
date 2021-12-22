import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	HashSet<String> hs = new HashSet<>();
    	int tc = 1;
    	
    	while(true) {
    		int N = sc.nextInt();
    		if(N == 0) break;
    		hs.clear();
    		sc.nextLine();
    		while(--N >= 0) {
    			String str = sc.nextLine();
    			hs.add(str);
    		}
    		
    		System.out.println("Week " + tc + " " + hs.size());
    		++tc;
    	}
    }
}