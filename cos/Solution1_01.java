package cos;

class Solution1_01 {
    public long solution(long num) {
        // Write code here.
    	num++;
    	long digit =1;
    	while(num/digit%10==0) {
    		num+=digit;
    		digit*=10;
    	}
    	return num;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1_01 sol = new Solution1_01();
        long num = 9949999;
        long ret = sol.solution(num);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}

//#����1
//��� �������� Ÿ�Ӹӽ��� Ÿ�� ���ŷ� ���� ���� 0�� ���� �� ü�踦 �����߽��ϴ�. ���簡 �ٲ�� ���� ������� �ǽ� �ӿ� 0�̶� ���ڰ� ��������ϴ�. ����, ������ �� ü��� 1, 2, 3, ..., 8, 9, 11, 12, ...�� ���� 0�� ���� �ٲ�����ϴ�.
//
//0�� �������� ���� �ڿ��� num�� �Ű������� �־��� ��, �� ���� 1�� ���� ���� return �ϵ��� solution �޼ҵ带 �ϼ����ּ���.
//
//---
//
//#####�Ű����� ����
//�ڿ��� num�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//* num�� 1 �̻� 999,999,999,999,999,999 ������ 0�� �������� �ʴ� �ڿ����Դϴ�.
//
//---
//
//#####return �� ����
//�ڿ��� num�� 1�� ���� ���� return ���ּ���.
//
//---
//
//#####����
//
//| num     | return |
//|---------|---------|
//| 9949999 | 9951111 |
//
//#####���� ����
//
//9,949,999�� 1�� ���ϸ� 9,950,000������ 0�� �������� �����Ƿ� 9,951,111�� �˴ϴ�.