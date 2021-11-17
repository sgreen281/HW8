
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
import java.util.Random;

public class GuessingGame implements ActionListener{
  JTextField userGuess;
  JButton guessButton;
  JButton playAgain;
  JLabel lblGuess;
  JLabel lblAnswer;
  JLabel lblLastGuess;
  int storeRandom;
  Random r;


  GuessingGame(){
    r = new Random();
    storeRandom = r.nextInt(100) +1;


    JFrame frame  = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);  

// Then, we need to set up the text field where the user will type in their guess:
// Initialize your userGuess field to be a new JTextField with size 10
// Set the action command for your userGuess field to be "myTF"

    userGuess = new JTextField(10);


    guessButton = new JButton("Button");
    playAgain = new JButton("Play Again");

    // Add action listeners to your userGuess text field, guessButton, and playAgainButton
    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgain.addActionListener(this);


  // Then we set up the three labels:


    lblGuess = new JLabel("Enter your guess: ");
    lblAnswer = new JLabel(" ");
    lblLastGuess = new JLabel(" ");


// first, the prompt to tell the user to enter a guess, then the userGuess text field, then the guessButton, then whether the user was too high or too low, then what the last guess was, then the playAgainButton

  frame.add(lblGuess);
  frame.add(userGuess);
  frame.add(guessButton);
  frame.add(lblAnswer);
  frame.add(lblLastGuess);
  frame.add(playAgain);

  frame.setVisible(true);

  }


      public void actionPerformed(ActionEvent myTF){
      int guess = Integer.parseInt(userGuess.getText());
      if(myTF.getActionCommand().equals("Button")){
      if (guess == storeRandom){
      lblAnswer.setText("You got it");
      }
      else if (guess > storeRandom){
        lblAnswer.setText("Too high!");
      }
      else{
        lblAnswer.setText("Too low!");
      }
      lblLastGuess.setText("Last Guess was " + guess);

      }
      else if(myTF.getActionCommand().equals("Play Again")){
        lblAnswer.setText(" ");
        lblLastGuess.setText(" ");
        userGuess.setText("");
        r = new Random();
        storeRandom = r.nextInt(100) +1;

      }
      else{
        JOptionPane.showMessageDialog(null, "You pressed Enter. Please press the Guess Button.");
      }
      }
      

      

      
  

}