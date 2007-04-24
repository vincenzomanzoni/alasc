package com.google.code.alasc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import jargs.gnu.CmdLineParser;                                                 

public class Alasc {

	private static String inputFileName, swfFileName;
	private static final String outputFileName = "Disegno.as";
	private static boolean tosEnabled, swfEnabled;
	
	private static Parser logoParser;
	
    private static void printUsage() {
        System.err.println("Usage: Alasc input_logo [-s/--swf] <output_flash> [-t/--tos]\n");
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
        		inputFileName = otherArgs[0];
        		break;
        	}
        	case 2: {
        		// Se ho due argomenti 'sfusi' e l'esportazione in swf è abilitata,
        		// allora il secondo è il target dell'esportazione.
        		
        		if(swfEnabled){
        			inputFileName = otherArgs[0];
        			swfFileName = otherArgs[1];
        		} else {
        			printUsage();                                                       
            		System.exit(2);
        		}
        		break;
        	}
        	
        	// Se non ho argomenti sfusi oppure ne ho più di due, allora c'è un errore.
        	
        	default:{
        		printUsage();                                                       
        		System.exit(2);
        	}
        }
    }
    
    // TODO Inserire qui il codice per il bannerino
    private static void printBanner() {
        System.out.println("ALASC: A Logo (to) ActionScript Compiler\n");
        System.out.println("http://code.google.com/p/alasc");
    }
    
    private static void printSummary() {
        System.out.println("Input LOGO file: " + inputFileName);
        System.out.println("Output ActionScript file: " + outputFileName);
        System.out.println("Export to SWF file: " + swfEnabled);
        System.out.println("Export to SWF file target: " + swfFileName);
        System.out.println("Print table of symbol: " + tosEnabled);
    }
    
    private static void compileLogo() {
         
    	logoParser = null;
    	
         try {
 			logoParser = new Parser(new FileReader(inputFileName));
 		} catch (FileNotFoundException e) {
         	System.err.println("The specified input file does not exist.");
         	System.exit(2);
 		}
         
 		// Parsing del file LOGO aperto...
         logoParser.parse();
         
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
    
    // TODO come farlo multipiattaforma?
    private static void exportToSwf() {
    	
    }
    
	private static void printTableOfSymbol() {
		System.out.println("\nDeclared variables:");
		System.out.println(logoParser.getSymbolsTable());
	}
    
    public static void main( String[] args ) {
    	
        printBanner();
        parseCommandLine(args);
        printSummary();
        compileLogo();
        
        if (swfEnabled) {
        	exportToSwf();
        }
        
        if (tosEnabled) {
        	printTableOfSymbol();
        }
        
        System.exit(0);
       
    }


}
                                                                                        