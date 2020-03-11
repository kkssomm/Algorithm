package swexpertacademy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S4050_BargainSale {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 1;
		
		for(int j=0;j<t;j++) {
			
			int n = sc.nextInt();
			int total = 0;
			Integer[] arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				total += arr[i];
			}
			
			// {1} 내림차순 정렬
			Arrays.sort(arr, Collections.reverseOrder());

			// {2} 3개씩 그룹으로 묶기
			int answer = 0;
			for (int i = 2; i < n; i += 3) {
				// {3} 그룹 중 가장 저렴한 옷 값 = 할인 값
				answer += arr[i];
			}

			// {4} 전체 옷값에서 할인 값 빼기
			System.out.printf("#%d %d\n", count++, total - answer);
		}
		sc.close();
	}
}