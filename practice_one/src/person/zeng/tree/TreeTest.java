package person.zeng.tree;
/**
 * 二叉树测试
 * @author Administrator
 *
 */
@SuppressWarnings("unused")
public class TreeTest {
	public static void main(String[] args) {
		TreeNode treeRoot = new TreeNode(0);
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode8 = new TreeNode(8);
		TreeNode treeNode9 = new TreeNode(9);
		
		treeRoot.setLeftTreeNdoe(treeNode1);
		treeRoot.setRightTreeNdoe(treeNode2);
		treeNode1.setLeftTreeNdoe(treeNode3);
		treeNode1.setRightTreeNdoe(treeNode4);
		treeNode2.setLeftTreeNdoe(treeNode5);
		treeNode2.setRightTreeNdoe(treeNode6);
		treeNode3.setLeftTreeNdoe(treeNode7);
		treeNode4.setLeftTreeNdoe(treeNode8);
		treeNode5.setLeftTreeNdoe(treeNode9);
		
		preBTree(treeRoot);
		//midBtree(treeRoot);
		//beBTree(treeRoot);
		//print(treeRoot);
		//System.out.println(getHeigh(treeRoot));
	}
	/**
	 * 先序遍历,根-左-右
	 * @param treeRoot
	 */
	public static void preBTree(TreeNode treeRoot) {
		if(treeRoot!=null) {
			System.out.println(treeRoot.getValue());
			preBTree(treeRoot.getLeftTreeNdoe());
			preBTree(treeRoot.getRightTreeNdoe());
		}
	}
	/**
	 * 中序遍历,左-根-右
	 * @param treeRoot
	 */
	public static void midBtree(TreeNode treeRoot) {
		if(treeRoot!=null) {
			midBtree(treeRoot.getLeftTreeNdoe());
			System.out.println(treeRoot.getValue());
			midBtree(treeRoot.getRightTreeNdoe());
		}
	}
	/**
	 * 后序遍历,左-右-根
	 * @param treeRoot
	 */
	public static void beBTree(TreeNode treeRoot) {
		if(treeRoot!=null) {
			beBTree(treeRoot.getLeftTreeNdoe());
			beBTree(treeRoot.getLeftTreeNdoe());
			System.out.println(treeRoot.getValue());
		}
	}
	/**
	 * 按层遍历
	 */
	public static void print(TreeNode treeRoot) {
		if(treeRoot!=null) {
			System.out.println(treeRoot.getValue());
			print(treeRoot.getRightTreeNdoe());
		}
	}
	/**
	 * 获取树的深度
	 * @param treeRoot
	 * @return
	 */
	public static int getHeigh(TreeNode treeRoot) {
		if(treeRoot==null) {
			return 0;
		}
		int left = getHeigh(treeRoot.getLeftTreeNdoe());
		int right = getHeigh(treeRoot.getRightTreeNdoe());
		int max = left;
		if(left<right) {
			max = right;
		}
		return max+1;
	}
}
