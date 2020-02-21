package cos;

class Solution1_10 {
    class Pair{
        public int firstNum;
        public int secondNum;
    }
    
    public int func_a(int numA, int numB, char exp){
        if (exp == '+')
            return numA + numB;
        else if (exp == '-')
            return numA - numB;
        else
            return numA * numB;
    }
    
    public int func_b(String exp){
        for(int i = 0; i < exp.length(); i++){
            char e = exp.charAt(i);
            if(e == '+' || e == '-' || e == '*')
                return i;
        }
        return -1;
    }
    public Pair func_c(String exp, int idx){
        Pair ret = new Pair();
        ret.firstNum = Integer.parseInt(exp.substring(0, idx));
        ret.secondNum = Integer.parseInt(exp.substring(idx + 1));
        return ret;
    }
    
    public int Solution1_10(String expression) {
        int expIndex = func_b(expression);
        Pair numbers = func_c(expression,expIndex);
        int result = func_a(numbers.firstNum,numbers.secondNum,expression.charAt(expIndex));
        return result;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1_10 sol = new Solution1_10();
        String expression = "123+12";
        int ret = sol.Solution1_10(expression);

        // Press Run button to receive output. 
        System.out.println("Solution1_10: return value of the method is " + ret + " .");
    }
}


//#����10
//���ڿ� ������ ���� ����Ϸ� �մϴ�. ���� 2���� �ڿ����� 1���� ������('+', '-', '*' �� �ϳ�)�� �̷���� �ֽ��ϴ�. ���� ��� �־��� ���� "123+12"��� �̸� ����� ����� 135�Դϴ�.
//
//���ڿ��� �̷���� ���� ����ϱ� ���� ������ ���� ������ ���α׷� ������ �ۼ��߽��ϴ�.
//
//~~~
//1�ܰ�. �־��� �Ŀ��� �������� ��ġ�� ã���ϴ�.
//2�ܰ�. �������� �հ� �ڿ� �ִ� ���ڿ��� ���� ���ڷ� ��ȯ�մϴ�.
//3�ܰ�. �־��� �����ڿ� �°� ������ �����մϴ�.
//~~~
//
//���ڿ� ������ �� expression�� �Ű������� �־��� ��, ���� ����� ����� return �ϵ��� solution �޼ҵ带 �ۼ��Ϸ� �մϴ�. �� ������ �����Ͽ� �ڵ尡 �ùٸ��� ������ �� �ֵ��� ��ĭ�� �־��� func_a, func_b, func_c �޼ҵ�� �Ű������� �˸°� ä���ּ���.
//
//---
//##### �Ű����� ����
//���ڿ� ������ �� expression�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//* expression�� ������ 1���� ���� 2���� ������ �����Դϴ�.
//  * �����ڴ� '+', '-', '*'�� ���˴ϴ�.
//  * ���ڴ� 1 �̻� 10,000 ������ �ڿ����Դϴ�.
//
//---
//##### return �� ����
//expression�� ����� ����� return ���ּ���.
//* ��� ����� ���ڿ��� ��ȯ���� �ʾƵ� �˴ϴ�.
//
//---
//##### ����
//
//| expression | return |
//|------------|--------|
//| "123+12"   | 135    |
//
//##### ���� ����
//
//'+'�� �������� ���� ���ڴ� 123�̰� ���� ���ڴ� 12�̹Ƿ� �� ���ڸ� ���ϸ� 135�� �˴ϴ�.


