package beakjun;

import java.util.Scanner;

public class B9663_NQueen {
	static int answer = 0;
	///static int[] check;
	
	public static void dfs(int x, int n) {
		// n열까지 탐색하면 종료
		if (x == n) {
			answer++;
			System.out.println("dd");
			return;
		}

		else {
			for (int i = 0; i < n; i++) {
				check[x]= i;
				for(int j=0;j<n;j++) {
					if(check[j]!=check[x] && Math.abs(x-j)!= Math.abs(check[x]-check[j])) {
						System.out.println("x="+x+" y="+i);
						dfs(x+1,n);
						
					}
				}
			}
		}
	}

	pubilc static boolean check(int[] col, int row) {
		for(int i=1;i<row;i++) {
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		check = new int[n];
		
		// n행까지 반복
			dfs(0, n);

		System.out.println(answer);
	}

}
