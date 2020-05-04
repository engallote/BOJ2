import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		
		long num = Long.parseLong(new String(ch));
		if(!isPrime(num)){
			System.out.println("no");
			return;
		}
		
		for(int i = ch.length - 1; i >= 0; i--){
			if(ch[i] == '0' || ch[i] == '1' || ch[i] == '2' || ch[i] == '5' || ch[i] == '8') 
				sb.append(ch[i]);
			else if(ch[i] == '6') sb.append(9);
			else if(ch[i] == '9') sb.append(6);
			else{
				flag = false;
				break;
			}
		}
		
		if(!flag) System.out.println("no");
		else{
			if(sb.toString().equals(new String(ch))) System.out.println("yes");
			else{
				num = Long.parseLong(sb.toString());
				if(!isPrime(num)){
					System.out.println("no");
					return;
				}
				System.out.println("yes");
			}
		}
	}

	private static boolean isPrime(long num) {
		if(num == 1) return false;
		if(num == 2) return true;
		
		for(long i = 3; i <= Math.sqrt(num); i+=2)
			if(num % i == 0) return false;
		return true;
	}
}