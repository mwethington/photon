package de.komoot.photon.importer.json;

import de.komoot.photon.importer.Importer;
import de.komoot.photon.importer.Utils;
import de.komoot.photon.importer.model.PhotonDoc;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * useful to create json files that can be used for fast re imports
 *
 * @author christoph
 */
@Slf4j
public class JsonDumper implements Importer {
	private int counter = 0;
	private int nbLines = 100000;
	private PrintWriter writer = null;
	private final String filename;

	public JsonDumper(String filename, int jsonLines) throws FileNotFoundException {
		this.filename = filename;
		this.nbLines = jsonLines;
	}

	@Override
	public void add(PhotonDoc doc) {
		try {
			if(counter % nbLines == 0) {
				if(writer != null) {
					// close previous writer
					writer.close();
				}
				writer = new PrintWriter(filename + "_" + counter / nbLines);
			}
			writer.println("{\"index\": {}}");
			writer.println(Utils.convert(doc).string());
			counter++;
		} catch(IOException e) {
			log.error("error writing json file", e);
		}
	}

	@Override
	public void finish() {
		if(writer != null) {
			writer.close();
		}
	}
}
