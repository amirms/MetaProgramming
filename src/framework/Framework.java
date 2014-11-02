package framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import framework.ast.Block;
import framework.ast.Element;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.*;

/**
 * Created by Rogier on 22-09-14.
 */
public class Framework
{

	public static int currentLabel = 1;

	public static String TESTDIR = "/Users/Rogier/Dropbox/Studie/ST Software Technology/IN4313 Seminar Metaprogramming/assignment1/tests/";
	public static String TESTFILE = "complex";

	public static void main( String[] args) {
		try {
			WhileLexer lexer = new WhileLexer(new ANTLRFileStream(TESTDIR+TESTFILE));
			WhileParser parser = new WhileParser(new CommonTokenStream(lexer));
			ParseTree tree = parser.program();
			ParseTreeWalker.DEFAULT.walk(new MPWhileListener(), tree);

			System.out.println(MPWhileListener.FINAL_PROGRAM.astString());

			System.out.println(MPWhileListener.FINAL_PROGRAM.internalFlow());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
