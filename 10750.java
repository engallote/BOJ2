import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] c = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < c.length; i++)
		{
			st.push(c[i]);
			if(st.size() >= bomb.length && st.peek() == bomb[bomb.length-1])
			{
				boolean match = true;
				int idx = st.size() - 1;
				
				for(int j = bomb.length - 1; j >= 0; j--)
				{
					if(st.get(idx) != bomb[j])
					{
						match = false;
						break;
					}
					--idx;
				}
				if(match)
				{
					for(int j = 0; j < bomb.length; j++)
						st.pop();
				}
			}
		}
		
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < st.size(); i++)
			ans.append(st.get(i));
		bw.write(ans.toString());
		bw.flush();
		
	}
}