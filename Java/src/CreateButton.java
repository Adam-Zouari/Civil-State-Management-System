import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;
import java.util.Calendar;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;

public class CreateButton {
     private JPanel panel;
     private String button_name;
     private int x;
     private int y;
     private int width;
     private int height;
     private JButton button;
 
     CreateButton(){
        button=new JButton("");
     }

     CreateButton(JPanel panel, String button_name, int x, int y, int width, int height){
        this.panel=panel;
        button = new JButton(button_name);
        this.button_name=button_name;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(0, 94, 157));
      button.setForeground(Color.WHITE);
        panel.add(button);
     }
        int get_x(){
            return(x);
        }

        int get_y(){
            return(y);
        }

        int get_width(){
            return(width);
        }

        int get_height(){
            return(height);
        }

        JPanel get_panel(){
            return(panel);
        }

        String get_button_name(){
            return(button_name);
        }

        JButton get_button(){
            return(button);
        }

        void change_x(int x){
            this.x=x;
            button.setBounds(x, y, width, height);
        }

        void change_y(int y){
            this.y=y;
            button.setBounds(x, y, width, height);
        }

        void change_height(int height){
            this.height=height;
            button.setBounds(x, y, width, height);
        }

        void change_width(int width){
            this.width=width;
            button.setBounds(x, y, width, height);
        }

        void change_name(String button_name){
            this.button_name=button_name;
            button.setText(button_name);
        }

        void change_all(int x, int y, int width, int height){
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
            button.setBounds(x, y, width, height);
        }

        
        void change_all(String button_name,int x, int y, int width, int height){
            this.button_name=button_name;
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
            button.setText(button_name);
            button.setBounds(x, y, width, height);
        }

        void createbackbutton(JFrame frame,JPanel prev_panel){
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Remove the form panel from the frame
                    frame.getContentPane().remove(panel);
        
                    // Add the old panel back to the frame
                    frame.getContentPane().add(prev_panel);
        
                    // Repaint the frame
                    frame.revalidate();
                    frame.repaint();
                }
            });
    }

    void CreateJPanel_Extrait_décès(CreateFrame frame,JPanel prevpanel){

    // Add an action listener to button4
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Remove the old panel from the frame
        frame.getFrame().remove(prevpanel);

        // Create a new panel for the form
        JPanel panel_extrait_d = new JPanel();
        panel_extrait_d.setLayout(null);

        CreateJlabel formTitle = new CreateJlabel(panel_extrait_d,"Extrait de décès",150,0,250,100,25);
        formTitle.get_label().setForeground(new Color(0, 94, 157));
        
        CreateJlabel_textfield nameLT = new CreateJlabel_textfield(panel_extrait_d, "Nom:", 120, 110, 100, 20, 20,"", 175, 110, 120, 25);
        nameLT.get_label().setForeground(new Color(0, 94, 157));

        CreateJlabel_textfield surnameLT = new CreateJlabel_textfield(panel_extrait_d, "Prénom:", 120, 180, 100, 20, 20,"", 205, 180, 120, 25); 
        surnameLT.get_label().setForeground(new Color(0, 94, 157));

        CreateJlabel dodLabel = new CreateJlabel(panel_extrait_d,"Date de décès:",120,320,200,20,20);
        dodLabel.get_label().setForeground(new Color(0, 94, 157));

        CreateJTextField dod1Field = new CreateJTextField(panel_extrait_d,"",265,322,20,20);
        CreateJTextField dod2Field = new CreateJTextField(panel_extrait_d,"",285,322,20,20);
        CreateJTextField dod3Field = new CreateJTextField(panel_extrait_d,"",305,322,40,20);

        CreateJlabel_textfield podLT =new CreateJlabel_textfield(panel_extrait_d,"Lieu de décès:",120,250,200,20,20,"", 260,250,120,25);
        podLT.get_label().setForeground(new Color(0, 94, 157));

       CreateButton validerButton = new CreateButton(panel_extrait_d, "Valider",300,470, 100, 20);

       CreateButton backButton = new CreateButton(panel_extrait_d, "Retour",100,470, 100, 20);

       backButton.createbackbutton(frame.getFrame(),prevpanel);
        

        validerButton.get_button().addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {

                   // test
                   int i=0;
                   String stest1 =dod3Field.get_textfield().getText();
                   String stest2 =dod2Field.get_textfield().getText();
                   String stest3 =dod1Field.get_textfield().getText();
                   if(stest1.length()!=4 || stest2.length()!=2 || stest3.length()!=2 ){
                       i++;
                   }
                   else{
                    try{
                        Calendar calendar = Calendar.getInstance();
                         int year = calendar.get(Calendar.YEAR);
                         int month = calendar.get(Calendar.MONTH)+1;
                         int day = calendar.get(Calendar.DAY_OF_MONTH);
                           int itest1 = Integer.parseInt(stest1);
                           int itest2 = Integer.parseInt(stest2);
                           int itest3 = Integer.parseInt(stest3);
                           if (!(itest1>=1000 & itest1<=year & itest2>=1 & itest2<=12 & itest3>=1 & itest3<=31)){
                               i++;
                           }
                               else{
                                if(itest1==year){
                                    if(!(itest2<=month))
                                    i++;
                                    else{
                                        if(!(itest3<=day))
                                        i++;
                                    }
                                }
                               }
                           }
                           catch(NumberFormatException a){
                               i++;
                           }
                       }
                           if(i!=0){
                               frame.CreateErrorFrame("Date est invalide");
                           }
                           else{

               String nom = nameLT.get_textfield().get_textfield().getText();
               String prénom = surnameLT.get_textfield().get_textfield().getText();
               String pod = podLT.get_textfield().get_textfield().getText();
               String dod = stest1+"-"+stest2+"-"+stest3;
               java.sql.Date date = java.sql.Date.valueOf(dod);
               
               try {
                   // Connect to the database
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
               
                   String query = "SELECT * FROM Décès WHERE Nom=? AND Prénom=? AND Date_de_décès=? AND Lieu_de_décès=?" ;
                   PreparedStatement pstmt = con.prepareStatement(query);
                   pstmt.setString(1, nom);
                   pstmt.setString(2, prénom);
                   pstmt.setDate(3, date);
                   pstmt.setString(4, pod);
                   ResultSet rs = pstmt.executeQuery();
               
                   // Check if the query returned any rows
                   if (rs.next()) {
                             // Remove the form panel from the frame
             panel_extrait_d.setVisible(false);
    

             JPanel panel = new JPanel();
             panel.setBorder(BorderFactory.createTitledBorder("Extrait de décès"));
             panel.setLayout(null);

             CreateJlabel nom1 = new CreateJlabel(panel,"Nom: ",20,50,100,25,20);
             
             CreateJlabel nom2 = new CreateJlabel(panel,nom,360,50,100,25,20);

             CreateJlabel prénom1 = new CreateJlabel(panel,"Prénom: ",20,90,100,25,20);

             CreateJlabel prénom2 = new CreateJlabel(panel,prénom,360,90,200,25,20);

             CreateJlabel dod1 = new CreateJlabel(panel,"Date de décès: ",20,130,200,25,20);

            CreateJlabel dod2 = new CreateJlabel(panel,stest3+"-"+stest2+"-"+stest1,360,130,200,25,20);

             CreateJlabel pod1 = new CreateJlabel(panel,"Lieu de décès: ",20,170,200,25,20);

             CreateJlabel pod2 = new CreateJlabel(panel,pod,360,170,200,25,20);

             CreateJlabel nomp1 = new CreateJlabel(panel,"Nom du père: ",20,210,200,25,20);

             String storedProcedureCall = "{CALL get_nom_p2(?, ?, ?, ?)}";
             java.sql.CallableStatement cstmt = con.prepareCall(storedProcedureCall);
             cstmt.setString(1, nom);
             cstmt.setString(2, prénom);
             cstmt.setString(3, dod);
             cstmt.setString(4, pod);
             ResultSet rs2 = cstmt.executeQuery();
             String m;
             if(!rs2.next()){
                m="    -";
             }
             else{
                m=rs2.getString(1);
             }; 
             CreateJlabel nomp2 = new CreateJlabel(panel,m,360,210,200,25,20);

             CreateJlabel nomm = new CreateJlabel(panel,"Nom de mère: ",20,290,200,25,20);

             storedProcedureCall = "{CALL get_nom_m2(?, ?, ?, ?)}";
             cstmt = con.prepareCall(storedProcedureCall);
             cstmt.setString(1, nom);
             cstmt.setString(2, prénom);
             cstmt.setString(3, dod);
             cstmt.setString(4, pod);
             rs2 = cstmt.executeQuery(); 
             if(!rs2.next()){
                m="    -";
             }
             else{
                m=rs2.getString(1);
             }; 
             CreateJlabel nomm2 = new CreateJlabel(panel,m,360,290,200,25,20);

             CreateJlabel prénomp = new CreateJlabel(panel,"Prénom du père: ",20,250,200,25,20);

             storedProcedureCall = "{CALL get_prénom_p2(?, ?, ?, ?)}";
             cstmt = con.prepareCall(storedProcedureCall);
             cstmt.setString(1, nom);
             cstmt.setString(2, prénom);
             cstmt.setString(3, dod);
             cstmt.setString(4, pod);
             rs2 = cstmt.executeQuery();  
             if(!rs2.next()){
                m="    -";
             }
             else{
                m=rs2.getString(1);
             }; 

             CreateJlabel prénomp1 = new CreateJlabel(panel,m,360,250,200,25,20);

             CreateJlabel prénomm = new CreateJlabel(panel,"Prénom de mère: ",20,330,200,25,20);

             storedProcedureCall = "{CALL get_prénom_m2(?, ?, ?, ?)}";
             cstmt = con.prepareCall(storedProcedureCall);
             cstmt.setString(1, nom);
             cstmt.setString(2, prénom);
             cstmt.setString(3, dod);
             cstmt.setString(4, pod);
             rs2 = cstmt.executeQuery();  
             if(!rs2.next()){
                m="    -";
             }
             else{
                m=rs2.getString(1);
             }; 
             CreateJlabel prénnomm1 = new CreateJlabel(panel,m,360,330,200,25,20);

             CreateJlabel nbr = new CreateJlabel(panel,"Nombre des extractions total:",20,370,340,25,20);

             String s2=rs.getString(7);
             CreateJlabel nbr1 = new CreateJlabel(panel,s2,380,370,100,25,20);

             CreateJlabel nbr2 = new CreateJlabel(panel,"Nombre des extractions cette semaine:",20,410,400,25,20);

             String s=rs.getString(8);
             CreateJlabel nbr3 = new CreateJlabel(panel,s,400,410,100,25,20);

             // Load the image file
     BufferedImage image = null;
     try {
         image = ImageIO.read(new File("image2.png"));
     } catch (IOException a) {
         a.printStackTrace();
     }
     
     // Create a label and set its icon to the loaded image
     JLabel image_label = new JLabel(new ImageIcon(image));
     image_label.setBounds(190, 5, 150, 100);
     
     // Add the label to the panel
     panel.add(image_label);

             // Create a button
             CreateButton button_imprimer = new CreateButton(panel, "Imprimer",390, 465, 100, 25);


             button_imprimer.get_button().addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                     if(Integer.parseInt(s)==3){
                         frame.CreateErrorFrame("Limite dépassé");
             
                     }
                     else{
                         try{
                             Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                         String query = "UPDATE Décès set Nombre_de_retrait_total=? WHERE Nom=? AND Prénom=? AND Date_de_décès=? AND Lieu_de_décès=?" ;
                     PreparedStatement pstmt = con.prepareStatement(query);
                     pstmt.setString(2, nom);
                     pstmt.setString(3, prénom);
                     pstmt.setDate(4, date);
                     pstmt.setString(5, pod);
                     pstmt.setInt(1,Integer.parseInt(s2)+1);
                     pstmt.executeUpdate();
                     nbr1.get_label().setText(String.valueOf(Integer.parseInt(s2)+1));

                     query = "UPDATE Décès set Nombre_de_retrait_semaine=? WHERE Nom=? AND Prénom=? AND Date_de_décès=? AND Lieu_de_décès=?" ;
                     pstmt = con.prepareStatement(query);
                     pstmt.setString(2, nom);
                     pstmt.setString(3, prénom);
                     pstmt.setDate(4, date);
                     pstmt.setString(5, pod);
                     pstmt.setInt(1,Integer.parseInt(s)+1);
                     pstmt.executeUpdate();
                     nbr3.get_label().setText(String.valueOf(Integer.parseInt(s)+1));

         
/////////////////aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                         
                          // Close the database connection
                 rs.close();
                 pstmt.close();
                 con.close();
                         }
                         catch (Exception ex) {
                             ex.printStackTrace();
                         }
                         
                     }

                 }

             });
                 
             CreateButton backButton = new CreateButton(panel, "Retour", 10, 465, 100, 25);

             backButton.createbackbutton(frame.getFrame(), prevpanel);
             
             frame.getFrame().add(panel);
                   } else {
                       frame.CreateErrorFrame("Cette personne n'éxiste pas");
               
                       }
               
                       // Close the database connection
                       rs.close();
                       pstmt.close();
                       con.close();
                   } catch (Exception ex) {
                       ex.printStackTrace();
                   }
               }

               }
           });
   

        frame.add_panel(panel_extrait_d);
    }
});

     }
    

    void CreateJPanel_Extrait_naissance(CreateFrame frame,JPanel prevpanel){
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Remove the old panel from the frame
                frame.getFrame().remove(prevpanel);
        
                JPanel panel_extrait_naissance = new JPanel();
                     panel_extrait_naissance.setLayout(null);
               
        
                    CreateJlabel formTitle = new CreateJlabel(panel_extrait_naissance,"Extrait de naissance",130,0,250,100,25);
                    formTitle.get_label().setForeground(new Color( 0, 94, 157));
        
                    CreateJlabel_textfield nameLT = new CreateJlabel_textfield(panel_extrait_naissance, "Nom:", 120, 110, 100, 20, 20,"", 175, 110, 120, 25);
                    nameLT.get_label().setForeground(new Color(0,94,157));
        
                    CreateJlabel_textfield surnameLT = new CreateJlabel_textfield(panel_extrait_naissance, "Prénom:", 120, 180, 100, 20, 20,"", 205, 180, 120, 25); 
                    surnameLT.get_label().setForeground(new Color(0,94,157));
                    
                    CreateJlabel dobLabel = new CreateJlabel(panel_extrait_naissance,"Date de naissance:",120,320,200,20,20);
                    dobLabel.get_label().setForeground(new Color(0,94,157));
        
                    CreateJTextField dob1Field = new CreateJTextField(panel_extrait_naissance,"",305,322,20,20);
                    CreateJTextField dob2Field = new CreateJTextField(panel_extrait_naissance,"",325,322,20,20);
                    CreateJTextField dob3Field = new CreateJTextField(panel_extrait_naissance,"",345,322,40,20);
            
                    CreateJlabel_textfield pobLT =new CreateJlabel_textfield(panel_extrait_naissance,"Lieu de naisance:",120,250,200,20,20,"", 290,250,120,25);
                    pobLT.get_label().setForeground(new Color(0,94,157));
            
                   CreateButton validerButton = new CreateButton(panel_extrait_naissance, "Valider",300,470, 100, 20);

                  
                   CreateButton backButton = new CreateButton(panel_extrait_naissance, "Retour",100,470, 100, 20);

                   backButton.createbackbutton(frame.getFrame(),prevpanel);
                    
        
                    validerButton.get_button().addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
        
                               // test
                               int i=0;
                               String stest1 =dob3Field.get_textfield().getText();
                               String stest2 =dob2Field.get_textfield().getText();
                               String stest3 =dob1Field.get_textfield().getText();
                               if(stest1.length()!=4 || stest2.length()!=2 || stest3.length()!=2 ){
                                   i++;
                               }
                               else{
                                   try{
                                    Calendar calendar = Calendar.getInstance();
                                     int year = calendar.get(Calendar.YEAR);
                                     int month = calendar.get(Calendar.MONTH)+1;
                                     int day = calendar.get(Calendar.DAY_OF_MONTH);
                                       int itest1 = Integer.parseInt(stest1);
                                       int itest2 = Integer.parseInt(stest2);
                                       int itest3 = Integer.parseInt(stest3);
                                       if (!(itest1>=1000 & itest1<=year & itest2>=1 & itest2<=12 & itest3>=1 & itest3<=31)){
                                        i++;
                                    }
                                        else{
                                         if(itest1==year){
                                             if(!(itest2<=month))
                                             i++;
                                             else{
                                                 if(!(itest3<=day))
                                                 i++;
                                             }
                                         }
                                        }
                                    }
                                       catch(NumberFormatException a){
                                           i++;
                                       }
                                   }
                                       if(i!=0){
                                           frame.CreateErrorFrame("Date est invalide");
                                       }
                                       else{
        
                           String nom = nameLT.get_textfield().get_textfield().getText();
                           String prénom = surnameLT.get_textfield().get_textfield().getText();
                           String pob = pobLT.get_textfield().get_textfield().getText();
                           String dob = stest1+"-"+stest2+"-"+stest3;
                           java.sql.Date date = java.sql.Date.valueOf(dob);
                           
                           try {
                               // Connect to the database
                               Class.forName("com.mysql.cj.jdbc.Driver");
                               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                           
                               String query = "SELECT * FROM Naissance WHERE Nom=? AND Prénom=? AND Date_de_naissance=? AND Lieu_de_naissance=?" ;
                               PreparedStatement pstmt = con.prepareStatement(query);
                               pstmt.setString(1, nom);
                               pstmt.setString(2, prénom);
                               pstmt.setDate(3, date);
                               pstmt.setString(4, pob);
                               ResultSet rs = pstmt.executeQuery();
                           
                               // Check if the query returned any rows
                               if (rs.next()) {
                                         // Remove the form panel from the frame
                         panel_extrait_naissance.setVisible(false);
                
        
                         JPanel panel = new JPanel();
                         panel.setBorder(BorderFactory.createTitledBorder("Extrait de naissance"));
                         panel.setLayout(null);
        
                         CreateJlabel nom1 = new CreateJlabel(panel,"Nom: ",20,50,100,25,20);
                         
                         CreateJlabel nom2 = new CreateJlabel(panel,nom,360,50,100,25,20);
        
                         CreateJlabel prénom1 = new CreateJlabel(panel,"Prénom: ",20,90,100,25,20);
        
                         CreateJlabel prénom2 = new CreateJlabel(panel,prénom,360,90,200,25,20);
            
                         CreateJlabel dob1 = new CreateJlabel(panel,"Date de naissance: ",20,130,200,25,20);
        
                         CreateJlabel dob2 = new CreateJlabel(panel,stest3+"-"+stest2+"-"+stest1,360,130,200,25,20);
         
                         CreateJlabel pob1 = new CreateJlabel(panel,"Lieu de naissance: ",20,170,200,25,20);
          
                         CreateJlabel pob2 = new CreateJlabel(panel,pob,360,170,200,25,20);
           
                         CreateJlabel nomp1 = new CreateJlabel(panel,"Nom du père: ",20,210,200,25,20);
         
                         String storedProcedureCall = "{CALL get_nom_p(?, ?, ?, ?)}";
                         java.sql.CallableStatement cstmt = con.prepareCall(storedProcedureCall);
                         cstmt.setString(1, nom);
                         cstmt.setString(2, prénom);
                         cstmt.setString(3, dob);
                         cstmt.setString(4, pob);
                         ResultSet rs2 = cstmt.executeQuery();
                         String m;
                         if(!rs2.next()){
                             m="    -";
                         }else{
                           m=rs2.getString(1);
                         };
                         CreateJlabel nomp2 = new CreateJlabel(panel,m,360,210,200,25,20);
        
                         CreateJlabel nomm = new CreateJlabel(panel,"Nom de mère: ",20,290,200,25,20);
         
                         storedProcedureCall = "{CALL get_nom_m(?, ?, ?, ?)}";
                         cstmt = con.prepareCall(storedProcedureCall);
                         cstmt.setString(1, nom);
                         cstmt.setString(2, prénom);
                         cstmt.setString(3, dob);
                         cstmt.setString(4, pob);
                         rs2 = cstmt.executeQuery(); 
                         if(!rs2.next()){
                            m="    -";
                         }
                         else{
                            m=rs2.getString(1);
                         }; 
                         CreateJlabel nomm2 = new CreateJlabel(panel,m,360,290,200,25,20);
        
                         CreateJlabel prénomp = new CreateJlabel(panel,"Prénom du père: ",20,250,200,25,20);
         
                         storedProcedureCall = "{CALL get_prénom_p(?, ?, ?, ?)}";
                         cstmt = con.prepareCall(storedProcedureCall);
                         cstmt.setString(1, nom);
                         cstmt.setString(2, prénom);
                         cstmt.setString(3, dob);
                         cstmt.setString(4, pob);
                         rs2 = cstmt.executeQuery();  
                         if(!rs2.next()){
                            m="    -";
                         }
                         else{
                            m=rs2.getString(1);
                         }; 
                         CreateJlabel prénomp1 = new CreateJlabel(panel,m,360,250,200,25,20);
        
                         CreateJlabel prénomm = new CreateJlabel(panel,"Prénom de mère: ",20,330,200,25,20);
         
                         storedProcedureCall = "{CALL get_prénom_m(?, ?, ?, ?)}";
                         cstmt = con.prepareCall(storedProcedureCall);
                         cstmt.setString(1, nom);
                         cstmt.setString(2, prénom);
                         cstmt.setString(3, dob);
                         cstmt.setString(4, pob);
                         rs2 = cstmt.executeQuery();  
                         if(!rs2.next()){
                            m="    -";
                         }
                         else{
                            m=rs2.getString(1);
                         }; 
                         CreateJlabel prénnomm1 = new CreateJlabel(panel,m,360,330,200,25,20);
         
                         CreateJlabel nbr = new CreateJlabel(panel,"Nombre des extractions total:",20,370,340,25,20);
            
                         String s2=rs.getString(7);
                         CreateJlabel nbr1 = new CreateJlabel(panel,s2,380,370,100,25,20);
         
                         CreateJlabel nbr2 = new CreateJlabel(panel,"Nombre des extractions cette semaine:",20,410,400,25,20);
        
                         String s=rs.getString(8);
                         CreateJlabel nbr3 = new CreateJlabel(panel,s,400,410,100,25,20);
         
                         // Load the image file
                 BufferedImage image = null;
                 try {
                     image = ImageIO.read(new File("image2.png"));
                 } catch (IOException a) {
                     a.printStackTrace();
                 }
                 
                 // Create a label and set its icon to the loaded image
                 JLabel image_label = new JLabel(new ImageIcon(image));
                 image_label.setBounds(190, 5, 150, 100);
                 
                 // Add the label to the panel
                 panel.add(image_label);
         
                         // Create a button
                         CreateButton button_imprimer = new CreateButton(panel, "Imprimer",390, 465, 100, 25);
        
                         button_imprimer.get_button().addActionListener(new ActionListener(){
                             public void actionPerformed(ActionEvent e){
                                 if(Integer.parseInt(s)==3){
                                     frame.CreateErrorFrame("Limite dépassé");
                         
                                 }
                                 else{
                                     try{
                                         Class.forName("com.mysql.cj.jdbc.Driver");
                             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                                     String query = "UPDATE Naissance set Nombre_de_retrait_total=? WHERE Nom=? AND Prénom=? AND Date_de_naissance=? AND Lieu_de_naissance=?" ;
                                 PreparedStatement pstmt = con.prepareStatement(query);
                                 pstmt.setString(2, nom);
                                 pstmt.setString(3, prénom);
                                 pstmt.setDate(4, date);
                                 pstmt.setString(5, pob);
                                 pstmt.setInt(1,Integer.parseInt(s2)+1);
                                 pstmt.executeUpdate();
                                 nbr1.get_label().setText(String.valueOf(Integer.parseInt(s2)+1));
        
                                 query = "UPDATE Naissance set Nombre_de_retrait_semaine=? WHERE Nom=? AND Prénom=? AND Date_de_naissance=? AND Lieu_de_naissance=?" ;
                                 pstmt = con.prepareStatement(query);
                                 pstmt.setString(2, nom);
                                 pstmt.setString(3, prénom);
                                 pstmt.setDate(4, date);
                                 pstmt.setString(5, pob);
                                 pstmt.setInt(1,Integer.parseInt(s)+1);
                                 pstmt.executeUpdate();
                                 nbr3.get_label().setText(String.valueOf(Integer.parseInt(s)+1));
                     
                             rs.close();
                             pstmt.close();
                             con.close();
                                     }
                                     catch (Exception ex) {
                                         ex.printStackTrace();
                                     }
                                     
                                 }
         
                             }
         
                         });
                             
                        
                         CreateButton backButton = new CreateButton(panel, "Retour", 10, 465, 100, 25);

                         backButton.createbackbutton(frame.getFrame(),prevpanel);
                         
                         frame.getFrame().add(panel);
                               } else {
                                   frame.CreateErrorFrame("Cette personne n'éxiste pas");
                           
                                   }
                           
                                   // Close the database connection
                                   rs.close();
                                   pstmt.close();
                                   con.close();
                               } catch (Exception ex) {
                                   ex.printStackTrace();
                               }
                           }
        
                           }
                       });
               
        
                    frame.add_panel(panel_extrait_naissance);
            }
        });

    }


    void CreateJPanel_Inscri_n(CreateFrame frame,JPanel prevpanel){

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Remove the old panel from the frame
                frame.getFrame().remove(prevpanel);
        
                // Create a new panel for the form
                JPanel panel_inscri_n = new JPanel();
                panel_inscri_n.setLayout(null);
        
                CreateJlabel formTitle = new CreateJlabel(panel_inscri_n,"Inscription de naissance",110, 0, 300, 100,25);
                formTitle.get_label().setForeground(new Color(0,94,157));
                
                CreateJlabel_textfield nameLT =new CreateJlabel_textfield(panel_inscri_n,"Nom:",120,110,100,20,20,"",175,110,120,25);
                nameLT.get_label().setForeground(new Color(0,94,157));
                
                CreateJlabel_textfield surnameLT = new CreateJlabel_textfield(panel_inscri_n,"Prénom:",120,180,100,20,20,"",205,180,120,25);
                surnameLT.get_label().setForeground(new Color(0,94,157));
    
                CreateJlabel dobLabel = new CreateJlabel(panel_inscri_n,"Date de naissance:",120, 390, 200, 20,20);
                dobLabel.get_label().setForeground(new Color(0,94,157));
    
                CreateJTextField dob1Field = new CreateJTextField(panel_inscri_n,"",305,392,20,20);
                CreateJTextField dob2Field = new CreateJTextField(panel_inscri_n,"",325,392,20,20);
                CreateJTextField dob3Field = new CreateJTextField(panel_inscri_n,"",345,392,40,20);
                
                CreateJlabel_textfield pobLT = new CreateJlabel_textfield(panel_inscri_n,"Lieu de naissance",120,250,200,20,20,"", 300,250,120,25);
                pobLT.get_label().setForeground(new Color(0,94,157));
    
                CreateJlabel cinpLabel= new CreateJlabel(panel_inscri_n,"CIN du père & de mère:",120,320,300,20,20);
                cinpLabel.get_label().setForeground(new Color(0,94,157));
    
                CreateJTextField cinpField =new CreateJTextField(panel_inscri_n,"", 345,318,70,25);
                CreateJTextField cinmField =new CreateJTextField(panel_inscri_n,"", 420,318,70,25);
    
                CreateButton validerButton = new CreateButton(panel_inscri_n, "Valider",300,470, 100, 20);

              
                CreateButton backButton = new CreateButton(panel_inscri_n, "Retour",100,470, 100, 20);
  
    
               backButton.createbackbutton(frame.getFrame(),prevpanel);
                
                validerButton.get_button().addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
    
                           // test
                           int i=0;
                           String stest1 =dob3Field.get_textfield().getText();
                           String stest2 =dob2Field.get_textfield().getText();
                           String stest3 =dob1Field.get_textfield().getText();
                           if(stest1.length()!=4 || stest2.length()!=2 || stest3.length()!=2 ){
                               i++;
                           }
                           else{
                            try{
                                Calendar calendar = Calendar.getInstance();
                                 int year = calendar.get(Calendar.YEAR);
                                 int month = calendar.get(Calendar.MONTH)+1;
                                 int day = calendar.get(Calendar.DAY_OF_MONTH);
                                   int itest1 = Integer.parseInt(stest1);
                                   int itest2 = Integer.parseInt(stest2);
                                   int itest3 = Integer.parseInt(stest3);
                                   if (!(itest1>=1000 & itest1<=year & itest2>=1 & itest2<=12 & itest3>=1 & itest3<=31)){
                                    i++;
                                }
                                    else{
                                     if(itest1==year){
                                         if(!(itest2<=month))
                                         i++;
                                         else{
                                             if(!(itest3<=day))
                                             i++;
                                         }
                                     }
                                    }
                                }
                                   catch(NumberFormatException a){
                                       i++;
                                   }
                               }
                                   if(i!=0){
                                       frame.CreateErrorFrame("Date est invalide");
                                   }
                                   else{
                                       
                           String nom = nameLT.get_textfield().get_textfield().getText();
                           String prénom = surnameLT.get_textfield().get_textfield().getText();
                           String pob = pobLT.get_textfield().get_textfield().getText();
                           String cinp = cinpField.get_textfield().getText();
                           String cinm = cinmField.get_textfield().getText();
                           String dob = stest1+"-"+stest2+"-"+stest3;
                           java.sql.Date date = java.sql.Date.valueOf(dob);
                           try{
                               int icinp = Integer.parseInt(cinp);
                               int icinm = Integer.parseInt(cinm);
                               if(icinp<0 || icinm<0 ||cinp.length()!=8 ||cinm.length()!=8){
                                   i++;
                               }
                           }catch(NumberFormatException a){
                               i++;
                           }
                           if(i!=0){
                               frame.CreateErrorFrame("CIN est invalide");
                           }
                           else{
                           try {
                                    // Connect to the database
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                                    
                                    PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Citoyen WHERE CIN=?");
                                    pstmt.setString(1,cinp);
                                    ResultSet rs=pstmt.executeQuery();
                                    if(rs.next() || Integer.parseInt(cinp)==0){
                                    pstmt = con.prepareStatement("SELECT * FROM Citoyen WHERE CIN=?");
                                    pstmt.setString(1,cinm);
                                    rs=pstmt.executeQuery();
                                    if(rs.next() || Integer.parseInt(cinm)==0){
                                    pstmt = con.prepareStatement("SELECT * FROM Naissance WHERE nom=?AND Prénom=?AND Date_de_naissance=? AND Lieu_de_naissance=?");
                                    pstmt.setString(1,nom);
                                    pstmt.setString(2,prénom);
                                    pstmt.setDate(3,date);
                                    pstmt.setString(4,pob);
                                    rs=pstmt.executeQuery();
                                    if(!rs.next()){
                                    pstmt = con.prepareStatement("INSERT INTO naissance (Nom,Prénom,Date_de_naissance,lieu_de_naissance,CIN_pére,CIN_mére,Nombre_de_retrait_total,Nombre_de_retrait_semaine) VALUES (?, ?, ?, ?,?,?,?,?)");
                                    pstmt.setString(1, nom);
                                    pstmt.setString(2, prénom);
                                    pstmt.setDate(3, date);
                                    pstmt.setString(4, pob);
                                    pstmt.setString(5, cinp);
                                    pstmt.setString(6, cinm);
                                    pstmt.setInt(7,0);
                                    pstmt.setInt(8,0);
                                    pstmt.executeUpdate();
                                    frame.CreateSuccessFrame("L'ajout est complet");
                                    }
                                    else{
                                        frame.CreateErrorFrame("Cette personne éxiste déja");
                                    }
                                }else{
                                    frame.CreateErrorFrame("CIN de mère est fausse");
                                }
                            }else{
                                frame.CreateErrorFrame("CIN du père est fausse");
                            }
                                           pstmt.close();
                                           con.close();
                                   
                                   
    
                            } catch (Exception ex) {
                               ex.printStackTrace();
                           }}
                                   }
                               }
                           });
                // Add the form panel to the frame
                frame.add_panel(panel_inscri_n);
            }
        });
    }


        void CreateJPanel_Inscri_d(CreateFrame frame,JPanel prevpanel){

            get_button().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Remove the old panel from the frame
                    frame.getFrame().remove(prevpanel);
            
                      // Create a new panel for the form
                   JPanel panel_inscri_d = new JPanel();
                   panel_inscri_d.setLayout(null);
           
                   CreateJlabel formTitle = new CreateJlabel(panel_inscri_d,"Inscription de décès",140, 0, 300, 100,25);
                   formTitle.get_label().setForeground(new Color(0,94,157));
       
                   CreateJlabel_textfield nameLT =new CreateJlabel_textfield(panel_inscri_d,"Nom:",120,110,100,20,20,"",175,110,120,25);
                   nameLT.get_label().setForeground(new Color(0,94,157));
       
                   CreateJlabel_textfield surnameLT = new CreateJlabel_textfield(panel_inscri_d,"Prénom:",120,180,100,20,20,"",205,180,120,25);
                   surnameLT.get_label().setForeground(new Color(0,94,157));
       
                   CreateJlabel dobLabel = new CreateJlabel(panel_inscri_d,"Date de décès:",130, 390, 200, 20,20);
                   dobLabel.get_label().setForeground(new Color(0,94,157));
       
                   CreateJTextField dob1Field = new CreateJTextField(panel_inscri_d,"",275,392,20,20);
                   CreateJTextField dob2Field = new CreateJTextField(panel_inscri_d,"",295,392,20,20);
                   CreateJTextField dob3Field = new CreateJTextField(panel_inscri_d,"",315,392,40,20);
                   
                   CreateJlabel_textfield pobLT = new CreateJlabel_textfield(panel_inscri_d,"Lieu de décès:",120,250,200,20,20,"", 260,250,120,25);
                   pobLT.get_label().setForeground(new Color(0,94,157));
       
                   CreateJlabel cinpLabel= new CreateJlabel(panel_inscri_d,"CIN du père & de mère:",120,320,300,20,20);
                   cinpLabel.get_label().setForeground(new Color(0,94,157));
       
                   CreateJTextField cinpField =new CreateJTextField(panel_inscri_d,"", 345,318,70,25);
                   CreateJTextField cinmField =new CreateJTextField(panel_inscri_d,"", 420,318,70,25);
       
                   CreateButton validerButton = new CreateButton(panel_inscri_d, "Valider",300,470, 100, 20);

                   CreateButton backButton = new CreateButton(panel_inscri_d, "Retour",100,470, 100, 20);
  
                  backButton.createbackbutton(frame.getFrame(), prevpanel);
                   
                   validerButton.get_button().addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent e) {
       
                              // test
                              int i=0;
                              String stest1 =dob3Field.get_textfield().getText();
                              String stest2 =dob2Field.get_textfield().getText();
                              String stest3 =dob1Field.get_textfield().getText();
                              if(stest1.length()!=4 || stest2.length()!=2 || stest3.length()!=2 ){
                                  i++;
                              }
                              else{
                                try{
                                    Calendar calendar = Calendar.getInstance();
                                     int year = calendar.get(Calendar.YEAR);
                                     int month = calendar.get(Calendar.MONTH)+1;
                                     int day = calendar.get(Calendar.DAY_OF_MONTH);
                                       int itest1 = Integer.parseInt(stest1);
                                       int itest2 = Integer.parseInt(stest2);
                                       int itest3 = Integer.parseInt(stest3);
                                       if (!(itest1>=1000 & itest1<=year & itest2>=1 & itest2<=12 & itest3>=1 & itest3<=31)){
                                        i++;
                                    }
                                        else{
                                         if(itest1==year){
                                             if(!(itest2<=month))
                                             i++;
                                             else{
                                                 if(!(itest3<=day))
                                                 i++;
                                             }
                                         }
                                        }
                                    }
                                      catch(NumberFormatException a){
                                          i++;
                                      }
                                  }
                                      if(i!=0){
                                          frame.CreateErrorFrame("Date est invalide");
                                      }
                                      else{
                                          
                              String nom = nameLT.get_textfield().get_textfield().getText();
                              String prénom = surnameLT.get_textfield().get_textfield().getText();
                              String pod = pobLT.get_textfield().get_textfield().getText();
                              String cinp = cinpField.get_textfield().getText();
                              String cinm = cinmField.get_textfield().getText();
                              String dod = stest1+"-"+stest2+"-"+stest3;
                              java.sql.Date date = java.sql.Date.valueOf(dod);
                              try{
                                  int icinp = Integer.parseInt(cinp);
                                  int icinm = Integer.parseInt(cinm);
                                  if(icinp<0 || icinm<0 || cinp.length()!=8 || cinm.length()!=8){
                                      i++;
                                  }
                              }catch(NumberFormatException a){
                                  i++;
                              }
                              if(i!=0){
                                  frame.CreateErrorFrame("CIN est invalide");
                              }
                              else{
                               try {
                                   // Connect to the database
                                   Class.forName("com.mysql.cj.jdbc.Driver");
                                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                                   PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Décès WHERE nom=? AND Prénom=? AND Date_de_décès=? AND Lieu_de_décès=?");
                                   pstmt.setString(1,nom);
                                   pstmt.setString(2,prénom);
                                   pstmt.setDate(3,date);
                                   pstmt.setString(4,pod);
                                   ResultSet rs=pstmt.executeQuery();
                                   if(!rs.next()){
                                   pstmt = con.prepareStatement("INSERT INTO Décès (Nom,Prénom,Date_de_décès,lieu_de_décès,CIN_pére,CIN_mére,Nombre_de_retrait_total,Nombre_de_retrait_semaine) VALUES (?, ?, ?, ?,?,?,?,?)");
                                       pstmt.setString(1, nom);
                                       pstmt.setString(2, prénom);
                                       pstmt.setDate(3, date);
                                       pstmt.setString(4, pod);
                                       pstmt.setString(5, cinp);
                                       pstmt.setString(6, cinm);
                                       pstmt.setInt(7,0);
                                       pstmt.setInt(8,0);
                                       pstmt.executeUpdate();
                                       frame.CreateSuccessFrame("L'ajout est complet");
                                   }
                                   else{
                                    frame.CreateErrorFrame("Cette personne éxiste déja");
                                }
                                       pstmt.close();
                                       con.close();
        
                               } catch (Exception ex) {
                                  ex.printStackTrace();
                              }}
                                      }
                                  }
                              });
                   // Add the form panel to the frame
                   frame.add_panel(panel_inscri_d);
                }
            });
        }


