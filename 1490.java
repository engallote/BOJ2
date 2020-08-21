import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = Integer.toString(N).toCharArray();
		boolean flag = false;
		long num = N, cnt = 0, max = 1;
		while(true){
			flag = true;
			
			for(int i = 0; i < ch.length; i++)
				if((ch[i] - '0') != 0 && num % (ch[i]-'0') != 0){
					flag = false;
					break;
				}
			
			if(flag) break;
			++num;
			++cnt;
			if(cnt == max){
				max *= 10;
				cnt = 0;
				num = N * max;
			}
		}
		
		System.out.println(num);
	}
}