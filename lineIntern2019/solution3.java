package lineIntern2019;

public class solution3 {
	public static int solution(int[] hList) {
        int answer = 0;
        int max=hList[0];
        int index=0;
        int box=0;
        
        for(int i=1;i<hList.length;i++) {
        	
        	if(max<hList[i]) {
        		answer+=max*(i-index-1)-box;
        		
        		index=i;
        		max=hList[i];
        		box=0;
        	}
        	
        	else {
        		box+=hList[i];
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] hList = {1,2,1,3,1,2,1,3};
		int answer = solution(hList);
		System.out.println(answer);
	}
}
