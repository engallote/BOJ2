import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] r = new int[4], f = new int[4];
		int[] con = new int[100001], time = new int[100001];
		Arrays.fill(time, -1);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			r[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			f[i] = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hs = new HashMap<>();
		int idx = 0;
		
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			if(num == 1){
				if(hs.containsKey(name)){
					++con[hs.get(name)];
					time[hs.get(name)] = i;
				}
				else{
					hs.put(name, idx);
					++con[idx];
					time[idx] = i;
					++idx;
				}
			}
			else{
				if(!hs.containsKey(name)){
					bw.write("None\n");
					continue;
				}
				int cnt = 0, recent = 0;
				
				if(con[hs.get(name)] > f[3]) cnt = 4;
				else{
					for(int j = 0; j < 4; j++)
						if(con[hs.get(name)] <= f[j]){
							cnt = j;
							break;
						}
				}
				if(i - time[hs.get(name)] > r[3]) recent = 4;
				else{
					for(int j = 0; j < 4; j++)
						if(i - time[hs.get(name)] <= r[j]){
							recent = j;
							break;
						}
				}
				bw.write(find(cnt, recent, f, r)+"\n");
			}
		}
		bw.flush();
	}

	private static String find(int cnt, int recent, int[] f, int[] r) {
		String res = "";
		if(cnt == 0){
			if(recent == 0) res = "New Customer";
			else if(recent == 1) res = "Promising";
			else if(recent == 2) res = "About to Sleep";
			else res = "Lost";
		}
		else if(cnt == 1){
			if(recent <= 1) res = "Potential Loyalist";
			else if(recent == 2) res = "About to Sleep";
			else if(recent == 3) res = "Hibernating";
			else res = "Lost";
		}
		else if(cnt == 2){
			if(recent <= 1) res = "Potential Loyalist";
			else if(recent == 2) res = "Need Attention";
			else res = "About to Leave";
		}
		else if(cnt == 3){
			if(recent <= 2) res = "Loyal Customer";
			else res = "About to Leave";
		}
		else{
			if(recent == 0) res = "Champion";
			else if(recent <= 2) res = "Loyal Customer";
			else if(recent == 3) res = "About to Leave";
			else res = "Can't Lose Them";
		}
		return res;
	}
}