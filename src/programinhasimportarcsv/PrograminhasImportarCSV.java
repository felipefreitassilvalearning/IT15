package programinhasimportarcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrograminhasImportarCSV {

	public static void main(String[] args) {
				
		File arquivoCSV = new File("D:\\Programming\\GitHub\\IT15\\br-capes-bolsistas-uab.csv");
		
		try {
			
			String linhasDoArquivo = new String();
			
			try (Scanner leitor = new Scanner(arquivoCSV)) {
				leitor.nextLine();
				
				while(leitor.hasNext()) {
					linhasDoArquivo = leitor.nextLine();
					
					String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
					
					System.out.println("============= BOLSISTA ==============");
					System.out.println(valoresEntreVirgulas[0]+" - "+valoresEntreVirgulas[1]+" - "+valoresEntreVirgulas[2]+" - "+valoresEntreVirgulas[3]+" - "+valoresEntreVirgulas[4]+" - "+valoresEntreVirgulas[5]+" - "+valoresEntreVirgulas[6]+" - "+valoresEntreVirgulas[7]+" - "+valoresEntreVirgulas[8]+" - "+valoresEntreVirgulas[9]+valoresEntreVirgulas[10]);
				}
			}
		} catch(FileNotFoundException e) {}
	}
}
