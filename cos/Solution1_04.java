package cos;

import java.util.*;

class Solution1_04 {
    public int[] Solution1_4(int[] arrA, int[] arrB) {
        int arrA_idx = 0, arrB_idx = 0;
        int arrA_len = arrA.length;
        int arrB_len = arrB.length;
        int answer[] = new int[arrA_len + arrB_len];
        int answer_idx = 0;
        while(arrA_idx<arrA_len && arrB_idx<arrB_len){
            if(arrA[arrA_idx] < arrB[arrB_idx])
                answer[answer_idx++] = arrA[arrA_idx++];
            else
                answer[answer_idx++] = arrB[arrB_idx++];
        }
        while(arrA_idx<arrA_len)
            answer[answer_idx++] = arrA[arrA_idx++];
        while(arrB_idx<arrB_len)
            answer[answer_idx++] = arrB[arrB_idx++];
        return answer;
    }
    
    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1_04 sol = new Solution1_04();
        int[] arrA = {-2, 3, 5, 9};
        int[] arrB = {0, 1, 5};
        int[] ret = sol.Solution1_4(arrA, arrB);
 
        // Press Run button to receive output. 
        System.out.println("Solution1_4: return value of the method is " + Arrays.toString(ret) + " .");
    }
}


//#����4
//������������ ���ĵǾ��ִ� �� �迭 arrA, arrB�� �ϳ��� �迭�� ��ġ�� �մϴ�. ��, ��ģ ���� �迭�� ������������ ���ĵǾ� �־�� �մϴ�.
//
//���� ��� arrA = [-2, 3, 5, 9], arrB = [0, 1, 5]�� ��� �� �迭�� ������������ ���ĵ� �ϳ��� �迭�� ��ġ�� [-2, 0, 1, 3, 5, 5, 9]�� �˴ϴ�.
//
//������������ ���ĵ� �� �迭 arrA�� arrB�� �־����� ��, �� �迭�� ������������ ���ĵ� �ϳ��� �迭�� ���ļ� return �ϵ��� solution �޼ҵ带 �ۼ��Ϸ� �մϴ�. ��ĭ�� ä�� ��ü �ڵ带 �ϼ����ּ���.
//
//---
//##### �Ű����� ����
//������������ ���ĵ� �� �迭 arrA�� arrB�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//
//* arrA�� ���̴� 1 �̻� 200,000 �����Դϴ�.
//* arrA�� ���Ҵ� -1,000,000 �̻� 1,000,000 ������ �����Դϴ�.
//* arrB�� ���̴� 1 �̻� 200,000 �����Դϴ�.
//* arrB�� ���Ҵ� -1,000,000 �̻� 1,000,000 ������ �����Դϴ�.
//
//---
//##### return �� ����
//�� �迭 arrA, arrB�� ������������ ���ĵ� �ϳ��� �迭�� ���ļ� return ���ּ���.
//
//---
//##### ����
//
//| arrA          | arrB      | return                 |
//|---------------|-----------|------------------------|
//| [-2, 3, 5, 9] | [0, 1, 5] | [-2, 0, 1, 3, 5, 5, 9] |