void CreateJPanel_Modifier_mdp1(CreateFrame frame,JPanel prev_panel){

    button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.getFrame().remove(prev_panel); 

            JPanel modifier_mdp = new JPanel();
            modifier_mdp.setLayout(null);

            CreateJlabel title = new CreateJlabel(modifier_mdp,"Modifier mot de passe",130,10,400,50,25);
            title.get_label().setForeground(new Color(0,94,157));

        CreateJlabel_textfield CIN=new CreateJlabel_textfield(modifier_mdp,"CIN:",100,170,100,20,20,"",140,170,150,25);
        CIN.get_label().setForeground(new Color(0,94,157));
       
        CreateJlabel passwordLabel1 = new CreateJlabel(modifier_mdp,"Ancien mot de passe:", 100, 235, 250, 20, 20);
        passwordLabel1.get_label().setForeground(new Color(0,94,157));   
        
        CreateJlabel passwordLabel2 = new CreateJlabel(modifier_mdp,"Nouveau mot de passe:", 100, 300, 250, 20, 20);
            passwordLabel2.get_label().setForeground(new Color(0,94,157));

            JPasswordField passwordField1 = new JPasswordField();
            passwordField1.setBounds(305, 235, 150, 25);
            modifier_mdp.add(passwordField1);

            JPasswordField passwordField2 = new JPasswordField();
            passwordField2.setBounds(325, 300, 150, 25);
            modifier_mdp.add(passwordField2);

            CreateButton ValiderButton=new CreateButton(modifier_mdp,"Valider",380,470,100,20);


           
            CreateButton backbutton=new CreateButton(modifier_mdp,"Retour",20,470,100,20);


            backbutton.createbackbutton(frame.getFrame(),prev_panel);
            ValiderButton.get_button().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String cin=CIN.get_textfield().get_textfield().getText();
                    String amdp=new String(passwordField1.getPassword());
                    String nmdp=new String(passwordField2.getPassword());
                    if(cin.length()!=8){
                        frame.CreateErrorFrame("CIN est invalide");
                    }
                    else{
                    try {
                        // Connect to the database
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");

                        String checkQuery = "SELECT * FROM administrateur WHERE CIN = ? AND mot_de_passe=?";
                        PreparedStatement checkStmt = con.prepareStatement(checkQuery);
                        checkStmt.setString(1, cin);
                        checkStmt.setString(2,amdp);
                        ResultSet checkResult = checkStmt.executeQuery();
                        if (checkResult.next()) {
                        
                        // Update the password for the given CIN
                        String query="UPDATE administrateur set mot_de_passe=? WHERE CIN=?";
                            PreparedStatement pstmt = con.prepareStatement(query);
                            pstmt.setString(1,nmdp);
                            pstmt.setString(2,cin);
                            pstmt.executeUpdate();
                            frame.CreateSuccessFrame("Modification est compléte");
                            pstmt.close();
                        }
                        else{
                            frame.CreateErrorFrame("Cet admin n'éxiste pas");
                        }
                    
                
                        // Close the database connection
                        checkResult.close();
                        checkStmt.close();
                        con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                }
                }
            });

            frame.add_panel(modifier_mdp);
        }
    });
}

