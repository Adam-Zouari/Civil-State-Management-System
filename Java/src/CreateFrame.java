import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateFrame {
 
    private JFrame frame;

    CreateFrame(String frame_name) {
        frame = new JFrame(frame_name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(560, 539);
    }


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    void add_panel(JPanel panel){
         frame.getContentPane().add(panel);
             frame.revalidate();
             frame.repaint();
    }

    void CreateErrorFrame(String s){
        JFrame errorFrame = new JFrame("Error");
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                errorFrame.setResizable(false);
                errorFrame.setPreferredSize(new Dimension(300, 170));
                int mainFrameX = frame.getX();
                int mainFrameY = frame.getY();
                int mainFrameWidth = frame.getWidth();
                int mainFrameHeight = frame.getHeight();
                int errorFrameWidth = errorFrame.getPreferredSize().width;
                int errorFrameHeight = errorFrame.getPreferredSize().height;
                int errorFrameX = mainFrameX + (mainFrameWidth - errorFrameWidth) / 2;
                int errorFrameY = mainFrameY + (mainFrameHeight - errorFrameHeight) / 2;
                errorFrame.setLocation(errorFrameX, errorFrameY);
                
                // create an error icon label
                JLabel errorIcon = new JLabel("\u26A0", JLabel.CENTER); // Unicode code for warning sign
                errorIcon.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
                errorFrame.add(errorIcon, BorderLayout.NORTH);
                
                // create an error message label
                JLabel errorMessage = new JLabel(s, JLabel.CENTER);
                errorFrame.add(errorMessage, BorderLayout.CENTER);
                
                // create an OK button
                JButton okButton = new JButton("OK");
                okButton.setPreferredSize(new Dimension(51,20));
                okButton.setBackground(Color.WHITE);
                okButton.setForeground(new Color(0,94,157));
                okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    errorFrame.dispose(); // close the error frame when OK is clicked
                }
                });
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(okButton);
                errorFrame.add(buttonPanel, BorderLayout.SOUTH);
                
                // show the error frame
                errorFrame.pack();
                errorFrame.setVisible(true);
                
    }


    void CreateSuccessFrame(String s){
        JFrame SuccessFrame = new JFrame("Succés");
                SuccessFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SuccessFrame.setResizable(false);
                SuccessFrame.setPreferredSize(new Dimension(300, 170));
                int mainFrameX = frame.getX();
                int mainFrameY = frame.getY();
                int mainFrameWidth = frame.getWidth();
                int mainFrameHeight = frame.getHeight();
                int SuccessFrameWidth = SuccessFrame.getPreferredSize().width;
                int SuccessFrameHeight = SuccessFrame.getPreferredSize().height;
                int SuccessFrameX = mainFrameX + (mainFrameWidth - SuccessFrameWidth) / 2;
                int SuccessFrameY = mainFrameY + (mainFrameHeight - SuccessFrameHeight) / 2;
                SuccessFrame.setLocation(SuccessFrameX, SuccessFrameY);
                
                // create an error icon label
                JLabel errorIcon = new JLabel("\u26A0", JLabel.CENTER); // Unicode code for warning sign
                errorIcon.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
                SuccessFrame.add(errorIcon, BorderLayout.NORTH);
                
                // create an error message label
                JLabel errorMessage = new JLabel(s, JLabel.CENTER);
                SuccessFrame.add(errorMessage, BorderLayout.CENTER);
                
                // create an OK button
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SuccessFrame.dispose(); // close the error frame when OK is clicked
                }
                });
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(okButton);
                SuccessFrame.add(buttonPanel, BorderLayout.SOUTH);
                
                // show the error frame
                SuccessFrame.pack();
                SuccessFrame.setVisible(true);
                
    }
}
