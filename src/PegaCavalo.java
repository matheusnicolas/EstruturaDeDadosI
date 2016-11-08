import java.io.IOException;
import java.util.Scanner;
public class PegaCavalo {
	
	private static String tabuleiroLetras = "abcdefgh";
	private static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		
		int contador = 0;
		
		String[][] tabuleiroXadrez = new String[8][8];
		String entradaCavalo = s.nextLine();
		boolean condicao = true;
		
		while(condicao){
			tabuleiroXadrez = atualizaTabuleiro(tabuleiroXadrez);
			
			int posicaoNumerica = Integer.parseInt(entradaCavalo.substring(0, 1)) - 1;
			int posicaoLetra = tabuleiroLetras.indexOf(entradaCavalo.substring(1, 2).toLowerCase());
			preencherPeoes(tabuleiroXadrez);
			System.out.println("Caso de Teste #" + (contador + 1) + ": " + contaJogadas(tabuleiroXadrez, posicaoNumerica, posicaoLetra) + " movimento(s).");
			entradaCavalo = s.nextLine();
			if(entradaCavalo.equalsIgnoreCase("0")){
				condicao = false;
			}
		}
		
		
	}
	
	public static String[][] atualizaTabuleiro(String[][] tabuleiroXadrez){
		for(int x = 0; x < 8; x++ ){
			for(int x2 = 0; x2 < 8; x2++){
				tabuleiroXadrez[x][x2] = "";
			}
		}
		return tabuleiroXadrez;
	}
	
	public static void preencherPeoes(String[][] tabuleiroPeoes){
		for(int x = 0; x < 8; x++){
			String peao = s.nextLine();
			
			int posicaoNumerica = Integer.parseInt(peao.substring(0,1)) - 1;
			int posicaoLetra = tabuleiroLetras.indexOf(peao.substring(1,2).toLowerCase());
			
			if((posicaoNumerica > 0) && (posicaoLetra - 1 >= 0)){
				tabuleiroPeoes[posicaoNumerica - 1][posicaoLetra - 1] = "P";
			
			}if((posicaoNumerica > 0) && (posicaoLetra + 1 <= 7)){
				tabuleiroPeoes[posicaoNumerica - 1][posicaoLetra + 1] = "P";
			}
		}
	}
	
	public static int contaJogadas(String[][] tabuleiro, int coordenadaNumero, int coordenadaLetra){
		
		int [] numerosTabuleiro = new int[]{coordenadaNumero + 1, coordenadaNumero + 1, coordenadaNumero - 1, coordenadaNumero - 1, coordenadaNumero + 2, coordenadaNumero + 2, coordenadaNumero - 2, coordenadaNumero - 2};
		int [] letrasTabuleiro = new int[]{coordenadaLetra + 2, coordenadaLetra - 2, coordenadaLetra + 2, coordenadaLetra - 2, coordenadaLetra + 1, coordenadaLetra - 1, coordenadaLetra + 1, coordenadaLetra - 1};
		int contador = 0;
		for(int i = 0; i < numerosTabuleiro.length; i++){
			int numero = numerosTabuleiro[i];
			int letra = letrasTabuleiro[i];
			if((numero >= 0 && numero <= 7) && (letra >= 0 && letra <= 7)){
				if(!tabuleiro[numero][letra].equalsIgnoreCase("P")){
					contador++;
				}
			}
		}
		return contador;
	}
	
}