// 정확도 실패

package programmers;

public class Greedy02_Joystick {

	static int solution(String name) {
		
	    int len = name.length();
	    int ud = 0;
	    int rl1 = 0;
	    int rl2 = 0;
	    int ACount = 0;
	    
	    ud += Math.min(name.charAt(0)-'A', 'Z'-name.charAt(0)+1); 
	    
	    for(int i=1;i<len;i++) {
	    	rl1++;
	    	if(name.charAt(i)=='A') {
	    		ACount++;
	    		if(i==len-1) {
	    			rl1-=ACount;
	    		}
	    	}
	    	else {
	    		ACount =0;
	    		ud += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1); 
	    	}
	    }
	    
	    for(int i=len-1;i>0;i--) {
	    	rl2++;
	    	System.out.println(rl2);
	    	if(name.charAt(i)=='A') {
	    		ACount++;
	    		if(i==1) {
	    			rl2-=ACount;
	    		}
	    	}
	    	else {
	    		ACount =0;
	    	}
	    }
	    
	    return Math.min(ud+rl1,ud+rl2);
	}
	
	public static void main(String[] args) {
		String name = "AZAAZ";
		System.out.println(solution(name));

	}

}
