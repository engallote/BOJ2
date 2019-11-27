import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("#")) break;
			str = str.replaceAll("<br />", "");
			while(str.contains(" "))
				str = str.replaceAll(" ", "");
			
			boolean flag = true;
			char[] ch = str.toCharArray();
			Stack<String> st = new Stack<>();
			for(int i = 0; i < ch.length; i++)
			{
				if(ch[i] == '<')
				{
					boolean f = true;
					StringBuilder sb = new StringBuilder();
					for(int k = i + 1; k < ch.length; k++)
					{
						if(ch[k] == '>')
						{
							i = k;
							break;
						}
						else if(ch[k] == '/') f = false;
						else
						{
							sb.append(ch[k]);
							if(ch[k] == 'a' && sb.toString().length() == 1) break;
						}
					}
					
					if(f) st.push(sb.toString());
					else
					{
						if(st.isEmpty() || !st.peek().equals(sb.toString())) 
						{
							flag = false;
							break;
						}
						else st.pop();
					}
				}
			}
			
			if(flag && st.isEmpty()) System.out.println("legal");
			else System.out.println("illegal");
		}
	}
}