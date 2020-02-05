package programmers;

public class DfsBfs02_Network {
	static int answer = 0;
	static boolean visited[];

	public static int solution(int n, int[][] computers) {
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(i, n, computers);
				answer++;
			}
		}
		return answer;
	}
	
	static void dfs(int index, int n, int[][] computers) {
		visited[index] = true;
		//System.out.println("index"+index);
		
		for(int j=0;j<n;j++) {
			if(!visited[j]&&computers[index][j]==1) {
				dfs(j,n,computers);
			}
		}
	}

	
	public static void main(String[] args) {
		int n = 5;
		int[][] computers = { {1, 0, 1, 0, 1},{0, 0, 0, 0, 0},{1, 0, 1, 0, 1},{0, 0, 0, 0, 0},{1, 0, 1, 0, 1} };
		int answer = solution(n, computers);
		System.out.println(answer);
	}

}
