import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends CalcBaseVisitor<Integer> {
	Map<String, Integer> memory = new HashMap<String, Integer>();

	@Override
	public Integer visitAssign(CalcParser.AssignContext ctx) {
		String id = ctx.ID().getText();
		int value = visit(ctx.expr());
		memory.put(id, value);
		return value;
	}
	
	@Override
	public Integer visitPrintExpr(CalcParser.PrintExprContext ctx) {
		Integer value = visit(ctx.expr());
		System.out.println(value);
		return 0;
	}

	@Override
	public Integer visitInt(CalcParser.IntContext ctx) {
		return Integer.valueOf(ctx.INT().getText());
	}

	@Override
	public Integer visitId(CalcParser.IdContext ctx) {
		String id = ctx.ID().getText();
		if ( memory.containsKey(id)) return memory.get(id);
		return 0;
	}

	@Override
	public Integer visitMulDiv(CalcParser.MulDivContext ctx) {
		int left = visit(ctx.expr(0));
		int right = visit(ctx.expr(1));
		if ( ctx.op.getType() == CalcParser.MUL ) return left * right ;
		return left / right;
	}

	@Override
	public Integer visitAddSub(CalcParser.AddSubContext ctx) {
		int left = visit(ctx.expr(0));
		int right = visit(ctx.expr(1));
		if ( ctx.op.getType() == CalcParser.ADD ) return left + right;
		return left - right;
	}

	@Override
	public Integer visitParens(CalcParser.ParensContext ctx) {
		return visit(ctx.expr());
	}
}
