package beakjoon;

import java.util.Scanner;

public class B17136_PastingColoredPaper {
	static int answer = 0;
	static int[] coloredPaper = { 0, 5, 5, 5, 5 }; // �������� ��
	static boolean check[];

	public static void dfs(int x, int y, int count, int[][] paper) {
		if (x == 9 && y == 9) { // ������ Ž��
			answer = Math.min(answer, count);
			return;
		}
		if (answer <= count)
			return;

		if (x == 0 && y == 0) { // ����
			for (int i = 5; i > 0; i--) { // ũ�Ⱑ ū ������
				if (coloredPaper[i] > 0) { 
					if (check(x, y, i)) {
						fill(x, y, i, 0);
						coloredPaper[i]--;
						dfs(x+1, y+1, count + 1, paper);
						fill(x, y, i, 1);
						coloredPaper[i]++;
					}
				}
			}
		} else {
			dfs(x+1, y+1, count, paper);
		}
	}
	
	public static boolean check(int x, int y, int index) {
		return true;
	}
	
	public static void fill(int x, int y, int index, int a) {
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] paper = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paper[i][j] = sc.nextInt();
			}
		}

		dfs(0,0,0,paper);
	}

}
