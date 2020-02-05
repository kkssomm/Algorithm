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
			// ')'일때
			if (p.charAt(i) == ')') {
				close++;
				//스택이 비어있지 않을 때 element 비교 후 push or pop
				if (!s.isEmpty()) {
					if (s.peek() == '(')
						s.pop();
					else {
						s.push(p.charAt(i));
					}
				}
				// 스택이 비어있을 때 push
				else {
					s.push(p.charAt(i));
				}
			}
			
			// '('일때 모두 push
			else {
				open++;
				s.push(ecr.charAt(i));
				// System.out.println(i);
			}
			
			///////////////////////////////////////////
			// 균형있는 괄호
			if (open == close) {
				// 올바른 괄호
				if (s.isEmpty()) {
					answer.append(p.substring(k, i + 1));
					k = i + 1;
					// System.out.println("ans"+answer.toString());
				}
				// 틀린 괄호
				else {
					System.out.println(s);
					int size = s.size();
					//스택에서 꺼내서 append하면 좌우가 바뀜-> 올바른 괄호
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
원본 : babababtctctcbabababtctctc
암호화 문자열 : 2{b3{ab}3{tc}}
a1{abc}			aabc
2{3{ab}2{d}}	abababddabababdd
abcd			abcd
abd2{ab}		abdabab

 */