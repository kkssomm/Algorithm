package beakjoon;

import java.util.Scanner;

public class B14719_Rainwater {

	public static int solution(int w, int[] blocks) {
		int answer = 0;
		int right= blocks[0];
		int left=blocks[0];
				
		for(int i=1;i<w;i++) {
			if(right<blocks[i]) {
				right=blocks[i];
			}
			for(int j=i;j<w;j++) {
				if(left<blocks[j]) {
					left=blocks[j];
				}
			}
			//System.out.println(i+" right="+right+" left="+left);
			if(right!=0&&left!=0) {
				answer+=Math.min(right,left)-blocks[i];
				left=0;
			}
			//System.out.println(answer);
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int[] blocks = new int[w];

		for (int i = 0; i < w; i++) {
			blocks[i] = sc.nextInt();
		}

		System.out.println(solution(w,blocks));
	}
}