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
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken().substring(0, 2);
			String code = st.nextToken();
			
			if(name.equals(code)) continue;
			if(hm.containsKey(name + " " + code)) 
				hm.replace(name + " " + code, hm.get(name + " " + code) + 1);
			else hm.put(name + " " + code, 1);
		}
		
		int res = 0;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = hm.get(key);
			String[] arr = key.split(" ");
			
			if(hm.containsKey(arr[1] + " " + arr[0])) {
				res += value * hm.get(arr[1] + " " + arr[0]);
				hm.replace(key, 0);
			}
		}
		
		bw.write(res+"");
		bw.flush();
	}
}