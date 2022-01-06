import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	
    	int N = sc.nextInt();
    	int res = -1000000;
    	String ans = "";
    	
    	for(int i = 0; i < N; i++) {
    		char[] tmp = sc.next().toCharArray();
    		int num = cal(ch, tmp);
//    		System.out.println(new String(tmp) + " " + num);
    		if(res < num) {
    			res = num;
    			ans = new String(tmp);
    		}
    		else if(res == num) {
    			char[] pre = ans.toCharArray();
    			for(int j = 0; j < 8; j++) {
    				if(pre[j] > tmp[j]) {
    					ans = new String(tmp);
    					break;
    				}
    				else if(pre[j] == tmp[j]) continue;
    				else break;
    			}
    		}
    	}
    	
    	System.out.println(ans);
    }

	private static int cal(char[] a, char[] b) {
		int year = (int) Math.pow((a[0] -'0') - (b[0] - '0'), 2)
				+ (int) Math.pow((a[1] -'0') - (b[1] - '0'), 2)
				+ (int) Math.pow((a[2] -'0') - (b[2] - '0'), 2)
				+ (int) Math.pow((a[3] -'0') - (b[3] - '0'), 2);
		int month = (int) Math.pow((a[4] -'0') - (b[4] - '0'), 2)
				+ (int) Math.pow((a[5] -'0') - (b[5] - '0'), 2);
		int day = (int) Math.pow((a[6] -'0') - (b[6] - '0'), 2)
				+ (int) Math.pow((a[7] -'0') - (b[7] - '0'), 2);
		
		return year * month * day;
	}
}