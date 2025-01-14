package config;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.File;

// Berfungsi mengambil file Laporan yang dibuat dari iReport
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class dbCRUD {
    
    String jdbcURL ="jdbc:mysql://localhost:3306/pemetaan_kehutanan";
    String username ="root";
    String password ="";
    
    Connection koneksi;
    private DefaultTableModel Modelnya;
    private TableColumn kolomnya;
    
    public dbCRUD(){
        try (Connection Koneksi = DriverManager.getConnection(jdbcURL, username, password)){
            Driver mysqldriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(mysqldriver);
            System.out.println("Berhasil");
        } catch (SQLException error) {
            System.err.println(error.toString());
        }
    }
    
    public dbCRUD(String url, String user, String pass){
        
        try(Connection Koneksi = DriverManager.getConnection(url, user, pass)) {
            Driver mysqldriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(mysqldriver);
            
            System.out.println("Berhasil");
        } catch (Exception error) {
            System.err.println(error.toString());
        }
        
    }
    
    public Connection getKoneksi () throws SQLException{
        try { 
            Driver mysqldriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver (mysqldriver);

        } catch (SQLException e) {

            System.err.println(e.toString());
        }

         return DriverManager.getConnection(this.jdbcURL, this.username, this.password);
    }
    
    public boolean DuplicateKey(String NamaTabel, String PrimaryKey, String isiData){
        boolean hasil=false;
        int jumlah=0;
        try {
            String SQL="SELECT * FROM "+NamaTabel+" WHERE "+PrimaryKey+" ='"+isiData+"'";
            Statement perintah = getKoneksi().createStatement();
            ResultSet hasilData = perintah.executeQuery(SQL);
            while(hasilData.next()){
                jumlah++;
            }
            
            if (jumlah==1) { hasil=true;} else { hasil=false;}
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return hasil;
    }

        public String getFieldTabel(String[] FieldTabelnya){
        String hasilnya = "";
        int deteksiIndexAkhir = FieldTabelnya.length - 1;
        try {
            for (int i = 0; i < FieldTabelnya.length; i++) {
                if (i == deteksiIndexAkhir) {
                    hasilnya = hasilnya + FieldTabelnya[i];
                } else {
                    hasilnya = hasilnya + FieldTabelnya[i] + ",";
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "(" + hasilnya + ")";
    }

    public String getIsiTabel(String[] IsiTabelnya){
        String hasilnya = "";
        int deteksiIndexAkhir = IsiTabelnya.length - 1;
        try {
            for (int i = 0; i < IsiTabelnya.length; i++) {
                // Tambahkan tanda kutip untuk setiap isi data
                if (i == deteksiIndexAkhir) {
                    hasilnya = hasilnya + "'" + IsiTabelnya[i] + "'";
                } else {
                    hasilnya = hasilnya + "'" + IsiTabelnya[i] + "',";
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "(" + hasilnya + ")";
    }
    
    public boolean duplicateKey(String table, String PrimaryKey, String value) { 
        boolean hasil=false;

        try {
            Statement sts = getKoneksi().createStatement();
            ResultSet rs = sts.executeQuery("SELECT * FROM "+table+" WHERE "+PrimaryKey+" ='"+value+"'");

            hasil = rs.next();

            rs.close();
            sts.close(); 
            getKoneksi().close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return hasil;
    }
    
        public void simpanDinamis(String NamaTabel, String[] Fieldnya, String[] isinya) {
    try {
        Statement perintah = getKoneksi().createStatement();  // Tambahkan pembuatan Statement
        String SQLSave = "INSERT INTO " + NamaTabel + " " + getFieldTabel(Fieldnya) +
                         " VALUES " + getIsiTabel(isinya);
        perintah.executeUpdate(SQLSave);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
    } catch (Exception e) {
        System.out.println(e.toString());
        
    }
    
    
//    public void SimpanContact(String noktp, String nama, String alamat, String email, String keluhan_saran) {
//        try {
//            if (duplicateKey("contact", "noktp", noktp)) {
//                JOptionPane.showMessageDialog(null, "No KTP sudah Terdaftar");
//            } else{ 
//                String SQL ="INSERT INTO contact (noktp, nama, alamat, email, keluhan_saran) VALUE (?, ?, ?, ?, ?)";
//                PreparedStatement simpan = getKoneksi ().prepareStatement (SQL);
//                simpan.setString(1, noktp);
//                simpan.setString (2, nama);
//                simpan.setString(3, alamat);
//                simpan.setString(4, email);
//                simpan.setString(5, keluhan_saran);
//                 System.out.println("Data Berhasil Disimpan");
//                simpan.executeUpdate();
//                simpan.close(); getKoneksi ().close();
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//    }
//    
//    public void SimpanBerita(String idberita, String judul, String isi, String Kdgambar, String tgl, String jam) {
//        try {
//            if (duplicateKey("berita", "idberita", idberita)) {
//                JOptionPane.showMessageDialog(null, "ID Berita sudah Terdaftar");
//            } else{ 
//                String SQL ="INSERT INTO berita (idberita, judul, isi, Kdgambar, tgl, jam) VALUE (?, ?, ?, ?, ?, ?)";
//                PreparedStatement simpan = getKoneksi ().prepareStatement (SQL);
//                simpan.setString(1, idberita);
//                simpan.setString(2, judul);
//                simpan.setString(3, isi);
//                simpan.setString(4, Kdgambar);
//                simpan.setString(5, tgl);
//                simpan.setString(6, jam);
//                System.out.println("Data Berhasil Disimpan");
//                simpan.executeUpdate();
//                simpan.close(); getKoneksi ().close();
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
    }
    
     public String getFieldValueEdit(String[] Field, String[] value){
        String hasil = "";
        int deteksi = Field.length-1;
        try {
            for (int i = 0; i < Field.length; i++) {
                if (i==deteksi){
                    hasil = hasil +Field[i]+" ='"+value[i]+"'";
                }else{
                   hasil = hasil +Field[i]+" ='"+value[i]+"',";  
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return hasil;
    }
    
    public void UbahDinamis(String NamaTabel, String PrimaryKey, String IsiPrimary,String[] Field, String[] Value){
        
        try {
           String SQLUbah = "UPDATE "+NamaTabel+" SET "+getFieldValueEdit(Field, Value)+" WHERE "+PrimaryKey+"='"+IsiPrimary+"'";
           Statement perintah = getKoneksi().createStatement();
           perintah.executeUpdate(SQLUbah);
           perintah.close();
           getKoneksi().close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
    }

          public void HapusDinamis(String NamaTabel, String PK, String isi){
        try {
            String SQL="DELETE FROM "+NamaTabel+" WHERE "+PK+"='"+isi+"'";
            Statement perintah = getKoneksi().createStatement();
            perintah.executeUpdate(SQL);
            perintah.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public String getTableField (String[] TableField){
        String result = "";
        int lastIndex = TableField.length-1;
        try {
            for ( int i = 0; i < TableField.length; i++ ){
                if(i==lastIndex){
                    result = result + TableField[i];
                }else {
                    result = result + TableField[i]+ ",";
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "("+result+")";
    }
    
    public String getTableFill(String [] FillValue){
        String result = "";
        int lastIndex = FillValue.length-1;
        try {
            for ( int i = 0; i < FillValue.length; i++ ){
                if(i==lastIndex){
                    result = result + FillValue[i];
                }else {
                    result = result + FillValue[i]+ ",";
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "("+result+")";
    }
//    public void SaveFillValue(String TableName, String[] Field, String[] Value){
//        try{
//            String SQLSave = "insert into" + TableName +" " + getTableField(TableField) +
//                    "values" + getTableFill(FillValue);
//            query.executeUpdate(SQLSave);
//            query.close();
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//    }
    public void settingJudulTabel(JTable Tabelnya, String[] JudulKolom){
        try {
            Modelnya = new DefaultTableModel();
            Tabelnya.setModel(Modelnya);
            for (int i = 0; i < JudulKolom.length; i++) {
                Modelnya.addColumn(JudulKolom[i]);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void settingLebarKolom(JTable Tabelnya, int[] Kolom){
      try {
          Tabelnya.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
          for (int i = 0; i < Kolom.length; i++) {
           kolomnya = Tabelnya.getColumnModel().getColumn(i);
           kolomnya.setPreferredWidth(Kolom[i]);   
          }
      } catch (Exception e) {
          System.out.println(e.toString());
        }
    }
    
    //Untuk mengambil data tabel
    public Object[][] isiTabel(String SQL, int jumlah){
      Object[][] data =null;
      try {
         Statement perintah = getKoneksi().createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_READ_ONLY
        );
         ResultSet dataset = perintah.executeQuery(SQL);
         dataset.last();
         int baris = dataset.getRow();
         dataset.beforeFirst();
         
         int j =0;
         data = new Object[baris][jumlah];
         
         while (dataset.next()){
             for (int i = 0; i < jumlah; i++) {
                 data[j][i]=dataset.getString(i+1);
             } // Looping barisnya dulu, baru kolomnya 🙏🙏
             j++;
         }
      } catch (Exception e) {
            System.out.println(e.toString());
      }
      return data;
    }
    
    //Untuk menampilkan ke JTable
        public void tampilTabel(JTable Tabelnya, String SQL, String[] Judul){
          try {
            Tabelnya.setModel(new DefaultTableModel(isiTabel(SQL,Judul.length), Judul));
          } catch (Exception e) {
              System.out.println(e.toString());
          }
      }
        
    public void tampilLaporan(String laporanFile, String SQL) throws SQLException {
    try {
        File file = new File(laporanFile);
        JasperDesign jasDes = JRXmlLoader.load(file);

        JRDesignQuery sqlQuery = new JRDesignQuery();
        sqlQuery.setText(SQL);
        jasDes.setQuery(sqlQuery);

        JasperReport JR = JasperCompileManager.compileReport(jasDes);
        JasperPrint JP = JasperFillManager.fillReport(JR, null, getKoneksi());
        JasperViewer.viewReport(JP, false);
    } catch (JRException e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }
}


}
