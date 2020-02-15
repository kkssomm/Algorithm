package kakao2020;

public class solution1 {
	public static int solution(String s) {
		int len = s.length();
		int answer = len;

		// 1부터 len/2 단위로 자른다
		for (int i = 1; i <= len / 2; i++) {
			int com = 0;
			int rep=1;
			com+=i;
			String u = s.substring(0, i);
			System.out.println("unit"+i);
			
			for (int j = 1; j < len / i; j++) {
				int start = i * j;
				int end = i * (j + 1);
				String c = s.substring(start, end);
				System.out.println(u);
				System.out.println(c);
				if(u.equals(c)) {
					rep++;
					System.out.println("rep="+rep);
				}
				else {
					com += i;
					if(rep!=1) {
						com+=Math.log10(rep)+1;
					}
					System.out.println("com="+com);
					rep = 1;
					
					u = s.substring(start,end);
				}
			}
			
				//com += i;
				if(rep!=1) {
					com+=Math.log10(rep)+1;
				}
				System.out.println("com="+com);
				
			if (len % i != 0) {
				com+=s.substring(len-len%i,len).length();
				System.out.println("com="+com);
			}
			
			answer = Math.min(com, answer);
			
		}

		return answer;
	}

	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
		int answer = solution(s);
		System.out.println(answer);
	}
}
