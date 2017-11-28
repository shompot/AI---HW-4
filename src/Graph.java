//We largely borrowed the following topological sorting program from <http://www.geeksforgeeks.org/topological-sorting/>.
//Written by Aakash Hasija
// We have made <such and such> modifications.
// --<Cholpon and Nashiha>
// A Java program to print topological sorting of a DAG
import java.util.*;

// This class represents a directed graph using adjacency
// list representation
class Graph
{
    private int vertices;   // No. of vertices
    private ArrayList<Node> nodes;
    private LinkedList adj[]; // Adjacency List

    //Constructor
    Graph(int vertices)
    {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        nodes = new ArrayList<Node>();
        for (int i=0; i<vertices; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public void addNodes (ArrayList <Node> list){
        this.nodes = list;
    }
    // Function to add an edge into the graph
    public void addEdge( Node node, Node w)
    {
        adj[node.getIndex()].add(w);
    }

    // A recursive function used by topologicalSort
    public void topologicalSortUtil(int v, boolean visited[],
                                    Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Node> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = (it.next()).getIndex();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    public void topologicalSort()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++)
            visited[i] = false;

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < vertices; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        System.out.print( "HIGHEST PRECEDENCE\n");
        while (stack.empty() == false)
        {
                System.out.print("\t"+this.nodes.get((int)stack.pop()) + "\n");
        }
        System.out.print( "LOWEST PRECEDENCE");
    }

    // Driver method
    public static void main(String args[])
    {
        // Graph 1
        Graph g1 = new Graph(13);
        ArrayList <Node> nodes1 = new ArrayList<Node>();
        Node n1 = new Node(0, "Throwable");
        Node n2 = new Node(1, "Exception");
        Node n3 = new Node(2, "Error");
        Node n4 = new Node(3, "RuntimeException");
        Node n5 = new Node(4, "IOException");
        Node n6 = new Node(5, "AWTError");
        Node n7 = new Node(6, "ThreadDeath");
        Node n8 = new Node(7, "OutOfMemoryError");
        Node n9 = new Node(8, "ClassCastException");
        Node n10 = new Node(9, "ArrayIndexOutOfBoundsException");
        Node n11 = new Node(10, "NullPointerException");
        Node n12 = new Node(11, "InputMismatchException");
        Node n13 = new Node(12, "ArithmeticException");
        nodes1.add(n1);
        nodes1.add(n2);
        nodes1.add(n3);
        nodes1.add(n4);
        nodes1.add(n5);
        nodes1.add(n6);
        nodes1.add(n7);
        nodes1.add(n8);
        nodes1.add(n9);
        nodes1.add(n10);
        nodes1.add(n11);
        nodes1.add(n12);
        nodes1.add(n13);
        g1.addNodes(nodes1);
        g1.addEdge(n1, n2);
        g1.addEdge(n1, n3);
        g1.addEdge(n2, n4);
        g1.addEdge(n2, n5);
        g1.addEdge(n3, n6);
        g1.addEdge(n3, n7);
        g1.addEdge(n3, n8);
        g1.addEdge(n4, n9);
        g1.addEdge(n4, n10);
        g1.addEdge(n4, n11);
        g1.addEdge(n4, n12);
        g1.addEdge(n4, n13);

        System.out.println("------------------TEST 1----------------------");
        g1.topologicalSort();
        System.out.println();
        System.out.println();

        // Graph 2
        Graph g2 = new Graph(7);
        ArrayList <Node> nodes2 = new ArrayList<Node>();
        Node a1 = new Node(0, "iOS");
        Node a2 = new Node(1, "istream");
        Node a3 = new Node(2, "ostream");
        Node a4 = new Node(3, "ifstream");
        Node a5 = new Node(4, "iostream");
        Node a6 = new Node(5, "ofstream");
        Node a7 = new Node(6, "fstream");
        nodes2.add(a1);
        nodes2.add(a2);
        nodes2.add(a3);
        nodes2.add(a4);
        nodes2.add(a5);
        nodes2.add(a6);
        nodes2.add(a7);
        g2.addNodes(nodes2);
        g2.addEdge(a1,a2);
        g2.addEdge(a1, a3);
        g2.addEdge(a2, a4);
        g2.addEdge(a2, a5);
        g2.addEdge(a3, a5);
        g2.addEdge(a3, a6);
        g2.addEdge(a5, a7);

        System.out.println("------------------TEST 2----------------------");
        g2.topologicalSort();
        System.out.println();
        System.out.println();

        // Graph 3
        Graph g3 = new Graph(8);
        ArrayList <Node> nodes3 = new ArrayList<Node>();
        Node x1 = new Node(0, "Employee");
        Node x2 = new Node(1, "Temporary Employee");
        Node x3 = new Node(2, "Permanent Employee");
        Node x4 = new Node(3, "Consultant");
        Node x5 = new Node(4, "Manager");
        Node x6 = new Node(5, "Consultant Manager");
        Node x7 = new Node(6, "Director");
        Node x8 = new Node(7, "Permanent Manager");
        nodes3.add(x1);
        nodes3.add(x2);
        nodes3.add(x3);
        nodes3.add(x4);
        nodes3.add(x5);
        nodes3.add(x6);
        nodes3.add(x7);
        nodes3.add(x8);
        g3.addNodes(nodes3);
        g3.addEdge(x1, x2);
        g3.addEdge(x1, x5);
        g3.addEdge(x1, x3);
        g3.addEdge(x2, x4);
        g3.addEdge(x3, x7);
        g3.addEdge(x4, x6);
        g3.addEdge(x5, x6);
        g3.addEdge(x5, x7);
        g3.addEdge(x5, x8);

        System.out.println("------------------TEST 3----------------------");
        g3.topologicalSort();
        System.out.println();
        System.out.println();
    }
}
// This code is contributed by Aakash Hasija