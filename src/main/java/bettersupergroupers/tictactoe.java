package bettersupergroupers;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class tictactoe {
  static JFrame _frame;
  static JButton[] _buttons;
  static boolean isPlayerOne;

  public static void main(String[] args) {
    _frame = new JFrame("Tic-Tac-Toe");
    _buttons = new JButton[9];
    isPlayerOne = true;

    _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel _ttt = new JPanel();
	  JPanel _newPanel = new JPanel();

    _ttt.setLayout(new GridLayout(3, 3));
	  _newPanel.setLayout(new FlowLayout());

    _frame.add(_ttt, BorderLayout.NORTH);
	  _frame.add(_newPanel, BorderLayout.SOUTH);

    for (int j=0; j<9; j++) {

        _buttons[j] = new JButton("_");

        ActionListener buttonListener = new ButtonListener();
        _buttons[j].addActionListener(buttonListener);

        _buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));

        _ttt.add(_buttons[j]);
    }

		JButton newGame = new JButton("New Game");
		ActionListener buttonListener = new ButtonListener();
		newGame.addActionListener(buttonListener);
		newGame.setFont(new Font("Courier", Font.PLAIN, 36));
		_newPanel.add(newGame);

    _frame.setSize(400, 400);
    _frame.setVisible(true);
  }
  private static class ButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

      JButton source = (JButton) e.getSource();
      String currentText = source.getText();

      if (currentText.equals("_") && isPlayerOne) {
        source.setText("X");
        isPlayerOne = false;
      } 
      else if (currentText.equals("_") && !isPlayerOne) {
        source.setText("O");
        isPlayerOne = true;
      }
      else if (currentText.equals("New Game")) {
				for (int i = 0; i < 9; i++) {
					_buttons[i].setText("_");
					_buttons[i].setEnabled(true);
					isPlayerOne = true;
				}
			}
    }
  }
}