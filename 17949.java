import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int N = sc.nextInt();
		int idx = 0;
		String str;
		StringBuilder num;
		for(int i = 0; i < N; i++)
		{
			str = sc.next();
			if(str.equals("char")){
				num = new StringBuilder();
				num.append(ch[idx]);
				num.append(ch[idx+1]);
				idx += 2;
				System.out.print(Integer.parseInt(num.toString(), 16) + " ");
			}
			else if(str.equals("int")){
				num = new StringBuilder();
				for(int j = idx; j < idx + 8; j++) num.append(ch[j]);
				idx += 8;
				System.out.print(Integer.parseInt(num.toString(), 16) + " ");
			}
			else{
				num = new StringBuilder();
				for(int j = idx; j < idx + 16; j++) num.append(ch[j]);
				idx += 16;
				System.out.print(Long.parseLong(num.toString(), 16) + " ");
			}
		}
	}
}