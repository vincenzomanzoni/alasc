package com.google.code.alasc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import jargs.gnu.CmdLineParser;                                                 

public class Alasc {

	private static String inputFileName = "", swfFileName = "", pathMtasc = "";
	private static final String outputFileName = "Disegno.as";
	private static boolean tosEnabled, swfEnabled;
	
	private static Parser logoParser;
	private static ParserStatus parserStatus;
	
    private static void printUsage() {
        System.err.println("Usage: Alasc input_logo [-s/--swf] pathMtasc <output_flash> [-t/--tos]\n");
    }
    
    private static void parseCommandLine(String[] args) {
    	CmdLineParser parser = new CmdLineParser();
        
        CmdLineParser.Option swfParam = parser.addBooleanOption('s', "swf");
        CmdLineParser.Option tosParam = parser.addBooleanOption('t', "tos");
        

        try {
            parser.parse(args);
        }
        catch ( CmdLineParser.OptionException e ) {
            System.err.println(e.getMessage());
            printUsage();
            System.exit(2);
        }
       
        swfEnabled = (Boolean)parser.getOptionValue(swfParam, Boolean.FALSE);
        tosEnabled = (Boolean)parser.getOptionValue(tosParam, Boolean.FALSE);
        String[] otherArgs = parser.getRemainingArgs();
        
        switch(otherArgs.length){
        	case 1: {
        		if(!swfEnabled){
        			inputFileName = otherArgs[0];
        		} else {
        			printUsage();                                                       
            		System.exit(2);
        		}
        		break;
        	}
        	
        	// TODO 'Alasc --swf pippo pluto' passa lo stesso, che fare?
        	
        	case 2: {
        		// Se ho due argomenti 'sfusi' e l'esportazione in swf e' abilitata,
        		// allora il secondo e' path di Mtasc.
        		
        		if(swfEnabled){
        			inputFileName = otherArgs[0];
        			pathMtasc = otherArgs[1];
        			swfFileName = inputFileName + ".swf";
        		} else {
        			printUsage();                                                       
            		System.exit(2);
        		}
        		break;
        	}
        	case 3: {
        		// Se ho tre argomenti 'sfusi' e l'esportazione in swf e' abilitata,
        		// allora il secondo e' il path del compilatore Mtasc e il terzo il target dell'esportazione.
        		if(swfEnabled){
        			inputFileName = otherArgs[0];
        			pathMtasc = otherArgs[1];
        			swfFileName = otherArgs[2];
        		} else {
        			printUsage();                                                       
            		System.exit(2);
        		}
        		break;
        	}
        	
        	// Se non ho argomenti sfusi oppure ne ho piu' di due, allora errore nell'invocazione.
        	
        	default:{
        		printUsage();                                                       
        		System.exit(2);
        	}
        }
    }
    
    // TODO Inserire qui il codice per il bannerino
    private static void printBanner() {
        System.out.println("ALASC: A Logo (to) ActionScript Compiler");
        System.out.println("http://code.google.com/p/alasc\n");
    }
    
    private static void printSummary() {
    	System.out.println("Alasc options summary");
        System.out.println(" Input LOGO file: " + inputFileName);
        System.out.println(" Output ActionScript file: " + outputFileName);
        System.out.println(" Print table of symbol: " + tosEnabled);
        System.out.println(" Export to SWF file via Mtasc: " + swfEnabled);
        
        if(swfEnabled){
        	System.out.println("\nMtasc options summary");
        	System.out.println(" Mtasc path: " + pathMtasc);
        	System.out.println(" Export to SWF file target: " + swfFileName + "\n");
        }
        
    }
    
    private static void compileLogo() {
         
    	logoParser = null;
    	
         try {
 			logoParser = new Parser(new FileReader(inputFileName));
 		} catch (FileNotFoundException e) {
         	System.err.println("The specified input file does not exist.");
         	System.exit(2);
 		}
         
 		// TODO Rendere robusta la comunicazione con il parser del Logo!
 		// Parsing del file LOGO aperto...
         parserStatus = logoParser.parse();
         
         // Scrittura su file del risultato...
         FileOutputStream fos = null;
         
 		 try {
 			fos = new FileOutputStream(outputFileName);
 		 } catch (FileNotFoundException e) {
 			System.err.println("The specified output file cannot be written.");
         	System.exit(2);
 		 }
 		
         PrintStream ps=new PrintStream(fos);
         ps.println(logoParser.getCode());
    }
    
    // TODO Sistemare le chiamate di sistema
    private static void exportToSwf() {
    	
    	String mtascCall;
    	
    	if(System.getProperty("os.name").toLowerCase().indexOf("windows")!=-1){
    		System.out.println("Compiling with mtasc.exe (win32)...");
    		mtascCall = pathMtasc + "mtasc.exe Pen.as Disegno.as -main -header 800:600:0 -swf " + swfFileName;
    	} else {
    		System.out.println("Compiling with mtasc (*nix)...");
    		mtascCall = pathMtasc + "mtasc Pen.as Disegno.as -main -header 800:600:0 -swf " + swfFileName;
    	}
    	
    	try {
			Runtime.getRuntime().exec(mtascCall);
		} catch (IOException e) {
			System.err.println("There is some trouble with MTASC. Check that MTASC path is correct.");
			System.exit(2);
		}
    }
    
	private static void printTableOfSymbol() {
		System.out.println("\nDeclared variables:");
		System.out.println(logoParser.getSymbolsTable());
	}
    
	private static void printErrors() {
		System.out.println("\nErrors:");
		System.out.println(logoParser.getErrors());
	}
	
    public static void main( String[] args ) {
    	
        printBanner();
        parseCommandLine(args);
        printSummary();
        compileLogo();
        
        
		if (parserStatus == ParserStatus.COMPILED) {
			System.out.println("\nCompile process has finished succesfully.");
			if (swfEnabled) {
				exportToSwf();
			}
			if (tosEnabled) {
				printTableOfSymbol();
			}
		} else {
			System.out.println("\nSome errors occured during compile process.");
			printErrors();
		}
		System.exit(0);
       
    }


}
                                                                                        