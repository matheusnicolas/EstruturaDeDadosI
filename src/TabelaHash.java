
import java.util.Scanner;
public class TabelaHash {

	private static final Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int testes = Integer.parseInt(s.nextLine());
		
		for(int x = 0; x < testes; x++){
			String entrada = s.nextLine();
			String[] caractere = entrada.split(" ");
			
			int enderecos = Integer.parseInt(caractere[0]);
			int chaves = Integer.parseInt(caractere[1]);
			
			int[][] t = new int[enderecos][chaves];
			
			String k = s.nextLine();
			String[] caractereK = k.split(" ");
			
			for(int i = 0; i < caractereK.length; i++) {
				int convK = Integer.parseInt(caractereK[i]);
				t[convK % enderecos][i] = convK;

			}
			String resposta = "";
			for (int i = 0; i < enderecos; i++) {
				int contador = 0;
				resposta += i + " -> ";
				for (int y = 0; y < chaves; y++) {
					contador++;
					if (t[i][y] == 0) {
						resposta += "\\" + "\n";
						break;
					}
					resposta += t[i][y] + " -> ";
					if (contador == chaves) {
						resposta += "\\" + "\n";
					}
				}
			}

			System.out.println(resposta);

		}
	}
}
