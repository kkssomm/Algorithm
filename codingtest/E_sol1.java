package codingtest;

import java.util.HashMap;
import java.util.Iterator;

public class E_sol1 {
	public static int solution (int[] A) {
        int answer=0;
        HashMap<Integer, Integer> map = new HashMap<>();

		for (Integer p : A) {
			if(map.containsKey(p)) {
				map.put(p, map.get(p)+1);
			}
			else {
				map.put(p,1);
			}
		}
        //System.out.println(map);
        
        for (Integer key : map.keySet()) {
			//answer[map.get(key)-1] = key;
        	if(map.get(key)==key) {
        		answer = Math.max(answer, key);
        	}
		 }
        
		return answer;
	}
		


	public static void main(String[] args) {
		int[] A = {3,1,4,1,5};
		int answer = solution(A);
		System.out.println(answer);
	}

}
