package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skane", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		List<TextProcessor> theList = new ArrayList<TextProcessor>();
		// här skapar man en lista av TextProcessor-obj
		//TextProcessor p = new SingleWordCounter("nils");
		theList.add(new SingleWordCounter("nils"));
		theList.add(new SingleWordCounter("norge"));
		// add WordCounter for " norge"
		theList.add(new MultiWordCounter(REGIONS));
		// add multiwordCounter för Regions-array
		Scanner s = new Scanner(new File("C:\\Users\\Admin\\OneDrive\\Dokument\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		// konfigurerar Scanner-obj så att skiljetecken ,.:;!? filteras bort från de inlästa orden. 

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			//här se man till at string ska ha små bokstäver (gemener)
			for (TextProcessor obj : theList){
				obj.process(word);
			}
			//p.process(word);
		}

		s.close();

		//p.report();
		for (TextProcessor obj : theList){
			obj.report();
		}


	}
}