import mytopology.Topology;
import java.util.Scanner;
public class Main {
   public static void main(String[] args){

    Topology topology = new Topology();
    String func = "";
    String name_id= "";
    String netlistNodeID = "";
    Scanner myObj = new Scanner(System.in);
    while(true){
        
        try{
            System.out.println("\nEnter the required command >>\n");
            String[] input = myObj.nextLine().split(" ");  // Read user input
            if(input.length == 1){
                func = input[0];
            }
            else if(input.length == 2)
            {
                func = input[0];
                name_id = input[1];
            }
            else if(input.length == 3)
            {
                func = input[0];
                name_id = input[1];
                netlistNodeID = input[2];
            }
            else{
                System.out.println("\nError: Invalid syntax\n");
            }
            
            topology.excute(name_id, func,netlistNodeID);
            func = "";
            name_id = "";
            netlistNodeID = "";

        }
        catch(Exception e){
            System.out.println("\nError: Not valid syntex\n");
        }



    }
    


   }
    
}
