package kakao2017;

public class fourthStageHighTone {
	static int answer;
	
	static int solution(int n) {
	    answer = 0;
	   
	    int k=0;
	    int sum=0;
	    for(int i=0;i<n;i++) {
	    	sum+=i*3+2;
	    	if(sum>=n) {
	    		k=i; break;
	    	}
	    }
	    System.out.println("k"+k);
	    //top-down
	    func(0,n,k*2);
	    
	    return answer;
	}
	
	static void func(int plus, int n,int k) {
		//최대길이까지 왔을 때 return
		if(n<3||k<0) {
			System.out.println("k"+k);
			return;
		}
		
		//마지막에는 *==만 남아야함
		if(n==3) {
			if(plus==2) {
				System.out.println("ans");
				answer++;
			}
		}
		else {
			if(n%3==0&&plus>=2) {
				System.out.println(plus+" "+n+" "+k);
				func(plus-2,n/3,k);
				
			}
			System.out.println(plus+" "+n+" "+k);
			func(plus+1,n-1,k-1);
		}
		
	}

	public static void main(String[] args) {
		int n = 24;

		System.out.println(solution(n));
	}

}
