
package assignment10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//********************************************************//
// Name: Parth Patel                                      //
// Class: CIS 2168                                        //
// Assignment #10                                         //
//                                                        //
// Summary: Purpose was to create a Kevin Bacon game      //
// where we had to implement a Breadth First Search       //
// algorithm to find the shortest path.                   //
//********************************************************//

public class KevinBaconNumber {
    
    SymbolGraph sg;
    
    KevinBaconNumber(String filename, String delimiter) throws FileNotFoundException, IOException {
        sg = new SymbolGraph(filename, delimiter);
    }
    public void list(String source){
        Bag<String> bg = sg.list(source);
        Graph G = sg.G();
        
        // Checks to see if the name in the database starts with the 'source'
        // then adds it to the bag
        for(int i = 0; i < G.V(); i++){
            if(sg.name(i).startsWith(source))
                bg.add(sg.name(i));
        }
        
        // Prints the name(s) from the bag
        if(bg != null){
            for(String s:bg){
                System.out.println(s);
            }
        }
    }
    public void neighbors(String source){
        Bag<String> bg = sg.neighbors(source);
        Graph G = sg.G();

        // Creates a bag of integers and gets the adjacent verticies
        int k = sg.st.get(source);
        Bag<Integer> bi = (Bag<Integer>) G.adj(k);
        
        // Adds the name to the bag
        for(int i : bi){
            bg.add(sg.name(i));
        }
        
        // Prints the names from the bag
        if(bg != null){
            for(String s:bg){
                System.out.println(s);
            }
        }
    }
    public void path(String source, String sink){  
        Graph G = sg.G();
        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }
        
        int s = sg.index(source);

        // Do a Breadth First Search
        BreadthFirstSearch bfs = new BreadthFirstSearch(G, s);
        
        System.out.println("");
        if(sg.contains(sink)){
            int t = sg.index(sink);
            if(bfs.hasPathTo(t)){
                System.out.println(sg.name(s) + " --> " + sg.name(t) + " || Bacon number = " + (bfs.dt(t)/2));
                for(int x : bfs.pathTo(t)){
                    if(x == s)
                        System.out.println(sg.name(x));                 // Kevin Bacon
                    else{
                        if(bfs.dt(x) % 2 != 0)
                            System.out.println("   " + sg.name(x));     // Indents movie names
                        else
                            System.out.println(sg.name(x));
                    }
                }  
            }
            else
                System.out.println("Not connected");
        }
        else
            System.out.println("Not in database");
    }
    /**
     * To allocate more memory to JVM, use -Xmx2g flag
     * java -Xmx2g assignment10/KevinBaconNumber
     * 
     */
    public static void main(String[] args) {
        
      String filename = "action06.txt"; // "cast.all.txt";
      String delimiter = "/";
      KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String from = "Bacon, Kevin";
            String to;
            while(true){
                int select = 0;
                while(!(select >= 1 && select <=5)){
                    System.out.println("========================================");
                    System.out.println("1.Degree of separation from Kevin Bacon:");
                    System.out.println("2.Degree of separation between any two actors/actrsses:");
                    System.out.println("3.Search actor/actress/movie:");
                    System.out.println("4.List cast of a movie or movies of an actor/actress:");
                    System.out.println("5. Exit");
                    select = InputHelper.getIntegerInput("Select:");
                }
                switch(select){
                    case 1:
                        to = InputHelper.getStringInput("Enter the name (lastname, firstname): ");
                        kv.path("Bacon, Kevin", to);
                        break;
                    case 2:
                        from = InputHelper.getStringInput("Enter the name (lastname, firstname): ");
                        to = InputHelper.getStringInput("Enter the name (lastname, firstname): ");
                        kv.path(from, to);  
                        break;
                    case 3:
                        to = InputHelper.getStringInput("Enter the name:");
                        kv.list(to);
                        break;
                    case 4:
                        to = InputHelper.getStringInput("Enter the name:");
                        kv.neighbors(to);  
                        break;
                    case 5:
                        return;
                }
                System.out.println("");
            }     
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
      
    }
}
