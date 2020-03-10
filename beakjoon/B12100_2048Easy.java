package beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12100_2048Easy {
	
	static int[] dm = {1,-1,1,-1};
	static int[] ds = {0,1,0,1};
	static int n;
	static int[][] board;
	
	public static int dfs(int depth, int dir) {
		// �̵���Ų �� �ִ� ����
		if(depth==5) {
			int max=0;
			for(int i =0;i<n;i++) {
				for(int j =0;j<n;j++) {
					max=Math.max(board[i][j], max);
				}
			}
			return max;
		}
		
		// �̵�
		int[][] map = board;
		int num = 0;
		
		for(int i =0;i<4;i++) {
			shift(i);
			num = Math.max(num, dfs(depth+1,i));
			board = map;
		}
		
		return num;
	}
	
	// �̵���Ű�� �Լ�
	public static void shift(int dir) {
		Queue q = new LinkedList();

		for(int i = 0;i<n;i++) {
			int start = 0;
			int end = 0;
			int r = ds[dir] * (n-1);
			boolean check = false;
			
			while(r>=0&&r<n) {
				int nblock = d &2?
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j =0;j<n;j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int count = 0;
		count = dfs(0,0);
		
	}

}
