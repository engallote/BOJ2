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
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());//���� ��
    	int d = Integer.parseInt(st.nextToken());//�ʹ� ������
    	int k = Integer.parseInt(st.nextToken());//�����ؼ� �Դ� ���� ��
    	int c = Integer.parseInt(st.nextToken());//���� ��ȣ
    	int[] arr = new int[N], num = new int[d + 1];
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = Integer.parseInt(br.readLine());
    	
    	int res = 0, max = 0;
    	for(int i = 0; i < k; i++) {
    		if(num[arr[i]] == 0) ++max;
    		++num[arr[i]];
    	}
    	
    	res = max;
    	
    	for(int i = 0; i < N; i++) {
    		--num[arr[i]];//������ ���� ����
    		if(num[arr[i]] == 0) --max;
    		
    		int idx = (i + k) % N;
    		if(num[arr[idx]] > 0) ++num[arr[idx]];
    		else {
    			++num[arr[idx]];
    			++max;
    		}
    		
    		if(num[c] == 0) res = Math.max(res, max + 1);
    		else res = Math.max(res, max);
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
}