package primary.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Wwl
 * ֻ����һ�ε�����
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 * ˵����
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 * ʾ�� 1:
 * ����: [2,2,1]
 * ���: 1
 * ʾ�� 2:
 * ����: [4,1,2,1,2]
 * ���: 4
 * 
 * ִ����ʱ��3<4<2<1
 */
public class SingleNumber {
	//˼·5����������^������
	
	//˼·4���������򣬱����жϣ�ͨ���ÿպ͸���ֵ��ȷ������ֵ -10ms
	public int singleNumber4(int[] nums) {
		if(nums.length==1) return nums[0];
		Arrays.sort(nums);
		Integer cur = null;
		for(int x=0; x<nums.length; ++x) {
			if(cur==null) {
				cur = nums[x];
			}else if(cur.equals(nums[x])) {
				cur = null;
			}
		}
		return cur;
	}
	
	//˼·3����ӽ�׳���жϷ��أ����������޶�������^���������-13ms ȥ��ǰ�������� -1ms
	public int singleNumber3(int[] nums) {
		//if(nums.length==1) return nums[0];
		//Arrays.sort(nums);
		int n = nums[0];
		for(int x=1; x<nums.length; ++x) {
			n = n ^ nums[x];
		}
		return n;
	}
	
	//˼·2��������������������ظ�Ԫ��λ2�����ԣ����б��� -16ms
	public int singleNumber2(int[] nums) {
		Arrays.sort(nums);
		
		for(int x=0; x<nums.length-1; ) {
			if(nums[x]==nums[x+1]) {
				x+=2;
			}else {
				return nums[x];
			}
		}
		return nums[nums.length-1];
	}
	
	//˼·1��ʹ��Map���� -20ms
	public int singleNumber1(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int single = 0;
		for(int num : nums) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				map.put(num, 2);
			}
		}
		for(int num:nums) {
			if(map.get(num)==1) 
				single = num;
		}
		return single;
	}
}
