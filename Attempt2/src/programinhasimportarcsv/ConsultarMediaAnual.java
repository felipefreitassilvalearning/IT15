package programinhasimportarcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsultarMediaAnual {

	public static void main(String[] args) {
				
		File arquivoCSV = new File("D:\\Programming\\GitHub\\IT15\\br-capes-bolsistas-uab.csv");
		String anoProcurado;
		
		try (Scanner input = new Scanner(System.in)) {
			try {
				String linhasDoArquivo = new String();
				System.out.print("Escreva aqui o ano desejado: ");
				anoProcurado = input.nextLine();
				boolean haBolsista = false;
				int valorBolsa = 0;
				double mediaBolsa = 0;
				int amountBolsistasAno = 1;
				
				try (Scanner leitor = new Scanner(arquivoCSV)) {
					leitor.nextLine();
					
					while(leitor.hasNext()) {
						linhasDoArquivo = leitor.nextLine();
						
						String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
						
						if (valoresEntreVirgulas[4].equals(anoProcurado)) {
							
							Integer valorEntreVirgulas = Integer.parseInt(valoresEntreVirgulas[10]);
							
							haBolsista = true;
							valorBolsa += valorEntreVirgulas;
							amountBolsistasAno++;
						}
						
						mediaBolsa = valorBolsa / amountBolsistasAno;
					}

					if (haBolsista) {
						System.out.println("/=============================================\\");
						System.out.println("| Total de bolsistas em "+anoProcurado+": "+amountBolsistasAno);
						System.out.println("| Total de bolsas no ano: R$ "+valorBolsa);
						System.out.println("| Valor médio de cada bolsa: R$ "+mediaBolsa);
						System.out.println("\\=============================================/");
					} else {
						System.out.println("Infelizmente, não há bolsistas em "+anoProcurado+".");
					}
				}
			} catch(FileNotFoundException e) {}
		}
	}
}
