package programmers;

public class DP04_WaytoSchool {

	public int solution(int m, int n, int[][] puddles) {
		int x = m;
		int y = n;
		int[][] path = new int[y][x];
		
		// ¿õµ¢ÀÌ -> -1
		for (int i = 0; i < puddles.length; i++) {
			path[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
		}
		
		// ¸ð¼­¸® ¿õµ¢ÀÌ Ã¼Å© (1Çà) -> 0
		int tmp = 1;
		for (int i = 0; i < y; i++) {
			if (path[i][0] != -1) {
				path[i][0] = tmp;
			} else {
				tmp = 0;
			}
		}
		
		// ¸ð¼­¸® ¿õµ¢ÀÌ Ã¼Å© (1¿­) -> 0
		tmp = 1;
		for (int i = 0; i < x; i++) {
			if (path[0][i] != -1) {
				path[0][i] = tmp;
			} else {
				tmp = 0;
			}
		}
		
		// °æ¿ìÀÇ ¼ö ´õÇÏ±â
		for (int i = 1; i < y; i++) {
			for (int j = 1; j < x; j++) {
				if (path[i][j] == -1)
					continue;
				else {
					if (path[i - 1][j] != -1 && path[i][j - 1] != -1)
						path[i][j] = (path[i - 1][j] + path[i][j - 1]) % 1000000007;
					else if (path[i - 1][j] != -1 && path[i][j - 1] == -1)
						path[i][j] = path[i - 1][j] % 1000000007;
					else if (path[i - 1][j] == -1 && path[i][j - 1] != -1)
						path[i][j] = path[i][j - 1] % 1000000007;
					else {
						path[i][j] = 0;
					}
				}
			}
		}
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++)
				System.out.print(path[i][j]);
			System.out.println();
		}
		return path[y - 1][x - 1];
	}

	public static void main(String[] args) {
		int x = 4; //°¡·Î
		int y = 3; //¼¼·Î
		int[][] puddles = { { 2, 2 },{2,1}};
		DP04_WaytoSchool s = new DP04_WaytoSchool();
		System.out.println(s.solution(x, y, puddles));
	}
}
