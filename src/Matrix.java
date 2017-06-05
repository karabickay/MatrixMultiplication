import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Matrix extends JFrame {
    private JButton confirm = new JButton("Next");
    private JLabel message;
    private java.util.List<JTextField> value;
    private boolean first;
    private int dimention;

    public Matrix(int dimention, boolean first) {
        this.dimention = dimention;
        this.first = first;
        this.setBounds(100,100,dimention * 70,dimention * 70 + 20);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        message = new JLabel("Enter matrix " + (first ? "A":"B"), JLabel.CENTER);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(message, BorderLayout.NORTH);
        Container valuesLayout = new Container();
        valuesLayout.setLayout(new GridLayout(dimention, dimention,10,10));
        value = new ArrayList<>();
        for (int i = 0; i < dimention; i++){
            for (int j = 0; j < dimention; j++) {
                JTextField field = new JTextField(String.valueOf(i) + String.valueOf(j));
                field.setHorizontalAlignment(SwingConstants.CENTER);
                value.add(field);
                valuesLayout.add(field);
            }
        }
        container.add(valuesLayout, BorderLayout.CENTER);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setValue();
            }
        });
        container.add(confirm, BorderLayout.SOUTH);
    }

    private void setValue() {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        int i = 0, j = 0;
        try {
            for (i = 0; i < value.size(); i += dimention) {
                ArrayList<Integer> B = new ArrayList<>();
                for (j = 0; j < dimention; j++) {
                    B.add(Integer.valueOf(value.get(j + i).getText()));
                }
                A.add(B);
            }
            if (first) {
                Multiplication.setA(A);
                Matrix matrix = new Matrix(dimention, false);
                Matrix.this.dispose();
                matrix.setVisible(true);
            }
            else {
                Multiplication.setB(A);
                Answer answer = new Answer(dimention);
                Matrix.this.dispose();
                answer.setVisible(true);
            }
        } catch (NumberFormatException ex){
            Border border = BorderFactory.createLineBorder(Color.RED, 5);
            value.get(j + i).setBorder(border);
            JOptionPane.showMessageDialog(null, "You are not enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
