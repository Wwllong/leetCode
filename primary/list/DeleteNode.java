package primary.list;

/**
 * @author Wwl
 * ɾ�������еĽڵ�
 * 
 * �������ٰ��������ڵ㡣
 * ���������нڵ��ֵ����Ψһ�ġ�
 * �����Ľڵ�Ϊ��ĩβ�ڵ㲢��һ���������е�һ����Ч�ڵ㡣��Ҫ����ĺ����з����κν����
 * 
 */
public class DeleteNode {
	public void deleteNode(ListNode node) {
		if(node==null) {
			return;
		}
		node.val = node.next.val;
		node.next = node.next.next;
	}
}


