import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] dic = new char[20][2];
		int idx = 0;
		while(true)
		{
			String str = sc.next();
			if(str.equals("##")) break;
			dic[idx] = str.toCharArray();
			++idx;
		}
		sc.nextLine();
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("#")) break;
			char[] ch = str.toCharArray();
			boolean flag = false;
			
			for(int i = 0; i < ch.length; i++)
			{
				if(ch[i] >= 'a' && ch[i] <= 'z')
				{
					flag = false;
					for(int j = 0; j < idx; j++)
					{
						if(ch[i] == dic[j][0])
						{
							for(int k = i + 1; k < ch.length; k++)
							{
								if(!(ch[k] >= 'a' && ch[k] <= 'z') && !(ch[k] >= 'A' && ch[k] <= 'Z')) break;
								if(ch[k] == dic[j][1])
								{
									flag = true;
									for(int l = i + 1; l < k; l++)
										ch[l] = '*';
									break;
								}
							}
						}
						if(flag) break;
					}
				}
			}
			
			System.out.println(new String(ch));
		}
	}
}