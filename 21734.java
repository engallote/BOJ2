import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	char[] ch = sc.next().toCharArray();
    	
    	for(int i = 0; i < ch.length; i++) {
    		int num = (int)ch[i];
    		int sum = 0;
    		
    		while(num > 0) {
    			sum += num % 10;
    			num /= 10;
    		}
    		
    		for(int j = 0; j < sum; j++)
    			System.out.print(ch[i]);
    		System.out.println();
    	}
	}
}