package mytopology;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
* <h1>Topology-API<h1>
* This API provides the functionality to 
*  <ul>
*  <li>Read a topology from a given JSON file and store it in the memory: {@code read [filename]}</li>
*  <li>Write a given topology from the memory to a JSON file: {@code write [topologyID]}</li>
*  <li>Query about which topologies are currently in the memory: {@code getTopologies}</li>
*  <li>Delete a given topology from memory: {@code delete [topologyID]}</li>
*  <li>Query about which devices are in a given topology: {@code getDevices [topologyID]}</li>
*  <li>Query about which devices are connected to a given netlist node in a given topology: {@code getDevicesWithNetlistNode [topologyID] [netlistNodeID]}</li>
*  </ul>  
* @author  Ahmed Elbadawy
* @version 1.0
* @since   2021-9-27
*/

public class Topology {

    static HashMap<String,JSONObject> topologies = new HashMap<String, JSONObject>();

     /**
   * This method is used to ead a topology from a given JSON file and store it in the @param topologies.
   * @param filename This is the path of the json file
   */
  public void readTop(String fileName) {

        JSONParser parser = new JSONParser();
        try { 
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject)obj;
            topologies.put((String)jsonObject.get("id"),jsonObject);
            System.out.println("\nThe topology is readed successfully!\n");
        } 
        catch(Exception e){
            System.out.println("\nThe selected file does not exist.\n");
        }

        
    
    }
    /**
     * This method is used to print a topology data.
     */
    static void printJson(String id){
    

        JSONObject top_json = topologies.get(id);
        System.out.println("\nid: "+ (String)top_json.get("id") +"\n");
        JSONArray components = (JSONArray)top_json.get("components");
        System.out.println("\ncomponents: \n");
        Iterator iterator = components.iterator();
        while (iterator.hasNext()) {
            System.out.println("\n"+iterator.next() + "\n");

        }

    }
   /**
   * This method is used to query about which topologies are currently in the memory.
   */
  public void getTopologies() {

     

        JSONObject top_json;
        JSONArray components;
        try{
            for(String i : topologies.keySet()){

                printJson(i);
            }
        
        }
        catch(Exception e){
            System.out.println("\nThere are not topologies saved\n");
        }

        

    }

    /**
   * This method is used to query about which devices are in a given topology.
   * @param id This is the id of the desired topology
   */

  public void getDevices(String id){
        
        try{
            printJson(id);
        }
        catch(Exception e){
            System.out.println("\nThe selected topology does not exist\n");
        }

    }
    /**
   * This method is used to Delete a given topology from memory.
   * @param id This is the id of the desired topology
   */

  public void deleteTop(String id){
        try{
            topologies.remove(id);
            System.out.println("\nThe topology has been deleted successfully\n");
        }
        catch(Exception e){
            System.out.println("\nThe selected topology does not exist\n");
        }

    }

    /**
   * This method is used to write a given topology from memory.
   * @param id This is the id of the desired topology
   */
  public void writeTop(String id){
        try{
            JSONObject top_json = topologies.get(id);
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("\nEnter the filename\n");
            String fileName = myObj.nextLine();  // Read user input
            FileWriter file = new FileWriter(fileName);
            file.write(top_json.toJSONString()); 
            file.flush();
            System.out.println("\nThe Json file has been saved successfully!\n");
        }
        catch(Exception e){
            System.out.println("\nThe selected topology does not exist\n");
        }
        
    }
    /**
   * This method is used to query about which devices are connected to a given netlist node in a given topology.
   * @param id This is the id of the desired topology
   * @param netlistNodeID This is the id of the desired net list node
   */
  public  void getDevicesWithNetlistNode(String id, String netlistNodeID){

       try{
           
        JSONObject top_json = topologies.get(id);
        JSONArray components = (JSONArray)top_json.get("components");
        Iterator iterator = components.iterator();
        while (iterator.hasNext()) {

            JSONObject Object = (JSONObject)iterator.next();
            if(Object.get("id").equals(netlistNodeID)){
                System.out.println("\nTopology ID: " + id+"\n"+"The netlistNodeID: " + netlistNodeID + "\n"+" The device: " + "\n"+ Object.toJSONString());
    
                break;
            }

         }
    
       }
       catch(Exception e){

        System.out.println("\nThe selected topology does not exist\n");
        }
    
          

    }
    /**
   * This method is used to return the map that contain all topologies.
   * @param topologies This is the HashMap that contain all save topologies
   * @return topologies.
   */
    public HashMap getHashMap(){
        return topologies;
    }
    /**
   * This method is used to determine which operation will be performed.
   * @param func This is the name of the desired operation.
   */
    public void excute(String name_id, String func, String netlistNodeID){
        Topology obj = new Topology();
        switch (func) {
            case "read":
            obj.readTop(name_id);
              break;
            case "write":
            obj.writeTop(name_id);
              break;
            case "delete":
            obj.deleteTop(name_id);
              break;
            case "getTopologies":
            obj.getTopologies();
              break;
            case "getDevices":
            obj.getDevices(name_id);
              break;
            case "getDevicesWithNetlistNode":
            obj.getDevicesWithNetlistNode(name_id ,netlistNodeID);
        }
             
    }
}


