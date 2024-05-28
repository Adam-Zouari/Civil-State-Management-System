import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;



 interface MyGUI {
//class MyGUI {
    

            public static void resetToZero() {
    // Get the current day of the week
    Calendar calendar = Calendar.getInstance();
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);


    if (dayOfWeek == 2 ) {
        try{
                                Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                            String query = "UPDATE Naissance set Nombre_de_retrait_semaine=?" ;
                        PreparedStatement pstmt = con.prepareStatement(query);
                        pstmt.setInt(1,0);
                        pstmt.executeUpdate();
                        query = "UPDATE Décès set Nombre_de_retrait_semaine=?" ;
                        pstmt = con.prepareStatement(query);
                        pstmt.setInt(1,0);
                        pstmt.executeUpdate();
                             // Close the database connection
                    pstmt.close();
                    con.close();
                            }
                            catch (Exception ex) {
                                ex.printStackTrace();
                            }

    }
}
    default void createGUI() {
  //MyGUI(){
        resetToZero();
        CreateFrame frame=new CreateFrame("Etat civil");
        frame.getFrame().setLocation(400, 100);
        
        JPanel panel_etat_civil = new JPanel();
        panel_etat_civil.setLayout(null);

        CreateJlabel title = new CreateJlabel(panel_etat_civil,"Etat civil",200,30,400,50,30);
        title.get_label().setForeground(new Color( 0, 94, 157));
System.out.print(frame.getFrame().getWidth());

CreateButton button2=new CreateButton(panel_etat_civil, "Extrait de naissance", 160, 150, 200, 30);
CreateButton button4=new CreateButton(panel_etat_civil,"Extrait de décès",160, 250, 200, 30);
CreateButton button5=new CreateButton(panel_etat_civil, "S'inscrire comme administrateur", 135, 350, 250, 30);
        
        panel_etat_civil.setPreferredSize(new Dimension(500, 500)); // set preferred size of panel
        
        frame.getFrame().getContentPane().add(panel_etat_civil);
        frame.getFrame().pack();


        button5.get_button().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                 // Remove the old panel from the frame
        frame.getFrame().remove(panel_etat_civil);

        // Create a new panel for the form
        JPanel Panel_login = new JPanel();
        Panel_login.setLayout(null);

        CreateJlabel title = new CreateJlabel(Panel_login,"S'inscrire comme administrateur",60,10,400,50,25);
        title.get_label().setForeground(new Color(0,94,157));

        CreateJlabel_textfield loginLabel=new CreateJlabel_textfield(Panel_login,"CIN:",130,170,100,20,20,"",170,170,150,25);
        loginLabel.get_label().setForeground(new Color(0,94,157));

            CreateJlabel passwordLabel = new CreateJlabel(Panel_login,"Mot de passe: ", 130, 300, 150, 20, 20);
            passwordLabel.get_label().setForeground(new Color(0,94,157));

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(265, 300, 150, 25);
            Panel_login.add(passwordField);

            CreateButton loginButton=new CreateButton(Panel_login,"Login",380,470,100,20);
            loginButton.get_button().setBackground(new Color(0, 94, 157));
            loginButton.get_button().setForeground(Color.WHITE);
            
            CreateButton backbutton=new CreateButton(Panel_login,"Retour",20,470,100,20);
            backbutton.get_button().setBackground(new Color(0, 94, 157));
            backbutton.get_button().setForeground(Color.WHITE);

            backbutton.createbackbutton(frame.getFrame(), panel_etat_civil);
              
        loginButton.get_button().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String CIN = loginLabel.get_textfield().get_textfield().getText();
                String mot_de_passe = new String(passwordField.getPassword());
                int i=0;
                if(CIN.length()!=8){
                    i++;
                }
                else{
                    try{
                        if(Integer.parseInt(CIN)<0)
                        i++;
                    }
                    catch(NumberFormatException a){
                        i++;
                    }
                }
                    if(i!=0){
                        frame.CreateErrorFrame("CIN est invalide");
                    }
                    else{
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                    String query = "SELECT * FROM super_admin WHERE CIN=? AND mot_de_passe=?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, CIN);
                    pstmt.setString(2, mot_de_passe);
                    ResultSet rs = pstmt.executeQuery();
                    if(rs.next()){
                             frame.getFrame().getContentPane().remove(Panel_login);
        
     JPanel panel_super_admin = new JPanel();
     panel_super_admin.setLayout(null);

     CreateJlabel title =new CreateJlabel(panel_super_admin,"Etat civil",200,20,200,25,30);
     title.get_label().setForeground(new Color(0,94,157));

     CreateButton button1 = new CreateButton(panel_super_admin,"Inscription d'une naissance", 160, 80, 200, 25);
     CreateButton button2 = new CreateButton(panel_super_admin,"Extrait de naissance", 160, 130, 200, 25);
     CreateButton button3 = new CreateButton(panel_super_admin,"Inscription de décès", 160, 180, 200, 25);
     CreateButton button4 = new CreateButton(panel_super_admin,"Extrait de décès", 160, 230, 200, 25);
     CreateButton button5 = new CreateButton(panel_super_admin,"Modifier mot de passe", 160, 280, 200, 25);
     CreateButton button6 = new CreateButton(panel_super_admin,"Ajouter Admin", 160, 330, 200, 25);
     CreateButton button7 = new CreateButton(panel_super_admin,"Supprimer Admin", 160, 380, 200, 25);
    CreateButton button69 = new CreateButton(panel_super_admin,"Min/Max",160,430,200,25);
     CreateButton backbutton = new CreateButton(panel_super_admin,"Retour",10, 470, 100, 20);
     button69.create_scroll(frame);

    backbutton.createbackbutton(frame.getFrame(), panel_etat_civil);


    button7.CreateJPanel_Supprimer_Admin(frame, panel_super_admin);

    

    button6.CreateJPanel_Ajouter_Admin(frame, panel_super_admin);


    button5.CreateJPanel_Modifier_mdp2(frame, panel_super_admin);


button2.CreateJPanel_Extrait_naissance(frame, panel_super_admin);

     button3.CreateJPanel_Inscri_d(frame, panel_super_admin);


     button1.CreateJPanel_Inscri_n(frame, panel_super_admin);


     button4.CreateJPanel_Extrait_décès(frame, panel_super_admin);
     
     panel_super_admin.add(Box.createVerticalGlue()); // add some glue to center the buttons

     panel_super_admin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // add some padding

     frame.getFrame().getContentPane().add(panel_super_admin);

                    }
                    else{

                    query = "SELECT * FROM administrateur WHERE CIN=? AND mot_de_passe=?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, CIN);
                    pstmt.setString(2, mot_de_passe);
                    rs = pstmt.executeQuery();
        
                    // Check if the query returned any rows
                    if (rs.next()) {
                        
     frame.getFrame().getContentPane().remove(Panel_login);
        
     JPanel panel_admin = new JPanel();
     panel_admin.setLayout(null);

     JLabel title = new JLabel("Etat civil");
     title.setForeground(new Color(0,94,157));
     title.setFont(new Font(title.getFont().getName(), Font.BOLD, 30)); // change font size to 20
     title.setBounds(200, 20, 200, 30);
     panel_admin.add(title);


     CreateButton button1 = new CreateButton(panel_admin,"Inscription d'une naissance",160, 100, 200, 30);
     CreateButton button2 = new CreateButton(panel_admin,"Extrait de naissance",160, 160, 200, 30);
     CreateButton button3 = new CreateButton(panel_admin,"Inscription de décès", 160, 220, 200, 25);
     CreateButton button4 = new CreateButton(panel_admin,"Extrait de décès", 160, 280, 200, 30);
    CreateButton button69 = new CreateButton(panel_admin,"Min/Max",160,400,200,25);
     CreateButton button5 = new CreateButton(panel_admin,"Modifier mot de passe", 160, 340, 200, 30);
     CreateButton backButton = new CreateButton(panel_admin, "Retour",10,470, 100, 20);
      backButton.createbackbutton(frame.getFrame(), panel_etat_civil);

      button69.create_scroll(frame);
      button5.CreateJPanel_Modifier_mdp1(frame,panel_admin);

button2.CreateJPanel_Extrait_naissance(frame, panel_admin);

     button3.CreateJPanel_Inscri_d(frame, panel_admin);
     button1.CreateJPanel_Inscri_n(frame, panel_admin);
     button4.CreateJPanel_Extrait_décès(frame, panel_admin);
     
     panel_admin.add(Box.createVerticalGlue()); // add some glue to center the buttons

     panel_admin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // add some padding

     frame.getFrame().getContentPane().add(panel_admin);

                    } else {
                        frame.CreateErrorFrame("Cet admin n'éxiste pas");
     
                    }
                }
        
                    rs.close();
                    pstmt.close();
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
                // Repaint the frame
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
            }
    );
        
        frame.add_panel(Panel_login);
            }
        });
button2.CreateJPanel_Extrait_naissance(frame, panel_etat_civil);
button4.CreateJPanel_Extrait_décès(frame, panel_etat_civil);
    }
}

public class Main implements MyGUI {
    //public class Main {
    public static void main(String[] args) {
        Main gui = new Main();
       gui.createGUI();
       //MyGUI gui=new MyGUI();
    }
}
