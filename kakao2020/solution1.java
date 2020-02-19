package kakao2020;

public class solution1 {
	public static int solution(String s) {
		int len = s.length();
		int answer = len;

		// 1부터 len/2 단위로 자른다
		for (int i = 1; i <= len / 2; i++) {
			int com = 0;
			int rep = 1;
			
			com += i;
			String u = s.substring(0, i);
			System.out.println("unit" + i);

			// u : 단위 문자열 / c : 비교 문자열
			for (int j = 1; j < len / i; j++) {
				int start = i * j;
				int end = i * (j + 1);
				String c = s.substring(start, end);
				System.out.println(u);
				System.out.println(c);

				// 같은 단위 문자열이면 rep 카운트
				if (u.equals(c)) {
					rep++;
					System.out.println("rep=" + rep);
				}

				// 다른 단위 문자열이면 압축 문자열(com)에 반복된 숫자(rep)와 단위 문자열 길이 기록
				// 새로운 단위 문자열로 업데이트
				else {
					com += i;
					if (rep != 1) {
						com += Math.log10(rep) + 1;
					}
					System.out.println("com=" + com);
					rep = 1;

					u = s.substring(start, end);
				}
			}

			// 남은 문자열 기록
			if (rep != 1) {
				com += Math.log10(rep) + 1;
			}
			System.out.println("com=" + com);

			if (len % i != 0) {
				com += s.substring(len - len % i, len).length();
				System.out.println("com=" + com);
			}

			answer = Math.min(com, answer);

		}

		return answer;
	}

	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
		int answer = solution(s);
		System.out.println(answer);
	}
}
