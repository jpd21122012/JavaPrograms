package buscaminas_final;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;

public class Buscaminas_final extends JFrame implements ActionListener {
// Se crean las instancias de las clases referentes a los niveles de juego

    Principiante nivelPrincipiante = new Principiante(1);
    Intermedio nivelIntermedio = new Intermedio(1);
    Experto nivelExperto = new Experto(1);
    //se crea una menu y los items a seleccionar
    private JMenuBar barra;
    private JMenu juego, ranking, ayuda;
    private JMenuItem ranking_Facil, ranking_global, ranking_Intermedio, ranking_Experto, principiante, intermedio, experto, legendario, instrucciones;
    //Se crean variables booleanas para no tener problemas al pasar de un nivel a otro
    private boolean nivel1Activo = true, nivel2Activo = false, nivel3Activo = false;
    // Se crea un vector que contiene la ruta de las imagenes usadas
    private String[] imagenesPartida = {"/buscaminas_final/gano.jpg", "/buscaminas_final/perdio.png", "/buscaminas_final/nueva.jpg"};
    // Se crea un vector en donde imagenes partida se volveran iconos a usar y los botones y labels de seleccionar usuario
    private ImageIcon[] iconosPartida = new ImageIcon[3];
    private javax.swing.JButton btnEntrar;
    private javax.swing.JComboBox<String> cmbSelecciona;
    private javax.swing.JLabel lblSelecciona;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JTextField txtRegistro;
    private javax.swing.JButton btnRegistro;
    private int idJugador;
    Consultas_BD consultas = new Consultas_BD();
    //Constructor por defecto

