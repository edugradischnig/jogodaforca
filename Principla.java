package eaeKara;

import java.util.Random;
import java.util.Scanner;

public class Sabetudo {

	public static void main(String[] args) {
		//Array de palavras
		String palavrasN1[] = {"hidrogenio","agua","temperatura","linux","hub"};
		String palavrasN2[] = {"mitocondria","gravidade","metamorfose","determinantes","mercurio"};
		String palavrasN3[] = {"desoxirribonucleotideo","multiplexacao","enderecamento","horkheimer","montesquieu"};
		
		//Array de dicas
		String dicasPN1[] = {"Elemento químico mais abundante do universo","Cerca de 60% do corpo humano é composto por esse elemento","Grau de agitação das moléculas","Sistema operacional criado por Linus Torvalds","Centraliza e distribui dados entre os computadores"};
		String dicasPN2[] = {"Responsável pela respiração celular","Uma das quatro forças fundamentais da natureza","Livro escrito por Franz Kafka","Operação matemática que envolve matrizes","O único metal líquido em temperatura ambiente"};
		String dicasPN3[] = {"Participa da síntese proteíca","Técnica que consiste na combinação de 2 ou mais canais de informação para realizar uma comunicação","Um dos serviços da camada de rede no modelo híbrido","Sociólogo responsável pelo termo de Indústria Cultural","Filósofo francês famoso no século XVIII"};
		
		boolean errouTudo = false;
		Random r = new Random();
		int nivelQueEsta = 1;
		String entradasValidas[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		Scanner l = new Scanner(System.in);
		boolean passouNivel = false;
		int aleatorio = 0;
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("        >>>>>> SABE TUDO GAME <<<<<<");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		//NIVEL1
		//Daqui pra baixo em cada nível
		int acertosDeLetrasDaPalavra = 0;
		int ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista = 0;
		int errosDeLetra = 0;
		for (int i = 0; i < 1; i++) {
			aleatorio = r.nextInt(dicasPN1.length);//Só vai sortear uma palavra uma vez por nível
		}
		char letrasJaUsadas[] = new char[5+palavrasN1[aleatorio].length()];//CRIA UM MÁXIMO DE LETRAS QUE O USUÁRIO PODE DIGITAR ANTES DE PERDER O NÍVEL
		char hifensDaPalavra[] = new char[palavrasN1[aleatorio].length()];
		for (int j = 0; j < palavrasN1[aleatorio].length(); j++) {
			hifensDaPalavra[j] = '_';
		}
		System.out.println("Você está no nível 1");
		
		while(nivelQueEsta == 1) {
			if(errosDeLetra >= 5) {
				System.out.println();
				System.out.println("Você perdeu!");
				System.out.println("Fim de jogo.");
				nivelQueEsta = 0;
				break;
			}
			String letraDigitada = "";
			System.out.print("Palavra: ");
			System.out.println(hifensDaPalavra);
			System.out.print("Dica: " + dicasPN1[aleatorio]);
			System.out.println("");
			System.out.print("Letras já usadas: ");
			for (int i = 0; i < letrasJaUsadas.length; i++) {
				if(letrasJaUsadas[i] != ' ') {
					System.out.print(letrasJaUsadas[i]);
				}
			}
			System.out.println("");
			System.out.println("Quantidade de erros: " + errosDeLetra);
			System.out.print("Digite uma nova letra: ");
			
			//VERIFICAÇÃO PARA VER SE A ENTRADA É INVALIDA
			letraDigitada = l.nextLine(); //DA PARA OTIMIZAR A VERIFICAÇÃO DE ACENTOS
			System.out.println("........................................................");
			letraDigitada = letraDigitada.toLowerCase();
			boolean caractereEstaNaLista = false;
			
			while(caractereEstaNaLista == false) {
				while(letraDigitada.length() != 1) {
					System.out.println("Entrada inválida, digite apenas uma letra!");
					System.out.print("Digite uma nova letra: ");
					letraDigitada = l.nextLine();
				}
				if(letraDigitada.contentEquals("ç")) {
					letraDigitada = "c";
				}else if(letraDigitada.contentEquals("á") ||letraDigitada.contentEquals("â")|| letraDigitada.contentEquals("à")|| letraDigitada.contentEquals("å")||letraDigitada.contentEquals("ã")||letraDigitada.contentEquals("ä")) {
					letraDigitada = "a";
				}else if(letraDigitada.contentEquals("é")||letraDigitada.contentEquals("ê")||letraDigitada.contentEquals("è")||letraDigitada.contentEquals("ë")) {
					letraDigitada = "e";
				}else if(letraDigitada.contentEquals("í")||letraDigitada.contentEquals("î")||letraDigitada.contentEquals("ì")) {
					letraDigitada = "i";
				}else if(letraDigitada.contentEquals("ó")||letraDigitada.contentEquals("ô")||letraDigitada.contentEquals("ò")||letraDigitada.contentEquals("õ")||letraDigitada.contentEquals("ö")) {
					letraDigitada = "o";
				}else if(letraDigitada.contentEquals("ú")||letraDigitada.contentEquals("û")||letraDigitada.contentEquals("ù")||letraDigitada.contentEquals("ü")) {
					letraDigitada = "u";
				}else if(letraDigitada.contentEquals("ñ")) {
					letraDigitada = "n";
				}else if(letraDigitada.contentEquals("ý")) {
					letraDigitada = "y";
				}
				
				for (int j = 0; j < entradasValidas.length; j++) {
					if(letraDigitada.toLowerCase().contentEquals(entradasValidas[j])) {
						caractereEstaNaLista = true;
						break;
					}
				}
				if(caractereEstaNaLista == false) {
					System.out.println("Entrada inválida, digite apenas uma letra!");
					System.out.print("Digite uma nova letra: ");
					letraDigitada = l.nextLine();
						
				}
			}
			//A ENTRADA É VÁLIDA
			palavrasN1[aleatorio].toCharArray();//TRANSFORMA EM ARRAY
			letraDigitada.toCharArray();
			boolean acertouALetra = false;
			int letrasDiferentes = 0;
			boolean jaDigitouEssaLetraAntes = false;
			for (int j = 0; j < palavrasN1[aleatorio].length(); j++) {
				if((palavrasN1[aleatorio].charAt(j)) == letraDigitada.charAt(0)) {//A LETRA QUE O USUÁRIO DIGITOU TEM NA PALAVRA
					for (int i = 0; i < letrasJaUsadas.length; i++) {
						if(letrasJaUsadas[i] == letraDigitada.charAt(0)) {//VAI VERIFICAR SE O USUARIO JA DIGITOU ESSA LETRA ANTES, SE SIM, NAO CONTA COMO ACERTO NEM ERRO
							jaDigitouEssaLetraAntes = true;
							acertouALetra = false;
						}
					}
					if(!jaDigitouEssaLetraAntes) {
						hifensDaPalavra[j] = letraDigitada.charAt(0);
						acertouALetra = true;
						acertosDeLetrasDaPalavra += 1;
					}	
				}else {
					for (int i = 0; i < letrasJaUsadas.length; i++) {
						if(letrasJaUsadas[i] == letraDigitada.charAt(0)) {
							jaDigitouEssaLetraAntes = true;
						}
					}if(jaDigitouEssaLetraAntes) {
						acertouALetra = true;//NAO ACERTOU, É APENAS PARA NAO CONTAR COMO ERRO
					}
				}
			}
			if(jaDigitouEssaLetraAntes == true) {
				System.out.println("Você já digitou essa letra antes; por favor, digite uma letra diferente!");
			}
			
			for (int i = 0; i < letrasJaUsadas.length; i++) {
				if(letrasJaUsadas[i] != letraDigitada.charAt(0)){
					letrasDiferentes += 1;
				}
			}
			if(letrasDiferentes == letrasJaUsadas.length) {//SE A LETRA QUE ELE DIGITOU NÃO ESTÁ NA LISTA DAS LETRAS JÁ USADAS
				letrasJaUsadas[ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista] = letraDigitada.charAt(0);
				ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista += 1;
			}
			if(!acertouALetra) {
				System.out.println("Você ERROU a letra!");
				errosDeLetra += 1;
			}
			if(acertosDeLetrasDaPalavra == palavrasN1[aleatorio].length()) {
				nivelQueEsta += 1;
				System.out.print("Palavra: ");
				System.out.println(hifensDaPalavra);
				System.out.println("Parabéns, você passou de nível!");
				System.out.println("........................................................");
			}
			
	}			
		
		//NIVEL2
		//Daqui pra baixo em cada nível
		acertosDeLetrasDaPalavra = 0;
		ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista = 0;
		errosDeLetra = 0;
		for (int i = 0; i < 1; i++) {
			aleatorio = r.nextInt(dicasPN2.length);//Só vai sortear uma palavra uma vez por nível
		}
		char letrasJaUsadasNivel2[] = new char[4+palavrasN2[aleatorio].length()];//CRIA UM MÁXIMO DE LETRAS QUE O USUÁRIO PODE DIGITAR ANTES DE PERDER O NÍVEL
		char hifensDaPalavraNivel2[] = new char[palavrasN2[aleatorio].length()];
		for (int j = 0; j < palavrasN2[aleatorio].length(); j++) {
			hifensDaPalavraNivel2[j] = '_';
		}
		
		while(nivelQueEsta == 2) {
			for (int i = 0; i < 1; i++) {
				System.out.println("Você está no nível 2");
			}
			if(errosDeLetra >= 4) {
				System.out.println();
				System.out.println("Você perdeu!");
				System.out.println("Fim de jogo.");
				nivelQueEsta = 0;
				break;
			}
			String letraDigitada = "";
			System.out.print("Palavra: ");
			System.out.println(hifensDaPalavraNivel2);
			System.out.print("Dica: " + dicasPN2[aleatorio]);
			System.out.println("");
			System.out.print("Letras já usadas: ");
			for (int i = 0; i < letrasJaUsadasNivel2.length; i++) {
				if(letrasJaUsadasNivel2[i] != ' ') {
					System.out.print(letrasJaUsadasNivel2[i]);
				}
			}
			System.out.println("");
			System.out.println("Quantidade de erros: " + errosDeLetra);
			System.out.print("Digite uma nova letra: ");
					
			//VERIFICAÇÃO PARA VER SE A ENTRADA É INVALIDA
			letraDigitada = l.nextLine(); //DA PARA OTIMIZAR A VERIFICAÇÃO DE ACENTOS
			System.out.println("........................................................");
			letraDigitada = letraDigitada.toLowerCase();
			boolean caractereEstaNaLista = false;
					
			while(caractereEstaNaLista == false) {
				while(letraDigitada.length() != 1) {
					System.out.println("Entrada inválida, digite apenas uma letra!");
					System.out.print("Digite uma nova letra: ");
					letraDigitada = l.nextLine();
				}
				if(letraDigitada.contentEquals("ç")) {
					letraDigitada = "c";
				}else if(letraDigitada.contentEquals("á") ||letraDigitada.contentEquals("â")|| letraDigitada.contentEquals("à")|| letraDigitada.contentEquals("å")||letraDigitada.contentEquals("ã")||letraDigitada.contentEquals("ä")) {
					letraDigitada = "a";
				}else if(letraDigitada.contentEquals("é")||letraDigitada.contentEquals("ê")||letraDigitada.contentEquals("è")||letraDigitada.contentEquals("ë")) {
					letraDigitada = "e";
				}else if(letraDigitada.contentEquals("í")||letraDigitada.contentEquals("î")||letraDigitada.contentEquals("ì")) {
					letraDigitada = "i";
				}else if(letraDigitada.contentEquals("ó")||letraDigitada.contentEquals("ô")||letraDigitada.contentEquals("ò")||letraDigitada.contentEquals("õ")||letraDigitada.contentEquals("ö")) {
					letraDigitada = "o";
				}else if(letraDigitada.contentEquals("ú")||letraDigitada.contentEquals("û")||letraDigitada.contentEquals("ù")||letraDigitada.contentEquals("ü")) {
					letraDigitada = "u";
				}else if(letraDigitada.contentEquals("ñ")) {
					letraDigitada = "n";
				}else if(letraDigitada.contentEquals("ý")) {
					letraDigitada = "y";
				}
						
				for (int j = 0; j < entradasValidas.length; j++) {
					if(letraDigitada.toLowerCase().contentEquals(entradasValidas[j])) {
						caractereEstaNaLista = true;
						break;
					}
				}
				if(caractereEstaNaLista == false) {
					System.out.println("Entrada inválida, digite apenas uma letra!");
					System.out.print("Digite uma nova letra: ");
					letraDigitada = l.nextLine();			
				}
			}
			//A ENTRADA É VÁLIDA
			palavrasN2[aleatorio].toCharArray();//TRANSFORMA EM ARRAY
			letraDigitada.toCharArray();
			boolean acertouALetra = false;
			int letrasDiferentes = 0;
			boolean jaDigitouEssaLetraAntes = false;
					
			for (int j = 0; j < palavrasN2[aleatorio].length(); j++) {
				if((palavrasN2[aleatorio].charAt(j)) == letraDigitada.charAt(0)) {
					for (int i = 0; i < letrasJaUsadasNivel2.length; i++) {
						if(letrasJaUsadasNivel2[i] == letraDigitada.charAt(0)) {//VAI VERIFICAR SE O USUARIO JA DIGITOU ESSA LETRA ANTES, SE SIM, NAO CONTA COMO ACERTO NEM ERRO
							jaDigitouEssaLetraAntes = true;
							acertouALetra = false;
						}
					}
					if(!jaDigitouEssaLetraAntes) {
						hifensDaPalavraNivel2[j] = letraDigitada.charAt(0);
						acertouALetra = true;
						acertosDeLetrasDaPalavra += 1;
					}	
				}
				else {
					for (int i = 0; i < letrasJaUsadasNivel2.length; i++) {
						if(letrasJaUsadasNivel2[i] == letraDigitada.charAt(0)) {
							jaDigitouEssaLetraAntes = true;
						}
					}if(jaDigitouEssaLetraAntes) {
						acertouALetra = true;//NAO ACERTOU, É APENAS PARA NAO CONTAR COMO ERRO
					}
				}
			}
			if(jaDigitouEssaLetraAntes == true) {
				System.out.println("Você já digitou essa letra antes; por favor, digite uma letra diferente!");
			}
			for (int i = 0; i < letrasJaUsadasNivel2.length; i++) {
				if(letrasJaUsadasNivel2[i] != letraDigitada.charAt(0)){
					letrasDiferentes += 1;
				}
			}
			if(letrasDiferentes == letrasJaUsadasNivel2.length) {//SE A LETRA QUE ELE DIGITOU NÃO ESTÁ NA LISTA DAS LETRAS JÁ USADAS
				letrasJaUsadasNivel2[ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista] = letraDigitada.charAt(0);
				ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista += 1;
			}
			if(!acertouALetra) {
				System.out.println("Você ERROU a letra!");
				errosDeLetra += 1;
			}
			if(acertosDeLetrasDaPalavra == palavrasN2[aleatorio].length()) {
				nivelQueEsta += 1;
				System.out.print("Palavra: ");
				System.out.println(hifensDaPalavraNivel2);
				System.out.println("Parabéns, você passou de nível!");
				System.out.println("........................................................");
				
			}
		}
			//NIVEL3
			//Daqui pra baixo em cada nível
			acertosDeLetrasDaPalavra = 0;
			ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista = 0;
			errosDeLetra = 0;
			for (int i = 0; i < 1; i++) {
				aleatorio = r.nextInt(dicasPN2.length);//Só vai sortear uma palavra uma vez por nível
			}
			char letrasJaUsadasNivel3[] = new char[3+palavrasN3[aleatorio].length()];//CRIA UM MÁXIMO DE LETRAS QUE O USUÁRIO PODE DIGITAR ANTES DE PERDER O NÍVEL
			char hifensDaPalavraNivel3[] = new char[palavrasN3[aleatorio].length()];
			for (int j = 0; j < palavrasN3[aleatorio].length(); j++) {
				hifensDaPalavraNivel3[j] = '_';
			}
			
			while(nivelQueEsta == 3) {
				for (int i = 0; i < 1; i++) {
					System.out.println("Você está no nível 3");
				}
				if(errosDeLetra >= 3) {
					System.out.println();
					System.out.println("Você perdeu!");
					System.out.println("Fim de jogo.");
					nivelQueEsta = 0;
					break;
				}
				String letraDigitada = "";
				System.out.print("Palavra: ");
				System.out.println(hifensDaPalavraNivel3);
				System.out.print("Dica: " + dicasPN3[aleatorio]);
				System.out.println("");
				System.out.print("Letras já usadas: ");
				for (int i = 0; i < letrasJaUsadasNivel3.length; i++) {
					if(letrasJaUsadasNivel3[i] != ' ') {
						System.out.print(letrasJaUsadasNivel3[i]);
					}
				}
				System.out.println("");
				System.out.println("Quantidade de erros: " + errosDeLetra);
				System.out.print("Digite uma nova letra: ");
						
				//VERIFICAÇÃO PARA VER SE A ENTRADA É INVALIDA
				letraDigitada = l.nextLine(); //DA PARA OTIMIZAR A VERIFICAÇÃO DE ACENTOS
				System.out.println("........................................................");
				letraDigitada = letraDigitada.toLowerCase();
				boolean caractereEstaNaLista = false;
						
				while(caractereEstaNaLista == false) {
					while(letraDigitada.length() != 1) {
						System.out.println("Entrada inválida, digite apenas uma letra!");
						System.out.print("Digite uma nova letra: ");
						letraDigitada = l.nextLine();
					}
					if(letraDigitada.contentEquals("ç")) {
						letraDigitada = "c";
					}else if(letraDigitada.contentEquals("á") ||letraDigitada.contentEquals("â")|| letraDigitada.contentEquals("à")|| letraDigitada.contentEquals("å")||letraDigitada.contentEquals("ã")||letraDigitada.contentEquals("ä")) {
						letraDigitada = "a";
					}else if(letraDigitada.contentEquals("é")||letraDigitada.contentEquals("ê")||letraDigitada.contentEquals("è")||letraDigitada.contentEquals("ë")) {
						letraDigitada = "e";
					}else if(letraDigitada.contentEquals("í")||letraDigitada.contentEquals("î")||letraDigitada.contentEquals("ì")) {
						letraDigitada = "i";
					}else if(letraDigitada.contentEquals("ó")||letraDigitada.contentEquals("ô")||letraDigitada.contentEquals("ò")||letraDigitada.contentEquals("õ")||letraDigitada.contentEquals("ö")) {
						letraDigitada = "o";
					}else if(letraDigitada.contentEquals("ú")||letraDigitada.contentEquals("û")||letraDigitada.contentEquals("ù")||letraDigitada.contentEquals("ü")) {
						letraDigitada = "u";
					}else if(letraDigitada.contentEquals("ñ")) {
						letraDigitada = "n";
					}else if(letraDigitada.contentEquals("ý")) {
						letraDigitada = "y";
					}
							
					for (int j = 0; j < entradasValidas.length; j++) {
						if(letraDigitada.toLowerCase().contentEquals(entradasValidas[j])) {
							caractereEstaNaLista = true;
							break;
						}
					}
					if(caractereEstaNaLista == false) {
						System.out.println("Entrada inválida, digite apenas uma letra!");
						System.out.print("Digite uma nova letra: ");
						letraDigitada = l.nextLine();			
					}
				}
				//A ENTRADA É VÁLIDA
				palavrasN3[aleatorio].toCharArray();//TRANSFORMA EM ARRAY
				letraDigitada.toCharArray();
				boolean acertouALetra = false;
				int letrasDiferentes = 0;
				boolean jaDigitouEssaLetraAntes = false;
						
				for (int j = 0; j < palavrasN3[aleatorio].length(); j++) {
					if((palavrasN3[aleatorio].charAt(j)) == letraDigitada.charAt(0)) {
						for (int i = 0; i < letrasJaUsadasNivel3.length; i++) {
							if(letrasJaUsadasNivel3[i] == letraDigitada.charAt(0)) {//VAI VERIFICAR SE O USUARIO JA DIGITOU ESSA LETRA ANTES, SE SIM, NAO CONTA COMO ACERTO NEM ERRO
								jaDigitouEssaLetraAntes = true;
								acertouALetra = false;
							}
						}
						if(!jaDigitouEssaLetraAntes) {
							hifensDaPalavraNivel3[j] = letraDigitada.charAt(0);
							acertouALetra = true;
							acertosDeLetrasDaPalavra += 1;
						}	
					}
					else {
						for (int i = 0; i < letrasJaUsadasNivel3.length; i++) {
							if(letrasJaUsadasNivel3[i] == letraDigitada.charAt(0)) {
								jaDigitouEssaLetraAntes = true;
							}
						}if(jaDigitouEssaLetraAntes) {
							acertouALetra = true;//NAO ACERTOU, É APENAS PARA NAO CONTAR COMO ERRO
						}
					}
				}
				if(jaDigitouEssaLetraAntes == true) {
					System.out.println("Você já digitou essa letra antes; por favor, digite uma letra diferente!");
				}
				for (int i = 0; i < letrasJaUsadasNivel3.length; i++) {
					if(letrasJaUsadasNivel3[i] != letraDigitada.charAt(0)){
						letrasDiferentes += 1;
					}
				}
				if(letrasDiferentes == letrasJaUsadasNivel3.length) {//SE A LETRA QUE ELE DIGITOU NÃO ESTÁ NA LISTA DAS LETRAS JÁ USADAS
					letrasJaUsadasNivel3[ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista] = letraDigitada.charAt(0);
					ultimaPosicaoQueAdicionouLetrasJaUsadasNaLista += 1;
				}
				if(!acertouALetra) {
					System.out.println("Você ERROU a letra!");
					errosDeLetra += 1;
				}
				if(acertosDeLetrasDaPalavra == palavrasN3[aleatorio].length()) {
					System.out.print("Palavra: ");
					System.out.println(hifensDaPalavraNivel3);
					System.out.println("Parabéns, você venceu o jogo");
					System.out.println("........................................................");
					nivelQueEsta += 1;
				}
			}			
	}
}
