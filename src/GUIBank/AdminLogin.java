package GUIBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author MY LAPI
 */
public class AdminLogin extends javax.swing.JFrame {

	public AdminLogin() {
		initComponents();
	}
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jPasswordField1 = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 24));
		jLabel1.setText("ADMIN PANEL");

		jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 18));
		jLabel2.setText("UserName");

		jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 18));
		jLabel3.setText("Password");

		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jButton1.setFont(new java.awt.Font("Arial Unicode MS", 0, 18));
		jButton1.setText("Login");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel4.setForeground(new java.awt.Color(255, 0, 0));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(31, 31, 31)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 192,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
						.addGap(25, 25, 25))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(94, 94, 94))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(jButton1).addGap(103, 103, 103)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(24, 24, 24).addComponent(jLabel4)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
						.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(25, 25, 25)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(45, 45, 45).addComponent(jButton1).addContainerGap(56, Short.MAX_VALUE)));

		pack();
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","Thuongle2");

			Statement smt = cn.createStatement();
			ResultSet rs = smt.executeQuery("select aid from admin where uname='" + jTextField2.getText()
					+ "' and password='" + jPasswordField1.getText() + "'");

			if (rs.next()) {
				AdminLogin pb1 = new AdminLogin();
				AdminDesh pb2 = new AdminDesh();
				pb1.setVisible(false);
				pb2.setVisible(true);
				dispose();
			} else {
				jLabel4.setText("** Wrong Username OR Password **");
			}
		} catch (Exception e) {
			jLabel4.setText(e.getMessage());
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AdminLogin().setVisible(true);
			}
		});
	}
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JTextField jTextField2;
}
