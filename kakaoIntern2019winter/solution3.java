package kakaoIntern2019winter;

import java.util.LinkedList;

public class solution3 {

	public static long[] solution(long k, int[] room_number) {
        long[] answer = new long[room_number.length];
        LinkedList<String> q = new LinkedList<>();
        int index= 0;
        
        // 방
        for(int i=1;i<=k;i++) {
        	q.add(""+i);
        }

        for(int i=0;i<room_number.length;i++) {
        	// 바로 배정
        	int j=0;
        	
        	if(i!=0) {
        		if(room_number[i]>room_number[i-1]) {
        			j=index;
        		}
        	}
        	System.out.println(room_number[i]-1-j);
        	if(Integer.parseInt(q.get(room_number[i]-1-j))==room_number[i]) {
        		answer[i]=room_number[i];
        		q.remove(""+room_number[i]);
        		index++;
        		//System.out.println(q);
        	}
        	// 
        	else {
        		answer[i]=Integer.parseInt(q.get(room_number[i]-1-j));
        		//System.out.println(answer[i]);
        		q.remove(""+answer[i]);
        		index--;
        	}
        	
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int k =10;
		int[] room_number= {1,3,4,1,3,1};

		long[] answer = solution(k,room_number);
		for (long i : answer) {
			System.out.print(" " + i);
		}
	}
}
