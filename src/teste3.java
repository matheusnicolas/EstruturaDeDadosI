import java.util.Scanner;
public class teste3 {

	/*String resposta = "";			
	
	for(int x = 0; x < M; x++) {
		int contador = 0;
		resposta += x + " -> ";
		for(int y = 0; y < C; y++) {
			contador++;
			if(enderecosBase[x][y] == 0) {
				resposta += "\\" + "\n";
				break;
			}
			resposta += enderecosBase[x][y] + " -> ";
			if(contador == C) {
				resposta += "\\" + "\n";
			}
		}
	}*/
	private static final Scanner s = new Scanner(System.in);
	public static void main(String[] args){
		String num = s.nextLine();
		String[] caractere = num.split(" ");
		
		for(int x = 0; x < caractere.length; x++){
			System.out.println(caractere[x]);
		}
	}
}
