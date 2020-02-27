import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TreeMap<String, Pair> tree = new TreeMap<>();
		
		for(int i = 0; i < N; i++){
			TreeMap<String, Pair> sub = tree;
			int num = sc.nextInt();
			
			for(int j = 0; j < num; j++){
				String str = sc.next();
				if(!sub.containsKey(str)) sub.put(str, new Pair());
				sub = sub.get(str).child;
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
			System.out.print("--");
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