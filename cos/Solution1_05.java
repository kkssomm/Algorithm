package cos;

import java.util.*;

class Solution1_05 {
    public int[] Solution1_5(int N, int[] votes) {
        int voteCounter[] = new int[11];
        for (int i = 0; i < votes.length; i++) {
            voteCounter[votes[i]] += 1;
        }
        int maxVal = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (maxVal < voteCounter[i]) {
                maxVal = voteCounter[i];
                cnt = 1;
                System.out.println(i);
            }
            else if(maxVal == voteCounter[i]){
                cnt += 1;
            }
        }
        int answer[] = new int[cnt];
        for (int i = 1, idx = 0; i <= N; i++){
            if (voteCounter[i] == maxVal) {
                answer[idx] = i;
                idx += 1;
            }
        }
        return answer;
    }
    
    // The following is main method to output testcase. The main method is correct and you shall correct Solution1_5 method.
    public static void main(String[] args) {
        Solution1_05 sol = new Solution1_05();
        int N1 = 5;
        int[] votes1 = {1,5,4,3,2,5,2,5,5,4};
        int[] ret1 = sol.Solution1_5(N1, votes1);
 
        // Press Run button to receive output. 
        System.out.println("Solution1_5: return value of the method is " + Arrays.toString(ret1) + " .");
        

        int N2 = 4;
        int[] votes2 = {1, 3, 2, 3, 2};
        int[] ret2 = sol.Solution1_5(N2, votes2);
 
        // Press Run button to receive output. 
        System.out.println("Solution1_5: return value of the method is " + Arrays.toString(ret2) + " .");
    }
}

//#����5
//1������ N������ �ĺ��� ���ؼ� ��ǥ�� �����߽��ϴ�. ���� ��� ��ǥ ����� [1, 5, 4, 3, 2, 5, 2, 5, 5, 4]��� ������� [1��, 5��, 4��, 3��, 2��, 5��, 2��, 5��, 5��, 4��] �ĺ��� ��ǥ������ ��Ÿ���ϴ�. �̶�, ���� ���� ǥ�� ���� �ĺ��� ��ȣ�� ���Ϸ��� �մϴ�.
//
//�־��� solution �޼ҵ�� �ĺ��� �� N�� ��ǥ�� ������ ����� ��� �迭 votes�� �Ű������� �־����� ��, ���� ���� ǥ�� ���� �ĺ��� ��ȣ�� return �ϴ� �޼ҵ��Դϴ�. �׷���, �ڵ� �Ϻκ��� �߸��Ǿ��ֱ� ������, ��� �Է¿� ���ؼ��� �ùٸ��� �������� �ʽ��ϴ�. �־��� �ڵ忡�� _**�� ��**_�� �����ؼ� ��� �Է¿� ���� �ùٸ��� �����ϵ��� �����ϼ���.
//
//---
//#####�Ű����� ����
//�ĺ��� �� N�� ��ǥ ����� ����ִ� �迭 votes�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//* N�� 1 �̻� 10 ������ �ڿ����Դϴ�.
//* votes�� ���̴� 1 �̻� 100 �����Դϴ�.
//* votes�� ���Ҵ� 1 �̻� N������ �ڿ����Դϴ�.
//
//---
//#####return �� ����
//���� ���� ǥ�� ���� �ĺ��� ��ȣ�� �迭�� ��� return ���ּ���
//* ���� ���� ���� ǥ�� ���� �ĺ��� 2�� �̻��̶��, �� �ĺ����� ��ȣ�� ��� �迭�� ��� �������� �����Ͽ� return ���ּ���.
//
//---
//#####����
//
//| N | votes                 | return |
//|---|-----------------------|--------|
//| 5 | [1,5,4,3,2,5,2,5,5,4] | [5]    |
//| 4 | [1,3,2,3,2]           | [2,3]  |
//
//#####���� ����
//���� #1
//1������ 5������ 5���� �ĺ��� ������, ��ǥ ����� [1, 5, 4, 3, 2, 5, 2, 5, 5, 4]�Դϴ�. �� �ĺ��� ��ǥ���� ������ �����ϴ�.
//
//* 1�� �ĺ��� 1ǥ
//* 2�� �ĺ��� 2ǥ
//* 3�� �ĺ��� 1ǥ
//* 4�� �ĺ��� 2ǥ
//* 5�� �ĺ��� 4ǥ
//
//�� ��� 5�� �ĺ��� 4ǥ�� ���� ���� ǥ�� ������ϴ�.
//
//���� #2
//1�� �ĺ��� 1ǥ, 2�� �ĺ��� 2ǥ, 3�� �ĺ��� 2ǥ�� �޾ҽ��ϴ�. 2���� 3�� �ĺ��� �������� ���� ���� ǥ�� �޾ұ� ������ [2, 3]�� �������� �����Ͽ� return �ϸ� �˴ϴ�.