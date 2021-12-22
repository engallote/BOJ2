import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		String str = sc.nextLine();
    		if(str.equals("#")) break;
    		
    		String[] arr = str.split(" ");
    		int a = 0, b = 0;
    		for(int i = 0; i < arr.length; i++) {
    			if(arr[i].equals("*")) break;
    			if(find(arr[i])) ++a;
    			else ++b;
    		}
    		
    		if(a > b) System.out.println("Cheryl");
    		else if(a < b) System.out.println("Tania");
    		else System.out.println("Draw");
    	}
    }

	private static boolean find(String str) {
		if(str.equals("A") || str.equals("3") || str.equals("5") || str.equals("7") || str.equals("9"))
			return true;
		return false;
	}
}