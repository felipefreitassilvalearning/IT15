package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Bolsista;
import entities.Test;

public class Program {

	public static void main(String[] args) {

		String path = "D:\\Programming\\GitHub\\IT15\\br-capes-bolsistas-uab.txt";
		
		List<Bolsista> list = new ArrayList<Bolsista>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			line = br.readLine();
			while (line != null) {

				String[] vect = line.split(";");
				String nome = vect[0];
				String cpf = vect[1];
				String entidadeEnsino = vect[2];
				String referencia = vect[3];
				String diretoria = vect[4];
				String sistemaOrigem = vect[5];
				String modalidade = vect[6];
				String modalidadePagamento = vect[7];
				String moeda = vect[8];
				String valorBolsa = vect[9];

				Bolsista bolsista = new Bolsista(nome, cpf, entidadeEnsino, referencia,
						diretoria, sistemaOrigem, modalidade, modalidadePagamento, moeda,
						valorBolsa);
				list.add(bolsista);

				line = br.readLine();
			}

			System.out.println("BOLSISTAS:");
			for (Bolsista b : list) {
				System.out.println(b);
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
