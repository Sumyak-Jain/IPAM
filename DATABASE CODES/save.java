 private void saveActionPerformed(java.awt.event.ActionEvent evt) {
        
       
        String url = "jdbc:mysql://localhost:3306/ipam";
        String user = "root";
        String password = "01234";
 
         String pn=profile_txt.getText();
        String ip=IP_txt.getText();
        String sn=subnet_text.getText();
        String gw=gateway_text.getText();
        String dns1=dns1_txt.getText();
        String dns2=dns2_txt.getText();
 
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
 
            String sql = "insert into profile (profile_name,ip,subnet,gateway,dns1,dns2)" + " values (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
 
            statement.setString(1, pn);
              statement.setString(2, ip);
               statement.setString(3, sn);
                statement.setString(4, gw);
                 statement.setString(5, dns1);
                  statement.setString(6, dns2);
 
            int row = statement.executeUpdate();
            if (row > 0) {
                Window1 obj=new Window1();
               obj.profile1.setText(pn);
               this.setVisible(false);
               obj.setVisible(true);
                JOptionPane.showMessageDialog(null,"Profile Created");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
