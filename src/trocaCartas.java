
import java.util.Scanner;

public class trocaCartas {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		String compara = "";
		while (!compara.equals("0 0")) {
			String recebe = entrada.nextLine();
			compara = recebe;
			String[] repartir = recebe.split(" ");
			int numCartasA = Integer.parseInt(repartir[0]);
			int numCartasB = Integer.parseInt(repartir[1]);
			int trocas = 0;
			if (!(numCartasA < 1 || numCartasA > 10000 || numCartasB < 1 || numCartasB > 10000)){
				int[] cartasA = new int[numCartasA+1];
				recebe = entrada.nextLine();
				repartir = recebe.split(" ");
				for (int k = 0; k < numCartasA; k++) {
					cartasA[k] = Integer.parseInt(repartir[k]);
				} 
				cartasA[numCartasA] = -1;
				if (cartasA[0] < 1 || cartasA[numCartasA - 1] > 100000)
					break;
				int[] cartasB = new int[numCartasB+1];
				recebe = entrada.nextLine();
				repartir = recebe.split(" ");
				for (int k = 0; k < numCartasB; k++) {
					cartasB[k] = Integer.parseInt(repartir[k]);
				} 
				cartasB[numCartasB] = -1; 
				if (cartasB[0] < 1 || cartasA[numCartasA - 1] > 100000)
					break;
				boolean repetida;
				int cartaA =0;
				int cartaB =0;
				for ( int k = 0; k < numCartasA; k++){
					if(cartaA == (numCartasA) || cartaB == (numCartasB)) break;
					repetida = false;
					if (cartasA[k] != cartasA[k+1]){
						for (int y = 0; y < numCartasB; y++ ){
							if (cartasA[k] < cartasB[y])
								break;
							if(cartasA[k] == cartasB[y]){
								repetida = true;
								cartaA++;
								break;
							}
						}
						if(!repetida){
							for( int y = cartaB; y < numCartasB; y++){
								repetida = false;
								if(cartasB[y] != cartasB[y+1]){
									for(int z = 0; z < numCartasA; z++){
										if(cartasB[y] < cartasA[z])
											break;
										if( cartasB[y] == cartasA[z]){
											repetida = true;
											cartaB++;
											break;
										}
									}
									if (!repetida){
										cartaA++;
										cartaB++;
										trocas++;
										break;
									}
								}
								else if (cartasB[y] == cartasB[y+1]) cartaB++;
							}
						}
					}
					else if (cartasA[k] == cartasA[k+1]) cartaA++;
				}
			}
			if(!compara.equalsIgnoreCase("0 0")){
				System.out.println(trocas);
			}
		}
	}

}
