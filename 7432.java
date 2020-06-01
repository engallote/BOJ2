import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TreeMap<String, Pair> tree = new TreeMap<>();
		
		for(int i = 0; i < N; i++){
			TreeMap<String, Pair> child = tree;
			String tmp = sc.next();
			ArrayList<String> str = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			
			for(int j = 0; j < tmp.length(); j++){
				if(tmp.charAt(j) == '\\'){
					str.add(sb.toString());
					sb = new StringBuilder();
				}
				else sb.append(tmp.charAt(j));
			}
			str.add(sb.toString());
			
			if(!child.containsKey(str.get(0))) child.put(str.get(0), new Pair());
			child = child.get(str.get(0)).child;
			
			for(int j = 1; j < str.size(); j++){
				if(!child.containsKey(str.get(j))) child.put(str.get(j), new Pair());
				child = child.get(str.get(j)).child;
			}
		}
		
		Iterator<String> it = tree.keySet().iterator();
		while(it.hasNext()){
			String str = it.next();
			solve(str, 0, tree);
		}
	}

	private static void solve(String str, int cnt, TreeMap<String, Pair> tree) {
		for(int i = 0; i < cnt; i++)
			System.out.print(" ");
		System.out.println(str);
		for(String name : tree.get(str).child.keySet())
			solve(name, cnt + 1, tree.get(str).child);
	}
}
class Pair{
	TreeMap<String, Pair> child;
	Pair(){
		this.child = new TreeMap<>();
	}
}