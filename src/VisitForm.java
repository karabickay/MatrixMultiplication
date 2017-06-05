import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VisitForm extends JFrame {
    private JButton confirm = new JButton("Next");
    private JTextField dimention = new JTextField("", 4);
    private JLabel message = new JLabel("Enter matrix dimention:");

    public VisitForm() {
        this.setBounds(100,100,200,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(message, BorderLayout.WEST);
        container.add(dimention, BorderLayout.EAST);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Matrix matrix = new Matrix(Integer.valueOf(dimention.getText()), true);
                    VisitForm.this.dispose();
                    matrix.setVisible(true);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "You are not enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(confirm, BorderLayout.SOUTH);
    }

    public static void main(String[] args){
        VisitForm form = new VisitForm();
        form.setVisible(true);
    }
}
