import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int res = 1;
        if(N % 2 == 0) {
        	for(int i = 0; i < N; i++) {
            	System.out.print(res + " ");
            	res += 1;
            	res %= 3;
            	if(res == 0) res = 1;
            }
        }
        else {
        	for(int i = 0; i < N - 1; i++) {
            	System.out.print(res + " ");
            	res += 1;
            	res %= 3;
            	if(res == 0) res = 1;
            }
        	System.out.println(3);
        }
    }
}