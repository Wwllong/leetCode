package primary.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wwl
 * ��Ч������
 * �ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
 *  ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 *  ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 *  ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
 *  
 *  �������ֿո��������������֣��հ׸��� '.' ��ʾ��
 */
public class IsValidSudoku {
	/* ˼·һ����������HashSet���ϣ���¼3�����
	 * 504eg:25ms
	 * */
	public boolean isValidSudoku(char[][] board) {
		Set<Character> hSet = new HashSet<>();
		Set<Character> rSet = new HashSet<>();
		Set<Character> blockSet = new HashSet<>();
		
		int len = board.length; //9
		
		for(int x=0; x<len; ++x) {
			hSet.clear();
			rSet.clear();
			for(int y=0; y<len; ++y) {
//				System.out.print(board[x][y]+",");
//				System.out.print(board[y][x]+",");
//				if(x%3==0 &&  y%3==0)
//					System.out.println(x+" "+y);
				if(board[x][y]!='.' && !hSet.add(board[x][y])) return false;//��-�ж�
				if(board[y][x]!='.' && !rSet.add(board[y][x])) return false;//��-�ж�
				if(x%3==0 &&  y%3==0)
					if(!checkBlock(blockSet,board,x,y)) return false;//��-�ж�
			}
//			System.out.println();
		}
		
		return true;
	}

	private boolean checkBlock(Set<Character> blockSet, char[][] board, int x, int y) {
		blockSet.clear();
		for(int i=x; i<x+3; ++i) {
			for(int j=y; j<y+3; ++j) {
				if(board[i][j]!='.' && !blockSet.add(board[i][j]))
					return false;
			}
		}
		return true;
	}

}
