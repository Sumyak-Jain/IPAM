    //this is the code to extract data from database and display it on the textfield according to the button clicked
    
    private void profile1ActionPerformed(java.awt.event.ActionEvent evt) {
       String url = "jdbc:mysql://localhost:3306/ipam";
        String user = "root";
        String password = "01234";
 
         String Pname=profile1.getText();//getting the name of button
        System.out.println(Pname);
        
 
        try {
            Connection conn = DriverManager.getConnection(url, user, password);//making the connection
 
          String SQL="Select profile_name,ip,subnet,gateway,dns1,dns2 from profile where profile_name='"+Pname+"'";//writting the querry
          
           PreparedStatement statement = conn.prepareStatement(SQL);
 
          // statement.setString(1,Pname);

   
    

    ResultSet rs=statement.executeQuery(SQL);//storing result
    if(rs.next()==false){
        Window3 obj=new Window3();
        this.setVisible(false);
        obj.setVisible(true);
    }else{
    do

    {
    String pn= rs.getString("profile_name");
    String ip= rs.getString("ip");
    String sn= rs.getString("subnet");
    String gw= rs.getString("gateway");
    String dns1_= rs.getString("dns1");
    String dns2_= rs.getString("dns2");
    
     Window3 obj1=new Window3();
    this.setVisible(false);
    obj1.setVisible(true);
  // Window3 obj=new Window3();
    //displaying data
    obj1.profile_txt.setText(pn);
    
    obj1.IP_txt.setText(ip);
   
    obj1.subnet_text.setText(sn);
    
    obj1.gateway_text.setText(gw);
    
    obj1.dns1_txt.setText(dns1_);
    
    obj1.dns2_txt.setText(dns2_);
    
    
    }while(rs.next());
    }
    conn.close();
    statement.close();
  
    
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
