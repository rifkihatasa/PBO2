
package frame;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

import config.dbCRUD;
import javax.swing.JOptionPane;

public class berita extends javax.swing.JFrame {
    String[] judulKolom = {"Id Berita", "Judul", "Gambar", "Tanggal", "Waktu"};
    int[] lebarKolom = {120, 300, 150, 100, 100};
    String Sql = "select * from berita";
    private dbCRUD crud;

    /**
     * Creates new form berita1
     */
    public berita() {
        initComponents();
        this.setLocationRelativeTo(null); // meletakan posisi form berada ditengah windows
        crud = new dbCRUD();
        loaddata();
    }
    
    void loaddata(){
        crud.settingJudulTabel(tableberita, judulKolom);
        crud.settingLebarKolom(tableberita, lebarKolom);
        crud.tampilTabel(tableberita, Sql, judulKolom);
    }
    
    private void cariData(String sql, String keyword) {
    try {
        // Gunakan PreparedStatement untuk menghindari SQL injection
        PreparedStatement pst = crud.getKoneksi().prepareStatement(sql);
        pst.setString(1, keyword); // Menggunakan parameter pertama untuk LIKE id_surat
        pst.setString(2, keyword); // Menggunakan parameter kedua untuk LIKE sender

        ResultSet rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) tableberita.getModel();
        model.setRowCount(0);  // Menghapus data lama

        // Menambahkan data hasil query ke tabel
        while (rs.next()) {
            Object[] row = new Object[judulKolom.length];
            for (int i = 0; i < judulKolom.length; i++) {
                row[i] = rs.getObject(i + 1); // Mengambil data dari ResultSet
            }
            model.addRow(row); // Menambahkan baris ke model tabel
            }
        } catch (SQLException e) {
              e.printStackTrace();
        }
    
}
    
    private void bersihForm() {
    txtidberita.setText("");
    txtjudul.setText("");
    txtisi.setText("");
    txtKDgambar.setText("");
    txttgl.setText("");
    txtjam.setText("");
    txtidberita.requestFocus();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtisi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableberita = new javax.swing.JTable();
        txtKDgambar = new javax.swing.JTextField();
        txttgl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtjam = new javax.swing.JTextField();
        txtberita = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btncari = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        printbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidberita = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        txtjudul = new javax.swing.JTextField();
        btnhapus = new javax.swing.JButton();
        btnbersih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableberita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableberita);

        txtKDgambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKDgambarActionPerformed(evt);
            }
        });

        jLabel7.setText("Id Berita");

        txtberita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtberitaActionPerformed(evt);
            }
        });

        jLabel3.setText("Isi");

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jLabel4.setText("Gambar");

        printbtn.setText("PRINT");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Tanggal");

        jLabel1.setText("no");

        jLabel6.setText("Jam");

        txtidberita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidberitaActionPerformed(evt);
            }
        });

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        jLabel2.setText("Judul");

        btnedit.setText("edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setText("hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbersih.setText("Bersih");
        btnbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttgl)
                            .addComponent(txtKDgambar)
                            .addComponent(txtisi)
                            .addComponent(txtidberita)
                            .addComponent(txtjudul)
                            .addComponent(txtjam, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnsimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbersih)
                            .addComponent(btnhapus))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtberita, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncari))
                    .addComponent(printbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtberita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btncari))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidberita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKDgambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnhapus)
                            .addComponent(btnedit)
                            .addComponent(btnsimpan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbersih))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKDgambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKDgambarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKDgambarActionPerformed

    private void txtberitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtberitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtberitaActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
    String keyword = txtberita.getText();

    // Query pencarian menggunakan LIKE untuk id_surat dan sender
    String sql = "SELECT * FROM berita WHERE idberita LIKE ? OR judul LIKE ? ORDER BY idberita ASC";
    
    // Panggil fungsi cariData dengan query dan keyword
    cariData(sql, "%" + keyword + "%");
    }//GEN-LAST:event_btncariActionPerformed

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        try {
            crud.tampilLaporan("src/laporan/berita.jrxml", "SELECT * FROM berita");
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }//GEN-LAST:event_printbtnActionPerformed

    private void txtidberitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidberitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidberitaActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
    String[] fields = {"idberita", "judul", "isi", "Kdgambar", "tgl","jam"};
    String[] values = {
        txtidberita.getText(),
        txtjudul.getText(),
        txtisi.getText(),
        txtKDgambar.getText(),
        txttgl.getText(),
        txtjam.getText()
    };
    
    if (crud.DuplicateKey("berita", "idberita", values[0])) {
        JOptionPane.showMessageDialog(this, "Kode Berita Sudah Ada!");
        return;
    }
    
    crud.simpanDinamis("berita", fields, values);
    loaddata();
    bersihForm();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
    String[] fields = {"idberita", "judul", "isi", "Kdgambar", "tgl","jam"};
    String[] values = {
        txtidberita.getText(),
        txtjudul.getText(),
        txtisi.getText(),
        txtKDgambar.getText(),
        txttgl.getText(),
        txtjam.getText()
    };
    
    crud.UbahDinamis("berita", "idberita", txtidberita.getText(), fields, values);
        loaddata();
        bersihForm();
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, 
        "Apakah anda yakin ingin menghapus data ini?", 
        "Konfirmasi Hapus", 
        JOptionPane.YES_NO_OPTION);
        
    if (confirm == JOptionPane.YES_OPTION) {
        crud.HapusDinamis("berita", "idberita", txtidberita.getText());
        loaddata();
        bersihForm();
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihActionPerformed
        bersihForm();
    }//GEN-LAST:event_btnbersihActionPerformed

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
            java.util.logging.Logger.getLogger(berita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(berita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(berita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(berita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new berita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbersih;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printbtn;
    private javax.swing.JTable tableberita;
    private javax.swing.JTextField txtKDgambar;
    private javax.swing.JTextField txtberita;
    private javax.swing.JTextField txtidberita;
    private javax.swing.JTextField txtisi;
    private javax.swing.JTextField txtjam;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JTextField txttgl;
    // End of variables declaration//GEN-END:variables

}
