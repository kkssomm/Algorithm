package kakao2019;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Iterator;

class Node1 implements Comparable<Node1> {
	int x;
	int y;
	int a;

	public Node1(int x, int y, int a) {
		this.x = x;
		this.y = y;
		this.a = a;
	}

	@Override
	public int compareTo(Node1 compareBook) {
		// ��������
		return this.y - compareBook.y;
	}
}

class Node2 implements Comparable<Node2> {
	int x;
	int y;
	int a;

	public Node2(int x, int y, int a) {
		this.x = x;
		this.y = y;
		this.a = a;
	}

	@Override
	public int compareTo(Node2 compareBook) {
		// ��������
		return this.x - compareBook.x;
	}
}

public class sol5 {
	public static int[][] solution(int n, int[][] build_frame) {

		HashMap<Integer, Node1> h = new HashMap<Integer, Node1>();
		
		//���� �� ��Ҵ� �� ��
		for (int i = 0; i < build_frame.length; i++) {
			if (build_frame[i][3] == 1) {
				h.put(i, new Node1(build_frame[i][0], build_frame[i][1], build_frame[i][2]));
			} else {
				h.remove(i);
			}
		}
		
		//h�� �ִ� ��Ҹ� x�࿡ ���� ����
		PriorityQueue<Node1> q = new PriorityQueue<Node1>();

		Iterator<Integer> keySetIterator = h.keySet().iterator();
		while (keySetIterator.hasNext()) {
			Integer key = keySetIterator.next();
			q.offer(new Node1(h.get(key).x, h.get(key).y, h.get(key).a));
		}
		
		//q�� �ִ� ��Ҹ� y�࿡ ���� ����
		PriorityQueue<Node2> q2 = new PriorityQueue<Node2>();

		while (!q.isEmpty()) {
			q2.offer(new Node2(q.peek().x, q.peek().y, q.peek().a));
			q.poll();
		}
		
		//answer
		int[][] answer = new int[q2.size()][3];
		int i = 0;
		while (!q2.isEmpty()) {
			// System.out.println(q.poll().x);
			answer[i][0] = q2.peek().x;
			answer[i][1] = q2.peek().y;
			answer[i][2] = q2.peek().a;
			q2.poll();
			i++;

		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		int answer[][] = solution(n, build_frame);
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(" " + answer[i][j]);
			}
			System.out.println();
		}
	}
}
