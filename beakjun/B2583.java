package beakjun;

public class B2583 {
	static boolean[][] path;
	static int answer;
	public static void solution(int n, int m, int k, int[][] index) {
		boolean[][] graph = new boolean[n][m];

		// 1. 사각형그리기
		for (int l = 0; l < k; l++) {
			for (int i = index[l][1]; i < index[l][3]; i++) {
				for (int j = index[l][0]; j < index[l][2]; j++) {
					graph[i][j] = true;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(graph[i][j]+"\t");
			}
			System.out.println();
		}

		// 2. 갯수 세기 (graph의 false 영역)
		int numberOfArea = 0;
		int[] sizeOfArea = new int[n];
		int a = 0;
		path = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!path[i][j] && graph[i][j] == false) {
					path[i][j] = true;
					find(graph, i, j, graph[i][j]);
					numberOfArea++;
					sizeOfArea[a] = find(graph, i, j, graph[i][j]);
					System.out.println("size"+sizeOfArea[a]);
					a++;
					//System.out.println("start i, j : " + i + ", " + j);
				}
			}
		}
		System.out.println(numberOfArea);
//		for(int i:sizeOfArea) {
//			System.out.println(i);
//		}
	}

	// 3. 크기 구하기
	public static int find(boolean[][] graph, int i, int j, boolean val) {
		answer = 1;
		System.out.println("i, j : " + i + ", " + j);
		if (i > 0 && !path[i - 1][j] && graph[i - 1][j] == false) {
			path[i - 1][j] = true;
			answer+=find(graph, i - 1, j, val);
		}

		if (i < graph.length - 1 && !path[i + 1][j] && graph[i + 1][j] == false) {
			path[i + 1][j] = true;
			answer+=find(graph, i + 1, j, val);
		}

		if (j > 0 && !path[i][j - 1] && graph[i][j - 1] == false) {
			path[i][j - 1] = true;
			answer+=find(graph, i, j - 1, val);
		}

		if (j < graph[0].length - 1 && !path[i][j + 1] && graph[i][j + 1] == false) {
			path[i][j + 1] = true;
			answer+=find(graph, i, j + 1, val);
		}
		//System.out.println(answer);
		return answer;
		//탈출조건(return 1)
	}

	public static void main(String[] args) {
		int n = 5;
		int m = 7;
		int k = 3;
		int[][] index = { { 0, 2, 4, 4 }, { 1, 1, 2, 5 }, { 4, 0, 6, 2 } };
		solution(n, m, k, index);
	}
}
