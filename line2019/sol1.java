package line2019;

import java.util.Arrays;
import java.util.Scanner;

public class sol1 {
	public static int solution(int[] a, int[] b) {
		int message = a[0];
		int[] customer = new int[a[1]];
		int index = 0;
		int min = 0;

		for (int i = 0; i < message; i++) {
			min = customer[0];
			index = 0;
			for (int j = 0; j < customer.length; j++) {
				if (customer[j] == 0) {
					index = j;
					break;
				}
				if (customer[j] < min) {
					min = customer[j];
					index = j;
				}
			}
			customer[index] += b[i];
		}

		for(int i:customer) {
			System.out.println(i);
		}

		Arrays.sort(customer);
		return customer[customer.length - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[2];
		for (int i = 0; i < 2; i++) {
			a[i] = sc.nextInt();
		}
		int n = a[0];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println(solution(a, b));
	}

}
