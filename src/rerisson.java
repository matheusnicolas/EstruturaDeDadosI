import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;

public class rerisson {

	private static final Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		
		int totalAmizades, relacao = 0, grauDeRelacao;
		Amigo[] amigos = new Amigo[1000];
		amigos[relacao++] = new Amigo("Rerisson");
		String entrada = s.nextLine();
		String[] pegaCaractere = entrada.split(" ");
		totalAmizades = Integer.parseInt(pegaCaractere[0]);
		for(int x = 0; x < totalAmizades; x++){
			int amigo, amigo2;
			String entrada2 = s.nextLine();
			String[] pegaCaractere2 = entrada2.split(" ");
			amigo = posicaoAmigo(amigos, relacao, pegaCaractere2[0]);
			amigo2 = posicaoAmigo(amigos, relacao, pegaCaractere2[1]);
			if(amigo < 0){
				amigos[relacao] = new Amigo(pegaCaractere2[0]);
				amigo = relacao++;
			}
			if(amigo2 < 0){
				amigos[relacao] = new Amigo(pegaCaractere2[1]);
				amigo2 = relacao++;
			}
			amigos[amigo].adicionaAmigos(amigos[amigo2]);
			amigos[amigo2].adicionaAmigos(amigos[amigo]);
		}
		grauDeRelacao = Integer.parseInt(pegaCaractere[1]);
		LinkedList<String> todosConvidados = criarRelacaoDeAmigos(amigos, grauDeRelacao);
		Collections.sort(todosConvidados);
		System.out.println(todosConvidados.size());
		for(String s: todosConvidados){
			System.out.println(s);
		}
	}

	public static class Amigo{
		
		private String nome;
		private LinkedList<Amigo> amigos;
		private int relacao;
		private boolean amigoVisitado;
		
		public Amigo(String nome){
			this.nome = nome;
			this.amigos = new LinkedList<Amigo>();
			this.relacao = 0;
			this.amigoVisitado = false;
		}
		
		public String getNome(){
			return this.nome;
		}
		
		public void setNome(String nome){
			this.nome = nome;
		}
		
		public void adicionaAmigos(Amigo a){
			amigos.add(a);
		}
		
		public LinkedList<Amigo> getAmigos(){
			return this.amigos;
		}
		
		public int getRelacao(){
			return this.relacao;
		}
		
		public void setRelacao(int relacao){
			this.relacao = relacao;
		}
		
		public boolean amigoVisitado(){
			return this.amigoVisitado;
		}
		
		public void setAmigoVisitado(boolean amigoVisitado){
			this.amigoVisitado = amigoVisitado;
		}
		
	}
	
	private static int posicaoAmigo(Amigo[] amigos, int relacao, String nome){
		for(int x = 0; x < relacao; x++){
			if(amigos[x].getNome().equalsIgnoreCase(nome)){
				return x;
			}
		}
		return -1;
	}
	
	private static LinkedList<String> criarRelacaoDeAmigos(Amigo[] amigos, int grauDeRelacao){
		LinkedList<String> convidados = new LinkedList<String>();
		LinkedList<Amigo> filaDeAmigos = new LinkedList<Amigo>();
		filaDeAmigos.add(amigos[0]);
		while(filaDeAmigos.size() != 0){
			Amigo amigo = filaDeAmigos.removeFirst();
			if(amigo.getRelacao() < grauDeRelacao){
				for(Amigo a: amigo.getAmigos()){
					if(!a.amigoVisitado){
						a.setAmigoVisitado(true);
						a.setRelacao(amigo.getRelacao()+1);
						convidados.add(a.getNome());
						filaDeAmigos.add(a);
					}
				}
			}
			amigo.setAmigoVisitado(true);
		}
		return convidados;
	}
}
