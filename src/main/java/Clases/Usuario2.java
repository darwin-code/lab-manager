package Clases;

import com.toedter.calendar.JDateChooser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Usuario2 {

    int idSexo;

    public void establecerIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public void MostrarSexoCombo(JComboBox genero) {
        Conexion objetoConexion = new Conexion();

        String sql = "select * from sexo";
        Statement st;

        try {
            st = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            genero.removeAllItems();

            while (rs.next()) {
                String nombreSexo = rs.getString("sexo");
                this.establecerIdSexo(rs.getInt("id"));

                genero.addItem(nombreSexo);
                genero.putClientProperty(nombreSexo, idSexo);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar sexo" + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    JComboBox<String> horasCombo = new JComboBox<>(new String[]{"07:00-09:00", "09:00-11:00", "11:00-13:00", "14:00-16:00"});

    public void agregarInfo(JDateChooser dia, JTextField nombre, JComboBox genero, JTextField materia, JTextField alumnos, JTextArea observacion, JComboBox<String> horasCombo) {
        // Obtener la fecha actual
        Date fechaActual = new Date();
        // Obtener la fecha seleccionada en el JDateChooser
        Date fechaSeleccionada = dia.getDate();

        // Verificar si la fecha seleccionada es nula
        if (fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una fecha.");
            return; // Salir del método si la fecha seleccionada es nula
        }

        // Verificar si la fecha seleccionada es anterior a la fecha actual
        if (fechaSeleccionada.before(fechaActual)) {
            JOptionPane.showMessageDialog(null, "Seleccione una fecha válida.");
            return; // Salir del método si la fecha seleccionada es anterior a la fecha actual
        }

        Conexion obConexion = new Conexion();

        // Verificar si la hora seleccionada ya está registrada
        String horaSeleccionada = (String) horasCombo.getSelectedItem();
        if (horaRegistrada(fechaSeleccionada, horaSeleccionada)) {
            JOptionPane.showMessageDialog(null, "La hora ya está registrada para esta fecha.");
            return; // Salir del método si la hora ya está registrada para esta fecha
        }

        // Si la hora y fecha no están registradas, proceder a agregar la información
        String consulta = "INSERT INTO usuarios2(dia, nombre, fksexo, materia, alumnos, observacion, hora) VALUES (?,?,?,?,?,?,?)";

        try {
            CallableStatement cs = obConexion.estableceConexion().prepareCall(consulta);
            java.sql.Date fechaDiaSQL = new java.sql.Date(fechaSeleccionada.getTime());

            cs.setDate(1, fechaDiaSQL);
            cs.setString(2, nombre.getText());
            int idSexo = (int) genero.getClientProperty(genero.getSelectedItem());
            cs.setInt(3, idSexo);
            cs.setString(4, materia.getText());
            cs.setString(5, alumnos.getText());
            cs.setString(6, observacion.getText());
            cs.setString(7, horaSeleccionada);

            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se agregó correctamente la información");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.toString());
        } finally {
            obConexion.cerrarConexion();
        }
    }


    /*
    
     */
// Método para verificar si la hora seleccionada ya está registrada en la base de datos
    private boolean horaRegistrada(Date fecha, String horaSeleccionada) {
        Conexion obConexion = new Conexion();
        String consulta = "SELECT COUNT(*) AS cantidad FROM usuarios2 WHERE dia = ? AND hora = ?";

        try {
            PreparedStatement ps = obConexion.estableceConexion().prepareStatement(consulta);
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            ps.setDate(1, fechaSQL);
            ps.setString(2, horaSeleccionada);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int cantidad = rs.getInt("cantidad");
                return cantidad > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar la hora registrada: " + e.toString());
        } finally {
            obConexion.cerrarConexion();
        }
        return false;
    }

    public void mostrarUsuarios(JTable mostrarInfo) {
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();

        String sql = "";
        modelo.addColumn("ID");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORA");
        modelo.addColumn("ASIGNATURA");
        modelo.addColumn("DOCENTE");
        modelo.addColumn("GENERO");
        modelo.addColumn("CANTIDAD ALUMNOS");
        modelo.addColumn("OBSERVACIONES");

        mostrarInfo.setModel(modelo);

        // Modificar la consulta SQL para ordenar por fecha y hora
        sql = "SELECT usuarios2.id, usuarios2.dia, usuarios2.hora, usuarios2.nombre, sexo.sexo, usuarios2.materia, usuarios2.alumnos, usuarios2.observacion FROM usuarios2 INNER JOIN sexo ON usuarios2.fksexo = sexo.id ORDER BY usuarios2.dia ASC, CASE "
                + "WHEN usuarios2.hora = '07:00-09:00' THEN 1 "
                + "WHEN usuarios2.hora = '09:00-11:00' THEN 2 "
                + "WHEN usuarios2.hora = '11:00-13:00' THEN 3 "
                + "WHEN usuarios2.hora = '14:00-16:00' THEN 4 "
                + "END";

        try {
            Statement st = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fechaSQL = rs.getDate("dia");
                String nuevaFecha = sdf.format(fechaSQL);
                String hora = rs.getString("hora");
                String nombre = rs.getString("nombre");
                String genero = rs.getString("sexo");
                String materia = rs.getString("materia");
                int cantidadAlumnos = rs.getInt("alumnos");
                String observaciones = rs.getString("observacion");

                modelo.addRow(new Object[]{id, nuevaFecha, hora, materia, nombre, genero, cantidadAlumnos, observaciones}); // Añadir dentro del bucle while
            }
            mostrarInfo.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar usuarios: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    public void Eliminar(int id) {
        Conexion objetoConexion = new Conexion();

        try {
            String consulta = "DELETE FROM usuarios2 WHERE usuarios2.id = ?";

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, id);
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se eliminó el registro: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
    public void RellenarCombo(String tabla, String valor, JComboBox combo) {
        String sql = "SELECT * FROM " + tabla;
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.estableceConexion();

        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                combo.addItem(rs.getString(valor));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }

    }

    public void rellenarCamposPorNombre(String nombre, JTextField campoNombre, JComboBox genero, JTextField materia, JTextField alumnos, JTextArea observacion, JComboBox<String> horasCombo) {
        Conexion objetoConexion = new Conexion();

        // Consulta SQL para obtener la información del usuario por su nombre
        String sql = "SELECT usuarios2.dia, usuarios2.nombre, sexo.sexo, usuarios2.materia, usuarios2.alumnos, usuarios2.observacion, usuarios2.hora "
                + "FROM usuarios2 "
                + "INNER JOIN sexo ON usuarios2.fksexo = sexo.id "
                + "WHERE usuarios2.nombre = ?";

        try {
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            // Verificar si se encontró un usuario con el nombre proporcionado
            if (rs.next()) {
                // Rellenar los campos con la información obtenida de la consulta
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fechaSQL = rs.getDate("dia");
                String nuevaFecha = sdf.format(fechaSQL);
                String generoUsuario = rs.getString("sexo");
                String materiaUsuario = rs.getString("materia");
                String alumnosUsuario = rs.getString("alumnos");
                String observacionUsuario = rs.getString("observacion");
                String horaUsuario = rs.getString("hora");

                // Establecer los valores en los campos correspondientes
                campoNombre.setText(nombre);
                genero.setSelectedItem(generoUsuario);
                materia.setText(materiaUsuario);
                alumnos.setText(alumnosUsuario);
                observacion.setText(observacionUsuario);
                horasCombo.setSelectedItem(horaUsuario);
            } else {
                // Mostrar un mensaje si no se encuentra ningún usuario con el nombre proporcionado
                JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuario por nombre: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    public void buscarUsuarioPorNombre(String nombre, JTable mostrarInfo) {
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas del modelo de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORA");
        modelo.addColumn("ASIGNATURA");
        modelo.addColumn("DOCENTE");
        modelo.addColumn("GENERO");
        modelo.addColumn("CANTIDAD ALUMNOS");
        modelo.addColumn("OBSERVACIONES");

        // Asignar el modelo a la tabla
        mostrarInfo.setModel(modelo);

        // Consulta SQL para buscar usuarios por nombre
        String sql = "SELECT usuarios2.id, usuarios2.dia, usuarios2.hora, usuarios2.nombre, sexo.sexo, usuarios2.materia, usuarios2.alumnos, usuarios2.observacion "
                + "FROM usuarios2 "
                + "INNER JOIN sexo ON usuarios2.fksexo = sexo.id "
                + "WHERE usuarios2.nombre LIKE '%" + nombre + "%'";

        try {
            Statement st = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            boolean encontrado = false; // Variable para verificar si se encontraron usuarios
            while (rs.next()) {
                encontrado = true; // Se ha encontrado al menos un usuario
                String id = rs.getString("id");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fechaSQL = rs.getDate("dia");
                String nuevaFecha = sdf.format(fechaSQL);
                String hora = rs.getString("hora");
                String nombreUsuario = rs.getString("nombre");
                String genero = rs.getString("sexo");
                String materia = rs.getString("materia");
                int cantidadAlumnos = rs.getInt("alumnos");
                String observaciones = rs.getString("observacion");

                // Agregar la fila al modelo de la tabla
                modelo.addRow(new Object[]{id, nuevaFecha, hora, materia, nombreUsuario, genero, cantidadAlumnos, observaciones});
            }
            // Establecer el modelo actualizado en la tabla
            mostrarInfo.setModel(modelo);

            // Verificar si no se encontraron usuarios
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontraron usuarios con el nombre proporcionado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios por nombre: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
}
