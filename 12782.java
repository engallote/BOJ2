import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0){
			char[] a = sc.next().toCharArray();
			char[] b = sc.next().toCharArray();
			int len = a.length, res = 0;
			
			for(int i = 0; i < len; i++){
				if(a[i] == b[i]) continue;
				else{
					boolean flag = false;
					for(int j = i + 1; j < len; j++){
						if(a[i] == b[j] && b[j] != a[j]){
							b[j] = b[i];
							b[i] = a[i];
							flag = true;
							++res;
							break;
						}
					}
					
					if(!flag){
						b[i] = a[i];
						++res;
					}
				}
			}
			
			System.out.println(res);
		}
	}
}