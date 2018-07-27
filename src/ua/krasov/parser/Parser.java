package ua.krasov.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Parser {

	private String url;

	public Parser(String url) {
		this.url = url;
	}

	public String findRootByID(String id) throws IOException {
		
		if (id != null && url != null) {
			String root = "";

			Document document = Jsoup.connect(url).get();
			Element element = document.getElementById(id);
			
			List<String> tags = new ArrayList<>();
			while(element.hasParent()) {
				tags.add(element.tagName());
				element = element.parent();
			}
			
			Collections.reverse(tags);
			
			for (int i = 0; i < tags.size(); i++) {
				if (i == tags.size() - 1) {
					root += tags.get(i);
				} else {
					root += tags.get(i) + " > ";
				}
			}
				
			return root;
		}
		return null;
	}

}
