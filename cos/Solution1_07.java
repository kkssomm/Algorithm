package cos;

class Solution1_07 {
	int Solution1_7(int[] prices) {
		int INF = 1000000001;
		int tmp = INF;
		int answer = -INF;
		for (int price : prices) {
			if (tmp != INF)
				answer = Math.max(answer, price-tmp);
			System.out.println("ans"+answer+" tmp-price"+(tmp-price));
			tmp = Math.min(tmp, price);
		}
		return answer;
	}

	// The following is main method to output testcase. The main method is correct
	// and you shall correct Solution1_7 method.
	public static void main(String[] args) {
		Solution1_07 sol = new Solution1_07();
		int[] prices1 = { 1, 2, 3 };
		int ret1 = sol.Solution1_7(prices1);

		// Press Run button to receive output.
		System.out.println("Solution1_7: return value of the method is " + ret1 + " .");

		int[] prices2 = { 3, 1 };
		int ret2 = sol.Solution1_7(prices2);

		// Press Run button to receive output.
		System.out.println("Solution1_7: return value of the method is " + ret2 + " .");
	}
}

//#����7
//���� ���ӵ� n�� ������ �ֽ� ������ ������� ����ִ� �迭�� �ֽ��ϴ�. �̶�, ���� ��Ģ�� ���� �ֽ��� ��� �Ⱦ��� ���� �ִ� ������ ���Ϸ� �մϴ�.
//
//* n�� ���� �ֽ��� �� �� �� �� �� �ֽ��ϴ�.
//* n�� ���� �ֽ��� �� �� �� �� �� �ֽ��ϴ�.
//* �ֽ��� �� ���� �ٷ� �� ���� ������, �ּ� �Ϸ簡 ������ �� �� �ֽ��ϴ�.
//* ��� �� ���� �ֽ��� ����ϸ�, �� ���� �Ⱦƾ� �մϴ�.
//
//�ֽ��� �� ���� �ݵ�� ������ �ֽ��� ���� �ϸ�, �ִ� ������ ����� �ƴ� ���� �ֽ��ϴ�.
//
//���ӵ� n �� ������ �ֽ� ������ ������� ����ִ� �迭 prices�� �Ű������� �־��� ��, �ֽ��� ��Ģ�� �°� �� ���� ����Ⱦ��� �� ���� �� �ִ� �ִ� ������ return �ϵ��� solution �޼ҵ带 �ۼ��߽��ϴ�. �׷���, �ڵ� �Ϻκ��� �߸��Ǿ��ֱ� ������, �ڵ尡 �ùٸ��� �������� �ʽ��ϴ�. �־��� �ڵ忡�� _**�� ��**_�� �����ؼ� ��� �Է¿� ���� �ùٸ��� �����ϵ��� �������ּ���.
//
//---
//#####�Ű����� ����
//���ӵ� n �� ������ �ֽ� ������ ������� ����ִ� �迭 prices�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//* prices�� ���̴� 2 �̻� 1,000,000 �����Դϴ�.
//* prices�� �� ���Ҵ� 1 �̻� 1,000 ������ �ڿ����Դϴ�.
//
//---
//#####return �� ����
//�ֽ��� ��Ģ�� �°� �� ���� ����Ⱦ��� �� ���� �� �ִ� �ִ� ������ return ���ּ���.
//
//---
//##### ����
//
//| prices  	| return 	|
//|---------	|--------	|
//| [1,2,3] 	| 2      	|
//| [3,1]   	| -2     	|
//
//##### ���� ����
//
//���� #1
//���ӵ� 3���� �ְ��� ���ʷ� [1, 2, 3] �̸�, ù° ���� �ֽ��� �缭 ��° ���� �ȸ� ������ 2�̰�, �̶��� �ִ��Դϴ�.
//
//���� #2
//�������� ������ ��ó�� ������ �� ���� �ż��ϰ�, �� ���� �ŵ��ؾ� �մϴ�. ù° ���� �ż��Ͽ� ��° ���� �ŵ��ϴ� ����ۿ� ���� ������ ������ -2, �� 2��ŭ �ս��� ���� �˴ϴ�.
