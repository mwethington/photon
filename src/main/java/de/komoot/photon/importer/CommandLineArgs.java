package de.komoot.photon.importer;

/**
 * Command Line Arguments parsed by {@link com.beust.jcommander.JCommander} and used to start photon.
 */

import com.beust.jcommander.Parameter;
import lombok.Data;

import java.io.File;

@Data
public class CommandLineArgs {
	@Parameter(names = "-nominatim-import", description = "import nominatim database into photon (this will delete previous index)")
	private boolean nominatimImport = false;

	@Parameter(names = "-json", description = "import nominatim database and dump it to json like files in /tmp/ (useful for developing, see -json-nb-docs)")
	private boolean jsonDump = false;

	@Parameter(names = "-json-nb-docs", description = "if -json arg is set: number of documents per json file")
	private int jsonLines = 100000;

	@Parameter(names = "-create-snapshot", description = "create snapshot of photon index, useful for backups and for fast reimports on other photon instances ")
	private String createSnapshot = null;

	@Parameter(names = "-import-snapshot", description = "import a snapshot from an URL, can be remote (http://example.com/photon.zip) or local (file:///home/photon/photon.zip)")
	private String importSnapshot = null;

	@Parameter(names = "-delete-index", description = "delete index and all documents, creates a new and empty photon index")
	private boolean deleteIndex = false;

	@Parameter(names = "-host", description = "postgres host (default 127.0.0.1)")
	private String host = "127.0.0.1";

	@Parameter(names = "-port", description = "postgres port (default 5432)")
	private Integer port = 5432;

	@Parameter(names = "-database", description = "postgres host (default nominatim)")
	private String database = "nominatim";

	@Parameter(names = "-user", description = "postgres user (default nominatim)")
	private String user = "nominatim";

	@Parameter(names = "-password", description = "postgres host (default '')")
	private String password = "";

	@Parameter(names = "-data-dir", description = "data directory (default '.')")
	private String dataDirectory = new File(".").getAbsolutePath();
}

