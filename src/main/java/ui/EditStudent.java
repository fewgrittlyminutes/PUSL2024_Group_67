package ui;

import com.mycompany.studentrecordmanagement.database.StudentRepository;
import com.mycompany.studentrecordmanagement.model.Student;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class EditStudent extends javax.swing.JFrame {

    private Student currentStudent;
    private byte[] person_image = null;
    private JLabel imageLabel;

    public EditStudent(Student student) {
        this.currentStudent = student;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        customInit();
        loadStudentData();
    }

    public EditStudent() {
        initComponents();
        customInit();
    }

    private void customInit() {
        gpaspin.setModel(new SpinnerNumberModel(0.0, 0.0, 4.0, 0.1));
        yearspin.setModel(new SpinnerNumberModel(2005, 1980, 2030, 1));
        dayspin.setModel(new SpinnerNumberModel(1, 1, 31, 1));

        jPanel3.setLayout(new java.awt.BorderLayout());
        imageLabel = new JLabel("No Image", JLabel.CENTER);
        jPanel3.add(imageLabel);

        degreebox.addItem("BSc (Hons) in Software Engineering");
        degreebox.addItem("BSc (Hons) in Computer Science");
        degreebox.addItem("BSc (Hons) in Data Science");
        degreebox.addItem("BM (Hons) in Business Analytics");

        batchbox.addItem("23.1");
        batchbox.addItem("23.2");
        batchbox.addItem("24.1");
        batchbox.addItem("24.2");

        numbertext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '\b') {
                    evt.consume();
                }
            }
        });
    }

    private void loadStudentData() {
        if (currentStudent == null) {
            return;
        }

        fullnametext.setText(currentStudent.getFullName());
        emailtext.setText(currentStudent.getEmail());
        addresstext.setText(currentStudent.getAddress());
        numbertext.setText(currentStudent.getPhoneNumber());

        genderbox.setSelectedItem(currentStudent.getGender());
        degreebox.setSelectedItem(currentStudent.getDegreeProgram());
        batchbox.setSelectedItem(currentStudent.getBatchNumber());

        gpaspin.setValue(currentStudent.getGpa());

        if (currentStudent.getDateOfBirth() != null) {
            java.time.LocalDate date = currentStudent.getDateOfBirth().toLocalDate();
            dayspin.setValue(date.getDayOfMonth());
            yearspin.setValue(date.getYear());
            if (date.getMonthValue() > 0) {
                monthbox.setSelectedIndex(date.getMonthValue() - 1);
            }
        }

        if (currentStudent.getImageData() != null) {
            person_image = currentStudent.getImageData();
            ImageIcon icon = new ImageIcon(new ImageIcon(person_image).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            imageLabel.setIcon(icon);
            imageLabel.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        fullname = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        number = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        degree = new javax.swing.JLabel();
        batch = new javax.swing.JLabel();
        gpa = new javax.swing.JLabel();
        fullnametext = new javax.swing.JTextField();
        emailtext = new javax.swing.JTextField();
        addresstext = new javax.swing.JTextField();
        numbertext = new javax.swing.JTextField();
        genderbox = new javax.swing.JComboBox<>();
        degreebox = new javax.swing.JComboBox<>();
        batchbox = new javax.swing.JComboBox<>();
        gpaspin = new javax.swing.JSpinner();
        dayspin = new javax.swing.JSpinner();
        monthbox = new javax.swing.JComboBox<>();
        yearspin = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        imageactions = new javax.swing.JLabel();
        uploadbutton = new javax.swing.JButton();
        recordactions = new javax.swing.JLabel();
        removebutton = new javax.swing.JButton();
        confirmbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Student Records");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        fullname.setText("Full Name");
        email.setText("Email");
        address.setText("Address");
        number.setText("Phone Number");
        gender.setText("Gender");
        dob.setText("DOB");
        degree.setText("Degree");
        batch.setText("Batch");
        gpa.setText("GPA");

        genderbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        monthbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fullname).addComponent(email).addComponent(address).addComponent(number).addComponent(gender).addComponent(dob).addComponent(degree).addComponent(batch).addComponent(gpa))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fullnametext).addComponent(emailtext).addComponent(addresstext).addComponent(numbertext)
                    .addComponent(genderbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dayspin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(monthbox, 0, 90, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(yearspin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(degreebox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(batchbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gpaspin))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(fullname).addComponent(fullnametext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(email).addComponent(emailtext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(address).addComponent(addresstext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(number).addComponent(numbertext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(gender).addComponent(genderbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(dob).addComponent(dayspin).addComponent(monthbox).addComponent(yearspin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(degree).addComponent(degreebox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(batch).addComponent(batchbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(gpa).addComponent(gpaspin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        imageactions.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        imageactions.setText("Image Actions");

        uploadbutton.setText("Upload");
        uploadbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadbuttonActionPerformed(evt);
            }
        });

        recordactions.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        recordactions.setText("Record Actions");

        removebutton.setForeground(new java.awt.Color(255, 51, 51));
        removebutton.setText("Remove");
        removebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebuttonActionPerformed(evt);
            }
        });

        confirmbutton.setBackground(new java.awt.Color(0, 204, 51));
        confirmbutton.setForeground(new java.awt.Color(255, 255, 255));
        confirmbutton.setText("Confirm");
        confirmbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageactions)
                            .addComponent(uploadbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recordactions)
                            .addComponent(removebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    ).addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageactions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uploadbutton)
                        .addGap(20, 20, 20)
                        .addComponent(recordactions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmbutton)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadbuttonActionPerformed
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            if (f.length() > 1048576) {
                JOptionPane.showMessageDialog(this, "Image too large!");
                return;
            }
            try {
                FileInputStream fis = new FileInputStream(f);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                person_image = bos.toByteArray();

                ImageIcon icon = new ImageIcon(new ImageIcon(person_image).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                imageLabel.setIcon(icon);
                imageLabel.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_uploadbuttonActionPerformed

    private void removebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebuttonActionPerformed
        if (currentStudent == null) {
            return;
        }

        int check = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?");
        if (check == JOptionPane.YES_OPTION) {
            StudentRepository repo = new StudentRepository();
            if (repo.deleteStudent(currentStudent.getStudentId())) {
                JOptionPane.showMessageDialog(this, "Deleted Successfully!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Delete Failed.");
            }
        }
    }//GEN-LAST:event_removebuttonActionPerformed

    private void confirmbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbuttonActionPerformed
        try {
            String email = emailtext.getText().trim();
            if (!email.endsWith(".com")) {
                JOptionPane.showMessageDialog(this, "Enter valid email");
                return;
            }

            currentStudent.setFullName(fullnametext.getText());
            currentStudent.setEmail(email);
            currentStudent.setAddress(addresstext.getText());
            currentStudent.setPhoneNumber(numbertext.getText());
            currentStudent.setGender(genderbox.getSelectedItem().toString());
            currentStudent.setDegreeProgram(degreebox.getSelectedItem().toString());
            currentStudent.setBatchNumber(batchbox.getSelectedItem().toString());
            currentStudent.setGpa((Double) gpaspin.getValue());

            int day = (int) dayspin.getValue();
            int year = (int) yearspin.getValue();
            int month = monthbox.getSelectedIndex() + 1;
            currentStudent.setDateOfBirth(java.sql.Date.valueOf(year + "-" + month + "-" + day));

            if (person_image != null) {
                currentStudent.setImageData(person_image);
            }

            StudentRepository repo = new StudentRepository();
            if (repo.updateStudent(currentStudent)) {
                JOptionPane.showMessageDialog(this, "Updated Successfully!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Update Failed.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_confirmbuttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EditStudent().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField addresstext;
    private javax.swing.JLabel batch;
    private javax.swing.JComboBox<String> batchbox;
    private javax.swing.JButton confirmbutton;
    private javax.swing.JSpinner dayspin;
    private javax.swing.JLabel degree;
    private javax.swing.JComboBox<String> degreebox;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailtext;
    private javax.swing.JLabel fullname;
    private javax.swing.JTextField fullnametext;
    private javax.swing.JLabel gender;
    private javax.swing.JComboBox<String> genderbox;
    private javax.swing.JLabel gpa;
    private javax.swing.JSpinner gpaspin;
    private javax.swing.JLabel imageactions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> monthbox;
    private javax.swing.JLabel number;
    private javax.swing.JTextField numbertext;
    private javax.swing.JLabel recordactions;
    private javax.swing.JButton removebutton;
    private javax.swing.JButton uploadbutton;
    private javax.swing.JSpinner yearspin;
    // End of variables declaration//GEN-END:variables
}