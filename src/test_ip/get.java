 private void getActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getActionPerformed
     
		String dhcp="Wi-Fi";
		
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);
		       new Thread(new gui.SyncPipe(p.getErrorStream(), System.err)).start();
	               new Thread(new gui.SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("netsh interface ip set address "+dhcp+" dhcp");
	              
		                stdin.close();
	                p.waitFor();
                        JOptionPane.showMessageDialog(null,"ip changed successfully");
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
