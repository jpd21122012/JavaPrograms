import javax.swing.DefaultListModel;
import java.util.LinkedList; 
import javax.swing.JOptionPane;

public class EXAM extends javax.swing.JFrame {
DefaultListModel lista= new DefaultListModel();
LinkedList cola= new LinkedList();
    public EXAM() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Introducir palíndromo:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int contadorcadena=0;
        int numerodecaracteres;
        char letra;
        
        String palabra;
        palabra=jTextField1.getText();
        numerodecaracteres=palabra.length(); 
        
        for(int i=0;i<numerodecaracteres;i++){ 
           
            letra=palabra.charAt(i);
            contadorcadena++;  
           
            cola.offer(letra);      
        }      
            lista.addElement(cola);
            jList1.setModel(lista);
        
        if(numerodecaracteres==3){
            if(palabra.charAt(0)==palabra.charAt(2)){
                JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");  
            }
        }           
         if(numerodecaracteres==4){
            if(palabra.charAt(0)==palabra.charAt(3)&&palabra.charAt(1)==palabra.charAt(2)){
                JOptionPane.showMessageDialog(null,"Es un palindromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palindromo"); 
            }
        }   
          if(numerodecaracteres==5){
            if(palabra.charAt(0)==palabra.charAt(4)&&palabra.charAt(1)==palabra.charAt(3)){
                JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");  
            }
        }   
           if(numerodecaracteres==6){
            if(palabra.charAt(0)==palabra.charAt(5)&&palabra.charAt(1)==palabra.charAt(4)&&palabra.charAt(2)==palabra.charAt(3)){
                JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");
            } 
        }   
           if(numerodecaracteres==7){
            if(palabra.charAt(0)==palabra.charAt(6)&&palabra.charAt(1)==palabra.charAt(5)&&palabra.charAt(2)==palabra.charAt(4)){
                JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");  
            }
        }    
            if(numerodecaracteres==8){
            if(palabra.charAt(0)==palabra.charAt(7)&&palabra.charAt(1)==palabra.charAt(6)&&palabra.charAt(2)==palabra.charAt(5)&&palabra.charAt(3)==palabra.charAt(4)){
                JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");  
            }
        }   
             if(numerodecaracteres==9){
            if(palabra.charAt(0)==palabra.charAt(8)&&palabra.charAt(1)==palabra.charAt(7)&&palabra.charAt(2)==palabra.charAt(6)&&palabra.charAt(3)==palabra.charAt(5)){
               JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");  
            }
        }   
              if(numerodecaracteres==10){
           if(palabra.charAt(0)==palabra.charAt(9)&&palabra.charAt(1)==palabra.charAt(8)&&palabra.charAt(2)==palabra.charAt(7)&&palabra.charAt(3)==palabra.charAt(6)&&palabra.charAt(4)==palabra.charAt(5)){
                JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");  
            }
        }   
               if(numerodecaracteres==11){
           if(palabra.charAt(0)==palabra.charAt(10)&&palabra.charAt(1)==palabra.charAt(9)&&palabra.charAt(2)==palabra.charAt(8)&&palabra.charAt(3)==palabra.charAt(7)&&palabra.charAt(4)==palabra.charAt(6)){
                 JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");  
            }
        }   
                if(numerodecaracteres==12){
             if(palabra.charAt(0)==palabra.charAt(11)&&palabra.charAt(1)==palabra.charAt(10)&&palabra.charAt(2)==palabra.charAt(9)&&palabra.charAt(3)==palabra.charAt(8)&&palabra.charAt(4)==palabra.charAt(7)&&palabra.charAt(5)==palabra.charAt(6)){
                JOptionPane.showMessageDialog(null,"Es un palíndromo");    
            }else{
            JOptionPane.showMessageDialog(null,"No es un palíndromo");  
            }
        }   

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EXAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EXAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EXAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EXAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EXAM().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
