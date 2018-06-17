package primary.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wwl
 * ����֮��:
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 * ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
 * 
 * ʾ��:
 * ���� nums = [2, 7, 11, 15], target = 9
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 */
public class TwoSum {
	
	/* ˼·��:����HashMap�����жϺʹ洢
	 * 20eg:7ms
	 * �����ȴ���һ�����ص�����,��Ϊ������Ҫ���ؽ��
	 * */
	public int[] twoSum3(int[] nums,int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int x=0; x<nums.length; ++x) {
			if(!map.containsKey(target-nums[x])) {
				map.put(nums[x], x);
			}else {
				return new int[]{map.get(target-nums[x]),x};
			}
		}
		return null;
	}
	
	/* ˼·��:�Ż������Լ��жϵĴ��� 
	 * 20eg:24ms
	 * */
	public int[] twoSum2(int[] nums,int target) {
		for(int x=0; x<nums.length; ++x) {
			int temp = target - nums[x];
			for(int y=x+1; y<nums.length; ++y) {
				if(temp == nums[y]) {
					return new int[] {x,y};
				}
			}
		}
		return null;
	}
	
	/*˼·һ:��ͨ����ÿ��Ԫ��  
	* 20eg:97ms
	**/
	public int[] twoSum1(int[] nums,int target) {
		for(int x=0; x<nums.length; ++x) {
			for(int y=0; y<nums.length; ++y) {
				if(x==y) continue;
				if(nums[x] + nums[y] == target) {
					return new int[] {x,y};
				}
			}
		}
		return null;
	}
}
