package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap02_RamenFactory {
	public int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		int index = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

		for (int i = 0; i < k; i++) {
			// ���� ����
			if (index < dates.length && i == dates[index]) {
				heap.offer(supplies[index]);
				index++;
			}
			// ����
			if (stock == 0) {
				stock += heap.poll();
				answer++;
			}
			stock--;
		}
		return answer;
	}
}
