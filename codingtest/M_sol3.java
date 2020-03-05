package codingtest;

public class M_sol3 {
	public static int solution(int n, int[] v) {
		int answer = Integer.MIN_VALUE;
		
		int max = 0;
		int index =0;
		for(int i=0;i<n;i++) {
		
			if(v[i]>max) {
				max = v[i];
				index = i;
				//System.out.println(max);
				
			}
			else {
				continue;
			}
			for(int j =n-1;j>index;j--) {
				answer= Math.max(max-v[j],answer);
//				System.out.println("answer"+answer);
				//System.out.print(" j"+v[j]);
			}
			//System.out.println();
		}
		return answer;
	}

	public static void main(String[] args) {
		int n = 6;
		int[] v = {	4, 1, 7, 6, 5, 2};
		int answer = solution(n, v);
		System.out.println(answer);
	}

}
