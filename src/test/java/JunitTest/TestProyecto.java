package JunitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class TestProyecto {
    
    public TestProyecto() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void antes() {
        System.out.println("setUpClass");
    }
    
    @AfterAll
    public static void despues() {
         System.out.println("setUpClass");
    }
    
    @BeforeEach
    public void iniciar() {
         System.out.println("setUpClass");
    }
    
    @AfterEach
    public void terminar() {
         System.out.println("setUpClass");
    }

    @Test
    public void Proyecto(){
        System.out.println("::Test uno :Test Correcto");
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}