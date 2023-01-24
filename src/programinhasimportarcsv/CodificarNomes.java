package programinhasimportarcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CodificarNomes {
	public static void main(String args[]) {

		try (Scanner input = new Scanner(System.in)) {

			String name = "";

			String reverseName = "";

			System.out.print("Digite aqui o nome do bolsista que procura: ");

			name = input.nextLine().toUpperCase();

			if (name.length() <= 3) {

				for (int i = name.length() - 1; i >= 0; i--) {
					reverseName = reverseName + name.charAt(i);
				}
			} else 

				char firstLetter = 32;
				char lastLetter = 32;
				
				for (int j = name.length() - 1; j >= 0; j--) {
					if (j == name.length() - 1) {
						lastLetter = name.charAt(j);
					} else if (j == 0) {
						firstLetter = name.charAt(j);
					} else {
						reverseName = reverseName + name.charAt(j);
					}
				}
				reverseName = firstLetter + reverseName + lastLetter;
			}
			codificar(reverseName);
		}
	}

	public static void consultarBolsista(String name) {
		
		final String FILE_PATH = "D:\\Programming\\GitHub\\IT15\\br-capes-bolsistas-uab.csv";
		File arquivoCSV = new File(FILE_PATH);
		String anoProcurado;
		
		try (Scanner input = new Scanner(System.in)) {
			try {
				String linhasDoArquivo = new String();
				System.out.print("Escreva aqui o ano desejado: ");
				anoProcurado = input.nextLine();
				boolean haBolsista = false;
				
				try (Scanner leitor = new Scanner(arquivoCSV)) {
					leitor.nextLine();
					
					while (leitor.hasNext()) {
						linhasDoArquivo = leitor.nextLine();
						
						String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
						
						if (valoresEntreVirgulas[4].equals(anoProcurado)) {
							System.out.println("/===================================================\\");
							System.out.println("| Dados do primeiro bolsista de " + anoProcurado);
							System.out.println("| Nome: " + valoresEntreVirgulas[0]);
							System.out.println("| CPF: " + valoresEntreVirgulas[1]);
							System.out.println("| Entidade de Ensino: " + valoresEntreVirgulas[2]);
							System.out.println("| Valor da Bolsa: " + valoresEntreVirgulas[9] + valoresEntreVirgulas[10]);
							System.out.println("\\===================================================/");
							haBolsista = true;
							break;
						}
					}
					
					if (!haBolsista) {
						System.out.println("Infelizmente, n�o h� bolsistas em " + anoProcurado + ".");
					}
					
				}
			} catch (FileNotFoundException e) {
			}
		}
	}


	public static void codificar(String name) {

		String newName = "";

		for (int k = 0; k <= name.length() - 1; k++) {
			char character = name.charAt(k);
			int ascii = (int) character;
			int hash = ascii + 1;
			if (hash > 90) {
				hash = 65;
			}
			char postHash = (char) hash;
			newName = newName + postHash;
		}
		System.out.println(newName);
	}
}
