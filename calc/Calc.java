import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.InputStream;
import java.io.FileInputStream;
public class Calc {
	public static void main(String args[]) throws Exception {
		String inputFile = null;
		if ( args.length > 0 ) inputFile = args[0];
		InputStream is = System.in;
		if ( inputFile != null ) is = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(is);
		CalcLexer lexer = new CalcLexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(token);
		ParseTree tree = parser.prog();
		EvalVisitor eval = new EvalVisitor();
		eval.visit(tree);	
	}
}
