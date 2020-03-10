package beakjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B15683_CCTV {

	public static class Cctv {
		int x;
		int y;
		int num;

		Cctv(int y, int x, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	static int[][] check;
	static ArrayList<Cctv> list = new ArrayList<Cctv>();
	static int answer = Integer.MAX_VALUE;
	static int n;
	static int m;

	public static void dfs(int cctvIdx, int[][] office) {
		int[][] check = new int[n][m];

		// {탈출} 모든 cctv 탐색 시
		if (cctvIdx == list.size()) {
			// 최소 사각지대 수
			int blind = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (office[i][j] == 0) {
						blind++;
					}
				}
			}
			answer = Math.min(blind, answer);

//			System.out.println("cctv no." + cctvIdx);
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(" " + office[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

		}

		// {진행} cctv 탐색
		else {
			
			Cctv cctv = list.get(cctvIdx);
			int x = cctv.x;
			int y = cctv.y;
			int num = cctv.num;
//			System.out.println("x=" + x + " y=" + y + " num=" + num);

			switch (num) {
			case 1:				
				// {1}
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < m; j++) {
							check[i][j] = office[i][j];
						}
					}
					// {2} 
					watch(check, office, y, x, k);
					// {3} 
					dfs(cctvIdx + 1, check);
				}

				break;

			case 2:
				for (int k = 0; k < 2; k++) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < m; j++) {
							check[i][j] = office[i][j];
						}
					}
					watch(check, office, y, x, k);
					// 수평방향
					watch(check, office, y, x, (k + 2) % 4);
					dfs(cctvIdx + 1, check);
				}
				break;
			case 3:
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < m; j++) {
							check[i][j] = office[i][j];
						}
					}
					watch(check, office, y, x, k);
					// 수직방향
					watch(check, office, y, x, (k + 1) % 4);
					dfs(cctvIdx + 1, check);
				}
				break;
				
			case 4:
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < m; j++) {
							check[i][j] = office[i][j];
						}
					}
					watch(check, office, y, x, k);
					// 수직방향
					watch(check, office, y, x, (k + 1) % 4);
					// 수평방향
					watch(check, office, y, x, (k + 2) % 4);
					dfs(cctvIdx + 1, check);
				}
				break;
				
			case 5:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						check[i][j] = office[i][j];
					}
				}
				// 모든방향
				watch(check, office, y, x, 0);
				watch(check, office, y, x, 1);
				watch(check, office, y, x, 2);
				watch(check, office, y, x, 3);
				dfs(cctvIdx + 1, check);
				break;
			}
			
		}
	}

	public static void watch(int[][] check, int[][] office, int y, int x, int direction) {
		// 벽을 만나면 종료, 감시한 영역을 7로 바꾸면서 진행
		switch (direction) {
		// 왼쪽
		case 0:
			for (int k = x; k >= 0; k--) {
				if (check[y][k] == 6) {
					break;
				}
				check[y][k] = 7;
			}
			break;
		// 위
		case 1:
			for (int k = y; k >= 0; k--) {
				if (check[k][x] == 6) {
					break;
				}
				check[k][x] = 7;
			}
			break;
		// 오른쪽
		case 2:
			for (int k = x; k < m; k++) {
				if (check[y][k] == 6) {
					break;
				}
				check[y][k] = 7;
			}
			break;
		// 아래
		case 3:
			for (int k = y; k < n; k++) {
				if (check[k][x] == 6) {
					break;
				}
				check[k][x] = 7;
			}
			break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		int[][] office = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				office[i][j] = sc.nextInt();
				// cctv 위치 list에 add
				if (1 <= office[i][j] && office[i][j] <= 5) {
					list.add(new Cctv(i, j, office[i][j]));
				}
			}
		}

		dfs(0, office);

		System.out.println(answer);
		sc.close();
	}

}
