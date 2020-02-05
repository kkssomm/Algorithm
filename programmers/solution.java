package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solution {
	static int[] idxX = { -1, 0, 1, 0 };
	static int[] idxY = { 0, 1, 0, -1 };
	static int m;
	static boolean[][] visited;
	static int[][] arr;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 6;
		int[][] nums = { { 0, 1, 1, 0,0,1 }, { 0,1, 0, 1, 0,0 }, { 0, 1, 0, 0,1,1 }, { 1, 0, 1, 0,0,1 },
		{0,1,0,1,0,1},{0,1,0,1,0,1},{1,1,1,0,1,0}};
//		int n = sc.nextInt();
//		int[] nums = new int[n];
//		for (int i = 0; i < n; i++) {
//			nums[i] = sc.nextInt();
//		}

		new solution();
		solution.sol(n, nums);
	}

	public static void sol(int n, int[][] nums) {
		m = n;
		visited = new boolean[n][n];
		arr = nums;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, nums[i][j], 0);
				}
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int x, int y, int num, int size) {
		int addx, addy;
		visited[x][y] = true;
		System.out.println("i" + x + " j" + y);

		if (x == m - 1 && y == m - 1) {
			answer = size;
			System.out.println("size" + size);
			return;
		}

		for (int i = 0; i < 4; i++) {
			addx = idxX[i] + x;
			addy = idxY[i] + y;

			if (addx >= 0 && addy >= 0 && addx < m && addy < m && !visited[addx][addy]) {
				size += arr[addx][addy];
				bfs(addx, addy, num, size);
			}
		}
		return;
	}
	
	 static class Pair{
	        private int y,x;
	        Pair(int x, int y){
	            this.y = y;
	            this.x = x;
	        }
	    }
}
