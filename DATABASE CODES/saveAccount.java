//this code is for saving the details to create new account

private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       String url = "jdbc:mysql://localhost:3306/ipam";
        String user = "root";
        String password = "01234";
 
         String name=username_txt.getText();
        String passwd=password_txt.getText();
        
 
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
 
            String sql = "insert into login (username,password)" + " values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
 
            statement.setString(1, name);
              statement.setString(2, passwd);
              
 
            int row = statement.executeUpdate();
            if (row > 0) {
               
                JOptionPane.showMessageDialog(null,"Account Created");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      
    }
