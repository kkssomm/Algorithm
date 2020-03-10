package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B1912_ContinuousSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = 10;
//		int[] nums = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		new B1912_ContinuousSum();
		B1912_ContinuousSum.solution(n, nums);
	}
	
	public static void solution(int n, int[] nums) {
		int max = nums[0];
		int[] dp = nums;

		dp[0] = nums[0];
		for (int i = 1; i < n; i++) {
			// ���� ���� ���� ���� ��
			if (dp[i - 1] + nums[i] > nums[i]) {
				dp[i] = dp[i - 1] + nums[i];
			}
			// ���� �� -> ������ ���� ����
			else {
				dp[i] = nums[i];
			}
			// System.out.println(dp[i]);
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
