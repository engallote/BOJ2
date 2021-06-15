import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String str = sc.next();
    	int len = str.length();
    	
    	System.out.println(str.substring(0, len / 2) + " " + str.substring(len / 2));
	}
}