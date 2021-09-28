import mytopology.Topology;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Test_topology{

    

    @Test
    static void test_read(){
        Topology topology = new Topology();
        topology.excute("top1.json", "read", "");
        assertEquals(1,topology.getHashMap().size());
        
    }

    @Test
    static void test_delete(){
        Topology topology = new Topology();
        topology.excute("top1.json", "read", "");
        topology.excute("top2.json", "read", "");
        topology.excute("top1", "delete", "");
        assertEquals(1,topology.getHashMap().size());
        
    }
    public static void main(String[] args){
        test_read();
        test_delete();
    }
}