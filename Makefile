JAVAC = javac
JAR = jar
JARFLAGS = cfe

BINDIR = bin

JARFILE = minicomputer-asm.jar

# Java source files
SOURCES = src/ui/AssemblerPanel.java \
		  src/components/Assembler.java \
		  src/components/Compiler.java \
		  src/components/Keyword.java \
		  src/components/Parser.java \
		  src/io/InstructionWriter.java \
		  src/util/ParserUtils.java \
		  src/Main.java

all: program
	
program:
	$(JAVAC) -d bin $(SOURCES)
	$(JAR) $(JARFLAGS) $(JARFILE) Main -C $(BINDIR) .

run:
	java -jar $(JARFILE)

# Clean up the compiled class files and JAR output
clean:
	rm -rf $(BINDIR) $(JARFILE)