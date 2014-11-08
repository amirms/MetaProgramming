package framework;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.WhileLexer;
import parser.WhileParser;

/**
 * Created by Rogier on 22-09-14.
 */
public class Framework {

	public static int currentLabel = 1;

	public static String TESTDIR =
			"/Users/Rogier/Dropbox/Studie/ST Software Technology/IN4313 Seminar Metaprogramming/assignment1/tests/";

	public static void main(String[] args) {
		definiteAssignments();
		availableExpressions();
		reachingDefinitions();
	}

	public static void definiteAssignments() {
		try {
			System.out.println("#################################");
			System.out.println("#                               #");
			System.out.println("# DEFINITE ASSIGNMENTS ANALYSIS #");
			System.out.println("#                               #");

			WhileLexer lexer = new WhileLexer(new ANTLRFileStream(TESTDIR + "da_example"));
			WhileParser parser = new WhileParser(new CommonTokenStream(lexer));
			ParseTree tree = parser.program();
			ParseTreeWalker.DEFAULT.walk(new MPWhileListener(), tree);

			System.out.println("This is the generated AST:");
			System.out.println(MPWhileListener.FINAL_PROGRAM.astString());
			System.out.println();

			System.out.println("This is the generated CFG");
			System.out.println(MPWhileListener.FINAL_PROGRAM.internalFlow());

			System.out.println();

			System.out.println("These are the computed definite assignments");
			Analysis rd = new DefiniteAssignments(MPWhileListener.FINAL_PROGRAM.internalFlow());
			System.out.println(rd.performAnalysis());

			System.out.println();
			System.out.println("#     #");
			System.out.println("#######");
			System.out.println();

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void availableExpressions() {
		try {
			System.out.println("##################################");
			System.out.println("#                                #");
			System.out.println("# AVAILABLE EXPRESSIONS ANALYSIS #");
			System.out.println("#                                #");
			System.out.println("#                                #");
			System.out.println();

			WhileLexer lexer = new WhileLexer(new ANTLRFileStream(TESTDIR + "ae_example"));
			WhileParser parser = new WhileParser(new CommonTokenStream(lexer));
			ParseTree tree = parser.program();
			ParseTreeWalker.DEFAULT.walk(new MPWhileListener(), tree);

			System.out.println("This is the generated AST:");
			System.out.println(MPWhileListener.FINAL_PROGRAM.astString());
			System.out.println();

			System.out.println("This is the generated CFG");
			System.out.println(MPWhileListener.FINAL_PROGRAM.internalFlow());

			System.out.println();

			System.out.println("These are the computed definite assignments");
			Analysis rd = new AvailableExpressions(MPWhileListener.FINAL_PROGRAM.internalFlow());
			System.out.println(rd.performAnalysis());

			System.out.println();
			System.out.println("#     #");
			System.out.println("#######");
			System.out.println();

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void reachingDefinitions() {
		try {
			System.out.println("#################################");
			System.out.println("#                               #");
			System.out.println("# REACHING DEFINITIONS ANALYSIS #");
			System.out.println("#                               #");

			WhileLexer lexer = new WhileLexer(new ANTLRFileStream(TESTDIR + "rd_example"));
			WhileParser parser = new WhileParser(new CommonTokenStream(lexer));
			ParseTree tree = parser.program();
			ParseTreeWalker.DEFAULT.walk(new MPWhileListener(), tree);

			System.out.println("This is the generated AST:");
			System.out.println(MPWhileListener.FINAL_PROGRAM.astString());
			System.out.println();

			System.out.println("This is the generated CFG");
			System.out.println(MPWhileListener.FINAL_PROGRAM.internalFlow());

			System.out.println();

			System.out.println("These are the computed definite assignments");
			Analysis rd = new ReachingDefinitions(MPWhileListener.FINAL_PROGRAM.internalFlow());
			System.out.println(rd.performAnalysis());

			System.out.println();
			System.out.println("#     #");
			System.out.println("#######");
			System.out.println();

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
