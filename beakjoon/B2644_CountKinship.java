package beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2644_CountKinship {
	static int[][] kinship;
	static int[] visited;

	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
//			System.out.println(q);
			int y = q.poll();
		
			for(int i = 1;i<kinship.length;i++) {
				if(kinship[y][i]==1 && visited[i]==0) {
					q.offer(i);
					visited[i] = visited[y]+1;
//					for(int j:visited) System.out.print(j+" ");System.out.println();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		kinship = new int[n + 1][n + 1];

		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			kinship[a][b] = kinship[b][a] = 1;
		}
		
		visited = new int[n+1];
		bfs(x);
		
		if(visited[y]==0) System.out.println(-1);
		else {
			System.out.println(visited[y]);
		}
	}

}
