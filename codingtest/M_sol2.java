package codingtest;

public class M_sol2 {
	public static String solution(String s1, String s2) {
        String answer = "";
        int len1 = Math.min(s1.length(), s2.length());
        int len2 = Math.max(s1.length(), s2.length());
        String a1 = "";
        String a2 = ""; 
        String ss1 = "";
        String ss2 = "";
        if(len1==s1.length()) {
        	ss1 = s1;
        	ss2 = s2;
        }
        else {
        	ss1 = s2;
        	ss2 = s1;
        }
        //System.out.println(ss1);
        //System.out.println(ss2);
        
        for(int i=0;i<len1;i++) {
        //	System.out.println(ss1.substring(i)+" "+ss2.substring(0,len1-i));
        	if(ss1.substring(i).equals(ss2.substring(0,len1-i))) {
        		a1 = ss1+ss2.substring(len1-i);
        		break;
        	}
        }
        //System.out.println(a1);
        
        for(int i=0;i<len2;i++) {
        	//System.out.println(ss2.substring(len2-len1+i)+" "+ss1.substring(0,len1-i));
        	if(ss2.substring(len2-len1+i).equals(ss1.substring(0,len1-i))) {
            		a2 = ss2+ss1.substring(len1-i);
            		break;
        	}
        }
        //System.out.println(a2);
        
        if(a1.length()<a2.length()) {
        	answer = a1;
        }
        else if(a1.length()>a2.length()) {
        	answer = a2;
        }
        else {
        	if(a1.compareTo(a2)==-1) {
        		answer = a1;
        	}
        	else {
        		answer = a2;
        	}
        }
        
        return answer;
	}
	
	public static void main(String[] args) {
		String s1 = "AxA";
		String s2 = "AyA";
		String answer = solution(s1, s2);
		System.out.println(answer);
	}

}
