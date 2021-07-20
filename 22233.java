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
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	HashSet<String> hs = new HashSet<>();
    	for(int i = 0; i < N; i++)
    		hs.add(br.readLine().trim());
    	
    	for(int i = 0; i < M; i++) {
    		String[] str = br.readLine().trim().split(",");
    		
    		for(int j = 0; j < str.length; j++)
    			if(hs.contains(str[j])) hs.remove(str[j]);
    		
    		bw.write(hs.size()+"\n");
    	}
    	bw.flush();
	}
}