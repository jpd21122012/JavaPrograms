package buscaminas_final;

import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;

public class SeleccionarUsuario extends JPanel{
    /*
    Se crean los elementos de la interfaz grafica que pedira seleccionar un jugador o crear uno nuevo
    */
   private JComboBox<String> SeleccionarUsuario = new JComboBox<>();
   private JTextField AgregarUsuario = new JTextField();
   private JButton BotonSeleccionarUsuario = new JButton();
   private JButton BotonAgregarUsuario = new JButton();
private JPanel panel = new JPanel();
   
    public SeleccionarUsuario() {
        // Se adhiere al nuevo panel y se declaran sus propiedades incluyendo los metodos de consultas a base de datos
        SeleccionarUsuario.setBounds(10, 10, 50, 50);
        Consultas_BD m = new Consultas_BD();
        this.add(panel);
        SeleccionarUsuario.setModel(new DefaultComboBoxModel<>(m.ObtenerUsuarios()));
        panel.add(SeleccionarUsuario);
    }
}
