package beakjoon;

import java.util.Scanner;

public class B1760_NRook {
	static boolean[][] adj = new boolean[5002][5002];
	static int[] visit = new int[5002];
	static int n, m;
	static int visitCount;
	static int[] matchR;
	static int[] matchC;
	
	// matchR의 정점인 x에서 matchC의 매칭되지 않은 정점으로 가는 경로를 찾음
	static boolean dfs(int x) {
//		System.out.println("x="+x);
//		System.out.println("visitCnt="+visitCount);
		
		if(visit[x] == visitCount) {
			return false;
		}
		visit[x] = visitCount;
		
//		for(int i =0;i<10;i++) {
//			System.out.print(visit[i]+" ");
//		}
//		System.out.println();
		
		for(int y = 1;y<=m;y++) {
			if(adj[x][y]) {
				// y가 매칭되어 있지 않다면 matchC[y]부터 시작해 증가 경로를 찾음
				// 매칭되어 있다면 dfs에서 매칭되어 있는 matchR의 정점이 다른 곳을 매칭할 수 있는지 찾음
				if(matchC[y]==0||dfs(matchC[y])) {
					// x와 y매치(연결)
					matchR[x] = y;
					matchC[y] = x;
					return true;
				}
			}
		}
		return false;
	}
	
	static int bipartiteMatch() {
		matchR = new int[n+1];
		matchC = new int[m+1];
		
		int answer = 0;
		for(int i=1;i<=n;i++) {
			visitCount++;
			if(dfs(i)) {
				answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] map = new int[n+1][m+1];
		int[][] col = new int[n+1][m+1];
		int[][] row = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int count = 1;
		boolean check = true;
		// 행 기준으로 넘버링
		for (int i = 1; i <= n; i++) {
			check = false;
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 0 || map[i][j] == 1) {
					col[i][j] = count;
					check = true;
				} else {
					if (check) {
						count++;
						check = false;
					}
				}
//				System.out.println(check);
//				System.out.println(i+" "+j+" "+count);
			}
			if(check) {
				count++;
			}
		}
		
		// 열 기준으로 넘버링
		count = 1;
		for(int j=1;j<=m;j++) {
			check = false;
			
			for(int i=1;i<=n;i++) {
				if(map[i][j] ==0||map[i][j]==1) {
					row[i][j] = count;
					check = true;
				}
				
				else {
					if(check) {
						count++;
						check=false;
					}
				}
//				System.out.println(check);
//				System.out.println(i+" "+j+" "+count);
			}
			
			if(check) {
				count++;
			}
		}
		
		int maxR = 0;
		int maxC = 0;
		visitCount=0;
		// 1인 곳이 이분 매칭에 연결되지 않게 해줌
		for(int i =1;i<=n;i++) {
			for(int j =1;j<=m;j++) {
				if(map[i][j]==0) {
					adj[row[i][j]][col[i][j]] = true;
					maxR = Math.max(maxR,row[i][j]);
					maxC = Math.max(maxC, col[i][j]);
				}
			}
		}
		n=maxR;
		m=maxC;
		
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				System.out.print(adj[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		int answer = bipartiteMatch();
		System.out.println(answer);
		
		sc.close();
	}

}
