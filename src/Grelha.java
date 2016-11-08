import java.io.IOException;
 
import java.util.Scanner;

public class Grelha  {
	private static Scanner input = new Scanner(System.in);
	private static String colunaLetras = "ABCDEFGH";

	
	public static void main(String[] args) throws IOException{
		String [][] tabuleiro = new String[8][8];
		
		int contador = 0;
		String posicaoCavalo = input.nextLine();
		
		while(!posicaoCavalo.equalsIgnoreCase("0")){
			zeraTabuleiro(tabuleiro);
			
			int coordenadaNumero = Integer.parseInt(posicaoCavalo.substring(0,1)) - 1;
			int coordenadaLetra = colunaLetras.indexOf(posicaoCavalo.substring(1).toUpperCase());
			tabuleiro[coordenadaNumero][coordenadaLetra] = "cavalo";
			lerPeoes(tabuleiro);
			System.out.println("Caso de Teste #" + (++contador) + ": " + contadorJogadas(tabuleiro, coordenadaNumero, coordenadaLetra) + " movimento(s).");
			posicaoCavalo = input.nextLine();
		}
	}
	
	
	private static void lerPeoes(String[][] vetor){
		for(int i = 0; i < 8; i++){
			String posicaoPeao = input.nextLine();
			int coordenadaNumero = Integer.parseInt(posicaoPeao.substring(0,1)) - 1;
			int coordenadaLetra = colunaLetras.indexOf(posicaoPeao.substring(1).toUpperCase());
			if((coordenadaNumero > 0) && (coordenadaLetra - 1 >= 0)){
				vetor[coordenadaNumero - 1][coordenadaLetra - 1] = "a";
			}if((coordenadaNumero > 0) && (coordenadaLetra + 1 <= 7)){
				vetor[coordenadaNumero - 1][coordenadaLetra + 1] = "a";
			}
		}
	}
	private static int contadorJogadas(String[][] vetor, int cNumero, int cLetra){
		int contador = 0;
		int [] numeros = new int[]{cNumero + 1, cNumero + 1, cNumero - 1, cNumero - 1, cNumero + 2, cNumero + 2, cNumero - 2, cNumero - 2};
		int [] letras = new int[]{cLetra + 2, cLetra - 2, cLetra + 2, cLetra - 2, cLetra + 1, cLetra - 1, cLetra + 1, cLetra - 1};
		
		for(int i = 0; i < numeros.length; i++){
			int numero = numeros[i];
			int letra = letras[i];
			if((numero >= 0 && numero <= 7) && (letra >= 0 && letra <= 7)){
				if(!vetor[numero][letra].equalsIgnoreCase("a")){
					contador++;
				}
			}
		}
		return contador;
	}
	
	private static void zeraTabuleiro(String[][] vetor){
		for(int i = 0; i < 8; i++){
			for(int k = 0; k < 8; k++){
				vetor[i][k] = "";
			}
		}
	}
}