package programmers;

import java.util.HashSet;
import java.util.Iterator;

public class Greedy01_PEclothes {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		HashSet<Integer> lostSet = new HashSet<Integer>();
		HashSet<Integer> reserveSet = new HashSet<Integer>();

		for (int key : lost) {
			lostSet.add(key);
		}
		for (int key : reserve)
			reserveSet.add(key);

		for (int i = 0; i < reserve.length; i++) {
			if (lostSet.contains(reserve[i])) {
				reserveSet.remove(reserve[i]);
				lostSet.remove(reserve[i]);
			}
		}

		Iterator<Integer> itr = lostSet.iterator();
		while (itr.hasNext()) {
			int s = itr.next();

			if (reserveSet.contains(s - 1))
				reserveSet.remove(s - 1);
			else if (reserveSet.contains(s + 1))
				reserveSet.remove(s + 1);
			else
				answer--;
		}

		return answer;
	}
}
