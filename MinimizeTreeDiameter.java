import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MinimizeTreeDiameter {
    public static void main(String[] args) {
        int n = 3;  // Number of nodes
        int k = 1;  // Number of nodes to delete
        int[][] edges = {{1, 2}, {1, 3}};  // Edges between nodes

        TreeNode root = buildTree(n, edges);
        int minimizedDiameter = minimizeDiameter(root, k);
        System.out.println("Minimized Diameter: " + minimizedDiameter);
    }

    public static TreeNode buildTree(int n, int[][] edges) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new TreeNode(i + 1));
        }

        for (int[] edge : edges) {
            int parentVal = edge[0];
            int childVal = edge[1];

            TreeNode parent = nodes.get(parentVal - 1);
            TreeNode child = nodes.get(childVal - 1);

            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        return nodes.get(0);
    }

    public static int minimizeDiameter(TreeNode root, int k) {
        Map<TreeNode, Integer> maxDepthMap = new HashMap<>();
        int result = calculateDiameter(root, k, maxDepthMap);
        return result;
    }

    public static int calculateDiameter(TreeNode node, int k, Map<TreeNode, Integer> maxDepthMap) {
        if (node == null) {
            return 0;
        }

        if (maxDepthMap.containsKey(node)) {
            return maxDepthMap.get(node);
        }

        int leftDiameter = calculateDiameter(node.left, k, maxDepthMap);
        int rightDiameter = calculateDiameter(node.right, k, maxDepthMap);

        int leftDepth = maxDepth(node.left, maxDepthMap);
        int rightDepth = maxDepth(node.right, maxDepthMap);

        int currentDiameter = leftDepth + rightDepth + 1;

        if (k > 0) {
            int candidateDiameters[] = {leftDiameter, rightDiameter};
            Arrays.sort(candidateDiameters);

            currentDiameter = Math.min(currentDiameter, candidateDiameters[1]);
            k--;
        }

        maxDepthMap.put(node, Math.max(leftDepth, rightDepth) + 1);
        maxDepthMap.put(null, 0);

        return currentDiameter;
    }

    public static int maxDepth(TreeNode node, Map<TreeNode, Integer> maxDepthMap) {
        if (node == null) {
            return 0;
        }

        if (maxDepthMap.containsKey(node)) {
            return maxDepthMap.get(node);
        }

        int depth = 1 + Math.max(maxDepth(node.left, maxDepthMap), maxDepth(node.right, maxDepthMap));
        maxDepthMap.put(node, depth);
        return depth;
    }
}


