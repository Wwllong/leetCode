package primary.list;

/**
 * @author Wwl
 * ����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ���s(������ n ��֤����Ч�ġ�)
 */
public class RemoveNthFromEnd {
	
	public ListNode removeNthFromEnd1(ListNode head,int n) {
		
		ListNode s = head;
		
		int length = 1;
		while(s.next!=null)  {
			length++;
			s = s.next;
		}
		
		if(n==length) {
			s=head.next;
		}else {
			s = head;
			//�ҵ�Ҫɾ���Ľڵ�
			ListNode delNode = head;
			int x = 1;
			while(x<length-n) {
				delNode = delNode.next;
				++x;
			}
			//ɾ��
			if(delNode.next!=null) {
				delNode.next = delNode.next.next;
			}else {//ɾ���Ľڵ�Ϊĩβ�ڵ�
				delNode = null;
			}
		}
		
		return s;
	}
}
