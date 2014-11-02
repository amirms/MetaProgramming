package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import framework.ast.Assignment;
import framework.ast.BinaryExpression;
import framework.ast.Block;
import framework.ast.BooleanExpression;
import framework.ast.Element;
import framework.ast.Expression;
import framework.ast.ID;
import framework.ast.IdExpression;
import framework.ast.If;
import framework.ast.Int;
import framework.ast.MathExpression;
import framework.ast.NotExpression;
import framework.ast.Procedure;
import framework.ast.ProcedureCall;
import framework.ast.Program;
import framework.ast.SingleStatement;
import framework.ast.Statement;
import framework.ast.While;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.WhileListener;
import parser.WhileParser;

/**
 * Created by Rogier on 29-09-14.
 */
public class MPWhileListener implements WhileListener {

	private Stack<Element> elementStack = new Stack<>();
	private Stack<Block> blockStack = new Stack<>();

	private Map<ID,Procedure> procedureMap = new HashMap<>();


	static Program FINAL_PROGRAM;

	@Override
	public void enterS_while(@NotNull WhileParser.S_whileContext ctx) {
		this.elementStack.push(new While());
	}

	@Override
	public void exitS_while(@NotNull WhileParser.S_whileContext ctx) {
		Statement block = (Statement)this.elementStack.pop();
		Expression conditional = (Expression) this.elementStack.pop();
		While statement = (While) this.elementStack.pop();

		statement.conditional = conditional;
		statement.block = block;

		this.elementStack.push(statement);
	}

	@Override
	public void enterExpression(@NotNull WhileParser.ExpressionContext ctx) {

	}

	@Override
	public void exitExpression(@NotNull WhileParser.ExpressionContext ctx) {

	}

	@Override
	public void enterBool(@NotNull WhileParser.BoolContext ctx) {
		BooleanExpression be = new BooleanExpression();
		be.value = ctx.getText().equals("true");
		this.elementStack.push(be);
	}

	@Override
	public void exitBool(@NotNull WhileParser.BoolContext ctx) {

	}

	@Override
	public void enterAssignment(@NotNull WhileParser.AssignmentContext ctx) {
		Assignment ass = new Assignment();
		ID id = new ID();
		id.id = ctx.ID().getSymbol().getText();
		ass.id = id;
		this.elementStack.push(ass);
	}

	@Override
	public void exitAssignment(@NotNull WhileParser.AssignmentContext ctx) {
		Element value = this.elementStack.pop();
		if ( value instanceof Expression) {
			Expression exp = (Expression)value;
			value = this.elementStack.pop();
			if ( value instanceof Assignment) {
				Assignment assignment = (Assignment)value;
				assignment.expression = exp;
				this.elementStack.push(assignment);
			} else {
				System.err.println("Found " + value);
			}
		} else {
			System.err.println("Found " + value);
		}
	}

	@Override
	public void enterIntExpression(@NotNull WhileParser.IntExpressionContext ctx) {
		Int i = new Int();
		i.value = Integer.parseInt(ctx.Int().getSymbol().getText());
		this.elementStack.push(i);
	}

	@Override
	public void exitIntExpression(@NotNull WhileParser.IntExpressionContext ctx) {

	}

	@Override
	public void enterMathOperator(@NotNull WhileParser.MathOperatorContext ctx) {

	}

	@Override
	public void exitMathOperator(@NotNull WhileParser.MathOperatorContext ctx) {

	}

	@Override
	public void enterMathExpression(@NotNull WhileParser.MathExpressionContext ctx) {
		this.elementStack.push(new MathExpression());
	}

	@Override
	public void exitMathExpression(@NotNull WhileParser.MathExpressionContext ctx) {
		Expression right = (Expression)this.elementStack.pop();
		String operator = ctx.mathOperator().getText();
		Expression left = (Expression)this.elementStack.pop();
		MathExpression exp = (MathExpression) this.elementStack.pop();

		exp.left = left;
		exp.operator = operator;
		exp.right = right;
		this.elementStack.push(exp);
	}

	@Override
	public void enterNotExpression(@NotNull WhileParser.NotExpressionContext ctx) {
		this.elementStack.push(new NotExpression());
	}

	@Override
	public void exitNotExpression(@NotNull WhileParser.NotExpressionContext ctx) {
		Expression subExpression = (Expression)this.elementStack.pop();
		NotExpression exp = (NotExpression) this.elementStack.pop();

		exp.subExpression = subExpression;
		this.elementStack.push(exp);
	}

	@Override
	public void enterProgram(@NotNull WhileParser.ProgramContext ctx) {
		MPWhileListener.FINAL_PROGRAM = new Program();
	}

	@Override
	public void exitProgram(@NotNull WhileParser.ProgramContext ctx) {
		while(!this.elementStack.empty()) {
			MPWhileListener.FINAL_PROGRAM.add(this.elementStack.pop());
		}
	}

