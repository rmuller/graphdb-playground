package eu.infomas.research.orientdb;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;

import static java.nio.file.Files.delete;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.walkFileTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class can be used as base class for OrientDB based tests.
 * 
 * @author <a href="mailto:rmuller@xiam.nl">Ronald K. Muller</a>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public final class MainTest {

    protected final static Logger LOG = Logger.getLogger("test");

    // Database is removed after a (maven) build!
    private final static String DB_DIR = "./target/db/test";

    private static OrientGraphFactory factory;

    protected OrientGraph oGraph;

    /**
     * Remove database, start this test cycle with a new, empty database.
     *
     * Default credentials: admin / admin
     *
     * Note: Java 7+ API!
     */
    @BeforeClass
    public static void setupClass() throws IOException {
        Path root = Paths.get(DB_DIR);
        if (exists(root)) {
            walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {

                    delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                    throws IOException {

                    delete(dir);
                    return FileVisitResult.CONTINUE;
                }

            });
        }
        factory = new OrientGraphFactory("plocal:" + DB_DIR);
    }

    @BeforeClass
    public static void teardownClass() {
        if (factory != null) {
            factory.close();
        }
    }

    @Before
    public void setup() throws IOException {
        oGraph = factory.getTx();
    }

    @After
    public void teardown() {
        if (oGraph != null) {
            oGraph.shutdown();
        }
    }

    @Test
    public void testA() {
        oGraph.addVertex("1", "name", "First Vertex");
        oGraph.commit();
    }

    // Because of @FixMethodOrder this method will ALWAYS be executed after testA !
    @Test
    public void testB() {
        Iterator<Vertex> iter = oGraph.getVertices("name", "First Vertex").iterator();
        assertTrue(iter.hasNext());
        assertEquals("First Vertex", iter.next().getProperty("name"));
        assertFalse(iter.hasNext());
    }

}
