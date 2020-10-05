import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int L, D, P, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		L = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());//기관총 사거리
		P = Integer.parseInt(st.nextToken());//기관총 살상력
		C = Integer.parseInt(br.readLine());//지뢰 개수
		long[] arr = new long[L];
		
		for(int i = 0; i < L; i++)
			arr[i] = Long.parseLong(br.readLine());
		
		boolean flag = true;
		long curP = P;
		for(int i = 0; i < L; i++) {
			if(arr[i] > curP) {
				if(C > 0) {
					--C;
					curP -= P;
					continue;
				}
				else {
					flag = false;
					break;
				}
			}
			
			arr[i] -= curP;
			curP += P;
		}
		
		if(flag) bw.write("YES");
		else bw.write("NO");
		bw.flush();
	}
}