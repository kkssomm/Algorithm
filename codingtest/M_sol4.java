package codingtest;

public class M_sol4 {
	public static int solution(int[] bricks) {
		int answer = 0;
		int right= bricks[0];
		int left=bricks[0];
				
		for(int i=1;i<bricks.length;i++) {
			if(right<bricks[i]) {
				right=bricks[i];
			}
			for(int j=i;j<bricks.length;j++) {
				if(left<bricks[j]) {
					left=bricks[j];
				}
			}
			//System.out.println(i+" right="+right+" left="+left);
			if(right!=0&&left!=0) {
				answer+=Math.min(right,left)-bricks[i];
				left=0;
			}
			//System.out.println(answer);
		}
		
		return answer;
    }
	
	public static void main(String[] args) {
		int[] bricks = {0, 2, 0, 1, 3, 1, 2, 0, 1, 0, 2, 0};
		int answer = solution(bricks);
		System.out.println(answer);
	}

}
