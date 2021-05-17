import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.nextLine().toCharArray();
    	
    	for(int i = 0; i < ch.length; i++) {
    		if(ch[i] == ' ') System.out.print(" ");
    		else if('a' <= ch[i] && ch[i] <= 'z') System.out.print(ch[i]);
    		else {
    			char c = '.';
    			switch(ch[i]) {
    			case 'Q': c = 'W'; break;
    			case 'W': c = 'E'; break;
    			case 'E': c = 'R'; break;
    			case 'R': c = 'T'; break;
    			case 'T': c = 'Y'; break;
    			case 'Y': c = 'U'; break;
    			case 'U': c = 'I'; break;
    			case 'I': c = 'O'; break;
    			case 'O': c = 'P'; break;
    			case 'A': c = 'S'; break;
    			case 'S': c = 'D'; break;
    			case 'D': c = 'F'; break;
    			case 'F': c = 'G'; break;
    			case 'G': c = 'H'; break;
    			case 'H': c = 'J'; break;
    			case 'J': c = 'K'; break;
    			case 'K': c = 'L'; break;
    			case 'Z': c = 'X'; break;
    			case 'X': c = 'C'; break;
    			case 'C': c = 'V'; break;
    			case 'V': c = 'B'; break;
    			case 'B': c = 'N'; break;
    			case 'N': c = 'M'; break;
    			}
    			System.out.print(c);
    		}
    	}
	}
}