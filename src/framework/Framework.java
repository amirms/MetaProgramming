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
	public static String TESTFILE1 = "ae_example";

	public static void main(String[] args) {
		try {
			WhileLexer lexer = new WhileLexer(new ANTLRFileStream(TESTDIR + TESTFILE1));
			WhileParser parser = new WhileParser(new CommonTokenStream(lexer));
			ParseTree tree = parser.program();
			ParseTreeWalker.DEFAULT.walk(new MPWhileListener(), tree);

			System.out.println(MPWhileListener.FINAL_PROGRAM.astString());

			System.out.println(MPWhileListener.FINAL_PROGRAM.internalFlow());

			System.out.println();

			System.out.println("Reaching definitions");
			Analysis rd = new ReachingDefinitions(MPWhileListener.FINAL_PROGRAM.internalFlow());
			System.out.println(rd.performAnalysis());

			System.out.println("Available expressions");
			rd = new AvailableExpressions(MPWhileListener.FINAL_PROGRAM.internalFlow());
			System.out.println(rd.performAnalysis());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
