package person.zeng.tree;
/**
 * ¶þ²æÊ÷½Úµã
 * @author Administrator
 *
 */
public class TreeNode {
	private TreeNode leftTreeNdoe;
	private TreeNode rightTreeNdoe;
	private Object value;
	
	public TreeNode(Object value) {
		this.value = value;
	}
	public TreeNode getLeftTreeNdoe() {
		return leftTreeNdoe;
	}
	public void setLeftTreeNdoe(TreeNode leftTreeNdoe) {
		this.leftTreeNdoe = leftTreeNdoe;
	}
	public TreeNode getRightTreeNdoe() {
		return rightTreeNdoe;
	}
	public void setRightTreeNdoe(TreeNode rightTreeNdoe) {
		this.rightTreeNdoe = rightTreeNdoe;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
