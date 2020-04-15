package programmers;

import java.util.Arrays;

public class Greedy07_Weight {
	public static int solution(int[] weight) {
        Arrays.sort(weight);
        int answer = weight[0];    

        for(int i=1;i<=weight.length;i++) {
        	answer +=weight[i-1];
        	if(i==weight.length) {
        		return answer++;
        	}
        	if(answer<weight[i]) {
        		return answer++;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] weight = {3, 1, 6, 2, 7, 30, 1};
		System.out.println(solution(weight));
	}

}
