package ui;

import com.mycompany.studentrecordmanagement.model.Student;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewRecord extends javax.swing.JFrame {

    public ViewRecord(Student student) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        displayData(student);
        loadLogo(); 
    }

    public ViewRecord() {
        initComponents();
        loadLogo();
    }
    
    private void loadLogo() {
        try {
            javax.swing.ImageIcon i = new javax.swing.ImageIcon("C:\\Users\\anjud\\Downloads\\nsbm.jpg");
            
            // FIX: We use 'lblLogo.getWidth()' for width, but '-1' for height.
            // '-1' tells Java to maintain the aspect ratio automatically.
            Image img = i.getImage().getScaledInstance(lblLogo.getWidth(), -1, Image.SCALE_SMOOTH);
            
            lblLogo.setIcon(new javax.swing.ImageIcon(img));
            // Center the logo just in case
            lblLogo.setHorizontalAlignment(JLabel.CENTER); 
            lblLogo.setVerticalAlignment(JLabel.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayData(Student s) {
        if (s == null) return;

        lblId.setText("ID: " + s.getStudentId());
        lblName.setText("Full Name: " + s.getFullName());
        lblEmail.setText("Email: " + s.getEmail());
        lblAddress.setText("Address: " + s.getAddress());
        lblPhone.setText("Phone: " + s.getPhoneNumber());
        lblDob.setText("DOB: " + s.getDateOfBirth());
        lblGender.setText("Gender: " + s.getGender());
        lblDegree.setText("Degree: " + s.getDegreeProgram());
        lblBatch.setText("Batch: " + s.getBatchNumber());
        lblGpa.setText("GPA: " + s.getGpa());

        if (s.getImageData() != null) {
            ImageIcon icon = new ImageIcon(new ImageIcon(s.getImageData()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            lblImage.setIcon(icon);
            lblImage.setText("");
        } else {
            lblImage.setText("No Image");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        studentprofile = new javax.swing.JLabel();
        overview = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblDegree = new javax.swing.JLabel();
        lblBatch = new javax.swing.JLabel();
        lblGpa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        studentprofile.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        studentprofile.setForeground(new java.awt.Color(255, 255, 255));
        studentprofile.setText("Student Profile");

        overview.setForeground(new java.awt.Color(255, 255, 255));
        overview.setText("Overview of personal and academic student info");

        lblLogo.setPreferredSize(new java.awt.Dimension(260, 130));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentprofile)
                    .addComponent(overview)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(studentprofile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overview)
                .addGap(18, 18, 18)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblName.setText("Name: ");
        lblId.setText("ID: ");
        lblEmail.setText("Email: ");
        lblAddress.setText("Address: ");
        lblPhone.setText("Phone: ");
        lblDob.setText("DOB: ");
        lblGender.setText("Gender: ");
        lblDegree.setText("Degree: ");
        lblBatch.setText("Batch: ");
        lblGpa.setText("GPA: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName).addComponent(lblId).addComponent(lblEmail)
                    .addComponent(lblAddress).addComponent(lblPhone).addComponent(lblDob)
                    .addComponent(lblGender).addComponent(lblDegree).addComponent(lblBatch).addComponent(lblGpa))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName).addGap(10, 10, 10)
                .addComponent(lblId).addGap(10, 10, 10)
                .addComponent(lblEmail).addGap(10, 10, 10)
                .addComponent(lblAddress).addGap(10, 10, 10)
                .addComponent(lblPhone).addGap(10, 10, 10)
                .addComponent(lblDob).addGap(10, 10, 10)
                .addComponent(lblGender).addGap(10, 10, 10)
                .addComponent(lblDegree).addGap(10, 10, 10)
                .addComponent(lblBatch).addGap(10, 10, 10)
                .addComponent(lblGpa)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.BorderLayout());
        lblImage.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        lblImage.setText("Image");
        jPanel3.add(lblImage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ViewRecord().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBatch;
    private javax.swing.JLabel lblDegree;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGpa;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblLogo; 
    private javax.swing.JLabel overview;
    private javax.swing.JLabel studentprofile;
    // End of variables declaration//GEN-END:variables
}