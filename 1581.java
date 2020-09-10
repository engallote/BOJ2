import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int FF = sc.nextInt();
		int FS = sc.nextInt();
		int SF = sc.nextInt();
		int SS = sc.nextInt();
		int res = Math.max(FF, SS);
		
			
		if(FF == 0 && FS == 0){
			if(SF == 0) res = SS;
			else res = SS + 1;
		}
		else if(FS == 0) res = FF;
		else{
			if(FS <= SF) res = FF + SS + FS + FS;
			else res = FF + SS + SF + SF + 1;
		}
		
		System.out.println(res);
	}
}