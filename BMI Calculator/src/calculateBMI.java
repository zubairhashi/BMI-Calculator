
/*
 * Name: Zubair Hashi
 * Description: this program get input from the user and calculates their Body mass index
 * Date: 02/08/2023
 * 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.NumericShaper.Range;
import java.awt.print.Printable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class calculateBMI {

	private JFrame frame;
	private JTextField heightinFeet;
	private JTextField heightinInches;
	private JTextField weight;
	private JLabel poundsLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculateBMI window = new calculateBMI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calculateBMI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public int h1;
	public int h2;
	public int w1;

	JLabel resultsLabel1 = new JLabel("");
	JLabel resultsLabel2 = new JLabel("");


	public void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1354, 796);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);



		// Jtextfields in with users will enter their input

		heightinFeet = new JTextField();
		heightinFeet.setBounds(464, 370, 38, 33);
		frame.getContentPane().add(heightinFeet);
		heightinFeet.setColumns(10);


		heightinFeet.addKeyListener(new KeyAdapter() {
			@Override

			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				int length = heightinFeet.getText().length();

				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {

					e.consume(); // if it's not a number, ignore the event

				}else if (length > 0) {
					e.consume(); //makes sure numbers entered for the feet is not more than 1 number
				}

			}

		});






		heightinInches = new JTextField();
		heightinInches.setBounds(580, 370, 38, 33);
		frame.getContentPane().add(heightinInches);
		heightinInches.setColumns(10);


		heightinInches.addKeyListener(new KeyAdapter() {
			@Override

			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				int length = heightinInches.getText().length();


				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {

					e.consume(); // if it's not a number, ignore the event

				}else if (length > 1) {
					e.consume(); //makes sure numbers entered for the inches is not more than 2 numbers
				}





			}

		});





		weight = new JTextField();
		weight.setBounds(487, 581, 108, 33);
		frame.getContentPane().add(weight);
		weight.setColumns(10);

		// Labels that display all the labels on the program

		JLabel header = new JLabel("Body mass index Calculator\r\n");
		header.setFont(new Font("Tahoma", Font.BOLD, 36));
		header.setBounds(391, 63, 516, 64);
		frame.getContentPane().add(header);

		JLabel feetLabel = new JLabel("Feet\r\n");
		feetLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		feetLabel.setBounds(461, 422, 51, 23);
		frame.getContentPane().add(feetLabel);

		JLabel inchesLabel = new JLabel("Inches");
		inchesLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		inchesLabel.setBounds(569, 422, 79, 23);
		frame.getContentPane().add(inchesLabel);

		JLabel heightLabel = new JLabel("Your Height: ");
		heightLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		heightLabel.setBounds(270, 359, 150, 44);
		frame.getContentPane().add(heightLabel);

		JLabel weightLabel = new JLabel("Your weight: ");
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		weightLabel.setBounds(281, 570, 150, 44);
		frame.getContentPane().add(weightLabel);

		JLabel bmicateLabel = new JLabel("<html>"
				+ "BMI Categories:<br/><br/>Underweight = <18.5 <br/>Normal weight = 18.5\u201324.9<br/>Overweight = 25\u201329.9<br/>Obesity = BMI of 30 or greater"
				+ "</html>");
		bmicateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bmicateLabel.setBounds(903, 211, 318, 268);
		frame.getContentPane().add(bmicateLabel);

		poundsLabel = new JLabel("Pounds (lbs)");
		poundsLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		poundsLabel.setBounds(487, 625, 134, 23);
		frame.getContentPane().add(poundsLabel);




		// Button that calculates the BMI (with action listener)

		JButton calculateButton = new JButton("Calculate \r\n");
		calculateButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		calculateButton.setBounds(502, 710, 142, 44);
		frame.getContentPane().add(calculateButton);



		calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int secondNumber = 0;

				try {

					h1 = Integer.parseInt(heightinFeet.getText());

					h2 = Integer.parseInt(heightinInches.getText());

					w1 = Integer.parseInt(weight.getText());


			} catch (NumberFormatException ex) {
		

			}
				


			display(BMI(), category());


		}
	});


		//Button that clears all the values for the input jtextfields and results labels
		JButton clearButton = new JButton("Clear values");
		clearButton.setBounds(230, 718, 108, 33);

		frame.getContentPane().add(clearButton);


		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				heightinFeet.setText("");
				heightinInches.setText("");
				weight.setText("");


			}
		});



		// This button redirects users to a website where they could learn more information about BMI

		JButton learnmoreButton = new JButton("Click Here to Learn More about BMI");
		learnmoreButton.setBounds(1034, 723, 283, 23);
		frame.getContentPane().add(learnmoreButton);


		learnmoreButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				bmiwebsite b = new bmiwebsite();
				try {
					b.website();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});




}

public void checkError() {

	JLabel errMessage = new JLabel("Please Enter Valid Numbers");
	errMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
	errMessage.setForeground(new Color(255, 0, 0));
	errMessage.setBounds(681, 390, 174, 33);
	errMessage.setVisible(true);
	frame.getContentPane().add(errMessage);


}



public void display(double x, String y) {


	resultsLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	resultsLabel1.setBounds(786, 604, 400, 47);
	frame.getContentPane().add(resultsLabel1);

	resultsLabel1.setText("Your BMI is: " + x); 

	

	resultsLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	resultsLabel2.setBounds(786, 700, 400, 47);
	frame.getContentPane().add(resultsLabel2);

	resultsLabel2.setText("This is considered: " + y);
	
	if (heightinFeet.getText().isEmpty() || heightinInches.getText().isEmpty() || weight.getText().isEmpty()) {
		resultsLabel1.setText(""); 
		resultsLabel2.setText("");
	}


}

public double BMI() {

	double BMI = (w1 / Math.pow((h1 * 12) + h2, 2)) * 703;

	return BMI;
}




public String category() {

	String category = null;

	if (BMI() < 18.5 ) {
		category = "underweight";	
	}else if (BMI()>= 18.5 && BMI()<= 24.9) {
		category = "normal weight";
	}else if (BMI()>= 25 && BMI()<=29.9) {
		category = " overweight";
	}else {
		category = " obese";
	}

	return category;

}


}
