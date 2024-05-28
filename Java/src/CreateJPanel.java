import javax.swing.*;

public class CreateJPanel {
    private CreateFrame frame;
    private JPanel panel;

    CreateJPanel(){
        panel=new JPanel();
        panel.setLayout(null);
    }
    CreateJPanel(CreateFrame frame){
        this.frame=frame;
        panel=new JPanel();
        panel.setLayout(null);
        this.frame.getFrame().getContentPane().add(panel);
    }
    JPanel get_panel(){
        return(panel);
    }

    CreateFrame get_frame(){
        return(frame);
    }


}
    