	@Override
	public void enterProcedure(@NotNull WhileParser.ProcedureContext ctx) {
		Procedure procedure = new Procedure();

		ID name = new ID();
		name.id = ctx.ID(0).getText();
		procedure.name = name;

		ID returnVal = new ID();
		returnVal.id = ctx.ID(1).getText();
		procedure.returnVal = returnVal;

		List<TerminalNode> parameters = ctx.ID();
		parameters.remove(0);   // that was the name
		parameters.remove(0);   // that was the return value

		List<ID> parameterList = new ArrayList<>();
		for ( TerminalNode tn : parameters ) {
			ID id = new ID();
			id.id = tn.getText();
			parameterList.add(id);
		}
		procedure.parameters = parameterList;
		this.elementStack.push(procedure);
	}

	@Override
	public void exitProcedure(@NotNull WhileParser.ProcedureContext ctx) {
		Block b = (Block)this.elementStack.pop();
		Procedure p = (Procedure) this.elementStack.pop();
		p.content = b;

		this.procedureMap.put(p.name,p);
		this.elementStack.push(p);
	}

	@Override
	public void enterBinaryExpression(@NotNull WhileParser.BinaryExpressionContext ctx) {
		this.elementStack.push(new BinaryExpression());
	}

	@Override
	public void exitBinaryExpression(@NotNull WhileParser.BinaryExpressionContext ctx) {
		Expression right = (Expression)this.elementStack.pop();
		String operator = ctx.binaryOperator().getText();
		Expression left = (Expression)this.elementStack.pop();
		BinaryExpression exp = (BinaryExpression) this.elementStack.pop();

		exp.left = left;
		exp.operator = operator;
		exp.right = right;
		this.elementStack.push(exp);
	}

	@Override
	public void enterIdExpression(@NotNull WhileParser.IdExpressionContext ctx) {
		ID id = new ID();
		id.id = ctx.ID().getSymbol().getText();
		IdExpression ide = new IdExpression();
		ide.id = id;
		this.elementStack.push(ide);
	}

	@Override
	public void exitIdExpression(@NotNull WhileParser.IdExpressionContext ctx) {

	}

	@Override
	public void enterProcedureCall(@NotNull WhileParser.ProcedureCallContext ctx) {
		ID callee = new ID();
		callee.id = ctx.ID(0).getText();

		ID returnVal = new ID();
		returnVal.id = ctx.ID(1).getText();

		List<TerminalNode> list = ctx.ID();
		list.remove(0);
		list.remove(0);
		List<ID> params = new ArrayList<>();
		for(TerminalNode tn : list) {
			ID param = new ID();
			param.id = tn.getText();
			params.add(param);
		}

		ProcedureCall pc = new ProcedureCall();
		pc.callee = this.procedureMap.get(callee);
		pc.returnVal = returnVal;
		pc.params = params;
		this.elementStack.push(pc);
	}

	@Override
	public void exitProcedureCall(@NotNull WhileParser.ProcedureCallContext ctx) {

	}

	@Override
	public void enterBinaryOperator(@NotNull WhileParser.BinaryOperatorContext ctx) {

	}

	@Override
	public void exitBinaryOperator(@NotNull WhileParser.BinaryOperatorContext ctx) {

	}

	@Override
	public void enterStatement(@NotNull WhileParser.StatementContext ctx) {

	}

	@Override
	public void exitStatement(@NotNull WhileParser.StatementContext ctx) {

	}

	@Override
	public void enterBlock(@NotNull WhileParser.BlockContext ctx) {
		Block b = new Block();
		this.elementStack.push(b);
		this.blockStack.push(b);
	}

	@Override
	public void exitBlock(@NotNull WhileParser.BlockContext ctx) {
		Stack<Statement> tmp = new Stack<>();
		Statement x;
		while(true) {
			x = (Statement)this.elementStack.pop();
			if ( x == this.blockStack.peek() ) {
				this.blockStack.pop();
				// Ended
				while(!tmp.empty()) {
					x.add(tmp.pop());
				}
				break;
			} else {
				tmp.push(x);
			}
		}
		this.elementStack.push(x);
	}

	@Override
	public void enterS_if(@NotNull WhileParser.S_ifContext ctx) {
		this.elementStack.push(new If());
	}

	@Override
	public void exitS_if(@NotNull WhileParser.S_ifContext ctx) {
		Statement elseCase = (Statement)this.elementStack.pop();
		Statement ifCase = (Statement)this.elementStack.pop();
		Expression conditional = (Expression) this.elementStack.pop();
		If statement = (If) this.elementStack.pop();

		statement.conditional = conditional;
		statement.ifCase = ifCase;
		statement.elseCase = elseCase;

		this.elementStack.push(statement);

	}

	@Override
	public void enterUnaryExpression(@NotNull WhileParser.UnaryExpressionContext ctx) {

	}

	@Override
	public void exitUnaryExpression(@NotNull WhileParser.UnaryExpressionContext ctx) {

	}

	@Override
	public void visitTerminal(@NotNull TerminalNode terminalNode) {

	}

	@Override
	public void visitErrorNode(@NotNull ErrorNode errorNode) {

	}

	@Override
	public void enterEveryRule(@NotNull ParserRuleContext parserRuleContext) {
		//System.out.println(this.elementStack);
	}

	@Override
	public void exitEveryRule(@NotNull ParserRuleContext parserRuleContext) {
		//System.out.println(this.elementStack);
	}
}
