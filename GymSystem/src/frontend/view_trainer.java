package frontend;

import backend.AdminRole;
import backend.Trainer;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class view_trainer extends javax.swing.JFrame {

    /**
     * Creates new form view_trainer
     */
    private AdminRole admin;
    public view_trainer(AdminRole admin) {
        this.admin= admin;
        initComponents();
        populateTrainerTable();
    }

    private void populateTrainerTable() {
       
        ArrayList<Trainer> trainerList = admin.getListOfTrainers();

       
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        
        Trainer trainer1 = new Trainer("1", "John Doe", "johndoe@example.com", "Software Engineering", "123-456-7890");
        Trainer trainer2 = new Trainer("2", "Jane Smith", "janesmith@example.com", "Data Science", "098-765-4321");

        
        trainerList.add(trainer1);
        trainerList.add(trainer2);
        for (Trainer trainer : trainerList) {
        
        String[] rowData = trainer.lineRepresentation().split(",");
        model.addRow(rowData);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Trainer");

        jScrollPane1.setToolTipText("ViewTranier");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Email", "Speciality", "Phone Number"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}


