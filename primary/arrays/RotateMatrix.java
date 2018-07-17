package primary.arrays;

import java.util.Arrays;

/**
 * @author Wwl
 * ����һ�� n �� n �Ķ�ά�����ʾһ��ͼ��
 * ��ͼ��˳ʱ����ת 90 �ȡ�
 * ˵����
 * �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
 * �������� matrix = [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]
 *  ],ԭ����ת�������ʹ���Ϊ:[
 *  [7,4,1],
 *  [8,5,2],
 *  [9,6,3]
 *  ]
 *  
 *  �������������飬90����ת����
 */
public class RotateMatrix {
	
	/*���ڵ�ǰλ�ã�������ת�����λ�ã�������һ���µ�λ�ã�ֱ����λ��Ϊ��ʼλ��
	* 2ms
	*/
	public int[][] rotate(int[][] matrix) {
		int l = matrix.length;
		for (int i = 0; i<l/2 ; ++i) { //����ѭ���Ĵ���
			for (int j = i; j < l - 1 - i; ++j) {//ÿ��ѭ�����ĸ�ֵ
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[l - 1 - j][i]; //��ǰλ����ת���ֵ
                matrix[l - 1 - j][i] = matrix[l - 1 - i][l - 1 - j]; //��һ����תλ�õ�ֵ
                matrix[l - 1 - i][l - 1 - j] = matrix[j][l - 1 - i];
                matrix[j][l - 1 - i] = tmp;
			}
		}
		return matrix;
	}
	
	/* ���ԶԽ���Ϊ�ᷭת������x��Ϊ�������·�ת�õ����
	 * 3ms
	 * */
	public int[][] rotate2(int[][] matrix){
		int l = matrix.length;
		for (int i = 0; i < l-1; ++i) {
			for (int j = 0; j < l-i; ++j) {
				swap(matrix,i,j,l-1-j,l-1-i);
			}
		}
		for (int i = 0; i < l/2; ++i) {
			for (int j = 0; j < l; ++j) {
				swap(matrix,i,j,l-1-i,j);
			}
		}
		return matrix;
	}

	private void swap(int[][] matrix, int i, int j, int k, int l) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[k][l];
		matrix[k][l] = temp;
	}
	
	/* ת�þ���ÿ�����ַ�ת�õ����
	 * 2ms
	 * */
	public int[][] rotate3(int[][] matrix){
		int l = matrix.length;
		for(int i=0; i<l; ++i) {
			for(int j=i+1; j<l; ++j) {
				swap(matrix,i,j,j,i);
			}
		}
		reverse(matrix);
		return matrix;
	}

	public void reverse(int[][] matrix) {
		for(int j=0; j<matrix.length/2; ++j) {
			for(int x=0; x<matrix.length; ++x) {
				swap(matrix,x,j,x,matrix.length-1-j);
			}
		}
	}
}
