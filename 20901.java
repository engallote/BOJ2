import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	Pair[] arr = new Pair[N];
    	
    	for(int i = 0; i < N; i++) {
    		String str = sc.next();
    		int num = sc.nextInt();
    		arr[i] = new Pair(str, num);
    	}
    	
    	Arrays.sort(arr);
    	
    	for(int i = 0; i < N - 1; i++) {
    		if(!comp(arr[i], arr[i+1])) {
    			System.out.println("impossible");
    			return;
    		}
    	}
    	
    	for(int i = 0; i < N; i++)
    		System.out.println(arr[i].name + " " + arr[i].num);
	}
    public static boolean comp(Pair p1, Pair p2) {
    	if(p1.name.equals("cube")) {
    		if(p2.name.equals("cube")) return p1.num <= p2.num;
    		else return p1.num <= Math.sqrt(2) * p2.num;
    	}
    	else {
    		if(p2.name.equals("cube")) return p1.num <= 0.5 * p2.num;
    		else return p1.num <= p2.num;
    	}
    }
}
class Pair implements Comparable<Pair> {
	String name;
	int num;
	Pair(String name, int num) {
		this.name = name;
		this.num = num;
	}
	double cal() {
		if(name.equals("cube")) return num * num;
		else return num * num * Math.PI;
	}
	@Override
	public int compareTo(Pair o) {
		return Double.compare(cal(), o.cal());
	}
}