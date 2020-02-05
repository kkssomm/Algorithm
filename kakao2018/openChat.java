package kakao2018;

import java.util.HashMap;

public class openChat {
	 public static String[] solution(String[] record) {
	        int size=0;
	        //<uid,name>
	        HashMap<String,String> h = new HashMap<String,String>();
	        
	        for(int i=0;i<record.length;i++) {
	        	String[] temp = record[i].split(" ");
	        	if(temp[0].equals("Enter")) {
	        		h.put(temp[1], temp[2]);
	        		size++;
	        	}
	        	else if(temp[0].equals("Change")) {
	        		h.put(temp[1], temp[2]);
	        	}
	        	else {
	        		size++;
	        	}
	        }
//	        for(String key: h.keySet()) {
//				System.out.println("key:"+key+"   value:"+h.get(key));
//			}
	        
	        String[] answer = new String[size];
	        int index=0;
	        for(int i=0;i<record.length;i++) {
	        	String[] temp = record[i].split(" ");
	        	if(temp[0].equals("Enter")) {
	        		answer[index++] = h.get(temp[1])+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
	        	}
	        	else if(temp[0].equals("Leave")) {
	        		answer[index++] = h.get(temp[1])+"´ÔÀÌ ³ª°¬½À´Ï´Ù.";
	        	}
	        }
	        
	        return answer;
	    }
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

		String answer[]=(solution(record));
		for(String s:answer) {
			System.out.println(s);
		}
	}
}
