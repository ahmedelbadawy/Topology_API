package mytopology;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Topology {
    // static String name_id;
    // static String func;
    static HashMap<String,JSONObject> topologies = new HashMap<String, JSONObject>();

    // public Topology(String name,String f) {
    //     name_id = name;
    //     func = f;
    // }

    static void readTop(String fileName) {
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

    static void getTopologies() {

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

    static void getDevices(String id){
        try{
            printJson(id);
        }
        catch(Exception e){
            System.out.println("\nThe selected topology does not exist\n");
        }

    }

    static void deleteTop(String id){
        try{
            topologies.remove(id);
            System.out.println("\nThe topology has been deleted successfully\n");
        }
        catch(Exception e){
            System.out.println("\nThe selected topology does not exist\n");
        }

    }
    static void writeTop(String id){
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

    static  void getDevicesWithNetlistNode(String id, String netlistNodeID){

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

    public HashMap getHashMap(){
        return topologies;
    }
    
    public void excute(String name_id, String func, String netlistNodeID){
        switch (func) {
            case "read":
            readTop(name_id);
              break;
            case "write":
              writeTop(name_id);
              break;
            case "delete":
              deleteTop(name_id);
              break;
            case "getTopologies":
              getTopologies();
              break;
            case "getDevices":
              getDevices(name_id);
              break;
            case "getDevicesWithNetlistNode":
              getDevicesWithNetlistNode(name_id ,netlistNodeID);
        }
             
    }
}


