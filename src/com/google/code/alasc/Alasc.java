package com.google.code.alasc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import jargs.gnu.CmdLineParser;                                                 

public class Alasc {

    private static void printUsage() {
        System.err.println("Usage: Alasc [{-i, --input} i_file] [{-s,--swf}] [-t, -tos]\n");
    }

    public static void main( String[] args ) {

        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option swf = parser.addBooleanOption('s', "swf");
        CmdLineParser.Option tos = parser.addBooleanOption('t', "tos");
        CmdLineParser.Option iFile = parser.addStringOption('i', "input");

        try {
            parser.parse(args);
        }
        catch ( CmdLineParser.OptionException e ) {
            System.err.println(e.getMessage());
            printUsage();
            System.exit(2);
        }

        String iFileValue = (String)parser.getOptionValue(iFile);
        
        if(iFileValue == null){
        	printUsage();
        	System.exit(2);
        }
        
        Boolean swfValue = (Boolean)parser.getOptionValue(swf, Boolean.FALSE);
        Boolean tosValue = (Boolean)parser.getOptionValue(tos, Boolean.FALSE);
        String[] otherArgs = parser.getRemainingArgs();
        
        System.out.println("ALASC: A Logo (to) ActionScript Compiler\n");
        System.out.println("Print table of symbol: " + tosValue);
        System.out.println("Export to swf: " + swfValue);
        System.out.println("Input file: " + iFileValue);

//        System.out.println("remaining args: ");
//        for ( int i = 0; i < otherArgs.length; ++i ) {
//            System.out.println(otherArgs[i]);
//        }
        
        Parser logoParser = null;
        
        try {
			logoParser = new Parser(new FileReader(iFileValue));
		} catch (FileNotFoundException e) {
        	System.err.println("The specified file does not exist.");
        	System.exit(2);
		}
        
        logoParser.parse();
        
        System.out.println(logoParser.getCode());
		
        System.exit(0);
    }
}
                                                                                        