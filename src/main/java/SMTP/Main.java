/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMTP;

import SMTP.Dialogs.LogIn;
import SMTP.Dialogs.SendAgain;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumne
 */
public class Main extends javax.swing.JFrame {

    private boolean loggedIn = false;
    private LogIn logIn = new LogIn(this, true);
    JFileChooser fileChooser;
    String correoRemitente;
    String passwordRemitente;
    String archivo;
    String nombre;
    
    public String getCorreoRemitente() {
        return correoRemitente;
    }

    public void setCorreoRemitente(String correoRemitente) {
        this.correoRemitente = correoRemitente;
    }

    public String getPasswordRemitente() {
        return passwordRemitente;
    }

    public void setPasswordRemitente(String passwordRemitente) {
        this.passwordRemitente = passwordRemitente;
    }

    public Main() {
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
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMissatge = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(650, 300));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmail.setFont(new java.awt.Font("Roboto Light", 2, 12)); // NOI18N
        txtEmail.setBorder(null);
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 290, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Correo Receptor:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mensaje:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 60, 30));

        jButton1.setBackground(new java.awt.Color(0, 134, 190));
        jButton1.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ENVIAR");
        jButton1.setToolTipText("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 120, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 290, 20));

        txtAreaMissatge.setColumns(20);
        txtAreaMissatge.setFont(new java.awt.Font("Roboto Light", 2, 12)); // NOI18N
        txtAreaMissatge.setLineWrap(true);
        txtAreaMissatge.setRows(5);
        txtAreaMissatge.setWrapStyleWord(true);
        txtAreaMissatge.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtAreaMissatge.setOpaque(false);
        jScrollPane1.setViewportView(txtAreaMissatge);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 290, 170));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Asunto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        txtAsunto.setFont(new java.awt.Font("Roboto Light", 2, 12)); // NOI18N
        txtAsunto.setBorder(null);
        jPanel1.add(txtAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 290, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 290, 10));

        jButton2.setBackground(new java.awt.Color(0, 134, 190));
        jButton2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("INSERTAR ARCHIVO");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 160, 30));
        jPanel1.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 230, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked

    }//GEN-LAST:event_txtEmailMouseClicked

    private ImageIcon resizeImageIcon(BufferedImage originalImage, int desiredWidth, int desiredHeight) {
        int newHeight = 0;
        int newWidth = 0;
        float aspectRatio = (float) originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() > originalImage.getHeight()) {
            newWidth = desiredWidth;
            newHeight = Math.round(desiredWidth / aspectRatio);
        } else {
            newHeight = desiredHeight;
            newWidth = Math.round(desiredHeight * aspectRatio);
        }
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        ImageIcon imageIcon = new ImageIcon(outputImage);
        return imageIcon;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // No ens agafa el correu i password de la clase LogIn per aixo hem fet un default
        correoRemitente = "interficies99@gmail.com";
        passwordRemitente = "1234joan";
        //correoRemitente = logIn.getTxtEmail().getText();
        //passwordRemitente = logIn.(new String getPswPassword1.getPassword());
        String correoReceptor = txtEmail.getText();
        String asunto = txtAsunto.getText();
        String missatge = txtAreaMissatge.getText();
        Pattern emailRegEx = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        if (emailRegEx.matcher(correoReceptor).matches()) {
            if (archivo == null || archivo == "") {
                Properties props = System.getProperties();
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");  //El servidor SMTP de Google
                props.put("mail.smtp.user", correoRemitente);     // El correo del remitente
                props.put("mail.smtp.clave", passwordRemitente);  //La clave de la cuenta
                props.put("mail.smtp.auth", "true");    //Usar autenticaci??n mediante usuario y clave
                props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
                props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
                System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //Solucionar el error de protocol

                Session session = Session.getDefaultInstance(props);
                MimeMessage message = new MimeMessage(session);
                try {
                    message.setFrom(new InternetAddress(correoRemitente));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
                    message.setSubject(asunto);
                    message.setText(missatge);

                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", correoRemitente, passwordRemitente);
                    transport.sendMessage(message, message.getAllRecipients());
                    transport.close();

                    JOptionPane.showMessageDialog(null, "Correu Electronic Enviat");
                    
                    int response = JOptionPane.showConfirmDialog(this, "Vols tornar a mandar un missatge?", "Confirm action", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        txtEmail.setText("");
                        txtAsunto.setText("");
                        txtAreaMissatge.setText("");
                    } else {
                    setVisible(false);
                    Main ma = new Main();
                    ma.setVisible(true);
                    }
                } catch (AddressException ex) {
                    ex.printStackTrace();
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
            } else {
                try {
                    Properties props = System.getProperties();
                    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");  //El servidor SMTP de Google
                    props.put("mail.smtp.user", correoRemitente);     // El correo del remitente
                    props.put("mail.smtp.clave", passwordRemitente);  //La clave de la cuenta
                    props.put("mail.smtp.auth", "true");    //Usar autenticaci??n mediante usuario y clave
                    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
                    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
                    System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //Solucionar el error de protocol

                    Session session = Session.getDefaultInstance(props);
                    session.setDebug(false);
                    BodyPart texto = new MimeBodyPart();
                    texto.setText(missatge);
                    BodyPart adjunto = new MimeBodyPart();
                    adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
                    adjunto.setFileName(nombre);
                    MimeMultipart multiParte = new MimeMultipart();
                    multiParte.addBodyPart(texto);
                    multiParte.addBodyPart(adjunto);

                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(correoRemitente));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
                    message.setSubject(asunto);
                    message.setContent(multiParte);
                    Transport t = null;
                    t = session.getTransport("smtp");
                    t.connect("smtp.gmail.com", correoRemitente, passwordRemitente);
                    t.sendMessage(message, message.getAllRecipients());
                    t.close();
                    JOptionPane.showMessageDialog(null, "Correu Electronic Enviat");
                    int response = JOptionPane.showConfirmDialog(this, "Vols tornar a mandar un missatge?", "Confirm action", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        txtEmail.setText("");
                        txtAsunto.setText("");
                        txtAreaMissatge.setText("");
                        lblImage.setIcon(null);
                        archivo = "";
                    } else {
                    setVisible(false);
                    Main ma = new Main();
                    ma.setVisible(true);
                    }
                } catch (MessagingException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (!emailRegEx.matcher(correoReceptor).matches()) {
            JOptionPane.showMessageDialog(null, "El text introduit no es un correu electronic");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        askLoginLoop();
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fileChooser = new JFileChooser();
        archivo = "";
        lblImage.setIcon(null);
        int returnOption = fileChooser.showOpenDialog(this);
        if (returnOption == JFileChooser.APPROVE_OPTION) // try {
        {
            archivo = fileChooser.getSelectedFile().getPath();
        }
        nombre = fileChooser.getSelectedFile().getName();
        String miss = txtAreaMissatge.getText();
        txtAreaMissatge.setText(miss + "\n" + nombre);
        if (archivo.contains(".jpg") || archivo.contains(".png") || archivo.contains(".jpeg")) {
            BufferedImage bufferedImage;
            try {
                bufferedImage = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                ImageIcon icon = resizeImageIcon(bufferedImage, lblImage.getWidth(), lblImage.getHeight());
                lblImage.setIcon(icon);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextArea txtAreaMissatge;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables

    private void askLoginLoop() {
        while (!loggedIn) {
            LogIn ld = new LogIn(this, true);
            ld.setVisible(true);
        }
    }

    //getters and setters
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
