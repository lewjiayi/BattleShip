import java.util.Scanner;

public class Input {
	private Scanner input;
	
	public Input() {
		input= new Scanner(System.in);
	}
	
	public int inputInt() {
		return input.nextInt();
	}
	
	
	public String inputName() {
		System.out.print("What is your name?\n");
		return input.nextLine();
	}

}