    public Buscaminas_final() {
        for (int i = 0; i < 3; i++) {
            //Se convierten las imagenes en iconos para poderlos utilizar
            iconosPartida[i] = new ImageIcon(getClass().getResource(imagenesPartida[i]));
        }
        // Sirve para poner los labels vacios
        this.setLayout(null);
        // Se coloca el titulo de la ventana de juego principal
        this.setTitle("Buscaminas - Jorge Perales Diaz");
        //propiedades por default del frame
        this.setLocationRelativeTo(null);
        // metodo para que cuando se cierre la ventana de juego, finalice el proceso en memoria
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Se coloca un icono al programa
        setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());
        //Metodo para hacer visible la ventana
        inicializarEntrada();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        // Sentencia condicional para evaluar que nivel seleccionamos
        if (evento.getSource() == experto) {
            // Se pone el icono de juego nuevo
            nivelExperto.botonPartida.setIcon(iconosPartida[2]);
            nivelExperto.quitarBotonesExperto();
            // La ventana se hace invisible
            nivelExperto.setVisible(false);
            // Se resetea la puntuacion
            nivelExperto.puntuacion.setText("");
            // Se llama al metodo donde carga una nueva partida
            nivelExperto.nuevaPartidaExperto();
            // Finalmente se hace visible la ventana
            nivelExperto.setVisible(true);
            if (nivel1Activo) {
// Si se selecciona nivel Experto y nivel Principiante esta en uso            
                this.remove(nivelPrincipiante);
                this.add(nivelExperto);
                // Se cambian los valores booleanos para que el programa sepa en que nivel se esta jugando
                nivel1Activo = false;
                nivel3Activo = true;
                nivel2Activo = false;
            } else if (nivel2Activo) {
                this.remove(nivelIntermedio);
                this.add(nivelExperto);
                nivel2Activo = false;
                nivel3Activo = true;
                nivel1Activo = false;
            }
            setSize(614, 702);
            setLocationRelativeTo(null);
            // ahora se evalua respecto al nivel intermedio los demas niveles
        } else if (evento.getSource() == intermedio) {
            nivelIntermedio.botonPartida.setIcon(iconosPartida[2]);
            nivelIntermedio.quitarBotonesIntermedio();
            nivelIntermedio.setVisible(false);
            nivelIntermedio.puntuacion.setText("");
            nivelIntermedio.nuevaPartidaIntermedio();
            nivelIntermedio.setVisible(true);
            if (nivel1Activo) {
                this.remove(nivelPrincipiante);
                this.add(nivelIntermedio);
                nivel1Activo = false;
                nivel2Activo = true;
                nivel3Activo = false;
            } else if (nivel3Activo) {
                this.remove(nivelExperto);
                this.add(nivelIntermedio);
                nivel2Activo = true;
                nivel1Activo = false;
                nivel3Activo = false;
            }
            setSize(414, 502);
            setLocationRelativeTo(null);
        } else if (evento.getSource() == principiante) {
            // se evalua a el nivel principiante respecto a los demas niveles
            nivelPrincipiante.botonPartida.setIcon(iconosPartida[2]);
            nivelPrincipiante.quitarBotonesPrincipiante();
            nivelPrincipiante.setVisible(false);
            nivelPrincipiante.puntuacion.setText("");
            nivelPrincipiante.nuevaPartidaPrincipiante();
            nivelPrincipiante.setVisible(true);
            if (nivel2Activo) {
                this.remove(nivelIntermedio);
                this.add(nivelPrincipiante);
                nivel2Activo = false;
                nivel1Activo = true;
                nivel3Activo = false;
            } else if (nivel3Activo) {
                this.remove(nivelExperto);
                this.add(nivelPrincipiante);
                nivel1Activo = true;
                nivel3Activo = false;
                nivel2Activo = false;
            }
            setSize(214, 302);
            setLocationRelativeTo(null);
        }//Sentencia condicional en donde se evalua si seleccionas instrucciones
        else if (evento.getSource() == instrucciones) {
            instrucciones();
        } else if (evento.getSource() == ranking_Facil) {// se evaluan los rankings
            mostrarRanking("Principiante", "Principiante");
        } else if (evento.getSource() == ranking_Intermedio) {
            mostrarRanking("Intermedio", "Intermedio");
        } else if (evento.getSource() == ranking_Experto) {
            mostrarRanking("Experto", "Experto");
        } else if (evento.getSource() == ranking_global) {
            mostrarRanking("%", "Global");
        }
    }
     //ventana de los ranking

    private void mostrarRanking(String dificultad, String titulo) {
        JDialog dialog = new JDialog(this, "Ranking " + titulo);
        String resultados = "<html><body>";
        ArrayList<Puntuacion> puntuaciones = consultas.Ranking(dificultad);
        for (Puntuacion puntuacion : puntuaciones) {
            resultados = resultados.concat(puntuacion.toString());
        }
        resultados = resultados.concat("</body></html>");
        JLabel etiqueta = new JLabel(resultados);
        dialog.getContentPane().add(etiqueta);
        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(this);
    }
