import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if((A + B + C) % 3 != 0) System.out.println(0);
		else{
			Queue<Pair> q = new LinkedList<Pair>();
			HashSet<String> hs = new HashSet<>();
			q.offer(new Pair(A, B, C));
			int size = 0;
			while(!q.isEmpty()){
				size = q.size();
				while(--size >= 0){
					Pair p = q.poll();
					if(p.a == p.b && p.b == p.c && p.c == p.a){
						System.out.println(1);
						return;
					}
					
					if(p.a != p.b){
						if(p.a > p.b && !hs.contains((p.a-p.b)+"."+(p.b*2)+"."+p.c)){
							hs.add((p.a-p.b)+"."+(p.b*2)+"."+p.c);
							q.offer(new Pair(p.a-p.b, p.b*2, p.c));
						}
						else if(p.a < p.b && !hs.contains((p.a*2)+"."+(p.b-p.a)+"."+p.c)){
							hs.add((p.a*2)+"."+(p.b-p.a)+"."+p.c);
							q.offer(new Pair(p.a*2, p.b-p.a, p.c));
						}
					}
					if(p.a != p.c){
						if(p.a > p.c && !hs.contains((p.a-p.c)+"."+p.b+"."+(p.c*2))){
							hs.add((p.a-p.c)+"."+p.b+"."+(p.c*2));
							q.offer(new Pair(p.a-p.c, p.b, p.c*2));
						}
						else if(p.a < p.c && !hs.contains((p.a*2)+"."+p.b+"."+(p.c-p.a))){
							hs.add((p.a*2)+"."+p.b+"."+(p.c-p.a));
							q.offer(new Pair(p.a*2, p.b, p.c-p.a));
						}
					}
					if(p.b != p.c){
						if(p.b > p.c && !hs.contains(p.a+"."+(p.b-p.c)+"."+(p.c*2))){
							hs.add(p.a+"."+(p.b-p.c)+"."+(p.c*2));
							q.offer(new Pair(p.a, p.b-p.c, p.c*2));
						}
						else if(p.b < p.c && !hs.contains(p.a+"."+(p.b*2)+"."+(p.c-p.b))){
							hs.add(p.a+"."+(p.b*2)+"."+(p.c-p.b));
							q.offer(new Pair(p.a, p.b*2, p.c-p.b));
						}
					}
				}//while size
			}//while q
			
			System.out.println(0);
		}//else
	}
}
class Pair{
	int a, b, c;
	Pair(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
}