package kakao2019;

public class sol4 {
	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		// ���� ��ȸ
		for (int i = 0; i < queries.length; i++) {

			String q = queries[i];
			int qlen = q.length();

			// ����ǥ�� �տ� ���� �� : �ܾ� �ں��� ��
			if (q.charAt(0) == '?') {
				// �ܾ��� ��ȸ
				for (int j = 0; j < words.length; j++) {
					// �� �ܾ� ��ȸ
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
			// ����ǥ�� �ڿ� ���� �� : �ܾ� �պ��� ��
			else {
				// �ܾ��� ��ȸ
				for (int j = 0; j < words.length; j++) {
					// �� �ܾ� ��ȸ
					for (int k = 0; k < qlen; k++) {
						// System.out.println("-"+i);
						// ���� ��
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
