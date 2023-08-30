package br.com.bd.aplicacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtratorTitulo {

	public static void main(String[] args) {
		String url = "https://revistaoeste.com";
		String nomeArquivo = "titulo.txt";

		try {
			Document doc = Jsoup.connect(url).get();
			Elements titleElements = doc.select("h1, h2, h3, h4, h5, h6");

			BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));

			for (Element titleElement : titleElements) {
				String title = titleElement.text();
				writer.write(title);
				writer.newLine();
			}

			writer.close();

			System.out.println("Títulos extraídos e salvos em " + nomeArquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
