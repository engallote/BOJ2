import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		while(--N >= 0)
		{
			String[] str = sc.nextLine().split(" ");
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < str.length; i++)
			{
				boolean flag = false;
				for(int j = 0; j < str[i].length(); j++)
				{
					char c = str[i].charAt(j);
					if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
					{
						if(j == 0){
							sb.append(str[i] + "yay");
							flag = true;
						}
						else{
							sb.append(str[i].substring(j));
							sb.append(str[i].substring(0, j) + "ay");
							flag = true;
						}
						break;
					}
				}
				
				if(!flag){
					sb.append(str[i] + "ay");
				}
				sb.append(" ");
			}
			
			System.out.println(sb.toString());
		}
	}
}