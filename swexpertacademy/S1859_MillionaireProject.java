package swexpertacademy;

import java.util.Scanner;


public class S1859_MillionaireProject {
	
	public static long solution(int n, int[] prices) {
		
		long answer =0;
		int max = prices[n-1];
		
		for(int i=n-2;i>=0;i--) {
		
			if (prices[i] < max) {
                   answer += max - prices[i];
               } else {
                   max = prices[i];
               }
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int n = 0; 
		long answer = 0;
		
		for(int i=1; i<=t; i++) {
			n = sc.nextInt();
			int[] prices = new int[n];
			
			for(int j=0;j<n;j++) {
				prices[j] = sc.nextInt();
			}
			
			answer = solution(n,prices);
			System.out.println("#"+i+" "+answer);
		}
		
		sc.close();
	}

}
