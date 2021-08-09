import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int K = sc.nextInt();//사용중으로 판단할 시간
    	int L = sc.nextInt();//사람이 없는 시간
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	int cnt1 = 0, cnt2 = 0, time = 0;
    	boolean flag = false, no = true;
    	char pre = '0';
    	for(int i = 0; i < ch.length; i++) {
    		++time;
    		if(ch[i] == '0') {
    			if(flag && pre == ch[i]) cnt2 += 1;
    			else cnt2 = 1;
    			
    			if(cnt2 >= L) {
    				no = false;
    				System.out.println(time);
    				flag = false;
    				cnt1 = 0;
    				cnt2 = 0;
    			}
    		}
    		else if(ch[i] == '1') {
    			if(pre == ch[i]) cnt1 += 1;
    			else cnt1 = 1;
    			
    			if(cnt1 >= K) flag = true;
    		}
    		pre = ch[i];
    	}
    	
    	if(flag) {
    		no = false;
    		System.out.println(time + L);
    	}
    	
    	if(no) System.out.println("NIKAD");
	}
}