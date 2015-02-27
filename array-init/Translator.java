import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Translator {
	public static void main(String args[]) throws Exception{
		ANTLRInputStream input = new ANTLRInputStream(System.in);

		ArrayInitLexer lexer = new ArrayInitLexer(input);
	
		CommonTokenStream token = new CommonTokenStream(lexer);

		ArrayInitParser parser = new ArrayInitParser(token);
	
		ParseTree tree = parser.init();
		
		ParseTreeWalker walker = new ParseTreeWalker();

		walker.walk(new ShortToUnicodeString(), tree);
	
		System.out.println();
	}
}
