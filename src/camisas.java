import java.io.IOException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class camisas {

	private static final Scanner s = new Scanner(System.in);
	private static LinkedList<Camisas> lista;
	public static void main(String[] args) throws IOException{
		ComparaPedidos comparador = new ComparaPedidos();
		int quant = Integer.parseInt(s.nextLine());
		while(quant != 0){
			lista = new LinkedList<Camisas>();
			for(int x = 0; x < quant; x++){
				Camisas camisas = new Camisas();
				String nomeAluno = s.nextLine();
				String corETamanho = s.nextLine();
				String[] caractere = corETamanho.split(" ");
				camisas.setAluno(nomeAluno);
				camisas.setCorCamisa(caractere[0]);
				camisas.setTamanho(caractere[1]);
				lista.add(camisas);
			}
			quant = Integer.parseInt(s.nextLine());
			Collections.sort(lista, comparador);
			for(Camisas i: lista){
				System.out.println(i);
			}
			if(quant != 0){
				System.out.println("");
			}
		}
	}

	private static class Camisas{
		private String aluno;
		private String corCamisa;
		private String tamanho;

		public Camisas(){
			this.aluno = null;
			this.corCamisa = null;
			this.tamanho = null;
		}

		public String getAluno(){
			return this.aluno;
		}

		public void setAluno(String aluno){
			this.aluno = aluno;
		}

		public String getCorCamisa(){
			return this.corCamisa;
		}

		public void setCorCamisa(String corCamisa){
			this.corCamisa = corCamisa;
		}

		public String getTamanho(){
			return this.tamanho;
		}

		public void setTamanho(String tamanho){
			this.tamanho = tamanho;
		}

		public String toString() {
			return this.corCamisa + " " + this.tamanho + " " + this.aluno;
		}
	}

	private static class ComparaPedidos implements Comparator<Camisas>{
		public int compare(Camisas primeira, Camisas segunda) {
			int x = primeira.getCorCamisa().compareTo(segunda.getCorCamisa());
			if (x != 0){
				return x;
			}
			x = primeira.getTamanho().compareTo(segunda.getTamanho());
			if (x != 0){
				if (x < 0){
					return 1;
				} else{
					return -1;
				}
			}

			return primeira.getAluno().compareTo(segunda.getAluno());
		}
	}

}
