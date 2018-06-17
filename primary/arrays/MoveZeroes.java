package primary.arrays;

/**
 * @author Wwl
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 *
 * ʾ��:
 * ����: [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 * ˵��:
 *  ������ԭ�����ϲ��������ܿ�����������顣
 *  �������ٲ���������
 */
public class MoveZeroes {
	/*
	 * ˼·��:
	 * ��ϸ���������Ԫ��:0���0.���ַ�0Ԫ�ص�ԭʼ˳��
	 * ʹ������ָ��,һ��ָ��ֵ��0����,һ��ָ���������ʼ
	 * ��������,�ҵ���һ����0��ֵ,��������ʼָ����н���
	 * ֱ������������
	 * 21eg:3ms
	 * */
	public int[] moveZeroes2(int[] nums) {
		for(int nonZero=0,index=0; nonZero<nums.length; ++nonZero) {
			if(nums[nonZero]!=0) {
				swap(nums,index,nonZero);
				index++;
			}
		}
		return nums;
	}
	
	/* ˼·1��
	 * 0 1 0 3 12
	 * 1 0 3 12 0
	 * 1 3 12 0 0
	 * ð������Ľ�
	 * ѭ������Ԫ�أ���Ԫ��Ϊ0���Ӹ�Ԫ�ؽ���ð��
	 * ð�ݽ��������½���0��ʼ���������0Ԫ�ء�
	 * �����������Ӧ��Ϊlength-1-zerose
	 * 21eg:36ms
	 * */
	public int[] moveZeroes1(int[] nums) {
		int zeroes = 0;
		for(int x=0; x<nums.length-1-zeroes; ++x) {
			if(nums[x] != 0 ) {
				continue;
			}else {
				for(int y=x; y<nums.length-zeroes-1; ++y) {
					swap(nums,y,y+1);
				}
				++zeroes;
				if(nums[x]==0) --x; //��ֹһ��ð��֮��,ǰ����ֵ0
			}
		}
		return nums;
	}
	
	public void swap(int[] nums,int a,int b) {
		int temp = nums[a];
		nums[a] = nums[b]; 
		nums[b] = temp;
	}
}
