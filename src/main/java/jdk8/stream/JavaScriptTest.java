package jdk8.stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Created by Administrator on 2017/2/9.
 */
public class JavaScriptTest {
    public static void main(String[] args) throws  Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName( "JavaScript" );

        System.out.println( engine.getClass().getName() );
        System.out.println( "Result:" + engine.eval( "function f(a) { return a+1; }; f(2) + 1;" ) );


    }
}
