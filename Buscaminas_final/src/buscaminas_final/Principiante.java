package buscaminas_final;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Principiante extends JPanel implements ActionListener {

    // Se inicializan las variables que se usaran en el juego, asi como variables de contador y sus respectivas imagenes
    private int casillasFaltantes = 0, bomba = 10;
    int BotonesInferiores[][] = new int[bomba][bomba];
    public JLabel puntuacion;
    private JButton BotonesSuperiores[][] = new JButton[bomba][bomba];
    public JButton botonPartida;
    private String[] archivosBotonPartidaNueva = {"/buscaminas_final/gano.jpg", "/buscaminas_final/perdio.png", "/buscaminas_final/nueva.jpg"};
    private String archivosNumero[] = {"/buscaminas_final/0.PNG", "/buscaminas_final/1.PNG", "/buscaminas_final/2.PNG", "/buscaminas_final/3.PNG", "/buscaminas_final/4.PNG", "/buscaminas_final/5.PNG", "/buscaminas_final/6.PNG", "/buscaminas_final/7.PNG", "/buscaminas_final/8.PNG", "/buscaminas_final/9.PNG"};
    private ImageIcon[] imagenesNumero = new ImageIcon[10];
    public ImageIcon[] imagenesPartidaNueva = new ImageIcon[3];
    private boolean casillas[][] = new boolean[bomba][bomba];
    private JLabel contador;
    int minutos = 0, segundos = 0;//unidades de medida
    public boolean contadorInactivo = false;
    public boolean contadorIniciado = false;
    private int idUsuario;
    Consultas_BD consultas = new Consultas_BD();

// Se declara un objeto de la clase thread parael contador
    Thread hilo = new Thread() {
        //
        @Override
        public void run() {
            try {
                while (true) {//ciclo infinito
                    if (segundos == 59) {//si los segundos son iguales a 59
                        segundos = 0;//segundo vuelve a empezar en cero
                        minutos++;//y aumenta un minuto
                    }
                    if (minutos == 59) {//si los minutos son iguales a 59
                        minutos = 0;//minuto vuelve a empezar en cero
                    }
                    contador.setText(minutos + ":" + segundos);//se muestra en el jlabel
//                    System.out.println(minutos + ":" + segundos);
                    hilo.sleep(999);//que duerma una decima de segundo
                    segundos += 1;
                }
            } catch (java.lang.InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    };
// constructor de la clase principiante

    public Principiante(int idUsuario) {
        this.idUsuario = idUsuario;
        this.setLayout(null);
        for (int i = 0; i < 3; i++) {
            imagenesPartidaNueva[i] = new ImageIcon(getClass().getResource(archivosBotonPartidaNueva[i]));
        }

        inicializaContador();
        nuevaPartidaPrincipiante();
        this.setSize(200, 240);
        // Se creaun botonn con sus respectivos atributos
        botonPartida = new JButton();
        botonPartida.setBounds(86, 5, 30, 30);
        botonPartida.setIcon(imagenesPartidaNueva[2]);
        // Este boton se adhiere a la ventana principal
        this.add(botonPartida);
        this.botonPartida.addActionListener(this);
        // Se crea el label de la puntuacion con sus atributos y se agrega a la ventana principal
        puntuacion = new JLabel();
        puntuacion.setBounds(15, 15, 40, 15);
        this.add(puntuacion);
        // Se agrega el contador a la ventana principal
        this.add(contador);
    }

    /*
    Metodo el cual vuelve las casillas que falten a 0
    pone nuevos botones
    no se muestran los botones
    se colocan las minas
    Dependiendo de el numero de la bomba, a su contorno se le pone el numero
    Se llama al metodo para escuchar a lo que le des click
    Se vuelve a 0 el contador y empieza a contar
     */
    public void nuevaPartidaPrincipiante() {
        casillasFaltantes = 0;
        ponerBotonesPrincipiante();
        MostrarTodo(false);
        colocarMinasPrincipiante();
        contornoBombaPrincipiante();
        mostrarCasillasPrincipiante();
        eventoPrincipiante();
        contador.setText("0:0");//se reinicia la etiqueta del contador
        segundos = minutos = 0;//se reinician las variables del contador
        System.out.println("contadorInactivo->" + contadorIniciado);
        if (!contadorIniciado) {//Esto solo se ejecuta la primera vez
            hilo.start();//el hilo empieza
            contadorIniciado = true;
        } else if (contadorInactivo) {//cuando está pausado 
            hilo.resume();//el hilo se reanuda
            contadorInactivo = false;//el hilo ya no esta pausado
        }
    }

    /*
    Metodo el cual crea el label llamado contador, se asignan sus propiedades y se reinicia el contador
    Asi mismo se le asigna un color de fuente
     */
    private void inicializaContador() {
        contador = new javax.swing.JLabel();
        contador.setSize(50, 50);
        contador.setBounds(150, 5, 30, 30);
        contador.setText("0:0");
        contador.setForeground(Color.red);
    }

    /*
    Se convierten las imagenes en iconos
    Se recorre toda la matriz del juego y se van poniendo los botones a los cuales daremos click para que se eliminen
    y se haga visible ya sea la bomba o el numero de bombas alrededor
    Finalmente se adhieren a la ventana principal
     */
    public void ponerBotonesPrincipiante() {
        for (int i = 0; i < 10; i++) {
            imagenesNumero[i] = new ImageIcon(getClass().getResource(archivosNumero[i]));
        }
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                BotonesSuperiores[f][c] = new JButton();
                BotonesSuperiores[f][c].setBounds(20 * f, 20 * c + 40, 20, 20);
                BotonesSuperiores[f][c].setBackground(Color.gray);
                this.add(BotonesSuperiores[f][c]);
            }
        }
    }

    /*
Se recorre la matriz y se crea un numero aleatorio, para obtener la posicion en la matriz, y posteriormente se agregan   
     */
    public void colocarMinasPrincipiante() {
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                BotonesInferiores[f][c] = 0;
            }
        }
        int f1, c1;
        for (int i = 0; i < bomba; i++) {
            do {
                f1 = (int) (Math.random() * bomba);
                c1 = (int) (Math.random() * bomba);
            } while (BotonesInferiores[f1][c1] != 0);
            BotonesInferiores[f1][c1] = 9;
        }
    }

    /*
    Se recorre la matriz y checa si hay bomba, se evalua desde esa bomba alrededor
    y el contador para poner el numero de bombas alrededor aumenta solo si no hay una bomba alrededor 
     */
    public void contornoBombaPrincipiante() {
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                if (BotonesInferiores[f][c] == 9) {
                    for (int f2 = f - 1; f2 <= f + 1; f2++) {
                        for (int c2 = c - 1; c2 <= c + 1; c2++) {
                            if (f2 >= 0 && f2 < bomba && c2 >= 0 && c2 < bomba && BotonesInferiores[f2][c2] != 9) {
                                BotonesInferiores[f2][c2]++;
                            }
                        }
                    }
                }
            }
        }
    }

    /*
Metodo el cual hace visibles las casillas dependiendo del parametro que reciba    
     */
    public void MostrarTodo(boolean valor) {
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                casillas[f][c] = valor;
            }
        }
    }

    /*
Metodo el cual se acciona si se gana o pierde,
    Si seleccionas una bomba pierdes, si las evitas ganas
    En ese momento se suspende el contador,suena un sonido y manda un mensaje ya sea de que perdiste o ganaste
     */
    public void mensajePrincipiante(int f, int c) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (f >= 0 && f < bomba && c >= 0 && c < bomba && casillas[f][c] == false) {
            if (casillas[f][c] == false) {
                casillas[f][c] = true;
                if (BotonesInferiores[f][c] == 9) {
                    hilo.suspend();//se pausa el hilo
                    contadorInactivo = true;//el hilo esta pausado
                    MostrarTodo(true);
                    sonidoPerdedor();
                    botonPartida.setIcon(imagenesPartidaNueva[1]);
                    consultas.AgregarPuntuacion(idUsuario, "Principiante", casillasFaltantes);
                } else if (casillas[f][c] == true) {
                    casillasFaltantes++;
                    if (casillasFaltantes == 90) {
                        MostrarTodo(true);
                        hilo.suspend();//se pausa el hilo
                        contadorInactivo = true;//el hilo esta pausado
                        sonidoGanador();
                        JOptionPane.showMessageDialog(null, "              GANASTE");
                        botonPartida.setIcon(imagenesPartidaNueva[0]);
                        puntuacion.setText("");
                        consultas.AgregarPuntuacion(idUsuario, "Principiante", casillasFaltantes);
                    }
                    puntuacion.setText(casillasFaltantes + "/90");
                }
            }
            if (BotonesInferiores[f][c] == 0) {
                mensajePrincipiante(f, c - 1);
                mensajePrincipiante(f, c + 1);
                mensajePrincipiante(f - 1, c);
                mensajePrincipiante(f + 1, c);
            }
        }
    }

    /*
 Metodo donde se cargan los sonidos
     */
    private void sonidoPerdedor() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Clip sonido = AudioSystem.getClip();
        sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/buscaminas_final/perdedor.wav")));
        sonido.start();
    }

    private void sonidoGanador() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Clip sonido = AudioSystem.getClip();
        sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/buscaminas_final/ganador.wav")));
        sonido.start();
    }

    //Metodo donde el boton que pulsaste actua dependiendo de si es bomba o no
    public void pulsarBotonPrincipiante(int f, int c) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        mensajePrincipiante(f, c);
        mostrarCasillasPrincipiante();
    }

    /*
Metod en donde se evalua el boton que se pulso    
     */
    public void eventoPrincipiante() {
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                BotonesSuperiores[f][c].addActionListener(
                        new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        for (int f1 = 0; f1 < bomba; f1++) {
                            for (int c1 = 0; c1 < bomba; c1++) {
                                if (e.getSource() == BotonesSuperiores[f1][c1]) {
                                    try {
                                        pulsarBotonPrincipiante(f1, c1);
                                    } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                                        Logger.getLogger(Principiante.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }
// Metodo en donde dependiendo el numero coloca la imagen correspondiente

    public void mostrarCasillasPrincipiante() {
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                if (casillas[f][c] == false) {
                    BotonesSuperiores[f][c].setText("");
                } else if (casillas[f][c] == true) {
                    if (BotonesInferiores[f][c] == 0) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[0]);
                    } else if (BotonesInferiores[f][c] == 1) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[1]);
                    } else if (BotonesInferiores[f][c] == 2) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[2]);
                    } else if (BotonesInferiores[f][c] == 3) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[3]);
                    } else if (BotonesInferiores[f][c] == 4) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[4]);
                    } else if (BotonesInferiores[f][c] == 5) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[5]);
                    } else if (BotonesInferiores[f][c] == 6) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[6]);
                    } else if (BotonesInferiores[f][c] == 7) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[7]);
                    } else if (BotonesInferiores[f][c] == 8) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[8]);
                    } else if (BotonesInferiores[f][c] == 9) {
                        BotonesSuperiores[f][c].setIcon(imagenesNumero[9]);
                    }
                }
            }
        }
    }

    public void quitarBotonesPrincipiante() {
        for (int f1 = 0; f1 < bomba; f1++) {
            for (int c1 = 0; c1 < bomba; c1++) {
                this.remove(BotonesSuperiores[f1][c1]);
            }
        }
    }
// boton para reiniciar la partida

    @Override
    public void actionPerformed(ActionEvent eP) {
        if (eP.getSource() == botonPartida) {
            botonPartida.setIcon(imagenesPartidaNueva[2]);
            quitarBotonesPrincipiante();
            this.setVisible(false);
            puntuacion.setText("");
            nuevaPartidaPrincipiante();
            this.setVisible(true);
        }
    }
}
