package primary.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wwl
 * ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
 * ����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��
 * ����: [1,2,3,1]
 * ���: true
 * 
 * ����: [1,2,3,4]
 * ���: false
 * 
 * Ч�ʣ�method5>method2>method3/method4>method1
 */
public class ContainsDuplicate {
	
	//˼·5����˼·��1�Ļ����ϸĽ�����ǰ�����ж�-������Ч���ٱ���
	//��ǰ�жϹ��̽�����һ����С�ж��������ж���ȵĴ���
	public boolean containsDuplicate5(int[] nums) {
		 if (nums.length < 2) return false; 
		 
		 for (int i = 1; i < nums.length; i++) {
			 for (int j = i - 1; j >= 0; j--) {
				 if(nums[i] > nums[j] )break; //�������Ч�ʴ���ۿ�
	             if(nums[i] == nums[j])return true;
	         }
		 }
	     return false;
	}
	
	//˼·4:����Set���ϵ�Ԫ��Ψһ
	public boolean containsDuplicate4(int[] nums) {
		if(nums.length<2) return false;
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		Set<Integer>  set = new HashSet<Integer>();
		for(int num : nums) {
			if(!set.add(num))
				return true;
		}
		
		return false;
	}
	
	//˼·3������Map���бȽ�
	public boolean containsDuplicate3(int[] nums) {
		if(nums.length<2) return false;
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		Arrays.sort(nums);
		
		for(int num : nums) {
			if(map.get(num)!=null) {
				return true;
			}else {
				map.put(num, "");
			}
		}
		
		return false;
	}
	
	
	//˼·2������������������ڱȽ�
	public boolean containsDuplicate2(int[] nums) {
		if(nums==null) return false;
		Arrays.sort(nums);
		for(int x=0; x<nums.length-1; ++x) {
			if(nums[x]==nums[x+1])return true;
		}
		return false;
	}
	
	//˼·1:����Ƚ�
	public boolean containsDuplicate1(int[] nums) {
		if(nums==null) return false;
		for(int x=0; x<nums.length; ++x) {
			for(int y=x+1; y<nums.length; ++y) 
				if(nums[x]==nums[y])return true;
		}
		return false;
    }
}
