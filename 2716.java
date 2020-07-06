import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while(--T >= 0){
			String str = sc.nextLine();
			
			if(str.length() == 0) System.out.println(1);
			else{
				char[] ch = str.toCharArray();
				int res = 0, size = 0;
				
				for(int i = 0; i < ch.length; i++){
					if(ch[i] == '[') ++size;
					else --size;
					res = Math.max(res, size);
				}
				
				System.out.println((int)Math.pow(2, res));
			}
		}
	}
}