class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class RecoverBinarySearchTree {
    static List<TreeNode> inorder = new ArrayList<>();
    
    public static TreeNode buildTree(String[] values) {
        if (values == null || values.length == 0 || values[0].equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            
            if (i < values.length && !values[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;


            // Right child
            if (i < values.length && !values[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        
        return root;
    }
    
    // Get inorder traversal
    public static void getInorder(TreeNode root) {
        if (root == null) return;
        
        getInorder(root.left);
        inorder.add(root);
        getInorder(root.right);
    }
    
    // Print level order traversal
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] inpArr = inp.split(" ");
        
        // Build tree from input
        TreeNode root = buildTree(inpArr);
        
        // Get inorder traversal
        getInorder(root);
        
        // Find the two nodes that need to be swapped
        TreeNode first = null, second = null;
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                // First violation
                if (first == null) {
                    first = inorder.get(i);
                    second = inorder.get(i + 1);
                }
                // Second violation (if exists)
                else {
                    second = inorder.get(i + 1);
                }
            }
        }
        
        // Swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        // Print the corrected tree in level order
        printLevelOrder(root);
    }
}
