package cos;

class Solution1_06{
    public int func(int record){
        if(record == 0) return 1;
        else if(record == 1) return 2;
        return 0;
    }

    public int Solution1_6(int[] recordA, int[] recordB){
        int cnt = 0;
        for(int i = 0; i < recordA.length; i++){
            if(recordA[i] == recordB[i])
                continue;
            else if(recordA[i] == func(recordB[i]))
                cnt = cnt + 3;
            else
                cnt = Math.max(0, cnt-1);
        }
        return cnt;
    }

    // The following is main method to output testcase. The main method is correct and you shall correct Solution1_6 method.
    public static void main(String[] args) {
        Solution1_06 sol = new Solution1_06();
        int[] recordA = {2,0,0,0,0,0,1,1,0,0};
        int[] recordB = {0,0,0,0,2,2,0,2,2,2};
        int ret = sol.Solution1_6(recordA, recordB);

        // Press Run button to receive output. 
        System.out.println("Solution1_6: return value of the method is " + ret + " .");
    }
}


//#����6
//�� �л� A�� B�� ��� ������ �Ͽ����ϴ�.
//��� ������ ��Ģ�� �Ʒ��� �����ϴ�.
//
//~~~
//1. ��� ���� �Ʒ����� ������ �����մϴ�. (0��° ĭ)
//2. ������������ �մϴ�.
//3. �̱�� ��� �� ĭ�� �ö󰡰�, ���� �� ĭ�� ��������, ���� ���ڸ��� �ֽ��ϴ�.
//4. ��� ���� �Ʒ����� ���� ���ڸ��� �ֽ��ϴ�.
//5. 2~4 ������ �� �� �ݺ��մϴ�.
//~~~
//
//A�� B�� ��� ������ �Ϸ��� �Ŀ�, A�� ��� �� �� ��° ĭ�� �ִ��� �ľ��Ϸ��� �մϴ�.
//
//A�� B�� �� ���������� ����� ������� ����ִ� �迭 recordA�� recordB�� �Ű������� �־��� ��, ������ ��ģ ���� A�� ��ġ�� return �ϵ��� solution �޼ҵ带 �ۼ��߽��ϴ�. �׷���, �ڵ� �Ϻκ��� �߸��Ǿ��ֱ� ������, ��� �Է¿� ���ؼ��� �ùٸ��� �������� �ʽ��ϴ�. �־��� �ڵ忡�� _**�� ��**_�� �����ؼ� ��� �Է¿� ���� �ùٸ��� �����ϵ��� �����ϼ���.
//
//---
//
//#####�Ű����� ����
//A�� B�� �� ���������� ����� ������� ����ִ� �迭 recordA�� recordB�� �Ű������� �־����ϴ�.
//* recordA�� recordB�� ���Ҵ� 0, 1, 2�� �ϳ��̰� ������� ����, ����, ���� �ǹ��մϴ�.
//* recordA�� recordB�� ���̴� 10�Դϴ�.
//
//---
//
//#####return �� ����
//solution �޼ҵ�� ��� ������ ��ģ �Ŀ� A�� ��� �� �� ��° ĭ�� ��ġ�ϴ����� return �մϴ�.
//* ��� ���� �Ʒ� ĭ�� 0��° ĭ�Դϴ�.
//
//---
//
//#####����
//
//| recordA              | recordB              | return |
//|-----------------------|-----------------------|--------|
//| [2,0,0,0,0,0,1,1,0,0] | [0,0,0,0,2,2,0,2,2,2] | 14     |
//
//#####���� ����
//
//||||||||||||
//|----------|------|------|------|------|------|------|------|------|------|------|
//| recordA | ��   | ���� | ���� | ���� | ���� | ���� | ���� | ���� | ���� | ���� |
//| recordB | ���� | ���� | ���� | ���� | ��   | ��   | ���� | ��   | ��   | ��   |
//| result   | 0    | 0    | 0    | 0    | +3   | +6   | +9   | +8   | +11  | +14  |
