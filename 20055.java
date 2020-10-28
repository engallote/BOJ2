import java.util.*;

public class Main {
	static int N, K;
	static Pair[] arr; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() * 2;
		K = sc.nextInt();
		arr = new Pair[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), 0);
		
		System.out.println(run());
	}
	private static int run() {
		int count = 0, end = N / 2 - 1, zero = 0;
		
		while(true) {
			++count;//단계
			
			//(1) 벨트 회전
			int d = arr[N - 1].d, r = arr[N - 1].r;
			for(int i = N - 1; i > 0; i--) {
				arr[i].d = arr[i - 1].d;
				arr[i].r = arr[i - 1].r;
			}
			arr[0].d = d;
			arr[0].r = r;
			
			//(2) 로봇 이동
			for(int i = N - 1; i >= 0; i--) {
				if(arr[i].r == 1) {
					if(i == N - 1) {
						if(arr[0].r == 0 && arr[0].d > 0) {
							arr[0].r = 1;
							arr[0].d -= 1;
							arr[i].r = 0;
						}
					}
					else if(i == end) arr[i].r = 0;
					else {
						if(arr[i + 1].d > 0 && arr[i + 1].r == 0) {
							arr[i + 1].d -= 1;
							arr[i + 1].r = 1;
							arr[i].r = 0;
							if(i + 1 == end) arr[i + 1].r = 0;
						}
					}
				}
			}
			
			//(3) 로봇 올리기
			if(arr[0].d > 0 && arr[0].r == 0) {
				arr[0].d -= 1;
				arr[0].r = 1;
			}
			
			//0 검사
			zero = 0;
			for(int i = 0; i < N; i++)
				if(arr[i].d == 0) ++zero;
			
			//(4) 0인 칸이 K개 이상인 경우 종료
			if(zero >= K) break;
		}
		
		return count;
	}
}
class Pair {
	int d, r;
	Pair(int d, int r) {
		this.d = d;
		this.r = r;
	}
}