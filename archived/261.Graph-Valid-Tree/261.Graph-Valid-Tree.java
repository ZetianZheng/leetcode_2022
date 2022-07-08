/**
 * 
 * You have a graph of n nodes labeled from 0 to n - 1. 
 * You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * 
 * 很明显是graph的遍历问题，
 * 知识点考察： graph和tree的diff：
 * 1. if this graph is Acyclic
 * 2. full connnected
 * all yes -> tree
 * 
 * 所以需要使用bfs 或者dfs遍历，并且确定是无环，全链接的图。
 * 
 * 码： 
 * 1. 怎么确定全连接？ 最后判断seen的size是否和n相等
 * 2. 递归容易忽略的一点： 因为是无向图（双向）所以需要判断下一个节点是不是父亲节点，是的话则跳过。
 */
class Solution {
    // how to know if all nodes are connected?
    // -> seen set size
    public boolean validTree(int n, int[][] edges) {
        // create graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        
        // dfs 
        // 1. if this graph is Acyclic
        // 2. full connnected
        // all yes -> tree
        Set<Integer> seen = new HashSet<>();
        return dfs(adjList, seen, 0, -1) && seen.size() == n;
    }
    
    private boolean dfs(List<List<Integer>> adjList, Set<Integer> seen, int nodeInd, int parent) {
        if (seen.contains(nodeInd)) {
            return false;
        }
        seen.add(nodeInd);
        
        for (int neighbour : adjList.get(nodeInd)) {
            if (neighbour == parent) {
                continue;
            }
            boolean res = dfs(adjList, seen, neighbour, nodeInd);
            if (!res) return false;
        }
        
        return  true;
    }
}