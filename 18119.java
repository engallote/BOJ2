import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int chk = 0;
		
		for(int i = 0; i < 26; i++)
			chk |= (1<<i);
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			char[] ch = st.nextToken().toCharArray();
			for(char c : ch)
				arr[i] |= (1<<(c-'a'));
		}
		
		int res = 0;
		while(--M >= 0){
			res = 0;
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int c = st.nextToken().charAt(0) - 'a';
			
			if(num == 1) chk -= (1<<c);
			else chk |= (1<<c);
			
			for(int i = 0; i < N; i++)
				if((arr[i]&chk) == arr[i]) ++res; 
			
			bw.write(res+"\n");
		}
		bw.flush();
	}
}