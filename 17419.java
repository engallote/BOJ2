import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] ch = sc.next().toCharArray();
        int res = 0;
        
        for(char c : ch)
        	if(c == '1') ++res;
        
        System.out.println(res);
    }
}