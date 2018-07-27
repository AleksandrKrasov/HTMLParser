package ua.krasov.parser;

import java.io.IOException;

public class Main {
 
	public static void main(String[] args) throws IOException {
		String url = "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-0-origin.html";
		String id = "make-everything-ok-button";
				
		Parser parser = new Parser(url);
		
		System.out.println(parser.findRootByID(id));

	}
}
