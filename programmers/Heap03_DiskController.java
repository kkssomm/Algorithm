package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node {
	int idx;
	int val;

	Node(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}
}

public class Heap03_DiskController {
	public static int solution(int[][] jobs) {
		int answer = 0;
		int len = jobs.length;
		int startTime = 0;
		int runTime = 0;
		// ����Ʈ�� ����
		ArrayList<Node> list = new ArrayList<Node>();
		for (int i = 0; i < len; i++) {
			list.add(new Node(jobs[i][0], jobs[i][1]));
		}
		// �ð��� ���� �ɸ��� ������� ����
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.val - o2.val;
			}
		});

		while (list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {

				// ���۽ð�>��û�ð�
				if (list.get(i).idx <= startTime) {
					// ���۽ð� = sum(�ҿ�ð�)
					startTime += list.get(i).val;
					// ��ü �ð� = sum(�����ð�-��û�ð�)
					runTime += startTime - list.get(i).idx;
					list.remove(i);
					break;
				}
				if (i == list.size() - 1)
					startTime++;
			}
		}

		answer = runTime / len;
		return answer;
	}
}
