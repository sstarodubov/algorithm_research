public class Solution {
    public int longestConsecutive(int[] nums) {
            int[] m = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {

            }
    }
}

class QuickUnion   {

        private final int[] groupId;

        public QuickUnion(int[] id) {
                this.groupId = id;
        }

        public QuickUnion(int n) {
                groupId = new int[n];
                for (int i = 0; i < n; i++) {
                        groupId[i] = i;
                }
        }

        private int root(int node) {
                while (node != groupId[node]) {
                        groupId[node] = groupId[groupId[node]]; // compression
                        node = groupId[node];
                }
                return node;
        }

        public boolean connected(int p, int q) {
                return root(p) == root(q);
        }

        public void union(int p, int q) {
                int pid = root(p);
                int qid = root(q);
                groupId[qid] = pid;
        }


}