package com.google.code.alasc;

public class SimpleBeautifier extends Beautifier {

	public SimpleBeautifier(int tabs) {
		super(tabs);
	}

	public String beautify(String code) {
		StringBuffer buffer = new StringBuffer();	
		boolean inFor = false;
		StringBuffer toWrite = new StringBuffer();
		
		int codeLength = code.length();
		buffer.append(addTabs());
		for(int i = 0; i < codeLength; i++) {
			
			if ( (i+3) <= codeLength ) {
				if (code.substring(i, i+3).equals("for")) {
					inFor = true;
				}
			}
			
			if (code.charAt(i) == ';' && inFor == true) {
				buffer.append(code.charAt(i));
			}
			
			if (code.charAt(i) == ';' && inFor == false) {
				buffer.append(code.charAt(i));
				
				toWrite.append('\n');
				toWrite.append(addTabs());
				
				/*buffer.append('\n');
				buffer.append(addTabs());*/
			}
			
			if (code.charAt(i) != ';' && code.charAt(i) != '{' && code.charAt(i) != '}') {
				if(toWrite.length() > 0) {
					buffer.append(toWrite.toString());
					toWrite = new StringBuffer();
				}
				buffer.append(code.charAt(i));
			}
			
			if (inFor == true && code.charAt(i) == '{') {
				inFor = false;
			}
			
			if(code.charAt(i) == '{') {
				buffer.append(code.charAt(i));
				
				toWrite.append('\n');
				this.tabs++;
				toWrite.append(addTabs());
				
				/*buffer.append('\n');
				this.tabs++;
				buffer.append(addTabs());*/
			}
			
			if (code.charAt(i) == '}') {
				buffer.append('\n');
				this.tabs--;
				buffer.append(addTabs());
				buffer.append(code.charAt(i));
	
				toWrite = new StringBuffer();
				toWrite.append('\n');
				toWrite.append(addTabs());
				/*buffer.append('\n');
				buffer.append(addTabs());*/
			}
			
		}
		return buffer.toString();
	}
	
	private String addTabs() {
		String tabs = "";
		for(int i = 0; i < this.tabs; i++) {
			tabs += "\t";
		}
		return tabs;
	}

}
