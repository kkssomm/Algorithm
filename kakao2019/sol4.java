package kakao2019;

public class sol4 {
	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		// 쿼리 순회
		for (int i = 0; i < queries.length; i++) {

			String q = queries[i];
			int qlen = q.length();

			// 물음표가 앞에 있을 때 : 단어 뒤부터 비교
			if (q.charAt(0) == '?') {
				// 단어장 순회
				for (int j = 0; j < words.length; j++) {
					// 한 단어 순회
					for (int k = qlen - 1; k >= 0; k--) {
						// System.out.println("-"+i);
						if (qlen != words[j].length()) {
							break;
						}
						if (q.charAt(k) != '?') {
							if (q.charAt(k) != words[j].charAt(k)) {
								break;
							}
						} else {
							// System.out.println(q + " " + words[j]);
							answer[i]++;
							break;
						}
					}
				}
			}
			// 물음표가 뒤에 있을 때 : 단어 앞부터 비교
			else {
				// 단어장 순회
				for (int j = 0; j < words.length; j++) {
					// 한 단어 순회
					for (int k = 0; k < qlen; k++) {
						// System.out.println("-"+i);
						// 길이 비교
						if (qlen != words[j].length())
							break;
						if (q.charAt(k) != '?') {
							if (q.charAt(k) != words[j].charAt(k)) {
								break;
							}
						} else {
							// System.out.println(q + " " + words[j]);
							answer[i]++;
							break;
						}
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
		int[] answer = solution(words, queries);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(" " + answer[i]);
		}
	}
}
