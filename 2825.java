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
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[1100];
		
		for(int i = 0; i < N; i++){
			char[] ch = br.readLine().toCharArray();
			int num = 0;
			for(char c : ch){
				if((num&(1<<(c-'0'))) != 0) continue;
				num |= (1<<(c-'0'));
			}
			++arr[num];
		}
		
		long res = 0;
		for(int i = 0; i < 1100; i++){
			res += arr[i] * (arr[i] - 1) / 2;
			for(int j = i + 1; j < 1100; j++)
				if((i & j) != 0) res += arr[i] * arr[j];
		}
		
		bw.write(res+"");
		bw.flush();
	}
}