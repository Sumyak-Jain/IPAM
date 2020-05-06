// this code is for validating the login credentials

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {
    String pass1=password_txt.getText();//storing the password given by the user
         String name1 =username_txt.getText();//storing the name given by the user
        
        try
        {   //making connection
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ipam",
                        "root", "01234");
           
           //writing the querry
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select username, password from login where username=? and password=?");
                   st.setString(1,name1);
                   st.setString(2,pass1);//setting the name and password in the querry
                  
            
           
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                Window1 obj=new Window1();
                this.setVisible(false);
                obj.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Login Failed.Please Try Again");
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
