import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String str = sc.nextLine();
    	
    	if(str.contains("d2") || str.contains("D2")) System.out.println("D2");
    	else System.out.println("unrated");
	}
}