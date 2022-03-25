package programinhasimportarcsv;

import java.util.Scanner;

public class CodificarNomes {
    public static void main(String args[]) {
    	
    	try (Scanner input = new Scanner(System.in)) {
			String name = "";
			System.out.print("Digite aqui o nome do bolsista que procura: ");
			name = input.nextLine();
			name = name.toUpperCase();
			System.out.println("Primeira letra: "+name.charAt(0));
			System.out.println("Última letra: "+name.charAt(name.length()-1));
			for (int j = 1; j < name.length()-1; j++) {
			    char character = name.charAt(j);
			    System.out.print("ascii for the letter "+character);
			    int ascii = (int) character;
			    int hash = ascii + 1;
			    if (hash > 90) {
			        hash = 65;
			    }
			    char postHash = (char) hash;
			    System.out.println(" --> "+postHash);
			}
			System.out.println(name);
		}
    }
}