package finalExam;

import java.util.*;
class LargestTree
{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        adj[v].add(u);
        adj[u].add(v);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited) {

        int count = 1;
        visited.add(u, true);
        for (int i = 0; i < adj[u].size(); i++)
            if ( !visited.get(adj[u].get(i)))
                count += DFS(adj[u].get(i), adj, visited);
        return count;

    }

    public int largestTree(LinkedList<Integer> adj[], int V)
        {
            int largestTreeSize = 0;
            Vector<Boolean> visited = new Vector<>();
            for(int i = 0; i < V; i++)
                visited.add(false);

            for (int u = 0; u < V; u++)
                if (visited.get(u) == false)
                    largestTreeSize = Math.max( DFS(u, adj, visited),largestTreeSize);

            return largestTreeSize;

        }
    }
