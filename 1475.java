import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	int[] arr = new int[10];
    	int res = 0, cnt = 0;
    	
    	for(char c : ch) {
    		if(c == '6' || c == '9') cnt += 1;
    		else arr[c - '0'] += 1;
    	}
    	
    	for(int i = 0; i < 10; i++)
    		if(arr[i] > res) res = arr[i];
    	
    	res = Math.max(res, cnt / 2 + cnt % 2);
    	
    	System.out.println(res);
	}
}