import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		String chk = new String(ch).substring(14, 17);
		if(chk.equals("000")){//체크섬 체크
			System.out.println("I");
			return;
		}
		String code = new String(ch).substring(0, 6);
		int N = sc.nextInt();
		boolean flag = false;
		for(int i = 0; i < N; i++){
			String str = sc.next();
			
			if(str.equals(code)){
				flag = true;
				break;
			}
		}
		
		if(!flag){
			System.out.println("I");
			return;
		}
		
		int year = Integer.parseInt(new String(ch).substring(6, 10));
		
		if(year < 1900 || year > 2011){
			System.out.println("I");
			return;
		}
		
		int month = Integer.parseInt(new String(ch).substring(10, 12));
		int day = Integer.parseInt(new String(ch).substring(12, 14));
		
		flag = false;
		if(month == 2){
			if(day == 29){
				if((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) flag = true;
				else flag = false;
			}
			else if(day >= 1 && day <= 28) flag = true;
			else flag = false;
		}
		else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8|| month == 10 || month == 12){
			if(day >= 1 && day <= 31) flag = true;
			else flag = false;
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11){
			if(day >= 1 && day <= 30) flag = true;
			else flag = false;
		}
		else flag = false;
		
		if(!flag){
			System.out.println("I");
			return;
		}
		
		int x = 0;
		if(ch[17] == 'X') x = 10;
		else x = (ch[17]-'0');
		
		//cal
		long sum = 0;
		for(int i = 0; i < 17; i++){
			sum += (ch[i]-'0') * (long)Math.pow(2, 17-i);
		}
		
		if((int)(sum + x) % 11 != 1){
			System.out.println("I");
			return;
		}
		
		int mw = Integer.parseInt(chk);
		if(mw % 2 == 0)
			System.out.println("F");
		else System.out.println("M");
	}
}