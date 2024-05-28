import javax.swing.*;
import java.awt.*;

public class CreateJlabel {

   private JLabel label;
   private JPanel panel;
   private String label_name;
   private int x;
   private int y;
   private int width;
   private int height;
   private int size;
    
   CreateJlabel(JPanel panel,String label_name,int x,int y,int width,int height,int size){
    this.label_name=label_name;
    label=new JLabel(label_name);
    this.panel=panel;
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
    this.size=size;
    label.setBounds(x, y, width, height);
    label.setFont(new Font("Arial", Font.BOLD,this.size));
    panel.add(label);
   }
   
   CreateJlabel(){
    label=new JLabel();
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

String get_label_name(){
    return(label_name);
}

JLabel get_label(){
    return(label);
}

void change_x(int x){
    this.x=x;
    label.setBounds(x, y, width, height);
}

void change_y(int y){
    this.y=y;
    label.setBounds(x, y, width, height);
}

void change_height(int height){
    this.height=height;
    label.setBounds(x, y, width, height);
}

void change_width(int width){
    this.width=width;
    label.setBounds(x, y, width, height);
}

void change_name(String label_name){
    this.label_name=label_name;
    label.setText(label_name);
}

void change_all(int x, int y, int width, int height){
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
    label.setBounds(x, y, width, height);
}


void change_all(String button_name,int x, int y, int width, int height){
    this.label_name=button_name;
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
    label.setText(button_name);
    label.setBounds(x, y, width, height);
}


}
