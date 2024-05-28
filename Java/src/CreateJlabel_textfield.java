import javax.swing.*;

public class CreateJlabel_textfield extends CreateJlabel {

    private CreateJTextField textfield;

   CreateJlabel_textfield(JPanel panel,String label_name,int x,int y,int width,int height,int size,String textfield_name,int xt,int yt,int widtht,int heightt){
   super(panel,label_name,x,y,width,height,size);
   textfield=new CreateJTextField(panel,textfield_name,xt,yt,widtht,heightt);
    
   }
   CreateJTextField get_textfield(){
    return(textfield);
   }
    
}
