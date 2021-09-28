import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String str = sc.next();
    	boolean flag = true;
    	if(str.contains("A")) {
    		str = str.replaceAll("B", "A");
    		str = str.replaceAll("C", "A");
    		str = str.replaceAll("D", "A");
    		str = str.replaceAll("F", "A");
    	}
    	else if(str.contains("B")) {
    		str = str.replaceAll("C", "B");
    		str = str.replaceAll("D", "B");
    		str = str.replaceAll("F", "B");
    	}
    	else if(str.contains("C")) {
    		str = str.replaceAll("D", "C");
    		str = str.replaceAll("F", "C");
    	}
    	else flag = false;
    	
    	if(flag) System.out.println(str);
    	else {
    		for(int i = 0; i < str.length(); i++)
    			System.out.print("A");
    	}
	}
}