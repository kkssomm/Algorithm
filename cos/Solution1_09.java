package cos;

class Solution1_09 {
    public String func_a(String str, int len){
        String padZero = "";
        int padSize = len-str.length();
        for(int i = 0; i < padSize; i++)
            padZero += "0";
        return padZero + str;
    }
    
    public int Solution1_9(String binaryA, String binaryB) {
        int maxLength = Math.max(binaryA.length(), binaryB.length());
        binaryA = func_a(binaryA, maxLength);
        binaryB = func_a(binaryB, maxLength);
        
        int hammingDistance = 0;
        for(int i = 0; i < maxLength; i++)
            if(binaryA.charAt(i)!=binaryB.charAt(i))
                hammingDistance += 1;
        return hammingDistance;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1_09 sol = new Solution1_09();
        String binaryA = "10010";
        String binaryB = "110";
        int ret = sol.Solution1_9(binaryA, binaryB);
        
        // Press Run button to receive output. 
        System.out.println("Solution1_9: return value of the method is " + ret + " .");
    }
}

//#����9
//�ع� �Ÿ�(Hamming distance)�� ���� ���̸� ���� �� ���� ���ڿ����� ���� ��ġ�� ������ ���� �ٸ� ������ ������ ���մϴ�. ���� ��� �� 2���� ���ڿ��� "10010"�� "110"�̶��, ���� �� ���ڿ��� �ڸ����� ���߱� ���� "110"�� �տ� 0 �ΰ��� ä�� "00110"���� ����� �ݴϴ�. �� 2���� ���ڿ��� ù ��°�� �� ��° ���ڰ� ���� �ٸ��Ƿ� �ع� �Ÿ��� 2�Դϴ�.
//
//* `1`0`0`1 0
//* `0`0`1`1 0
//
//�� 2���� ���ڿ� binaryA, binaryB�� �ع� �Ÿ��� ���Ϸ� �մϴ�. �̸� ���� ������ ���� ������ ���α׷� ������ �ۼ��߽��ϴ�
//
//~~~
//1�ܰ�. ���̰� �� �� 2���� ���ڿ��� ���̸� ���մϴ�.
//2�ܰ�. ù ��° 2���� ���ڿ��� ���̰� �� ª�ٸ� ���ڿ��� �տ� 0�� ä���־� ���̸� �����ݴϴ�.
//3�ܰ�. �� ��° 2���� ���ڿ��� ���̰� �� ª�ٸ� ���ڿ��� �տ� 0�� ä���־� ���̸� �����ݴϴ�.
//4�ܰ�. ���̰� ���� �� 2���� ���ڿ��� �ع� �Ÿ��� ���մϴ�.
//~~~
//
//�� 2���� ���ڿ� binaryA�� binaryB�� �Ű������� �־��� ��, �� 2������ �ع� �Ÿ��� return �ϵ��� solution �޼ҵ带 �ۼ��߽��ϴ�. �̶�, �� ������ �����Ͽ� �ߺ��Ǵ� �κ��� func_a��� �޼ҵ�� �ۼ��߽��ϴ�. �ڵ尡 �ùٸ��� ������ �� �ֵ��� ��ĭ�� �˸°� ä�� ��ü �ڵ带 �ϼ����ּ���.
//
//---
//##### �Ű����� ����
//�� 2���� ���ڿ� binaryA�� binaryB�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//
//* binaryA�� ���̴� 1 �̻� 10 �����Դϴ�.
//* binaryA�� 0 �Ǵ� 1�θ� �̷���� ���ڿ��̸�, 0���� �������� �ʽ��ϴ�.
//* binaryB�� ���̴� 1 �̻� 10 �����Դϴ�.
//* binaryB�� 0 �Ǵ� 1�θ� �̷���� ���ڿ��̸�, 0���� �������� �ʽ��ϴ�.
//
//---
//##### return �� ����
//�� 2���� ���ڿ��� �ع� �Ÿ��� return ���ּ���.
//
//---
//##### ����
//
//| binaryA | binaryB | return |
//|---------|---------|--------|
//| "10010" | "110"   | 2      |
//
//##### ���� ����
//�� 2������ �ڸ����� ���� 5�� 3�Դϴ�. �ڸ����� ���߱� ���� "110" �տ� 0 �� ���� ä���ָ� "00110"�� �˴ϴ�. ���� �� 2���� ���ڿ��� �ع� �Ÿ��� ���ϸ� ������ �����ϴ�.
//
//* `1`0`0`1 0
//* `0`0`1`1 0
//
//���� ���� ù ��°�� �� ��° ���ڰ� ���� �ٸ��Ƿ�, �ع� �Ÿ��� 2�� �˴ϴ�.
