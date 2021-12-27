import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	long res = 0;
    	for(int i = 0; i < N; i++) {
    		long l = 0, r = 0;
    		if(i > 0 && ch[i - 1] != ch[i]) {
    			for(int j = i - 1; j >= 0 && ch[j] != ch[i]; j--) ++l;
    		}
    		if(i + 1 < N && ch[i + 1] != ch[i]) {
    			for(int j = i + 1; j < N && ch[j] != ch[i]; j++) ++r;
    		}
    		res += l * r + Math.max(l - 1, 0) + Math.max(r - 1,  0);
    	}
    	System.out.println(res);
    }
}