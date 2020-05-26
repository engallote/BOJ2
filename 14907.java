import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer>[] arr = new ArrayList[26]; 
		int[] time = new int[26], indgree = new int[26], max = new int[26];
		boolean[] chk = new boolean[26];
		
		for(int i = 0; i < 26; i++)
			arr[i] = new ArrayList<>();
		
		while(sc.hasNextLine()){
			String[] str = sc.nextLine().split(" ");
			int ch = str[0].charAt(0)-'A';
			time[ch] = Integer.parseInt(str[1]);
			chk[ch] = true;
			
			if(str.length > 2){
				for(char ch2 : str[2].toCharArray()){
					arr[ch2-'A'].add(ch);
					++indgree[ch];
				}
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < 26; i++)
			if(indgree[i] == 0 && chk[i]){
				max[i] = time[i];
				q.offer(i);
			}
		
		int size = 0, res = 0;
		Arrays.fill(chk, false);
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				res = Math.max(res, max[x]);
				
				for(int next : arr[x]){
					max[next] = Math.max(max[next], max[x] + time[next]);
					q.offer(next);
				}
			}
		}
		
		System.out.println(res);
	}
}