/** Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5
You should return 45, as it is (3 + 2) * (4 + 5).**/














class Node
{
    String val;
    Node left, right;
 
    Node(String val)
    {
        this.val = val;
        this.left = this.right = null;
    }
}
class dailycodingproblem10
{
    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    public static double process(String op, double a, double b)
    {
        if (op.equals("+")) { return a + b; }
        if (op.equals("-")) { return a - b; }
        if (op.equals("*")) { return a * b; }
        if (op.equals("/")) { return a / b; }
 
        return 0;
    }
    public static double evaluate(Node root)
    {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return Double.valueOf(root.val);
        }
        double a = evaluate(root.left);
        double b = evaluate(root.right);
        return process(root.val, a, b);
    }
    public static void main(String[] args)
    {
        Node root = new Node("*");
        root.left = new Node("+");
        root.right = new Node("+");
        root.left.left = new Node("3");
        root.left.right = new Node("2");
        root.right.left = new Node("4");
        root.right.right = new Node("5");
        System.out.println("The value is " + evaluate(root));
    }
}
