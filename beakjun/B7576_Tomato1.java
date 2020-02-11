package beakjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576_Tomato1 {

	static int h;
	static int w;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static int solution(int m, int n, int[][] tomatos) {

		Queue<Pairs> q = new LinkedList<Pairs>();

		// 익어 있는 토마토 좌표로 큐 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomatos[i][j] == 1) {
					q.add(new Pairs(j, i));
				}
			}
		}

		// 더 이상 익힐 토마토가 없으면 종료
		while (!q.isEmpty()) {

			// 다음 날 익은 토마토 좌표를 큐에 푸시
			Pairs p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (0 <= ny && ny < n && 0 <= nx && nx < m) {
					if (tomatos[ny][nx] == 0) {
						tomatos[ny][nx] = tomatos[p.y][p.x] + 1;
						q.add(new Pairs(nx, ny));
						//System.out.println(ny + " " + nx);
					}
				}
			}

//			for (int k = 0; k < n; k++) {
//				for (int l = 0; l < m; l++) {
//					System.out.print(tomatos[k][l]);
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

		// 큐에 저장된 최대 일 수 구하기
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomatos[i][j] == 0) {
					return -1;
				}
				max = Math.max(max, tomatos[i][j]);
			}
		}
		return max-1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] tomatos = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tomatos[i][j] = sc.nextInt();
			}
		}

		int answer = solution(m, n, tomatos);
		System.out.println(answer);
		
		sc.close();
	}
}