void CreateJPanel_Modifier_mdp2(CreateFrame frame,JPanel prevpanel){

    button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.getFrame().remove(prevpanel); 

            JPanel modifier_mdp = new JPanel();
            modifier_mdp.setLayout(null);

            CreateJlabel title = new CreateJlabel(modifier_mdp,"Modifier mot de passe",130,10,400,50,25);
            title.get_label().setForeground(new Color(0,94,157));

        CreateJlabel_textfield CIN=new CreateJlabel_textfield(modifier_mdp,"CIN:",100,170,100,20,20,"",140,170,150,25);
        CIN.get_label().setForeground(new Color(0,94,157));

            CreateJlabel passwordLabel = new CreateJlabel(modifier_mdp,"Nouveau mot de passe:", 100, 300, 250, 20, 20);
            passwordLabel.get_label().setForeground(new Color(0,94,157));

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(325, 300, 150, 25);
            modifier_mdp.add(passwordField);

            CreateButton ValiderButton=new CreateButton(modifier_mdp,"Valider",380,470,100,20);


            CreateButton backbutton=new CreateButton(modifier_mdp,"Retour",20,470,100,20);
  

            backbutton.createbackbutton(frame.getFrame(), prevpanel);
            ValiderButton.get_button().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String cin=CIN.get_textfield().get_textfield().getText();
                    String mdp=new String(passwordField.getPassword());
                    if(cin.length()!=8){
                        frame.CreateErrorFrame("CIN est invalide");
                    }
                    else{
                    try {
                        // Connect to the database
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");

                        String checkQuery = "SELECT * FROM super_admin WHERE CIN = ?";
                        PreparedStatement checkStmt = con.prepareStatement(checkQuery);
                        checkStmt.setString(1, cin);
                        ResultSet checkResult = checkStmt.executeQuery();
                        if (checkResult.next()) {
                            String query="UPDATE super_admin set mot_de_passe=? ";
                            PreparedStatement pstmt = con.prepareStatement(query);
                            pstmt.setString(1,mdp);
                            pstmt.executeUpdate();
                            frame.CreateSuccessFrame("Modification est compléte");
                            pstmt.close();
                        }else{

                        // Check if the given CIN exists in the table
                        checkQuery = "SELECT * FROM administrateur WHERE CIN = ?";
                        checkStmt = con.prepareStatement(checkQuery);
                        checkStmt.setString(1, cin);
                        checkResult = checkStmt.executeQuery();
                        if (checkResult.next()) {
                        
                        // Update the password for the given CIN
                        String query="UPDATE administrateur set mot_de_passe=?";
                            PreparedStatement pstmt = con.prepareStatement(query);
                            pstmt.setString(1,mdp);
                            pstmt.executeUpdate();
                            frame.CreateSuccessFrame("Modification est compléte");
                            pstmt.close();
                        }
                        else{
                            frame.CreateErrorFrame("Cet admin n'éxiste pas");
                        }
                    }
                
                        // Close the database connection
                        checkResult.close();
                        checkStmt.close();
                        con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                }     
                }
            });

            frame.add_panel(modifier_mdp);
        }
    });
}

