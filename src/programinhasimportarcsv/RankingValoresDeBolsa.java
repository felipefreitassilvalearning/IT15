package programinhasimportarcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RankingValoresDeBolsa {

	public static void main(String[] args) {

		final String FILE_PATH = "D:\\Programming\\GitHub\\IT15\\br-capes-bolsistas-uab.csv";
		File arquivoCSV = new File(FILE_PATH);

		try {
			String linhasDoArquivo = new String();

			Double maiorBolsa1 = 3.0;
			String maiorBolsista1 = "";
			Double maiorBolsa2 = 2.0;
			String maiorBolsista2 = "";
			Double maiorBolsa3 = 1.0;
			String maiorBolsista3 = "";
			Double menorBolsa3 = 1500.0;
			String menorBolsista3 = "";
			Double menorBolsa2 = 1500.0;
			String menorBolsista2 = "";
			Double menorBolsa1 = 1500.0;
			String menorBolsista1 = "";

			try (Scanner leitor = new Scanner(arquivoCSV)) {
				leitor.nextLine();

				while (leitor.hasNext()) {
					linhasDoArquivo = leitor.nextLine();

					String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
					Double valorEntreVirgulas = Double.parseDouble(valoresEntreVirgulas[10]);

					if (valorEntreVirgulas > maiorBolsa1) {
						maiorBolsa1 = valorEntreVirgulas;
						maiorBolsista1 = valoresEntreVirgulas[0];
					} else if (valorEntreVirgulas <= maiorBolsa1 && valorEntreVirgulas > maiorBolsa2) {
						maiorBolsa2 = valorEntreVirgulas;
						maiorBolsista2 = valoresEntreVirgulas[0];
					} else if (valorEntreVirgulas <= maiorBolsa2 && valorEntreVirgulas > maiorBolsa3) {
						maiorBolsa3 = valorEntreVirgulas;
						maiorBolsista3 = valoresEntreVirgulas[0];
					}

					if (valorEntreVirgulas < menorBolsa1) {
						menorBolsa1 = valorEntreVirgulas;
						menorBolsista1 = valoresEntreVirgulas[0];
					} else if (valorEntreVirgulas >= menorBolsa1 && valorEntreVirgulas < menorBolsa2) {
						menorBolsa2 = valorEntreVirgulas;
						menorBolsista2 = valoresEntreVirgulas[0];
					} else if (valorEntreVirgulas >= menorBolsa2 && valorEntreVirgulas < menorBolsa3) {
						menorBolsa3 = valorEntreVirgulas;
						menorBolsista3 = valoresEntreVirgulas[0];
					}
				}

				System.out.println("/================================================\\");
				System.out.println("| Três alunos com os valores da bolsa mais altos");
				System.out.println("| 1º - " + maiorBolsista1 + " - R$ " + maiorBolsa1);
				System.out.println("| 2º - " + maiorBolsista2 + " - R$ " + maiorBolsa2);
				System.out.println("| 3º - " + maiorBolsista3 + " - R$ " + maiorBolsa3);
				System.out.println("|");
				System.out.println("| Três alunos com os valores da bolsa mais baixos");
				System.out.println("| 1º - " + menorBolsista1 + " - R$ " + menorBolsa1);
				System.out.println("| 2º - " + menorBolsista2 + " - R$ " + menorBolsa2);
				System.out.println("| 3º - " + menorBolsista3 + " - R$ " + menorBolsa3);
				System.out.println("\\================================================/");
			}
		} catch (FileNotFoundException e) {
		}
	}
}
