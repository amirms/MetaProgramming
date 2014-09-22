// Generated from While.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhileParser}.
 */
public interface WhileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhileParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(@NotNull WhileParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(@NotNull WhileParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#r_while}.
	 * @param ctx the parse tree
	 */
	void enterR_while(@NotNull WhileParser.R_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#r_while}.
	 * @param ctx the parse tree
	 */
	void exitR_while(@NotNull WhileParser.R_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#booleanExp}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExp(@NotNull WhileParser.BooleanExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#booleanExp}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExp(@NotNull WhileParser.BooleanExpContext ctx);
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
	 * Enter a parse tree produced by {@link WhileParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(@NotNull WhileParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(@NotNull WhileParser.ArithmeticContext ctx);
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
	 * Enter a parse tree produced by {@link WhileParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull WhileParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull WhileParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull WhileParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull WhileParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#r_if}.
	 * @param ctx the parse tree
	 */
	void enterR_if(@NotNull WhileParser.R_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#r_if}.
	 * @param ctx the parse tree
	 */
	void exitR_if(@NotNull WhileParser.R_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#r_assignment}.
	 * @param ctx the parse tree
	 */
	void enterR_assignment(@NotNull WhileParser.R_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#r_assignment}.
	 * @param ctx the parse tree
	 */
	void exitR_assignment(@NotNull WhileParser.R_assignmentContext ctx);
}