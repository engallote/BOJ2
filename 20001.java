import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ques = 0;
		while(true) {
			String str = sc.nextLine();
			if(str.equals("������ ����� ��")) {
				if(ques > 0) System.out.println("����");
				else System.out.println("�������� �����");
				break;
			}
			else if(str.equals("����")) {
				++ques;
			}
			else if(str.equals("������")) {
				if(ques > 0) --ques;
				else ques += 2;
			}
		}
	}
}