import java.io.*;
import java.util.*;

public class BellmanFord {

    public static void bellmanFord(int V, int E, int edges[][], int start) {
        long dists[] = new long[V];  // Changed to long to prevent overflow
        for(int i = 0; i < V; i++) {
            dists[i] = Long.MAX_VALUE;
        }
        dists[start] = 0;
        
        for(int i = 0; i < V - 1; i++) {
            for(int u = 0; u < V; u++) {
                for(int v = 0; v < V; v++) {
                    if (edges[u][v] == 0) {
                        continue;
                    }
                    
                    int w = edges[u][v];
                    
                    if(dists[u] != Integer.MAX_VALUE && dists[u] + w < dists[v]) {
                        dists[v] = dists[u] + w;
                    }
                }
            }
        }
        
        for(int u = 0; u < V; u++) {
            for(int v = 0; v < V; v++) {
                if (edges[u][v] == 0) {
                    continue;
                }

                int w = edges[u][v];

                if(dists[u] != Long.MAX_VALUE && dists[u] + w < dists[v]) {
                    // Found a negative cycle
                    System.out.println(-1);
                    return;
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
            if (dists[i] == Long.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else if (dists[i] > Integer.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(dists[i] + " ");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        int edges[][] = new int[V][V];
        
        for(int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges[u][v] = w;
        }
        
        bellmanFord(V, E, edges, 0);
        
    }
}
