import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Test {
	public static void main(String args[]) throws Exception{
		ANTLRInputStream input = new ANTLRInputStream(System.in);

		ArrayInitLexer lexer = new ArrayInitLexer(input);
	
		CommonTokenStream token = new CommonTokenStream(lexer);

		ArrayInitParser parser = new ArrayInitParser(token);
	
		ParseTree tree = parser.init();
	
		System.out.println(tree.toStringTree(parser));
	}
}
