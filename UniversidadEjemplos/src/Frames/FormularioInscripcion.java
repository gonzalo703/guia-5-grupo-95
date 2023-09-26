/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Universidad.Entidades.Alumno;
import Universidad.Entidades.Inscripcion;
import Universidad.Entidades.Materia;
import conexion.AlumnoData;
import conexion.InscripcionData;
import conexion.MateriaData;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gonza
 */
public class FormularioInscripcion extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    private MateriaData materia = new MateriaData();
    private AlumnoData alu = new AlumnoData();
    private InscripcionData insc=new InscripcionData();
    
    public FormularioInscripcion() {
        initComponents();
        cargaListaAlumno();
        cabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jClistaAlu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jRmins = new javax.swing.JRadioButton();
        jRNomins = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMateria = new javax.swing.JTable();
        jBInscribir = new javax.swing.JButton();
        jBañadirInsc = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Seleccione un alumno");

        jClistaAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClistaAluActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Lista de Materias");

        jRmins.setText("Materias Inscriptas");
        jRmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRminsActionPerformed(evt);
            }
        });

        jRNomins.setText("Maerias no Inscriptas");
        jRNomins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRNominsActionPerformed(evt);
            }
        });

        jTMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMateriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTMateria);

        jBInscribir.setText("Inscribir");
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        jBañadirInsc.setText("Anular Inscripcion");
        jBañadirInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBañadirInscActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBInscribir)
                .addGap(45, 45, 45)
                .addComponent(jBañadirInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jClistaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jRmins)
                            .addGap(104, 104, 104)
                            .addComponent(jRNomins)
                            .addGap(103, 103, 103))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(67, 67, 67)))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jClistaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRmins)
                    .addComponent(jRNomins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBañadirInsc)
                    .addComponent(jBInscribir)
                    .addComponent(jButton3))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRminsActionPerformed
        boolean selec = jRmins.isSelected();
        modelo.setRowCount(0);
        int id = jClistaAlu.getItemAt(jClistaAlu.getSelectedIndex()).getId_Alumnos();
        if (selec == true){
            for (Materia mat : insc.materiasCursadas(id)){
                 modelo.addRow(new Object[]{mat.getId_Materia(),mat.getNombre(),mat.getAño()});
              
            }
      
        }
    }//GEN-LAST:event_jRminsActionPerformed

    private void jRNominsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRNominsActionPerformed
        boolean selec = jRNomins.isSelected();
        modelo.setRowCount(0);
        int id = jClistaAlu.getItemAt(jClistaAlu.getSelectedIndex()).getId_Alumnos();
        if (selec == true){
            for (Materia mat : insc.materiasNOCursadas(id)){
                 modelo.addRow(new Object[]{mat.getId_Materia(),mat.getNombre(),mat.getAño()});
              
            }
         }   
    }//GEN-LAST:event_jRNominsActionPerformed

    private void jBañadirInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBañadirInscActionPerformed
        int selec=jTMateria.getSelectedRow();
        int id = jClistaAlu.getItemAt(jClistaAlu.getSelectedIndex()).getId_Alumnos();
        
        if(selec!=-1){
        int idm = (Integer)jTMateria.getValueAt(selec,0);
        modelo.removeRow(selec);
        insc.borrarInscricion(id, idm);
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione materia para anular inscripcion");
        }
    }//GEN-LAST:event_jBañadirInscActionPerformed

    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed
        boolean selec = jRNomins.isSelected();
        int selecT=jTMateria.getSelectedRow();
        int id = jClistaAlu.getItemAt(jClistaAlu.getSelectedIndex()).getId_Alumnos();
        
        if(selecT!=-1  && selec == true){
        int idm = (Integer)jTMateria.getValueAt(selecT,0);
        
        Alumno alum=alu.buscarAlumno(id);
        Materia mater = materia.buscarMateria(idm);
        Inscripcion isncripcion = new Inscripcion(0,alum,mater);
        insc.guardarinscripcion(isncripcion);
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione materia para anular inscripcion");
        }
    }//GEN-LAST:event_jBInscribirActionPerformed

    private void jClistaAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClistaAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jClistaAluActionPerformed

    private void jTMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMateriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTMateriaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBañadirInsc;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Alumno> jClistaAlu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRNomins;
    private javax.swing.JRadioButton jRmins;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMateria;
    // End of variables declaration//GEN-END:variables
    private void cargaListaAlumno(){
       
        for (Alumno alumno :alu.buscarAlumnoLista()) {
        jClistaAlu.addItem(alumno);
   
        }
    }
    private void cabecera(){
     modelo.addColumn("id_Materia");
     modelo.addColumn("nombre");
     modelo.addColumn("Año");
    
     jTMateria.setModel(modelo);
    }
}
