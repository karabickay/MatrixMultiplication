import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Answer extends JFrame {
    private JButton confirm = new JButton("Another matrix");
    private JLabel message = new JLabel("A * B", JLabel.CENTER);
    private java.util.List<JTextField> value;

    public Answer(int dimention) {
        this.setBounds(100,100,dimention * 70,dimention * 70 + 20);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(message, BorderLayout.NORTH);
        Container values = new Container();
        values.setLayout(new GridLayout(dimention, dimention,10,10));
        int[][] C = Multiplication.multiply();
        for (int i = 0; i < dimention; i++){
            for (int j = 0; j < dimention; j++) {
                JLabel value = new JLabel(String.valueOf(C[i][j]));
                value.setBorder(border);
                value.setHorizontalAlignment(SwingConstants.CENTER);
                value.setVerticalAlignment(SwingConstants.CENTER);
                values.add(value);
            }
        }
        container.add(values, BorderLayout.CENTER);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisitForm form = new VisitForm();
                Answer.this.dispose();
                form.setVisible(true);
            }
        });
        container.add(confirm, BorderLayout.SOUTH);
    }
}