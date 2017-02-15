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

public class Experto extends JPanel implements ActionListener {

    private int casillasFaltantes = 0, bomba = 30;
    int BotonesInferiores[][] = new int[bomba][bomba];
    public JLabel puntuacion;
    private JButton BotonesSuperiores[][] = new JButton[bomba][bomba];
    public JButton botonPartida;
    private String[] archivosBotonPartidaNueva = {"/buscaminas_final/gano.jpg", "/buscaminas_final/perdio.png", "/buscaminas_final/nueva.jpg"};
    private String archivosNumero[] = {"/buscaminas_final/0.PNG", "/buscaminas_final/1.PNG", "/buscaminas_final/2.PNG", "/buscaminas_final/3.PNG", "/buscaminas_final/4.PNG", "/buscaminas_final/5.PNG", "/buscaminas_final/6.PNG", "/buscaminas_final/7.PNG", "/buscaminas_final/8.PNG", "/buscaminas_final/9.PNG"};
    private ImageIcon[] imagenesNumero = new ImageIcon[10];
    public ImageIcon[] imagenesPartidaNueva = new ImageIcon[3];
    private boolean casillas[][] = new boolean[bomba][bomba];
    private javax.swing.JLabel contador;//agregué esto!!!!!!!!
    int minutos = 0, segundos = 0;//unidades de medida
    public boolean contadorInactivo = false;
    public boolean contadorIniciado = false;
    private int idUsuario;
    Consultas_BD consultas = new Consultas_BD();
    
    Thread hilo = new Thread() {//declaramos un hilo, este hilo maneja el cronometro

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

    public Experto(int idUsuario) {
        this.idUsuario = idUsuario;
        this.setLayout(null);
        for (int i = 0; i < 3; i++) {
            imagenesPartidaNueva[i] = new ImageIcon(getClass().getResource(archivosBotonPartidaNueva[i]));
        }
        inicializaContador();
        nuevaPartidaExperto();
        this.setSize(600, 640);
        botonPartida = new JButton();
        botonPartida.setBounds(286, 5, 30, 30);
        botonPartida.setIcon(imagenesPartidaNueva[2]);
        this.add(botonPartida);
        this.botonPartida.addActionListener(this);
        puntuacion = new JLabel();
        puntuacion.setBounds(15, 15, 60, 15);
        this.add(puntuacion);
        this.add(contador);
    }

    public void nuevaPartidaExperto() {
        casillasFaltantes = 0;
        ponerBotonesExperto();
        MostrarTodo(false);
        colocarMinasExperto();
        contornoBombaExperto();
        mostrarCasillasExperto();
        eventoExperto();
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

    private void inicializaContador() {
        contador = new javax.swing.JLabel();
        contador.setSize(50, 50);
        contador.setBounds(440, 5, 30, 30);
        contador.setText("0:0");
        contador.setForeground(Color.red);
    }

    public void ponerBotonesExperto() {
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

    public void colocarMinasExperto() {
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                BotonesInferiores[f][c] = 0;
            }
        }
        int f1, c1;
        for (int i = 0; i < 3 * bomba; i++) {
            do {
                f1 = (int) (Math.random() * bomba);
                c1 = (int) (Math.random() * bomba);
            } while (BotonesInferiores[f1][c1] != 0);
            BotonesInferiores[f1][c1] = 9;
        }
    }

    public void contornoBombaExperto() {
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

    public void MostrarTodo(boolean valor) {
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                casillas[f][c] = valor;
            }
        }
    }

    public void mensajeExperto(int f, int c) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (f >= 0 && f < bomba && c >= 0 && c < bomba && casillas[f][c] == false) {
            if (casillas[f][c] == false) {
                casillas[f][c] = true;
                if (BotonesInferiores[f][c] == 9) {
                    hilo.suspend();//se pausa el hilo
                    contadorInactivo = true;//el hilo esta pausadosonidoExplosion();
                    MostrarTodo(true);
                    sonidoPerdedor();
                    botonPartida.setIcon(imagenesPartidaNueva[1]);
                    consultas.AgregarPuntuacion(idUsuario, "Experto", casillasFaltantes);
                } else if (casillas[f][c] == true) {
                    casillasFaltantes++;
                    if (casillasFaltantes == 810) {
                        MostrarTodo(true);
                        hilo.suspend();//se pausa el hilo
                        contadorInactivo = true;//el hilo esta pausado
                        sonidoGanador();
                        JOptionPane.showMessageDialog(null, "              GANASTE");
                        botonPartida.setIcon(imagenesPartidaNueva[0]);
                        puntuacion.setText("");
                        consultas.AgregarPuntuacion(idUsuario, "Experto", casillasFaltantes);
                    }
                    puntuacion.setText(casillasFaltantes + "/810");
                }
            }
            if (BotonesInferiores[f][c] == 0) {
                mensajeExperto(f, c - 1);
                mensajeExperto(f, c + 1);
                mensajeExperto(f - 1, c);
                mensajeExperto(f + 1, c);
            }
        }
    }

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

    public void pulsarBotonExperto(int f, int c) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        mensajeExperto(f, c);
        mostrarCasillasExperto();
    }

    public void eventoExperto() {
        for (int f = 0; f < bomba; f++) {
            for (int c = 0; c < bomba; c++) {
                BotonesSuperiores[f][c].addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                for (int f = 0; f < bomba; f++) {
                                    for (int c = 0; c < bomba; c++) {
                                        if (e.getSource() == BotonesSuperiores[f][c]) {
                                            try {
                                                pulsarBotonExperto(f, c);
                                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                                Logger.getLogger(Experto.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                );
            }
        }
    }

    public void mostrarCasillasExperto() {
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

    public void quitarBotonesExperto() {
        for (int f1 = 0; f1 < bomba; f1++) {
            for (int c1 = 0; c1 < bomba; c1++) {
                this.remove(BotonesSuperiores[f1][c1]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonPartida) {
            botonPartida.setIcon(imagenesPartidaNueva[2]);
            quitarBotonesExperto();
            this.setVisible(false);
            puntuacion.setText("");
            nuevaPartidaExperto();
            this.setVisible(true);
        }
    }
}
