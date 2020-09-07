import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int res = 0;
		Trie[] trie = new Trie[501];
		
		for(int i = 1; i <= 500; i++)
			trie[i] = new Trie();
		
		for(int i = 0; i < N; i++){
			String str = sc.next();
			trie[str.length()].insert(str.toCharArray());
		}
		
		for(int i = 0; i < M; i++){
			String str = sc.next();
			
			res += trie[str.length()].search(str.toCharArray());
		}
		
		System.out.println(res);
	}
}
class Trie{
	Trie[] child;
	
	Trie(){
		child = new Trie[26];
	}
	void insert(char[] word){
		Trie par = this;
		
		for(char ch : word){
			if(par.child[ch-'a'] == null)
				par.child[ch-'a'] = new Trie();
			par = par.child[ch-'a'];
		}
	}
	int search(char[] word){
		Trie par = this;
		
		for(char ch : word){
			if(par.child[ch-'a'] == null) return 0;
			par = par.child[ch-'a'];
		}
		
		return 1;
	}
}