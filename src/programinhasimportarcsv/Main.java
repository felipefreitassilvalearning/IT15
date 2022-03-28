package programinhasimportarcsv;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
			try (Scanner input = new Scanner(System.in)) {
				int escolha;
				
				try {
					do {
						System.out.println("\n/=======================================================\\");
						System.out.println("|	BEM-VINDO AO PROGRAMA	");
						System.out.println("|");
						System.out.println("| ESCOLHA UMA DAS OPÇÕES ABAIXO PARA INICIAR	");
						System.out.println("| (1) INFORMAÇÕES SOBRE O PRIMEIRO BOLSISTA DE UM ANO	");
						System.out.println("| (2) BUSCAR BOLSISTA E CODIFICAR NOME	");
						System.out.println("| (3) CONSULTAR MÉDIA ANUAL	");
						System.out.println("| (4) RANKING VALORES DE BOLSA	");
						System.out.println("| (5) TERMINAR O PROGRAMA	");
						System.out.println("\\======================================================/");
						escolha = input.nextInt();
						
						switch (escolha) {
							default:
								System.out.println("Valor inválido. Tente Novamente.");
								break;
							case 1:
								ConsultarBolsaZeroAno.main(args);
								break;
							case 2:
								CodificarNomes.main(args);
								break;
							case 3:
								ConsultarMediaAnual.main(args);
								break;
							case 4:
								RankingValoresDeBolsa.main(args);
								break;
							case 5:
								break;
						}
						
					} while (escolha != 5);
					
					System.out.println("Obrigado por utilizar!\n");
					
				} catch (Exception e) {
					System.out.println("Error: "+e);
				}
			}
	}
}
