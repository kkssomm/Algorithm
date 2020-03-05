package codingtest;
import java.util.HashMap;
import java.util.Iterator;

public class M_sol1 {
	public static int[] solution (int[] waiting) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

		for (Integer p : waiting) {
			if(!map.containsKey(p)) {
				map.put(p, ++count);
			}
		}

		int[] answer = new int[map.size()];
		for (Integer key : map.keySet()) {
			answer[map.get(key)-1] = key;
		 }
		
//		for(Integer i : answer) {
//			System.out.println(i);
//		}
		
		return answer;
	}
		


	public static void main(String[] args) {
		int[] waiting = {1, 5, 8, 2, 10, 5, 4, 6, 4, 8};
		int[] answer = solution(waiting);
		System.out.println(answer);
	}

}
