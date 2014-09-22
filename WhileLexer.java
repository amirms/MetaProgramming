// Generated from While.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WhileLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, ID=12, Int=13, Concat=14, BooleanOperator=15, IntOperator=16, 
		Bool=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "ID", "Int", "Concat", "BooleanOperator", "IntOperator", 
		"Bool", "WS"
	};


	public WhileLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "While.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\7\rM\n\r\f\r\16\rP\13\r\3\16\3\16\3\16\6\16U\n\16"+
		"\r\16\16\16V\5\16Y\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5"+
		"\17d\n\17\3\20\3\20\3\20\5\20i\n\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22v\n\22\3\23\7\23y\n\23\f\23\16\23|\13\23\3\23"+
		"\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\3\2\t\4\2C\\c|\5\2\62;C\\c|\3\2\62;\3\2"+
		"\63;\4\2>>@@\5\2,-//\61\61\5\2\13\f\17\17\"\"\u0087\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'"+
		"\3\2\2\2\5*\3\2\2\2\7/\3\2\2\2\t\61\3\2\2\2\13\64\3\2\2\2\r\66\3\2\2\2"+
		"\178\3\2\2\2\21>\3\2\2\2\23C\3\2\2\2\25E\3\2\2\2\27G\3\2\2\2\31J\3\2\2"+
		"\2\33X\3\2\2\2\35c\3\2\2\2\37h\3\2\2\2!j\3\2\2\2#u\3\2\2\2%z\3\2\2\2\'"+
		"(\7<\2\2()\7?\2\2)\4\3\2\2\2*+\7g\2\2+,\7n\2\2,-\7u\2\2-.\7g\2\2.\6\3"+
		"\2\2\2/\60\7*\2\2\60\b\3\2\2\2\61\62\7f\2\2\62\63\7q\2\2\63\n\3\2\2\2"+
		"\64\65\7+\2\2\65\f\3\2\2\2\66\67\7=\2\2\67\16\3\2\2\289\7y\2\29:\7j\2"+
		"\2:;\7k\2\2;<\7n\2\2<=\7g\2\2=\20\3\2\2\2>?\7v\2\2?@\7j\2\2@A\7g\2\2A"+
		"B\7p\2\2B\22\3\2\2\2CD\7}\2\2D\24\3\2\2\2EF\7\177\2\2F\26\3\2\2\2GH\7"+
		"k\2\2HI\7h\2\2I\30\3\2\2\2JN\t\2\2\2KM\t\3\2\2LK\3\2\2\2MP\3\2\2\2NL\3"+
		"\2\2\2NO\3\2\2\2O\32\3\2\2\2PN\3\2\2\2QY\t\4\2\2RT\t\5\2\2SU\t\4\2\2T"+
		"S\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XQ\3\2\2\2XR\3\2\2\2"+
		"Y\34\3\2\2\2Z[\7q\2\2[d\7t\2\2\\]\7c\2\2]^\7p\2\2^d\7f\2\2_`\7~\2\2`d"+
		"\7~\2\2ab\7(\2\2bd\7(\2\2cZ\3\2\2\2c\\\3\2\2\2c_\3\2\2\2ca\3\2\2\2d\36"+
		"\3\2\2\2ei\t\6\2\2fg\7?\2\2gi\7?\2\2he\3\2\2\2hf\3\2\2\2i \3\2\2\2jk\t"+
		"\7\2\2k\"\3\2\2\2lm\7v\2\2mn\7t\2\2no\7w\2\2ov\7g\2\2pq\7h\2\2qr\7c\2"+
		"\2rs\7n\2\2st\7u\2\2tv\7g\2\2ul\3\2\2\2up\3\2\2\2v$\3\2\2\2wy\t\b\2\2"+
		"xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\b\23\2"+
		"\2~&\3\2\2\2\n\2NVXchuz\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}