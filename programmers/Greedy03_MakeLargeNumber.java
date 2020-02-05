package programmers;

public class Greedy03_MakeLargeNumber {
	public static String solution(String number, int k) {
		StringBuffer answer = new StringBuffer();

		int max = 0;
		int maxi = 0;
		int index = 0;
		int q = number.length() - k;
		while (true) {
			max = 0;
			maxi = 0;
			for (int i = 0; i < number.length(); i++) {

				int temp = number.charAt(i) - '0';

				if (temp > max) {

					max = temp;

					maxi = i;

				}

			}

			if (maxi >= k) {

				answer.insert(index, number.substring(maxi));

				number = number.substring(0, maxi);

			} else {

				answer.insert(index, max);

				number = number.substring(maxi + 1, number.length());

				k = k - maxi;

				index++;

			}System.out.println(k);
			if (answer.length() == q)
				break;

		}

		return answer.toString();
	}

	public static void main(String[] args) {
		String number = "1231234";
		int k = 3;
		String answer = solution(number, k);
		System.out.println(answer);
	}

}