void CreateJPanel_Supprimer_Admin(CreateFrame frame,JPanel prevpanel){
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            frame.getFrame().remove(prevpanel);
            JPanel supprimer_admin = new JPanel();
            supprimer_admin.setLayout(null);
            frame.add_panel(supprimer_admin);

            CreateJlabel title = new CreateJlabel(supprimer_admin,"Supprimer Admin",150,10,400,50,25);
            title.get_label().setForeground(new Color(0,94,157));

        CreateJlabel_textfield CIN=new CreateJlabel_textfield(supprimer_admin,"CIN:",150,220,100,20,20,"",190,220,150,25);
        CIN.get_label().setForeground(new Color(0,94,157));

            CreateButton ValiderButton=new CreateButton(supprimer_admin,"Valider",380,470,100,20);

            
            CreateButton backbutton=new CreateButton(supprimer_admin,"Retour",20,470,100,20);


            backbutton.createbackbutton(frame.getFrame(), prevpanel);
            ValiderButton.get_button().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String cin=CIN.get_textfield().get_textfield().getText();
                    if(cin.length()!=8){
                        frame.CreateErrorFrame("CIN est invalide");
                    }
                    else{
                    try {
                        // Connect to the database
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Administrateur WHERE CIN=?");
                        pstmt.setString(1,cin);
                        ResultSet rs =pstmt.executeQuery();   
                        if(rs.next()){
                            pstmt=con.prepareStatement("DELETE FROM Administrateur WHERE CIN=?");
                            pstmt.setString(1,cin);
                            pstmt.executeUpdate();
                            frame.CreateSuccessFrame("La suppression est compléte");
                        }   
                        else{
                            frame.CreateErrorFrame("Cet admin n'éxiste pas");
                        }   
                        
                        pstmt.close();
                        con.close();
                    }
             catch (Exception ex) {
                ex.printStackTrace();
             }
            }
        }
        });

         }
    });
}

