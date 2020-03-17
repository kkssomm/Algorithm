package kakao2017;

public class sol1_ColoringBook {

	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visit;
	static int h;
	static int w;
	
	public static int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2];
		
		int numberOfArea = 0;
		int maxSizeOfArea = 0;
		h = m;
		w = n;
		visit = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && picture[i][j] != 0) {
					maxSizeOfArea = Math.max(dfs(i, j, picture, picture[i][j]),maxSizeOfArea);
					numberOfArea++;
				}
			}
		} 
		
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfArea;
		return answer;
	}
	
	static int dfs(int y, int x, int[][] picture, int p) {	
		int size = 1;
		
		if (picture[y][x] != p || picture[y][x]==0 || visit[y][x]) {
			return 0;
		}
		
		visit[y][x]=true;
		for(int i=0;i<4;i++) {
			int nx = x +dx[i];
			int ny = y+dy[i];
			
			if(nx<0||nx>=w||ny<0||ny>=h) {
				continue;
			}
			size +=dfs(ny,nx,picture,p);
		}
		return size;
	}
	
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

		int[] answer = solution(m,n,picture);
		for(int i:answer) {
			System.out.print(i+" ");
		}
	}

}
