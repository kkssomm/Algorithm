package lineIntern2019;

import java.util.Stack;

public class solution2 {
	public static String solution(String ecr) {
		StringBuffer answer = new StringBuffer();

		Stack<Character> s = new Stack<Character>();
		int open = 0; // '('
		int close = 0; // ')'
		int k = 0;

		for (int i = 0; i < ecr.length(); i++) {
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
				s.push(ecr.charAt(i));
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
		String ecryptedString = "a1{abc}";
		String answer = solution(ecryptedString);
		System.out.println(answer);
	}
}

/*
���� : babababtctctcbabababtctctc
��ȣȭ ���ڿ� : 2{b3{ab}3{tc}}
a1{abc}			aabc
2{3{ab}2{d}}	abababddabababdd
abcd			abcd
abd2{ab}		abdabab

 */