void CreateJPanel_Ajouter_Admin(CreateFrame frame,JPanel prevpanel){
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            frame.getFrame().remove(prevpanel);
            JPanel ajouter_admin = new JPanel();
            ajouter_admin.setLayout(null);
            frame.add_panel(ajouter_admin);

            CreateJlabel title = new CreateJlabel(ajouter_admin,"Ajouter Admin",170,10,400,50,25);
            title.get_label().setForeground(new Color(0,94,157));

        CreateJlabel_textfield CIN=new CreateJlabel_textfield(ajouter_admin,"CIN:",100,170,100,20,20,"",140,170,150,25);
        CIN.get_label().setForeground(new Color(0,94,157));

            CreateJlabel passwordLabel = new CreateJlabel(ajouter_admin,"Mot de passe:", 100, 300, 250, 20, 20);
            passwordLabel.get_label().setForeground(new Color(0,94,157));

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(235, 300, 150, 25);
            ajouter_admin.add(passwordField);

            CreateButton ValiderButton=new CreateButton(ajouter_admin,"Valider",380,470,100,20);
  
           
            CreateButton backbutton=new CreateButton(ajouter_admin,"Retour",20,470,100,20);


            backbutton.createbackbutton(frame.getFrame(),prevpanel);
            ValiderButton.get_button().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String cin=CIN.get_textfield().get_textfield().getText();
                    String mdp=new String(passwordField.getPassword());
                    int i=0;
                    try{
                        int icin=Integer.parseInt(cin);
                        if(icin<=0 || cin.length()!=8){
                            i++;
                        }
                    }catch(NumberFormatException a){
                        i++;
                    }
                    if(i!=0){
                        frame.CreateErrorFrame("CIN est invalide");
                    }
                    else{
                    try {
                        // Connect to the database
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");
                        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Administrateur WHERE CIN=?");
                        pstmt.setString(1, cin);
                        ResultSet rs=pstmt.executeQuery();
                        if(!rs.next()){
                        pstmt = con.prepareStatement("INSERT INTO Administrateur (CIN,Mot_de_passe) VALUES (?, ?)");
                        pstmt.setString(1,cin);
                        pstmt.setString(2,mdp);
                        pstmt.executeUpdate();         
                        frame.CreateSuccessFrame("L'ajout est complet");
                        }
                        else{
                            frame.CreateErrorFrame("Cet admin éxiste déja");
                        }
                        pstmt.close();
                        con.close();
                    }
             catch (Exception ex) {
                ex.printStackTrace();
             }
            }
        }
            });

        
        }
    });
}

