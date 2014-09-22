// Generated from While.g4 by ANTLR 4.4

package parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhileParser}.
 */
public interface WhileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhileParser#s_while}.
	 * @param ctx the parse tree
	 */
	void enterS_while(@NotNull WhileParser.S_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#s_while}.
	 * @param ctx the parse tree
	 */
	void exitS_while(@NotNull WhileParser.S_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull WhileParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull WhileParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull WhileParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull WhileParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull WhileParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull WhileParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpression(@NotNull WhileParser.IntExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpression(@NotNull WhileParser.IntExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void enterMathOperator(@NotNull WhileParser.MathOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void exitMathOperator(@NotNull WhileParser.MathOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterMathExpression(@NotNull WhileParser.MathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitMathExpression(@NotNull WhileParser.MathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(@NotNull WhileParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(@NotNull WhileParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull WhileParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull WhileParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(@NotNull WhileParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(@NotNull WhileParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(@NotNull WhileParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(@NotNull WhileParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#idExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpression(@NotNull WhileParser.IdExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#idExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpression(@NotNull WhileParser.IdExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void enterProcedureCall(@NotNull WhileParser.ProcedureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void exitProcedureCall(@NotNull WhileParser.ProcedureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperator(@NotNull WhileParser.BinaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperator(@NotNull WhileParser.BinaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull WhileParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull WhileParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull WhileParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull WhileParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#s_if}.
	 * @param ctx the parse tree
	 */
	void enterS_if(@NotNull WhileParser.S_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#s_if}.
	 * @param ctx the parse tree
	 */
	void exitS_if(@NotNull WhileParser.S_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(@NotNull WhileParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(@NotNull WhileParser.UnaryExpressionContext ctx);
}