
//Given the root to a binary search tree, find the second largest node in the tree.



 
      /* Let us create following BST
               4
           /     \
           2       6
         /  \    /  \
        1    3   5    7 */










class BSTNode {
	int data;
	 BSTNode left, right;
	BSTNode(int n)
	{
		data = n;
	}
}
class DailyCodingProblem7BST {
	BSTNode root;
	DailyCodingProblem7BST()
	{
		root = null;
	}
	public void insert(int data)
	{
		this.root = this.insertRec(this.root, data);
	}
	BSTNode insertRec(BSTNode node, int data)
	{
		if (node == null) {
			this.root = new BSTNode(data);
			return this.root;
		}
		if (data < node.data) {
			node.left = this.insertRec(node.left, data);
		} else {
			node.right = this.insertRec(node.right, data);
		}
		return node;
	}
	public class count {
		int c = 0;
	}
	void secondLargestUtil(BSTNode node, count C)
	{
		if (node == null || C.c >= 2)
			return;
		this.secondLargestUtil(node.right, C);
		C.c++;
		if (C.c == 2) {
			System.out.print("second largest node in the tree is "+
											node.data);
			return;
		}
		this.secondLargestUtil(node.left, C);
	}
	void secondLargest(BSTNode node)
	{
		count C = new count();
		this.secondLargestUtil(this.root, C);
	}
	public static void main(String[] args)
	{
		DailyCodingProblem7BST tree = new DailyCodingProblem7BST();
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(5);
		tree.insert(7);
		tree.secondLargest(tree.root);
	}
}



