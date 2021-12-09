import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	BigInteger max = new BigInteger(new String(ch));
    	int sum = 0;
    	
    	for(int i = ch.length - 2; i >= 0; i--) {
    		int num = ch[i] - '0';
    		if(ch[i + 1] >= '5' || sum == 1) num += 1;
    		ch[i + 1] = '0';
    		sum = 0;
    		
    		if(num == 10) {
    			ch[i] = '0';
    			sum = 1;
    		}
    		else ch[i] = (char) (num + '0');
    		if(max.compareTo(new BigInteger(new String(ch))) < 0) max = new BigInteger(new String(ch));
    	}
    	if(sum > 0 || ch[0] >= '5') {
    		ch[0] = '0';
    		if(max.compareTo(new BigInteger("1" + new String(ch))) < 0) 
    			max = new BigInteger("1" + new String(ch));
    	}
    	
    	System.out.println(max);
    }
}