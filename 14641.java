import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<Character, String> hs = new HashMap<>();
        for(int i = 0; i < N; i++){
        	char a = sc.next().charAt(0);
        	char b = sc.next().charAt(0);
        	if(hs.containsKey(a)) hs.replace(a, hs.get(a)+""+b);
        	else hs.put(a, b+"");
        }
        
        for(int i = 0; i < M; i++){
        	char[] ch1 = sc.next().toCharArray();
        	char[] ch2 = sc.next().toCharArray();
        	
        	if(ch1.length != ch2.length) System.out.println("no");
        	else{
        		boolean flag = true;
        		for(int j = 0; j < ch1.length; j++)
        			if(ch1[j] != ch2[j]){
        				if(!find(hs, ch1[j], ch2[j])){
        					flag = false;
        					break;
        				}
        			}
        			
        		if(flag) System.out.println("yes");
        		else System.out.println("no");
        	}
        }
    }

	private static boolean find(HashMap<Character, String> hs, char a, char b) {
		HashSet<Character> hs2 = new HashSet<>();
		Queue<Character> q = new LinkedList<Character>();
		q.offer(a);
		hs2.add(a);
		
		while(!q.isEmpty()){
			char x = q.poll();
			
			if(x == b) return true;
			
			if(hs.containsKey(x)){
				char[] ch1 = hs.get(x).toCharArray();
				for(char c : ch1){
					if(!hs2.contains(c)){
						hs2.add(c);
						q.offer(c);
					}
				}
			}
		}
		return false;
	}
}