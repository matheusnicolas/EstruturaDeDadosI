import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class tradeCards {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int cartasDeAlice, cartasDeBeatriz;

		String comparar = "";
		while (!comparar.equalsIgnoreCase("0 0")) {
			String entrada = s.nextLine();
			comparar = entrada;
			int pegaEspaco = entrada.indexOf(" ");
			cartasDeAlice = Integer.parseInt(entrada.substring(0, pegaEspaco));
			cartasDeBeatriz = Integer.parseInt(entrada.substring(pegaEspaco + 1));
			int quantTrocas = 0;
			if (!(cartasDeAlice < 1 || cartasDeAlice > 10000 || cartasDeBeatriz < 1 || cartasDeBeatriz > 10000)) {
				int[] cartasAlice = new int[cartasDeAlice + 1];
				entrada = s.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(entrada, " ");
				for (int x = 0; x < cartasDeAlice; x++) {
					cartasAlice[x] = Integer.parseInt(tokenizer.nextToken());
				}
				cartasAlice[cartasDeAlice] = -1;
				if (cartasAlice[0] < 1 || cartasAlice[cartasDeAlice - 1] > 100000) {
					break;
				}
				int[] cartasBeatriz = new int[cartasDeBeatriz + 1];
				entrada = s.nextLine();

				StringTokenizer tokenizer2 = new StringTokenizer(entrada, " ");
				for (int x = 0; x < cartasDeBeatriz; x++) {
					cartasBeatriz[x] = Integer.parseInt(tokenizer2.nextToken());
				}
				cartasBeatriz[cartasDeBeatriz] = -1;
				if (cartasBeatriz[0] < 1 || cartasAlice[cartasDeAlice - 1] > 100000) {
					break;
				}
				boolean cartaRepetida;
				int cartasRepetidasAlice = 0;
				int cartasRepetidasBeatriz = 0;
				for (int x = 0; x < cartasDeAlice; x++) {
					if (cartasRepetidasAlice == (cartasDeAlice) || cartasRepetidasBeatriz == (cartasDeBeatriz)) {
						break;
					}
					cartaRepetida = false;
					if (cartasAlice[x] != cartasAlice[x + 1]) {
						for (int i = 0; i < cartasDeBeatriz; i++) {
							if (cartasAlice[x] < cartasBeatriz[i]) {
								break;
							}
							if (cartasAlice[x] == cartasBeatriz[i]) {
								cartaRepetida = true;
								cartasRepetidasAlice++;
								break;
							}
						}
						if (!cartaRepetida) {
							for (int c = cartasRepetidasBeatriz; c < cartasDeBeatriz; c++) {
								cartaRepetida = false;
								if (cartasBeatriz[c] != cartasBeatriz[c + 1]) {
									for (int d = 0; d < cartasDeAlice; d++) {
										if (cartasBeatriz[c] < cartasAlice[d]) {
											break;
										}
										if (cartasBeatriz[c] == cartasAlice[d]) {
											cartaRepetida = true;
											cartasRepetidasBeatriz++;
											break;
										}
									}
									if (!cartaRepetida) {
										cartasRepetidasAlice++;
										cartasRepetidasBeatriz++;
										quantTrocas++;
										break;
									}

								} else if (cartasBeatriz[c] == cartasBeatriz[c + 1]) {
									cartasRepetidasBeatriz++;
								}
							}
						}
					} else if (cartasAlice[x] == cartasAlice[x + 1]) {
						cartasRepetidasAlice++;
					}
				}
			}
			if (!comparar.equalsIgnoreCase("0 0")) {
				System.out.println(quantTrocas);
			}
		}
	}
}
