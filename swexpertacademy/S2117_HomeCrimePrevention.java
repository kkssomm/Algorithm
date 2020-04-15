package swexpertacademy;

import java.util.Scanner;

public class S2117_HomeCrimePrevention {

	static int n, m, max;
	static int[][] city;

	public static void solution(int x, int y) {
		// k가 최대 n*n 칸을 모두 채우는 범위까지 진행
		for(int k=0;k<n+2;k++) {
			int count = 0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int nx = Math.abs(i-x);
					int ny = Math.abs(j-y);
					
					// 집의 수를 count
					if(nx+ny<k && city[i][j] ==1) {
						count++;
					}
				}
			}
			
			int profit = (count*m) -(k*k+(k-1)*(k-1));
			if(profit<0) continue;
			// 손해를 보지 않는 경우, 최대 집의 수 업데이트
			else {
				max = Math.max(count, max);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			city = new int[n][n];

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					city[r][c] = sc.nextInt();
				}
			}
			max = 0;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					solution(r, c);
				}
			}

			System.out.println("#" + i + " " + max);
		}

	}

}