void create_panel_min_max(CreateFrame frame,String Query){
    try {
        frame.getFrame().remove(panel);

        JPanel panel_Min_Max = new JPanel();
            panel_Min_Max.setLayout(new FlowLayout(FlowLayout.CENTER));
        // Connect to the database

        Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etat_civil", "root", "");

        // Execute the SQL query
        String query = Query;

        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        // Convert the ResultSet to a JTable
        ResultSetMetaData metaData = rs.getMetaData();

        // Get the number of columns in the result set
        int columnCount = metaData.getColumnCount();
    
        // Create a new DefaultTableModel with the correct number of columns
        DefaultTableModel tableModel = new DefaultTableModel(columnCount, 0);
    
        // Add the column names to the table model
        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(metaData.getColumnLabel(i));
        }
    
        // Add the rows to the table model
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(row);
        }
    
        // Create a new JTable with the table model
        JTable table = new JTable(tableModel);
    
        // Set some properties on the table
        table.setFillsViewportHeight(true);
        // Add the JTable to a JScrollPane and add the JScrollPane to the JPanel
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getFrame().setLocation(200, 200);
        frame.getFrame().setSize(1000, 200);
        panel_Min_Max.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(900, 119));
        JButton backbutton=new JButton("retour");
        backbutton.setBackground(new Color(0, 94, 157));
        backbutton.setForeground(Color.WHITE);
        panel_Min_Max.add(backbutton);
        backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Remove the form panel from the frame
                frame.getFrame().getContentPane().remove(panel_Min_Max);
                frame.getFrame().setLocation(400, 100);
                // Add the old panel back to the frame
                frame.getFrame().getContentPane().add(panel);
    
                // Repaint the frame
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
                frame.getFrame().setSize(520,539);
            }
        });
        frame.add_panel(panel_Min_Max);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

