import javax.swing.*;



public class CreateJTextField {


   private JTextField textfield;
   private JPanel panel;
   private String textfield_name;
   private int x;
   private int y;
   private int width;
   private int height;
    
   CreateJTextField(JPanel panel,String textfield_name,int x,int y,int width,int height){
    textfield=new JTextField(textfield_name);
    this.panel=panel;
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
    panel.add(textfield);
    textfield.setBounds(x, y, width, height);
   }
   CreateJTextField(){
    textfield=new JTextField();
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

String get_textfield_name(){
    return(textfield_name);
}

JTextField get_textfield(){
    return(textfield);
}

void change_x(int x){
    this.x=x;
    textfield.setBounds(x, y, width, height);
}

void change_y(int y){
    this.y=y;
    textfield.setBounds(x, y, width, height);
}

void change_height(int height){
    this.height=height;
    textfield.setBounds(x, y, width, height);
}

void change_width(int width){
    this.width=width;
    textfield.setBounds(x, y, width, height);
}

void change_name(String textfield_name){
    this.textfield_name=textfield_name;
    textfield.setText(textfield_name);
}

void change_all(int x, int y, int width, int height){
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
    textfield.setBounds(x, y, width, height);
}


void change_all(String textfield_name,int x, int y, int width, int height){
    this.textfield_name=textfield_name;
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
    textfield.setText(textfield_name);
    textfield.setBounds(x, y, width, height);
}


    
}
