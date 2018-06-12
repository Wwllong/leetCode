package primary.arrays;

/**
 * @author Wwl
 * ������������ɾ���ظ���
 * 
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * eg:
 * nums = [0,0,1,1,1,2,2,3,3,4]
 * ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
public class DeleteRepet {

	public static int removeDuplicates(int[] nums) {
		int len=0;
		for(int x=1; x<nums.length; ++x) {
			if(nums[len]!=nums[x]) {
				++len;
				nums[len]=nums[x];
			}
		}
        return len+1;
    }
}
