package primary.list;

/**
 * @author Wwl
 * ������ݹ�ط�ת����
 */
public class ReverseList {
	
	//��ͨʵ��-������ǰ�������ηŵ���ͷ
	public ListNode reverseList1(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode p = null;
		while(head!=null) {
			ListNode temp = head.next;
			head.next = p;
			p = head;
			head = temp;
		}
		
        return p;
    }
	
	//�ݹ�ʵ��
	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode p = reverseList2(head.next);
		head.next.next = head;
		head.next = null;//����1��2���ջ�
		
        return p;
    }
	
	public String printList(ListNode head) {
		String str = head.val+"";
		ListNode node = head.next;
		while(node!=null) {
			str += (node.val+"");
			node = node.next;
		}
		return str;
	}
}
