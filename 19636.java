import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();//���̾�Ʈ �� ü��
		int L = sc.nextInt();//���̾�Ʈ �� ������ ���뷮 �� ���� ��緮
		int T = sc.nextInt();//���ʴ�緮 ��ȭ ��ġ
		
		int D = sc.nextInt();//���̾�Ʈ �Ⱓ
		int I = sc.nextInt();//���̾�Ʈ �Ⱓ ������ ���뷮
		int A = sc.nextInt();//���̾�Ʈ �Ⱓ Ȱ�� ��緮
		
		int tmp1 = W, tmp2 = W, tl = L;
		boolean d1 = false, d2 = false;
		for(int i = 0; i < D; i++) {
			if(!d1) {
				tmp1 += I - (L + A);//���� ��緮 ��ȭ ��� x
				if(tmp1 <= 0) d1 = true;
			}
			
			//���� ��緮 ��ȭ ���
			if(d2) continue;
			tmp2 += I - (tl + A);
			if(Math.abs(I - (tl + A)) > T) {
				if((I - (tl + A)) >= 0) tl += (I - (tl + A)) / 2;
				else {
					if((I - (tl + A)) % 2 == 0) tl += (I - (tl + A)) / 2;
					else tl += (I - (tl + A)) / 2 - 1;
				}
			}
			if(tmp2 <= 0 || tl <= 0) d2 = true;
		}
		
		if(d1) System.out.println("Danger Diet");
		else System.out.println(tmp1 + " " + L);
		
		if(d2 || L - tl < 0) System.out.println("Danger Diet");
		else {
			System.out.print(tmp2 + " " + tl + " ");
			if((L - tl) > 0) System.out.println("YOYO");
			else System.out.println("NO");
		}
	}
}