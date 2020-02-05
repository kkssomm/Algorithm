package programmers;

import java.util.PriorityQueue;

public class Heap01_MoreSpicy {
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i: scoville) {
        	heap.offer(i);
        }
        System.out.println(heap);
        
        while(heap.peek()<K) {
        	if(heap.size()==1) {
        		return -1;
        	}
        	int temp = heap.poll()+heap.poll()*2;
        	heap.offer(temp);
        	answer++;
        	System.out.println("temp:"+temp);
        	System.out.println(heap);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] scoville = {1,2,3,4,5};
		int k =2;
		int answer = solution(scoville, k);
		System.out.println(answer);
	}
	
}
