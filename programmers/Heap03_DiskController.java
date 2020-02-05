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
		// 리스트에 삽입
		ArrayList<Node> list = new ArrayList<Node>();
		for (int i = 0; i < len; i++) {
			list.add(new Node(jobs[i][0], jobs[i][1]));
		}
		// 시간이 적게 걸리는 순서대로 정렬
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.val - o2.val;
			}
		});

		while (list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {

				// 시작시간>요청시간
				if (list.get(i).idx <= startTime) {
					// 시작시간 = sum(소요시간)
					startTime += list.get(i).val;
					// 전체 시간 = sum(끝난시간-요청시간)
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
