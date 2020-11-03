package controller;

import java.text.DecimalFormat;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainWindowController {
	
	@FXML private Label display;
	@FXML private Button ac_btn, conversion_btn;
	private Main main;
	private Boolean[] operator = new Boolean[4];
	private double[] temporary = {0,0};
	private DecimalFormat df = new DecimalFormat("###.####");
	
	public void setMain(Main main) {
		this.main = main;
		for(int i = 0; i<4;i++) {
			operator[i] = false;
		}
	}
	
	public void operatorPressed(Event event) {
		Button btn = (Button)event.getSource();
		temporary[0] = Double.parseDouble(display.getText());
		switch (btn.getId()) {
			case "plus_btn":
				operator[0] = true;
				break;
			case "minus_btn":
				operator[1] = true;
				break;
			case "times_btn":
				operator[2] = true;
				break;
			case "divide_btn":
				operator[3] = true;
				break;
		}
		display.setText("");
	}
	
	public void buttonPressed(Event event) {
		Button btn = (Button)event.getSource();
		if(display.getText().equals("0")) {
			ac_btn.setText("C");
			display.setText("");
		}
		switch (btn.getId()) {
			case "one_btn":
				display.setText(display.getText()+"1");
				break;
			case "two_btn":
				display.setText(display.getText()+"2");
				break;
			case "three_btn":
				display.setText(display.getText()+"3");
				break;
			case "four_btn":
				display.setText(display.getText()+"4");
				break;
			case "five_btn":
				display.setText(display.getText()+"5");
				break;
			case "six_btn":
				display.setText(display.getText()+"6");
				break;
			case "seven_btn":
				display.setText(display.getText()+"7");
				break;
			case "eight_btn":
				display.setText(display.getText()+"8");
				break;
			case "nine_btn":
				display.setText(display.getText()+"9");
				break;
			case "zero_btn":
				display.setText(display.getText()+"0");
				break;
			case "comma_btn":
				display.setText(display.getText()+".");
				break;
		}
	}
	
	public void delete() {
		ac_btn.setText("AC");
		display.setText("0");
		for(int i = 0; i<2;i++) {
			temporary[i] = 0;
		}
		for(int i = 0; i<4;i++) {
			operator[i] = false;
		}
	}
	
	public void result() {
		double result = 0;
		temporary[1] = Double.parseDouble(display.getText());
		
		if(operator[0]) {
			result = temporary[0] + temporary[1];
		}
		else if(operator[1]) {
			result = temporary[0] - temporary[1];
		}
		else if(operator[2]) {
			result = temporary[0] * temporary[1];
		}
		else if(operator[3]) {
			result = temporary[0] / temporary[1];
		}
		display.setText(df.format(result));
	}
	
	public void conversion() {
		if(!display.getText().equals("0")) {
			Double value = Double.parseDouble(display.getText());
			
			value = value * -1;
			display.setText(df.format(value));
		}
	}
	
	public void percent() {
		Double value = Double.parseDouble(display.getText());
		
		value = value * 0.01;
		display.setText(Double.toString(value));
	}
}
