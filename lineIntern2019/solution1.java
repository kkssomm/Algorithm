package lineIntern2019;

public class solution1 {
	static boolean answer = false;	
	public static boolean solution(int[] stones) {
		find(stones[0], 0, 1, stones);

		return answer;
	}

	static void find(int stone, int k, int index, int[] stones) {
		if(index==stones.length){
			if(stone==stones[stones.length-1]) {
				answer=true;
				return;
			}
			else return;
			}
		if (stone + k + 1 == stones[index]) {
			//System.out.println("stone" + stones[index] + " k" + (k + 1));
			find(stones[index], k + 1, index + 1, stones);
		}
		if (stone + k == stones[index]) {
			//System.out.println("stone" + stones[index] + " k" + k);
			find(stones[index], k, index + 1, stones);
		}
		if (stone + k - 1 == stones[index]) {
			//System.out.println("stone" + stones[index] + " k" + (k - 1));
			find(stones[index], k - 1, index + 1, stones);
		}
		find(stone,k,index+1,stones);
	}

	public static void main(String[] args) {
		int[] stones = {0,1,2,3,4,8,9,11};
		//int[] stones = {0,1,3,5,6,8,12,17};
		boolean answer = solution(stones);
		System.out.println(answer);
	}
}
