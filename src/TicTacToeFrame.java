

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jakub on 10.07.2017.
 */
public class TicTacToeFrame {

    public static class main extends JFrame implements ActionListener {

        private int counter;
        private ArrayList<JButton> buttons = new ArrayList<>();

        public main() {

            setSize(600, 600);
            setVisible(true);
            setTitle("Kółko i krzyżyk");
            setLayout(new GridLayout(3, 3));
            for (int i = 1; i <= 9; ++i) {
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.PLAIN, 100));
                button.setBackground(Color.blue);
                button.addActionListener(this);
                add(button);
                buttons.add(button);
            }
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton button = (JButton) e.getSource();
            if (counter % 2 == 0) {
                button.setText("X");
                System.out.println("X");
            } else {
                button.setText("O");
                System.out.println("O");
            }
            button.setEnabled(false);
            counter++;
            if (isWinner()) {
                JOptionPane.showMessageDialog(null, "Koniec gry");
                setAllDisable();
            } else {
                if (counter == 9)
                    JOptionPane.showMessageDialog(null, "Nie ma zwycięzcy");
            }
        }

        public boolean isWinner() {
            System.out.println(isWinner(0, 1, 2));
            if (isWinner(0, 1, 2))
                return true;
            if (isWinner(3, 4, 5))
                return true;
            if (isWinner(6, 7, 8))
                return true;
            if (isWinner(0, 3, 6))
                return true;
            if (isWinner(1, 4, 7))
                return true;
            if (isWinner(2, 5, 8))
                return true;
            if (isWinner(0, 4, 8))
                return true;
            if (isWinner(2, 4, 6))
                return true;
            return false;

        }

        public void setAllDisable() {

            if (isWinner() == true)
                for (JButton button : buttons)
                    button.setEnabled(false);
        }
        public boolean isWinner(int i, int j, int k) {
            if (buttons.get(i).getText().equals(""))
                return false;
            if (buttons.get(i).getText().equals(buttons.get(j).getText()) && buttons.get(j).getText().equals(buttons.get(k).getText())) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new main();
            }
        });
    }
}

