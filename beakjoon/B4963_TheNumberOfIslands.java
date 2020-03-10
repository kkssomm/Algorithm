package beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class B4963_TheNumberOfIslands {
	static int[][] check;
	static int h;
	static int w;
	// 8�� ����
	static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };

	/* DFS */
	private static void dfs(int y, int x, int[][] islands, int count) {
		check[y][x] = count;
		 System.out.println("x"+x+" y"+y);
		 System.out.println(count);

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < w && 0 <= ny && ny < h) {
				if (islands[ny][nx] == 1 && check[ny][nx] == 0) {
					dfs(ny, nx, islands, count);
				}
			}
		}
	}

	// BFS
	private static void bfs(int y, int x, int[][] islands, int count) {
		Queue<Pairs> q = new LinkedList<Pairs>();
		q.add(new Pairs(x, y));
		check[y][x] = count;
		// System.out.println("x"+x+" y"+y);

		while (!q.isEmpty()) {
			Pairs p = q.remove();
			x = p.x;
			y = p.y;
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= ny && ny < h && 0 <= nx && nx < w) {
					if (islands[ny][nx] == 1 && check[ny][nx] == 0) {
						bfs(ny, nx, islands, count);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
//		w = 5;
//		h = 4;
//		int[][] islands = { { 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 1, 0 } };
		Scanner sc = new Scanner(System.in);
		int[][] islands;
		
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0)
				break;

			islands = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					islands[i][j] = sc.nextInt();
				}
			}
			
			int count = 0;
			check = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (islands[i][j] == 1 && check[i][j] == 0)
						//dfs(i, j, islands, ++count);
						bfs(i, j, islands, ++count);
				}
			}
			System.out.println(count);
		}

		sc.close();
	}
}
