package programinhasimportarcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsultarBolsaZeroAno {

	public static void main(String[] args) {

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
							System.out
									.println("| Valor da Bolsa: " + valoresEntreVirgulas[9] + valoresEntreVirgulas[10]);
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
}
