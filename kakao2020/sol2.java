package kakao2020;

import java.util.Stack;

public class sol2 {
	public static String solution(String p) {
		StringBuffer answer = new StringBuffer();

		Stack<Character> s = new Stack<Character>();
		int open = 0; // '('
		int close = 0; // ')'
		int k = 0;

		for (int i = 0; i < p.length(); i++) {
			// ')'�϶�
			if (p.charAt(i) == ')') {
				close++;
				//������ ������� ���� �� element �� �� push or pop
				if (!s.isEmpty()) {
					if (s.peek() == '(')
						s.pop();
					else {
						s.push(p.charAt(i));
					}
				}
				// ������ ������� �� push
				else {
					s.push(p.charAt(i));
				}
			}
			
			// '('�϶� ��� push
			else {
				open++;
				s.push(p.charAt(i));
				// System.out.println(i);
			}
			
			///////////////////////////////////////////
			// �����ִ� ��ȣ
			if (open == close) {
				// �ùٸ� ��ȣ
				if (s.isEmpty()) {
					answer.append(p.substring(k, i + 1));
					k = i + 1;
					// System.out.println("ans"+answer.toString());
				}
				// Ʋ�� ��ȣ
				else {
					System.out.println(s);
					int size = s.size();
					//���ÿ��� ������ append�ϸ� �¿찡 �ٲ�-> �ùٸ� ��ȣ
					for (int j = 0; j < size; j++) {
						answer.append(s.pop());
					}
					k = i + 1;
					// System.out.println("ans"+answer.toString());
				}
			}
		}

		return answer.toString();
	}

	public static void main(String[] args) {
		String p = ")()()()(";
		String answer = solution(p);
		System.out.println(answer);
	}

}
