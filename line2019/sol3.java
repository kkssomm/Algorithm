package line2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class sol3 {
	public static int solution(int n, int[][] applicant) {
		int answer = 1;
		int exit = 0;
		// [0] : enterTime
		// [1] : exitTime

		Arrays.sort(applicant, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		for (int i = 0; i < n; i++) {
			System.out.println(applicant[i][0] + " " + applicant[i][1]);
		}

		for (int i = 0; i < n; i++) {
			if (exit > applicant[i][0]) {
				answer++;
			} else {
				exit = applicant[i][1];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] applicant = new int[N][2];

		for (int i = 0; i < N; i++) {
			applicant[i][0] = sc.nextInt();
			applicant[i][1] = sc.nextInt();
		}
		sc.close();

		System.out.println(solution(N, applicant));
	}

}
