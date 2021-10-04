import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	for(int i = 0; i < ch.length; i+=N)
    		System.out.print(ch[i]);
    	
	}
}