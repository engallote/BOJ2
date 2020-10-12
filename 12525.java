import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++) {
        	String name = sc.next();
        	String res = find(name.charAt(name.length()-1));
        	System.out.printf("Case #%d: %s is ruled by %s.\n", test_case, name, res);
        }
    }

	private static String find(char ch) {
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "a queen";
		else if(ch == 'y') return "nobody";
		else return "a king";
	}
}