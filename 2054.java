import java.util.*;

public class Main {
	static char[] c;
	static PriorityQueue<String> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.next().toCharArray();
		int num = 0;
		for(int i = 0; i < c.length - 1; i++)
		{
			num *= 10;
			num += c[i] - '0';
			solve(i + 1, num + "");
		}
		while(!pq.isEmpty())
			System.out.println(pq.poll());
	}
	private static void solve(int idx, String str) {
		if(idx >= c.length)
		{
			long sum = 0;
//			System.out.print(str + " : ");
			Stack<Long> st = new Stack<>();
			char[] ch = str.toCharArray();
//			System.out.print("mul :: ");
			for(int i = 1; i < ch.length; i++)
			{
				if(ch[i] == '*')
				{
					StringBuilder sb = new StringBuilder();
					boolean m = false;
					for(int j = i - 1; j >= 0; j--)
					{
						if(ch[j] >= '0' && ch[j] <= '9')
						{
							sb.append(ch[j]);
							ch[j] = '.';
						}
						else 
						{
							if(ch[j] == '-') m = true;
							break;
						}
					}
					sb.reverse();
					if(sb.toString().length() > 0)
					{
						if(m) st.push(-Long.parseLong(sb.toString()));
						else st.push(Long.parseLong(sb.toString()));
					}
					sb = new StringBuilder();
					for(int j = i + 1; j < ch.length; j++)
					{
						if(ch[j] >= '0' && ch[j] <= '9')
						{
							sb.append(ch[j]);
							ch[j] = '.';
						}
						else break;
					}
					if(sb.toString().length() > 0)  st.push(Long.parseLong(sb.toString()));
				}
				else if(ch[i] == '+' || ch[i] == '-')
				{
					if(!st.isEmpty())
					{
						long tmp = 1;
						while(!st.isEmpty()) 
						{
//							System.out.print(st.peek() + " ");
							tmp *= st.pop();
						}
//						System.out.print(", ");
						sum += tmp;
					}
				}
			}
			
			if(!st.isEmpty())//곱하기
			{
				long tmp = 1;
				while(!st.isEmpty()) tmp *= st.pop();
				sum += tmp;
			}
//			System.out.print("pls :: ");
			for(int i = 1; i < ch.length; i++)
			{
				if(ch[i] == '+' || ch[i] == '-')
				{
					StringBuilder sb = new StringBuilder();
					for(int j = i - 1; j >= 0; j--)
					{
						if(ch[j] >= '0' && ch[j] <= '9')
						{
							sb.append(ch[j]);
							ch[j] = '.';
						}
						else break;
					}
					sb.reverse();
					if(sb.toString().length() > 0) st.push(Long.parseLong(sb.toString()));
					sb = new StringBuilder();
					for(int j = i + 1; j < ch.length; j++)
					{
						if(ch[j] >= '0' && ch[j] <= '9')
						{
							sb.append(ch[j]);
							ch[j] = '.';
						}
						else break;
					}
					if(sb.toString().length() > 0) 
					{
						if(ch[i] == '+') st.push(Long.parseLong(sb.toString()));
						else st.push(-Long.parseLong(sb.toString()));
					}
				}
			}
			
			while(!st.isEmpty()) 
			{
//				System.out.print(st.peek() + " ");
				sum += st.pop();
			}
//			System.out.println(sum);
			if(sum == 2000 && !pq.contains(str))
				pq.add(str);
			return;
		}
		
		if(c[idx] == '0')
		{
			solve(idx + 1, str + "*0");
			solve(idx + 1, str + "+0");
			solve(idx + 1, str + "-0");
		}
		else
		{
			StringBuilder sb = new StringBuilder();
			for(int i = idx; i < c.length; i++)
			{
				sb.append(c[i]);
				solve(i + 1, str+"*"+sb.toString());
				solve(i + 1, str+"+"+sb.toString());
				solve(i + 1, str+"-"+sb.toString());
			}
		}
	}
}