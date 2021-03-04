import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] ch = sc.next().toCharArray();
        
        for(int i = 0; i < N; i++)
        	if(ch[i] == 'J') System.out.print(ch[i]);
        
        for(int i = 0; i < N; i++)
        	if(ch[i] == 'O') System.out.print(ch[i]);
        
        for(int i = 0; i < N; i++)
        	if(ch[i] == 'I') System.out.print(ch[i]);
    }
}