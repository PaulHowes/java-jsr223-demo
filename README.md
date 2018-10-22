# JSR223 Test

I wanted to better understand how the JSR-223 scripting interface worked with
some of the more popular JVM languages. This repository contains a very simple
application that enumerates languages recognized on the `CLASSPATH` and runs a
script in some of them.

This project was originally compiled for JRE 8, which includes Nashorn, the
Javascript runtime from Oracle. This is always available because it's built-
in to the JRE.

`build.gradle` includes support for Groovy and Kotlin, two popular JVM
languages. If there are other languages that you would like to see included,
send me a pull request.

## Build and Run

    ./gradlew clean run

## Notes

Kotlin is a bit odd in how JSR-223 support is enabled. With Groovy, it's
enough to simply include the JAR files on the `CLASSPATH` and the language
is available. Kotlin requires a file in your project named
`src/main/resources/MET-INF/services/javax.script.ScriptEngineFactory` to
exist and contain a single line:

    org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory

## TODO

I'd like to include some kind of test suite that can compare the performance
of the various languages. For example, running the application makes it very
obvious that Kotlin has an expensive (e.g. slow) startup where Groovy is
quick.

## Contributing

1.  Fork it
2.  Create a feature branch (`git checkout -b new-feature`)
3.  Commit changes (`git commit -am "Added new feature xyz"`)
4.  Push the branch (`git push origin new-feature`)
5.  Create a new pull request.

## Maintainers

* Paul Howes (http://github.com/PaulHowes/)

## License

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
