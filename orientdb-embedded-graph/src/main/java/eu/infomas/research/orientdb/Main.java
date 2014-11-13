package eu.infomas.research.orientdb;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;

/**
 * {@code Main}.
 *
 * @author <a href="mailto:rmuller@xiam.nl">Ronald K. Muller</a>
 */
public class Main {

    private static final String DB_DIR = System.getProperty("user.home") + "/orientdb/test";
    
    public static void main(String... args) {
        // start with a non existing database
        final OrientGraphFactory factory = new OrientGraphFactory(
            "plocal:" + DB_DIR, "admin", "admin");
        try {
            final OrientGraphNoTx g = factory.getNoTx();
            // database is now auto created
            
            // example from Tinkerpop 3 ()
            // Changed to be compatible with current OrientDB implementation
            Vertex marko = g.addVertex(null, "name", "marko", "age", 29);
            Vertex vadas = g.addVertex(null, "name", "vadas", "age", 27);
            Vertex lop = g.addVertex(null, "name", "lop", "lang", "java");
            Vertex josh = g.addVertex(null, "name", "josh", "age", 32);
            Vertex ripple = g.addVertex(null, "name", "ripple", "lang", "java");
            Vertex peter = g.addVertex(null, "name", "peter", "age", 35);
            
            marko.addEdge("knows", vadas).setProperty("weight", 0.5f);
            marko.addEdge("knows", josh).setProperty("weight", 1.0f);
            marko.addEdge("created", lop).setProperty("weight", 0.4f);
            josh.addEdge("created", ripple).setProperty("weight", 1.0f);
            josh.addEdge("created", lop).setProperty("weight", 0.4f);
            peter.addEdge("created", lop).setProperty("weight", 0.2f);
        } finally {
            // this also closes the OrientGraph instances created by the factory
            // Note that OrientGraphFactory does not implement Closeable
            factory.close();
        }
    }

}
