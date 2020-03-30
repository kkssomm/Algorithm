package codingtest;

import java.util.HashMap;

public class E_sol2 {
	public static int solution(int[] A) {
		int answer = 0;
		int idx = 0;
		int[][] maxA = new int[A.length][2];
		int[] temp = new int[2];
		boolean flag = false;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (Integer p : A) {
			//System.out.println("p:" + p);
			int sum = 0;
			int num = p;
			while (num != 0) {
				sum += num % 10;
				num /= 10;
			}
			//System.out.println("sum" + ":" + sum);

			if (!map.containsKey(sum)) {
				//System.out.println("없음");
				maxA[idx][1] = p;
				map.put(sum, idx);
				idx = idx + 1;
				//System.out.println(map);
			} else {
				flag =true;
				int tempI = map.get(sum);
				temp = maxA[tempI];
				//System.out.println(sum + ":" + temp[0] + " " + temp[1]);

				if (temp[0] == 0) {
					maxA[tempI][0] = p;
					map.put(sum, tempI);
				} else {
					if (p < temp[0]) {
						break;
					} else if (p < temp[1]) {
						maxA[tempI][0] = p;
					} else {
						maxA[tempI][0] = temp[1];
						maxA[tempI][1] = p;
					}
					map.put(sum, tempI);
				}
				//System.out.println(map);
			}

		}

		for (int i = 0; i < map.size(); i++) {
			answer = Math.max(answer, maxA[i][0] + maxA[i][1]);
		}
		if(flag==false) {
			answer = -1;
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] A = { 51, 71, 17, 42, 13, 52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52, };
		int answer = solution(A);
		System.out.println(answer);
	}

}
