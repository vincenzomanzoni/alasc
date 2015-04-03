package it.unibg.alasc;

import it.unibg.alasc.errors.GenericError;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {

		Options options = new Options();
		options.addOption("t", "tos", false, "generate the table of symbols");
		options.addOption("v", "verbose", false, "enable verbose mode");
	
		CommandLineParser parser = new BasicParser();

		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			logger.fatal("Error while parsing command line arguments", e);
			System.exit(1);
		}

		if (cmd.hasOption("h")) {
			printHelp(options);
			System.exit(0);
		}
		
		if (cmd.hasOption("v")) {
			logger.setLevel(Level.TRACE);
		}

		@SuppressWarnings("unchecked")
		List<String> otherArgs = cmd.getArgList();

		if (otherArgs.isEmpty()) {
			logger.fatal("No source file(s) specified");
			printHelp(options);
			System.exit(1);
		}

		for (String srcFilepath : otherArgs) {

			Parser logoParser = null;
			
			logger.debug("Reading source file " + srcFilepath);
			
			try {
				logoParser = new Parser(new FileInputStream(srcFilepath));
			} catch (FileNotFoundException e) {
				logger.fatal("Unable to read the source file " + srcFilepath, e);
				System.exit(1);
			}

			logger.debug("Compiling source file " + srcFilepath);
			ParserStatus parserExitCode = logoParser.parse();
			logoParser.getCode();

			switch (parserExitCode) {

			case COMPILED:

				writeActionScript(new File("Main.as"), logoParser.getCode());

				if (cmd.hasOption("t")) {
					printTOS(logoParser.getSymbolsTable());
				}
				
				break;
				
			case LEXICALERRORS:
			case SEMANTICERRORS:
			case SYNTAXERRORS:
			case TEMPLATEERRORS:
				printErrors(logoParser.getErrors());
				System.exit(1);
			default:
				break;
			}
		}
		
		logger.debug("Done. Compiled " + otherArgs.size() + " files.");
		System.exit(0);

	}

	private static void writeActionScript(File compiled, String code) {

		FileWriter fileWriter = null;

		logger.debug("Writing output Action Script file " + compiled.getName());
		
		try {
			fileWriter = new FileWriter(compiled);
			fileWriter.write(code);
		} catch (IOException e) {
			logger.fatal("Unable to write the output Action Script file " + compiled.getName(), e);
			System.exit(1);
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					logger.fatal("Unable to write the output action script file " + compiled.getName(), e);
					System.exit(1);
				}
			}
		}
	}

	private static void printTOS(List<Declaration> tos) {
		logger.info("The table of symbols (TOS) contains " + tos.size() + " entries");
		
		for (Declaration declaration : tos) {
			logger.info(declaration);
		}
	}

	private static void printErrors(List<GenericError> errors) {
		logger.error("Found " + errors.size() + " errors");
		
		for (GenericError e : errors) {
			logger.error(e);
		}
	}

	private static void printHelp(Options options) {
		System.out.println("ALASC, A Logo to Action Script Compiler");
		
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("alasc [logofile] ... [logofile]", options);
	}

}
