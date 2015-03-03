import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Calc {
	public static void main(String args[]) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		CalcLexer lexer = new CalcLexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(token);
		ParseTree tree = parser.prog();
		// System.out.println(tree.toStringTree(parser));
		
	}
}
