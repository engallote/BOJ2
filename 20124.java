import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		String res = "";
		
		while(--N >= 0) {
			String name = sc.next();
			int num = sc.nextInt();
			
			if(max < num) {
				max = num;
				res = name;
			}
			else if(max == num) {
				char[] a = name.toCharArray(), b = res.toCharArray();
				int len = Math.min(a.length, b.length);
				boolean flag = false;
				for(int i = 0; i < len; i++) {
					if(a[i] > b[i]) {
						flag = true;
						break;
					}
					else if(a[i] < b[i]) {
						res = name;
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					if(a.length < b.length) res = name;
				}
			}
		}
		
		System.out.println(res);
	}
}