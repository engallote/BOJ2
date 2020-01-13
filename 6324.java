import java.util.*;

public class Main {
	static String pro, host, port, path, d = "<default>";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			char[] ch = sc.next().toCharArray();
			int idx = 0;
			pro = "";
			host = "";
			port = d;
			path = d;
			
			idx = findProtocol(ch, 0);
			findHost(ch, idx);
			
			System.out.println("URL #" + test_case);
			System.out.println("Protocol = " + pro);
			System.out.println("Host     = " + host);
			System.out.println("Port     = " + port);
			System.out.println("Path     = " + path);
			System.out.println();
		}
	}
	private static void findHost(char[] ch, int i) {
		StringBuilder sb = new StringBuilder();
		for(; i < ch.length; i++){
			if(ch[i] == ':' || ch[i] == '/') {
				if(ch[i] == ':') findPort(ch, i + 1);
				else findPath(ch, i + 1);
				break;
			}
			sb.append(ch[i]);
		}
		host = sb.toString();
	}
	private static void findPort(char[] ch, int i) {
		StringBuilder sb = new StringBuilder();
		for(; i < ch.length; i++){
			if(ch[i] == '/'){
				findPath(ch, i + 1);
				break;
			}
			sb.append(ch[i]);
		}
		port = sb.toString();
	}
	private static void findPath(char[] ch, int i) {
		StringBuilder sb = new StringBuilder();
		for(; i < ch.length; i++)
			sb.append(ch[i]);
		
		path = sb.toString();
	}
	private static int findProtocol(char[] ch, int i) {
		StringBuilder sb = new StringBuilder();
		for(; i < ch.length; i++){
			if(ch[i] == ':') {
				pro = sb.toString();
				return i + 3;
			}
			sb.append(ch[i]);
		}
		return -1;
	}
}