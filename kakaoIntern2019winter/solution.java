package kakaoIntern2019winter;

import java.util.Arrays;

public class solution {

	public static int[] solution(String s) {
		
		String[] part;

		part = s.split("[^A-Z0-9]+|[^0-9$]");
		Arrays.sort(part);
		int len = part.length - 1;
		int n = (int) ((Math.sqrt(1 + 4 * 2 * len) - 1) / 2);
		int[] answer = new int[n];
		// 1개 이상 집합 존재
		if (part.length > 2) {
			//
			int count=1;
			for (int i = 2; i < part.length; i++) {
				if(part[i].equals(part[i-1])) {
					count++;
				}
				else{
					answer[n-count]=Integer.parseInt(part[i-1]);
					count=1;
				}
			}
			answer[n-count]=Integer.parseInt(part[part.length-1]);
		}
		
		// 1개의 집합만 존재
		else {
			answer[0] = Integer.parseInt(part[1]);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String s = "{{123}}";

		int[] answer = solution(s);
		for (int i : answer) {
			System.out.print(" " + i);
		}
	}
}
