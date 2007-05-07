package com.google.code.alasc;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.text.JTextComponent;

/**
 *
 * @author  vittorio
 */
public class AlascGui extends javax.swing.JFrame {
    private File logoFile = null;
    private File ASFile = null;
    
    public enum IDEStatus {DOCVUOTO, DOCNONSALVATO, DOCSALVATO, DOCCOMPILATO};
    private IDEStatus status;
    
    
    /** Creates new form AlascGui */
    public AlascGui() {
        initComponents();
        status = IDEStatus.DOCVUOTO;
        bloccaBottoni();
    }
    
    private void bloccaBottoni(){
        if (status == IDEStatus.DOCVUOTO){
            openMenuItem.setEnabled(true);
            openButton.setEnabled(true);
            saveButton.setEnabled(false);
            saveMenuItem.setEnabled(false);
            saveAsMenuItem.setEnabled(false);
            compileButton.setEnabled(false);
            compileExportButton.setEnabled(false);
            compileMenu.setEnabled(false);
            compileExportMenu.setEnabled(false);
            
        }
        if (status == IDEStatus.DOCNONSALVATO){
            openMenuItem.setEnabled(true);
            openButton.setEnabled(true);
            saveButton.setEnabled(true);
            saveMenuItem.setEnabled(true);
            saveAsMenuItem.setEnabled(true);
            compileButton.setEnabled(false);
            compileExportButton.setEnabled(false);
            compileMenu.setEnabled(false);
            compileExportMenu.setEnabled(false);
        }
        if (status == IDEStatus.DOCSALVATO){
            openMenuItem.setEnabled(true);
            openButton.setEnabled(true);
            saveButton.setEnabled(false);
            saveMenuItem.setEnabled(false);
            saveAsMenuItem.setEnabled(true);
            compileButton.setEnabled(true);
            compileExportButton.setEnabled(true);
            compileMenu.setEnabled(true);
            compileExportMenu.setEnabled(true);
        }
        if (status == IDEStatus.DOCCOMPILATO){
            openMenuItem.setEnabled(true);
            openButton.setEnabled(true);
            saveButton.setEnabled(false);
            saveMenuItem.setEnabled(false);
            saveAsMenuItem.setEnabled(true);
            compileButton.setEnabled(true);
            compileExportButton.setEnabled(true);
            compileMenu.setEnabled(true);
            compileExportMenu.setEnabled(true);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        openButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        compileButton = new javax.swing.JButton();
        compileExportButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        exitMenuItem = new javax.swing.JMenuItem();
        buildMenu = new javax.swing.JMenu();
        compileMenu = new javax.swing.JMenuItem();
        compileExportMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALASC: A Logo to ActionScript Compiler");
        jScrollPane1.setAutoscrolls(true);
        jTextArea1.setToolTipText("Your Logo code here!");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });

        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(jTextArea2);

        jToolBar1.setFloatable(false);
        openButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/openALASC.gif")));
        openButton.setToolTipText("Open new file..");
        openButton.setBorderPainted(false);
        openButton.setContentAreaFilled(false);
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        jToolBar1.add(openButton);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/saveALASC.gif")));
        saveButton.setToolTipText("Save");
        saveButton.setBorderPainted(false);
        saveButton.setContentAreaFilled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jToolBar1.add(saveButton);

        compileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comALASC.gif")));
        compileButton.setToolTipText("Compile");
        compileButton.setBorderPainted(false);
        compileButton.setContentAreaFilled(false);
        compileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileButtonActionPerformed(evt);
            }
        });

        jToolBar1.add(compileButton);

        compileExportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/celaALASC.gif")));
        compileExportButton.setToolTipText("Compile and export");
        compileExportButton.setBorderPainted(false);
        compileExportButton.setContentAreaFilled(false);
        jToolBar1.add(compileExportButton);

        fileMenu.setText("File");
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save as...");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(saveAsMenuItem);

        fileMenu.add(jSeparator1);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        buildMenu.setText("Build");
        buildMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildMenuActionPerformed(evt);
            }
        });

        compileMenu.setText("Compile");
        buildMenu.add(compileMenu);

        compileExportMenu.setText("Compile and export...");
        compileExportMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileExportMenuActionPerformed(evt);
            }
        });

        buildMenu.add(compileExportMenu);

        menuBar.add(buildMenu);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
    status = IDEStatus.DOCNONSALVATO;
    bloccaBottoni();
    }//GEN-LAST:event_jTextArea1KeyTyped
    
    private void compileExportMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileExportMenuActionPerformed
        //chiamata di sistema per compilare da riga di comando
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog((Component) evt.getSource());
        File swfFile = null;
        if (returnVal == JFileChooser.APPROVE_OPTION){
            swfFile = fc.getSelectedFile();
            String alascCall = "java Alasc " + logoFile.getAbsoluteFile() + "--swf " + swfFile.getAbsoluteFile();
            try {
                Runtime.getRuntime().exec(alascCall);
            } catch (IOException e) {
                System.err.println("There is some trouble with ALASC. Check that ALASC path is correct.");
                System.exit(2);
            }
            //String disegno =   "/Disegno.as";
            ASFile = new File("/home/vittorio/Disegno.as");
            //TODO <cobtrollare se serve un'attesa'
            //apertura del file da visuallizzare come risultato della compilazione
            openFile(ASFile, jTextArea2);
        }
        
    }//GEN-LAST:event_compileExportMenuActionPerformed
    
    private void buildMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildMenuActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_buildMenuActionPerformed
    
    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        if(logoFile==null)
            saveAsMenuItemActionPerformed(evt);
        else
            saveFileAs(logoFile, jTextArea1.getText());
        
        status = IDEStatus.DOCSALVATO;
        bloccaBottoni();
    }//GEN-LAST:event_saveMenuItemActionPerformed
    
    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog((Component) evt.getSource());
        
        if (returnVal == JFileChooser.APPROVE_OPTION){
            logoFile = fc.getSelectedFile();
            saveFileAs(logoFile, jTextArea1.getText());
        }
        status = IDEStatus.DOCSALVATO;
        bloccaBottoni();
    }//GEN-LAST:event_saveAsMenuItemActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveMenuItemActionPerformed(evt);
    }//GEN-LAST:event_saveButtonActionPerformed
    
    private void saveFileAs(File target, String daScrivere){
        
        Writer out;
        try {
            out = new FileWriter(target);
            out.write(daScrivere);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog((Component) evt.getSource());
        if (returnVal == JFileChooser.APPROVE_OPTION){
            logoFile = fc.getSelectedFile();
            openFile(logoFile, jTextArea1);
        }
        status = IDEStatus.DOCSALVATO;
        bloccaBottoni();
    }//GEN-LAST:event_openMenuItemActionPerformed
    
    private void compileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileButtonActionPerformed
        //chiamata di sistema per compilare da riga di comando
        String alascCall = "java Alasc " + logoFile.getAbsoluteFile();
       /* System.out.println(alascCall);
        
        try {
            Runtime.getRuntime().exec(alascCall);
        } catch (IOException e) {
            System.err.println("There is some trouble with ALASC. Check that ALASC path is correct.");
            System.exit(2);
        }
        */
        //String disegno =   "/Disegno.as";
        ASFile = new File("/home/vittorio/Disegno.as");
        //apertura del file da visuallizzare come risultato della compilazione
        openFile(ASFile, jTextArea2);
        status = IDEStatus.DOCCOMPILATO;
        bloccaBottoni();
    }//GEN-LAST:event_compileButtonActionPerformed
    
    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        openMenuItemActionPerformed(evt);
    }//GEN-LAST:event_openButtonActionPerformed
    
    
    private void openFile(File inputFile, JTextComponent target){
        StringBuffer logoCode = new StringBuffer();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Errore nell'apertura del file " + inputFile.getName());
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader myReader = new BufferedReader(isr);
        String line = null;
        
        try {
            line = myReader.readLine();
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file " + inputFile.getName());
        }
        String eol = System.getProperty("line.separator");
        while(line!=null){
            logoCode.append(line);
            logoCode.append(eol);
            
            try {
                line = myReader.readLine();
            } catch (IOException e) {
                System.out.println("Errore nella lettura del file " + inputFile.getName());
            }
        }
        
        target.setText(logoCode.toString());
    }
    
    private void chiediSalvataggio(){
    
    
    }
     
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlascGui().setVisible(true);
                
            }
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu buildMenu;
    private javax.swing.JButton compileButton;
    private javax.swing.JButton compileExportButton;
    private javax.swing.JMenuItem compileExportMenu;
    private javax.swing.JMenuItem compileMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JEditorPane jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton openButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JButton saveButton;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    
}
