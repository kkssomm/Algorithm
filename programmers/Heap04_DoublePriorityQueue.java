package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap04_DoublePriorityQueue {
	public static int[] solution(String[] operations) {
		int[] answer = { 0, 0 };
		int len = operations.length;
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();

		for (int i = 0; i < len; i++) {
			String[] temp = operations[i].split(" ");
			// Insert
			if (temp[0].equals("I")) {
				max.offer(Integer.parseInt(temp[1]));
				min.offer(Integer.parseInt(temp[1]));
			}
			// Delete
			else {
				if (max.isEmpty() && min.isEmpty()) {
					continue;
				}
				// 최솟값 삭제
				if (temp[1].equals("-1")) {
					int minNum = min.peek();

					min.remove(minNum);
					max.remove(minNum);
				}
				// 최댓값 삭제
				else {
					int maxNum = max.peek();

					min.remove(maxNum);
					max.remove(maxNum);
				}
			}
		}
		if (max.isEmpty() && min.isEmpty()) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = max.poll();
			answer[1] = min.poll();
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] operations = {"I 7","I 5","I -5","D -1"};
		int[] answer = solution(operations);
		for(int i:answer) {
			System.out.print(i);
		}
	}
}
