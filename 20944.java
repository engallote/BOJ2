import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] ch = new char[N];
        Arrays.fill(ch, 'c');
        
        System.out.println(new String(ch));
    }
}