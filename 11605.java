import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[][] arr = new String[N][2];
		for(int i = 0; i < N; i++)
		{
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
		}
		
		int res = 0;
		boolean flag;
		for(int i = 1; i <= 100; i++)
		{
			double num = i;
			flag = true;
			for(int j = 0; j < N; j++)
			{
				double tmp = Double.parseDouble(arr[j][1]);
				switch(arr[j][0]){
				case "SUBTRACT" : num -= tmp; if(num < 0) flag = false; break;
				case "ADD" : num += tmp; break;
				case "MULTIPLY" : num *= tmp; break;
				case "DIVIDE" : if(num % tmp != 0) flag = false; num /= tmp; break;
				}
				
				if(!flag) 
				{
					++res;
					break;
				}
			}
		}
		System.out.println(res);
	}
}