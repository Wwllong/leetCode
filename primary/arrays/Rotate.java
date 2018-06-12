package primary.arrays;

import java.util.Arrays;

/**
 * @author Wwl
 * ��ת����
 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
 * ����: [1,2,3,4,5,6,7] �� k = 3
 * ���: [5,6,7,1,2,3,4]
 * ����:
 * 			  [1,2,3,4,5,6,7]
 * ������ת 1 ��: [7,1,2,3,4,5,6]
 * ������ת 2 ��: [6,7,1,2,3,4,5]
 * ������ת 3 ��: [5,6,7,1,2,3,4]
 *  �������������Ľ�����������������ֲ�ͬ�ķ������Խ��������⡣
 *  Ҫ��ʹ�ÿռ临�Ӷ�Ϊ O(1) ��ԭ���㷨��
 *  
 */
public class Rotate {

	//˼·4����˼·2�Ļ����ϣ���ʹ�ø������� ��
	/* ���� (index+k)%arr.length����λ���ƶ����������֮�󣬺�һ������������һ����λ��
	 * ���磺[1,2,3,4,5,6,7] k=1
	 * 1
	 * 1 2 3 4 5 6 7
	 * 
	 *   2		     
	 * 1 1 3 4 5 6 7  
	 * 
	 *     3
	 * 1 1 2 4 5 6 7
	 * 
	 * ....
	 * 
	 *             7
	 * 1 1 2 3 4 5 6  
	 * 
	 * 1
	 * 7 1 2 3 4 5 6  
	 * 
	 * ��Ҫע����ǣ����е����󣬶Դ�����ֵ���µĿ��ƣ�
	 * 	�����鳤��Ϊ����������£�������ֱ�ӽ��д�����ֵ�ĸ���û���κ����⣬��Ϊȷ����ÿ�ε����󣬶�����ȷ��δ������λ��
	 *  ���������鳤��Ϊż������£�������ظ��滻��������磺
	 *  {1,2,3,4,5,6}, 2  --��3,2,1,4,1,6   (true��5,6,1,2,3,4)
	 *  1
	 *  1 2 3 4 5 6
	 *  
	 *      3
	 *  1 2 1 4 5 6
	 *  
	 *          5
	 *  1 2 1 4 3 6 //�˴�Ӧ���������� ��Ϊ��һ���滻index=0 ����������curΪtemp �������и���Ϊ��һ��index++
	 *  
	 *  1
	 *  5 2 1 4 3 6 //����Ŀ�ʼ
	 *  
	 *      1 
	 *  5 2 1 4 3 6 //�ڴ˴����������⣺�����˵�������
	 *  
	 *          3
	 *  5 2 1 4 1 6
	 *  
	 *  5
	 *  3 2 1 4 1 6
	 *  
	 *  �ܽ᣺���鳤��Ϊ��������£��÷�������������⣬
	 *  ż������£����ֵ��ظ��滻��ԭ����k %= nums.length���µ�
	 *  �������ǣ��ж�index==start��0������£�����start++��index++
	 *  ��Ҫ���µ�λ������λnums[index]
	 * 
	 * */
	public static int[] rotate4(int[] nums, int k) {
	    if (nums.length == 0 || (k %= nums.length) == 0) {
	        return nums;
	    }
	    int index = 0;
	    int length = nums.length;
	    int temp = 0;
	    int cur = nums[0];
	    
	    for(int count=0,start=0; count<length; ++count) {
	    	index = (index+k) % length;//waring
	    	temp = nums[index];
	    	nums[index] = cur;
	    	if(index==start) {
	    		++start;
	    		++index;
	    		cur = nums[index];
	    	}else {
	    		cur = temp;
	    	}
	    	
	    }
	    return nums;
	    /* whileʵ��
	    int length = nums.length;
	    int start = 0;
	    int i = 0; //index
	    int cur = nums[i];//���ƶ�����������ֵ
	    int count = 0; //������

	    //�������ÿ��Ԫ�ؽ���һ���滻
	    while (count++ < length) { 
	        i = (i + k) % length;
	        int t = nums[i]; //�洢��һ����������ֵ
	        nums[i] = cur; //����
	        //update cur
	        if (i == start) { 
	            ++start;
	            ++i;
	            cur = nums[i];
	        } else {
	            cur = t; 
	        }
	       
	    }*/
	}
	
	//˼·3�����÷�ת�ķ�������תǰn-k��Ԫ�أ��ڷ�ת��n-k��Ԫ�أ����ת��������  --��Ч�����
	/*	
	 * [1,2,3,4,5,6,7] k = 3 					k=1
	 * ��תǰn-k��Ԫ�أ�7-3-1=3 [4,3,2,1,5,6,7]     6 5 4 3 2 1 7
	 * ��ת��k��Ԫ�أ� [4,3,2,1,7,6,5]				7 1 2 3 4 5 6 
	 * ��ת�������飺[5,6,7,1,2,3,4]
	 * [5,6,7,1,2,3,4]
	 * */
	public static int[] rotate3(int[] arr,int k) {
		if(k<0) return arr;
		int len = arr.length;
		k = k%len;
		reverse(arr,0,len-1-k);
		reverse(arr,len-k,len-1);
		reverse(arr,0,len-1);
		return arr;
	}
	
	private static void reverse(int[] arr,int start,int end) {
		int temp = 0;
		while(start < end) {
			temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}

	}
	
	//˼·2����˼·1�Ļ����ϣ��ƽ�ѭ��Ƕ��--��Ȼͨ�����ԣ����Ǹ÷���ʹ���˸������飬������ԭ��
	/*	���� (index+k)%arr.length��ֱ�Ӷ�λ���ƶ����
	 * [1,2,3,4,5,6,7] k = 3 
	 * index = 0  (index+3)%arr.length=3  1�ƶ���arr[3]
	 * index = 6  (index+3)%arr.length=2  7�ƶ���arr[2]
	 * [5,6,7,1,2,3,4]
	 * */
	public static int[] rotate2(int[] arr, int k) {
		if(k<0||arr==null) return arr;
		
		int length = arr.length,index = 0;
		k = k%length;
		int[] copy_arr = arr.clone();
		
		for(int x=0; x<length; ++x) {
			index = (x+k)%length;
			arr[index] = copy_arr[x];
		}
		return arr;
//		System.out.println(Arrays.toString(arr));
	}

	//˼·1������K����ѭ����ÿ��ѭ������ÿλ�ƶ�һ��
	/* ���������������ƶ�һλ�Ĳ���˼·��
	 *  temp ��¼�´ν����ƶ�����  
	 *  ���� ��index=1��ʼ����������Ӧ���滻λtemp��λ��
	 *  arr[0] ��Ϊ��ת����������temp
	 *  
	 *  ���㷨 ������ʱ������� ������Ϊ����/k�ܴ��ʱ��ѭ��̫������
	 * */
	public static int[] rotate1(int[] arr, int k) {
		if(k<0||arr==null) return arr;
		int i = 0;
		
		int temp = arr[0]; //��ʼ�ƶ�ֵ
		while(i<k) {
			for(int x=1; x<arr.length; ++x) {
				arr[0] = arr[x];
				arr[x] = temp;
				temp = arr[0]; //��������ƶ���ֵ
			}
			++i;
		}
		
		//System.out.println(Arrays.toString(arr));
		return arr;
	}
	

}
