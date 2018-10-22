/*
   Copyright 2018 Paul Howes

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ScriptTest {
    static void listScriptEngines() {
        List<ScriptEngineFactory> factories = scriptEngineManager.getEngineFactories();

        factories.forEach(factory -> {
            System.out.printf("%s (%s)\n", factory.getEngineName(), factory.getEngineVersion());
            System.out.printf("\tLanguage:   %s (%s)\n", factory.getLanguageName(), factory.getLanguageVersion());
            System.out.printf("\tNames:      %s\n", String.join(", ", factory.getNames()));
            System.out.printf("\tExtensions: %s\n", String.join(", ", factory.getExtensions()));
            System.out.printf("\tMIME Types: %s\n", String.join(", ", factory.getMimeTypes()));
        });
    }

    static void runGroovy() throws Throwable {
        ScriptEngine engine = scriptEngineManager.getEngineByName("groovy");
        engine.eval("println(\"from groovy:     1 + 1 = ${1 + 1}\")");
    }

    static void runJavascript() throws Throwable {
        ScriptEngine engine = scriptEngineManager.getEngineByName("javascript");
        engine.eval("print('from javascript: 1 + 1 =', 1 + 1)");
    }

    static void runKotlin() throws Throwable {
        ScriptEngine engine = scriptEngineManager.getEngineByName("kotlin");
        engine.eval("println(\"from kotlin:     1 + 1 = ${1 + 1}\")");
    }

    public static void main(String[] args) throws Throwable {
        listScriptEngines();
        runGroovy();
        runJavascript();
        runKotlin();
    }

    private static ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
}
