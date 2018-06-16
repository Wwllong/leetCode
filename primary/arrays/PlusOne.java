package primary.arrays;

/**
 * @author Wwl
 * ����һ���Ǹ�������ɵķǿ����飬�ڸ����Ļ����ϼ�һ������һ���µ����顣
 * ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�
 * ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
 *
 * ʾ�� 1:
 * ����: [1,2,3]
 * ���: [1,2,4]
 * ����: ���������ʾ���� 123��
 * ʾ�� 2:
 * ����: [4,3,2,1]
 * ���: [4,3,2,2]
 * ����: ���������ʾ���� 4321��
 */

public class PlusOne {
	
	/* ��1���㣬��Ϊ��λ�Ƿ��λ���
	 * ��λ��λ��������length+1 ���飬��λΪ1����λ��Ϊ0
	 * ��λ����λ�����ô������飬���������ɵ�λ�������
	 * carry������Ƿ��λ��
	 * 	��carry��temp/10��Ϊ0����ʾ��û�в�����λ��
	 * -0ms
	 * */
	public int[] plusOne(int[] digits) {
		int carry = 1,temp = 0;
		
	    for (int i = digits.length - 1; i >= 0; --i) {
	        if (carry == 0) {
	            return digits;
	        }
	        temp = digits[i] + carry;
	        carry = temp / 10; //�Ƿ��λ�ı��   
	        digits[i] = temp % 10; //���µ�λ��ֵ
	    }

	    if (carry != 0) {
	        int[] result = new int[digits.length + 1];
	        result[0] = 1;
	        return result;
	    }

	    return digits;

    }
	
	
}
