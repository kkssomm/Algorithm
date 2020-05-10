package swexpertacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class theif{
	int x;
	int y;
	int dist;
	
	theif(int x,int y, int dist){
		this.x = x;
		this.y=y;
		this.dist = dist;
	}
}

public class S1953_ArrestDefector {
	
	static int n;
	static int m;
	static int[][] tunnel;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int answer;
	static boolean[][] visited;
	
	public static void bfs(theif before) {
		Queue<theif> q = new LinkedList<theif>();
		q.offer(before);
		visited[before.x][before.y] = true;
		
		while(!q.isEmpty()) {
			theif t = q.poll();
			int hall = tunnel[t.x][t.y];
			int nextX;
			int nextY;
			
			switch(hall) {
			case 1:
				for(int k =0;k<4;k++) {
					nextX = t.x + dx[k];
					nextY = t.y + dy[k];

					if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
						continue;
					
					if(k == 0 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 4 || tunnel[nextX][nextY] == 7))
						continue;
					else if(k == 1 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 5 || tunnel[nextX][nextY] == 6))
						continue;
					else if( k == 2 && (tunnel[nextX][nextY] == 2 || tunnel[nextX][nextY] == 6 || tunnel[nextX][nextY] == 7))
						continue;
					else if( k == 3 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 4 || tunnel[nextX][nextY] == 7))
						continue;
					
					if (!visited[nextX][nextY] && t.dist > 0 && tunnel[nextX][nextY] != 0) {
						visited[nextX][nextY] = true;
						q.offer(new theif(nextX, nextY, t.dist - 1));
						answer++;
					}
				}
				break;
				
			case 2:
				for(int k =0;k<3;k=k++) {
					nextX = t.x + dx[k];
					nextY = t.y + dy[k];

					if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
						continue;
					
					if(k == 0 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 4 || tunnel[nextX][nextY] == 7))
						continue;
					else if(k == 1 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 5 || tunnel[nextX][nextY] == 6))
						continue;
					else if( k == 2 && (tunnel[nextX][nextY] == 2 || tunnel[nextX][nextY] == 6 || tunnel[nextX][nextY] == 7))
						continue;
					else if( k == 3 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 4 || tunnel[nextX][nextY] == 7))
						continue;
					
					if (!visited[nextX][nextY] && t.dist > 0 && tunnel[nextX][nextY] != 0) {
						visited[nextX][nextY] = true;
						q.offer(new theif(nextX, nextY, t.dist - 1));
						answer++;
					}
				}
				break;
				
			case 3:
				for(int k =2;k<4;k++) {
					nextX = t.x + dx[k];
					nextY = t.y + dy[k];

					if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
						continue;
					
					if(k == 0 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 4 || tunnel[nextX][nextY] == 7))
						continue;
					else if(k == 1 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 5 || tunnel[nextX][nextY] == 6))
						continue;
					else if( k == 2 && (tunnel[nextX][nextY] == 2 || tunnel[nextX][nextY] == 6 || tunnel[nextX][nextY] == 7))
						continue;
					else if( k == 3 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 4 || tunnel[nextX][nextY] == 7))
						continue;
					
					if (!visited[nextX][nextY] && t.dist > 0 && tunnel[nextX][nextY] != 0) {
						visited[nextX][nextY] = true;
						q.offer(new theif(nextX, nextY, t.dist - 1));
						answer++;
					}
				}
				break;
				
			case 4:
				for(int k =0;k<4;k++) {
					nextX = t.x + dx[k];
					nextY = t.y + dy[k];

					if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
						continue;
					
					if(k == 0 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 4 || tunnel[nextX][nextY] == 7))
						continue;
					else if(k == 1 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 5 || tunnel[nextX][nextY] == 6))
						continue;
					else if( k == 2 && (tunnel[nextX][nextY] == 2 || tunnel[nextX][nextY] == 6 || tunnel[nextX][nextY] == 7))
						continue;
					else if( k == 3 && (tunnel[nextX][nextY] == 3 || tunnel[nextX][nextY] == 4 || tunnel[nextX][nextY] == 7))
						continue;
					
					if (!visited[nextX][nextY] && t.dist > 0 && tunnel[nextX][nextY] != 0) {
						visited[nextX][nextY] = true;
						q.offer(new theif(nextX, nextY, t.dist - 1));
						answer++;
					}
				}
				break;
			case 5:
				break;
			case 6:
				break;
		
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int l = sc.nextInt();
			tunnel = new int[n][m];
			visited = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					tunnel[i][j] = sc.nextInt();
				}
			}
			answer = 1;
			theif temp = new theif(r,c,l-1);
			bfs(temp);
			
			System.out.println("#" + tc + " ");
		}


	}

}
