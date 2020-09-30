import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ques = 0;
		while(true) {
			String str = sc.nextLine();
			if(str.equals("고무오리 디버깅 끝")) {
				if(ques > 0) System.out.println("힝구");
				else System.out.println("고무오리야 사랑해");
				break;
			}
			else if(str.equals("문제")) {
				++ques;
			}
			else if(str.equals("고무오리")) {
				if(ques > 0) --ques;
				else ques += 2;
			}
		}
	}
}