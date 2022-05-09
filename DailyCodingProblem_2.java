//A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
//Given the root to a binary tree, count the number of unival subtrees.
 






class univaltree  {
    public int val;
    public univaltree right;
    public univaltree left; 
    public univaltree (int val, univaltree right, univaltree left){
        this.val = val;
        this.right = right;
        this.left = left;
    }
    public static int count_unival_subtrees(univaltree tree){
        int count=0;
        if (tree.right==null && tree.left==null)
            return 1;
        if (tree.right.val==tree.left.val)
            count+=1;
        if (tree.left!=null)
            count+=count_unival_subtrees(tree.right);
        if (tree.right!=null)
            count+=count_unival_subtrees(tree.left);      
        return count; 
    }
    
/**
 * from the below tree example, the following tree has 5 unival subtrees:
 *  0
  / \
 1   0
    / \
   1   0
  / \
 1   1
 */ 
 public static void main(String [] args){
        univaltree tree = 
        new univaltree (0,
        new univaltree (1, null, null), new univaltree (0, 
        new univaltree (1, new univaltree (1, null, null), 
        new univaltree (1, null, null)), new univaltree (0, null, null)));
        System.out.println(count_unival_subtrees(tree));
    }
 }
