/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cumulo_;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Rey
 */
public class arboles extends javax.swing.JPanel {
public static void linea(Graphics g,int x,int y, int x1, int y2){
        g.setColor(Color.BLUE);
        g.drawLine(x, y, x1, y2);
    }
        public static void circulo(Graphics g,int x,int y, int alto, int ancho){
        g.setColor(Color.RED);
        g.drawOval(x, y, alto, ancho);
        
                g.drawString("65", 79, 118);
                g.drawString("87", 153, 24);
                g.drawString("45", 219, 120);
                g.drawString("35", 138, 220);
                g.drawString("32", 300, 220);
                g.drawString("17", 380, 330);
                g.drawString("12", 293, 421);
    }

    /**
     * Creates new form arboles
     */
    public arboles() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("Construir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 500, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:                                         
        arboles.linea(jPanel1.getGraphics(), 90, 100, 150, 30);
        arboles.linea(jPanel1.getGraphics(), 170, 30, 220, 100);
        arboles.linea(jPanel1.getGraphics(), 215, 126, 150, 200);
        arboles.linea(jPanel1.getGraphics(),  238, 125, 300, 200);
        arboles.linea(jPanel1.getGraphics(), 315, 225, 380, 310);
        arboles.linea(jPanel1.getGraphics(), 384, 338, 309, 401);
       
        arboles.circulo(jPanel1.getGraphics(), 70, 100, 30, 30);
        arboles.circulo(jPanel1.getGraphics(), 145, 5, 30, 30);
        arboles.circulo(jPanel1.getGraphics(), 210, 100, 30, 30);
        arboles.circulo(jPanel1.getGraphics(), 130, 200, 30, 30);
        arboles.circulo(jPanel1.getGraphics(), 290, 200, 30, 30);
        arboles.circulo(jPanel1.getGraphics(), 370, 310, 30, 30);
        arboles.circulo(jPanel1.getGraphics(), 285, 400, 30, 30);
    
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