// metodo en donde abre las instrucciones del juego

    private void instrucciones() {
        String archivo = new String("src/buscaminas_final/Instrucciones.txt");
        try {
            Runtime.getRuntime().exec("cmd /c start " + archivo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void inicializarEntrada() {
        // Se crean los labels y propiedades de la ventana donde seleccionas ya sea agregar usuario o elegir uno ya hecho
        lblSelecciona = new javax.swing.JLabel();
        cmbSelecciona = new javax.swing.JComboBox<>();
        btnEntrar = new javax.swing.JButton();
        lblRegistro = new javax.swing.JLabel();
        txtRegistro = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JButton();
        lblSelecciona.setText("Selecciona tu usuario:");
        lblSelecciona.setBounds(5, 5, 150, 30);
        lblSelecciona.setForeground(Color.red);
        this.add(lblSelecciona);
        cmbSelecciona.setModel(new javax.swing.DefaultComboBoxModel<>(consultas.ObtenerUsuarios()));
        cmbSelecciona.setBounds(145, 8, 150, 25);
        cmbSelecciona.setForeground(Color.BLUE);
        this.add(cmbSelecciona);
        btnEntrar.setText("Entrar!");
        btnEntrar.setForeground(Color.green);
        btnEntrar.setBounds(145, 45, 150, 30);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrar(evt);
            }
        });
        this.add(btnEntrar);
        lblRegistro.setText("Ingresa tu nombre:");
        lblRegistro.setForeground(Color.red);
        lblRegistro.setBounds(5, 90, 150, 30);
        this.add(lblRegistro);
        txtRegistro.setText("Nombre");
        txtRegistro.setForeground(Color.blue);
        txtRegistro.setBounds(145, 90, 150, 25);
        this.add(txtRegistro);
        btnRegistro.setText("Registrar!");
        btnRegistro.setForeground(Color.ORANGE);
        btnRegistro.setBounds(145, 130, 150, 30);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar(evt);
            }
        });
        this.add(btnRegistro);
        setSize(400, 240);
        setVisible(true);
    }

    private void terminarEntrada() {// cuando se termina de los anteriores procesos se quitan para poner la pantalla principal del juego
        this.remove(lblSelecciona);
        this.remove(cmbSelecciona);
        this.remove(btnEntrar);
        this.remove(lblRegistro);
        this.remove(txtRegistro);
        this.remove(btnRegistro);
        //se crean los objetos de la clase JmenuBar
        barra = new JMenuBar();
        juego = new JMenu("Juego");
        ranking = new JMenu("Ranking");
        ayuda = new JMenu("Ayuda");
        //Se crean los objetos de  los submenus
        principiante = new JMenuItem("Principiante");
        intermedio = new JMenuItem("Intermedio");
        experto = new JMenuItem("Experto");
        ranking_global = new JMenuItem("Ranking Global");
        ranking_Facil = new JMenuItem("Ranking Facil");
        ranking_Intermedio = new JMenuItem("Ranking Intermedio");
        ranking_Experto = new JMenuItem("Ranking Experto");
        legendario = new JMenuItem("Legendario");
        instrucciones = new JMenuItem("Instrucciones");
        //agregamos los items de menu
        juego.add(principiante);
        juego.add(intermedio);
        juego.add(experto);
        ranking.add(ranking_global);
        ranking.add(ranking_Facil);
        ranking.add(ranking_Intermedio);
        ranking.add(ranking_Experto);
        ayuda.add(instrucciones);
        //Se agregan las 3 opciones de menu a la barra
        barra.add(juego);
        barra.add(ranking);
        barra.add(ayuda);

        //La barra se agrega a la ventana principal
        this.setJMenuBar(barra);
        // Se le agregan a los submenus los eventos
        this.principiante.addActionListener(this);
        this.intermedio.addActionListener(this);
        this.experto.addActionListener(this);
        this.legendario.addActionListener(this);
        this.ranking_Facil.addActionListener(this);
        this.ranking_Intermedio.addActionListener(this);
        this.ranking_Experto.addActionListener(this);
        this.ranking_global.addActionListener(this);
        this.instrucciones.addActionListener(this);
        setSize(214, 302);
        this.add(nivelPrincipiante);
    }

    private void btnEntrar(java.awt.event.ActionEvent evt) {
        //se busca en base de datos el usuario seleccionado en el JcomboBox y el id de ese usuario se asigna en esta clase
        setIdJugador(consultas.idUsuario(cmbSelecciona.getSelectedItem().toString()));
        nivelPrincipiante = new Principiante(getIdJugador());
        nivelIntermedio = new Intermedio(getIdJugador());
        nivelExperto = new Experto(getIdJugador());
        terminarEntrada();
    }

    private void btnRegistrar(java.awt.event.ActionEvent evt) {
        //se agrega en base de datos el usuario ingresado en el JTextField
        consultas.AgregarUsuario(txtRegistro.getText());
        //se busca en base de datos el usuario introducido en el JTextField y el id de ese usuario se asigna en esta clase
        setIdJugador(consultas.idUsuario(txtRegistro.getText()));
        nivelPrincipiante = new Principiante(getIdJugador());
        nivelIntermedio = new Intermedio(getIdJugador());
        nivelExperto = new Experto(getIdJugador());
        terminarEntrada();
    }
// Setter y getter de el Id del jugador
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public static void main(String[] args) {
        // Se crea una instancia de la clase para que se ejecute una vez el juego
        Buscaminas_final juego = new Buscaminas_final();
    }
}
