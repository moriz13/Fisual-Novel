/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author hiilmifaturahman
 */
public class Tubes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
     int v = 8;
 
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
 
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 0, dest = 7;
        printShortestDistance(adj, source, dest, v);
    }
 
    
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
 
   
    private static void printShortestDistance(
                     ArrayList<ArrayList<Integer>> adj,
                             int s, int dest, int v)
    {
        
        int pred[] = new int[v];
        int dist[] = new int[v];
 
        if (BFS(adj, s, dest, v, pred, dist) == false) {
            System.out.println("Given source and destination" + "are not connected");
            return;
        }

        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
        
        System.out.println("Seorang mahasiswa ingin mencari roti");
        System.out.println("-------");
        System.out.println("Sedangkan roti hanya ada di kantin 7");
        System.out.println("-------");
        System.out.println("mahasiswa tersebut harus mengecek setiap makanan di kantin");
        System.out.println("-------");
        System.out.println("karena mahasiswa tersebut hanya mempunyai waktu yang sedikit,maka mahasiswa tersebut harus mencari kantin terdekat dahulu");
        System.out.println("-------");
        System.out.println("kanti apa dulu yang harus dilewati mahasiswa tersebut jika ingin cepat sampai ke kantin 7 ?");
        System.out.println("-------");
        System.out.println("Mahasiswa harus melewati " + dist[dest] + " kantin terlebih dahulu");
        System.out.println("-------");
        // Print path
        System.out.println("yaitu kantin :");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
 

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
                                  int dest, int v, int pred[], int dist[])
    {
       
        LinkedList<Integer> queue = new LinkedList<Integer>();
 

        boolean visited[] = new boolean[v];
 
 
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
 
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);
 

        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (visited[adj.get(u).get(i)] == false) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));
 

                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
    
    

