package primary.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wwl �����������飬дһ���������������ǵĽ�����
 *
 *         ����:���� nums1 = [1, 2, 2, 1], nums2 = [2, 2], ���� [2, 2]. ע�⣺
 *         ��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡� ���ǿ��Բ�������������˳��
 * 
 *         ����: ��������������Ѿ��ź����أ��㽫����Ż�����㷨�� ��� nums1 �Ĵ�С�� nums2 С�ܶ࣬���ַ������ţ�
 *         ���nums2��Ԫ�ش洢�ڴ����ϣ��ڴ������޵ģ��㲻��һ�μ������е�Ԫ�ص��ڴ��У������ô�죿
 */
public class Intersect {

	// �Ż�����2 -3ms
	public int[] intersect3(int[] nums1, int[] nums2) {

		int len1 = nums1.length;
		int len2 = nums2.length;
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int[] result = new int[Math.max(len1, len2)];
		int i = 0, j = 0, c = 0;
		while (i < len1 && j < len2) {
			if (nums1[i] == nums2[j]) {
				result[c++] = nums1[i];
				++i;
				++j;
			} else if (nums1[i] > nums2[j]) {
				++j;
			} else {
				++i;
			}
		}

		if (c > 0)
			return Arrays.copyOf(result, c);
		else
			return new int[0];

	}

	/*
	 * ��������������Ȼ�������������ֱ���������������ʼλ�ã� ������������������������ȣ������ִ������У���������������1��
	 * �����һ����������������ִ���ڶ�����������1����֮��Ȼ�� 4ms
	 */
	public int[] intersect2(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int len1 = nums1.length;
		int len2 = nums2.length;
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<>();
		while (i < len1 && j < len2) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				++i;
				++j;
			} else if (nums1[i] > nums2[j]) {
				++j;
			} else if (nums1[i] < nums2[j]) {
				++i;
			}
		}

		int[] result = new int[list.size()];
		int k = 0;
		for (Integer i1 : list) {
			result[k++] = i1;
		}
		return result;

	}

	/*
	 * ��Map������nums1���ַ�������ָ���֮���ӳ��, Ȼ�����nums2���飬
	 * �����ǰ�ַ���Map�еĸ�������0���򽫴��ַ�������res�У�Ȼ��Map�Ķ�Ӧֵ�Լ�1�� 7ms
	 */
	public int[] intersect1(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n1 : nums1) {
			Integer value = map.get(n1);
			map.put(n1, (value == null ? 0 : value) + 1);
		}

		List<Integer> list = new ArrayList<>();
		for (int n2 : nums2) {
			if (map.containsKey(n2) && map.get(n2) > 0) {
				list.add(n2);
				map.put(n2, map.get(n2) - 1);
			}
		}

		int[] result = new int[list.size()];
		int x = 0;
		for (Integer i : list) {
			result[x++] = i;
		}
		return result;
	}

}
