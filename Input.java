import java.util.Scanner;

public class Input {
	private Scanner input;
	
	public Input() {
		input= new Scanner(System.in);
	}
	
	public int inputLevel() {
		return input.nextInt();
	}
	
	public int[] inputShoot() {
		System.out.print("Where do you wish to shoot?\n");
		System.out.print("Row:");
		int a = input.nextInt();
		System.out.print("Column:");
		int b = input.nextInt();
		int[] coordinate = {a,b};
		return coordinate;
	}
	
	public String inputName() {
		System.out.print("What is your name?\n");
		return input.nextLine();
	}

}
