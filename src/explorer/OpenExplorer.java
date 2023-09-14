package explorer;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OpenExplorer {

	public static void main() {
		
		try {
			//Diretorio a ser aberto após a expotacao do arquivo.
			File diretorio = new File("C:\\Temp");
			
			//Verifica se o ambiente suporta a operacao de abrir a pasta
			if(Desktop.isDesktopSupported() && diretorio.exists()) {
				Desktop dkt = Desktop.getDesktop();
				dkt.open(diretorio);
			} else {
				System.out.println("Abertura não suportada do Explorer.");
			}
			
		}
		catch (IOException e) {
			System.out.println("Erro ao abrir o Explorer");
		}
	}

}
