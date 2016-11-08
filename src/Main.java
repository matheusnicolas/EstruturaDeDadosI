import java.io.IOException;
import java.util.Scanner;

public class Main{
	
	private static final Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws IOException{

		
		String entrada = s.nextLine();
		String entrada2 = s.nextLine();
		String[] caractere = entrada.split(" ");
		String[] caractere2 = entrada2.split(" ");
		int x = Integer.parseInt(caractere[1]);
		double y = Double.parseDouble(caractere[2]);
		int z = Integer.parseInt(caractere2[1]);
		double w = Double.parseDouble(caractere2[2]);
		
		double total = (x * y) + (z * w);
		System.out.printf("%d", (double)total);
		

	}
}