void create_scroll(CreateFrame frame){

    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            UIManager.put("OptionPane.background", Color.WHITE);
            UIManager.put("Button.background", Color.WHITE);
            UIManager.put("Button.foreground", new Color(0, 94, 157));

            String[] options = {"Min", "Max"};
            int minMaxChoice = JOptionPane.showOptionDialog(null, "                             Min ou Max ?", "Min/Max",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
            String[] naissanceDecesOptions = {"Naissance", "Décès"};
            int naissanceDecesChoice = JOptionPane.showOptionDialog(null, "                   Naissance ou Décès ?", "Naissance/Décès",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, naissanceDecesOptions, naissanceDecesOptions[0]);
    
            // Depending on the user's choices, do the appropriate actions to display the information.
    
            if (minMaxChoice == 0 && naissanceDecesChoice == 0) {
                 create_panel_min_max(frame,"SELECT Nom, Prénom, Date_de_naissance, Lieu_de_naissance, Nombre_de_retrait_total " +
                 "FROM Naissance WHERE nombre_de_retrait_total = (SELECT MIN(nombre_de_retrait_total) FROM Naissance)");
            }
                else if (minMaxChoice == 1 && naissanceDecesChoice == 0) {
               create_panel_min_max(frame, "SELECT Nom, Prénom, Date_de_naissance, Lieu_de_naissance, Nombre_de_retrait_total " +
               "FROM Naissance WHERE nombre_de_retrait_total = (SELECT MAX(nombre_de_retrait_total) FROM Naissance)");
            } else if (minMaxChoice == 0 && naissanceDecesChoice == 1) {
               create_panel_min_max(frame,"SELECT Nom, Prénom, Date_de_décès, Lieu_de_décès, Nombre_de_retrait_total " +
               "FROM Décès WHERE nombre_de_retrait_total = (SELECT MIN(nombre_de_retrait_total) FROM Décès)");
            } else if (minMaxChoice == 1 && naissanceDecesChoice == 1) {
               create_panel_min_max(frame,"SELECT Nom, Prénom, Date_de_décès, Lieu_de_décès, Nombre_de_retrait_total " +
               "FROM Décès WHERE nombre_de_retrait_total = (SELECT MAX(nombre_de_retrait_total) FROM Décès)");
            }
  
        }
    });

}

}
