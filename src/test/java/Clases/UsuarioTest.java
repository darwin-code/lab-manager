package Clases;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class UsuarioTest {

    public UsuarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of establecerIdSexo method, of class Usuario.
     */
    @Test
    public void testEstablecerIdSexo() {
        System.out.println("establecerIdSexo");
        int idSexo = 0;
        Usuario instance = new Usuario();
        instance.establecerIdSexo(idSexo);

    }

    /**
     * Test of MostrarSexoCombo method, of class Usuario.
     */
    @Test
    public void testMostrarSexoCombo() {
        System.out.println("MostrarSexoCombo");
        JComboBox genero = new JComboBox();
        Usuario instance = new Usuario();
        instance.MostrarSexoCombo(genero);
    }

    @Test
    public void testAgregarInfo() {
        System.out.println("agregarInfo");
        JDateChooser dia = new JDateChooser();
        JTextField nombre = new JTextField();
        JComboBox genero = new JComboBox();
        JTextField materia = new JTextField();
        JTextField alumnos = new JTextField();
        JTextArea observacion = new JTextArea();
        JComboBox<String> horasCombo = new JComboBox<>(new String[]{"07:00-09:00", "09:00-11:00", "11:00-13:00", "14:00-16:00"});
        Usuario instance = new Usuario();
        instance.agregarInfo(dia, nombre, genero, materia, alumnos, observacion, horasCombo);
    }

    @Test
    public void testMostrarUsuarios() {
        System.out.println("mostrarUsuarios");
        JTable mostrarInfo = new JTable();
        Usuario instance = new Usuario();
        instance.mostrarUsuarios(mostrarInfo);
    }

    @Test
    public void testBuscarUsuarioPorNombre() {
        System.out.println("buscarUsuarioPorNombre");
        String nombre = "Darwin";
        JTable mostrarInfo = new JTable();
        Usuario instance = new Usuario();
        instance.buscarUsuarioPorNombre(nombre, mostrarInfo);
    }
}
