import java.io.*;

public class CodeWriter {
    private BufferedWriter outputWriter;
    private File outputFile;
    public CodeWriter(File output) {
        this.outputFile = output;
        try {
            this.outputWriter = new BufferedWriter(new FileWriter(output));
        }catch (IOException e){
            System.out.println("Error opening output file");
        }
    }
    public void writeArithmetic(String command){
        try {
            switch (command) {
                case ("add"):
                    this.outputWriter.write("M=M+D");
                case("sub"):
                    this.outputWriter.write("M=M-D");
                case("neg"):
                    this.outputWriter.write("");
                case("eq"):
                    this.outputWriter.write("JEQ");
                case("gt"):
                    this.outputWriter.write("JGT");
                case("ls"):
                    this.outputWriter.write("JLT");
                case("and"):
                    this.outputWriter.write("M=M&D");
                case("or"):
                    this.outputWriter.write("M=M|D");
                case("not"):
                    this.outputWriter.write("");
                default:
                    System.out.println("");
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writePushPop(COMMAND_TYPE commandType, String arg1, int arg2) {
        if (commandType == COMMAND_TYPE.C_PUSH) {
            writePush(arg1,arg2);
        }else writePop(arg1,arg2);
    }

    public void writePush(String arg1, int arg2) {
        try {
            //write command as comment
            this.outputWriter.write("//push" + arg1 + arg2);
            //push constant
            this.outputWriter.write("@" + arg2 + "\nD=A\n@SP\nA=M\nM=D\n@SP\nM=M+1");
            //push local
            this.outputWriter.write("@LCL\nD=M\n@" + arg2 + "\nA=D+A\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1");
            //push argument
            this.outputWriter.write("@ARG\nD=M\n@" + arg2 + "\nA=D+A\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1");
            //push pointer//
            String pointer = "";
            if (arg2 == 0) {
                pointer = "THIS";
            }
                //push this
                this.outputWriter.write("@THIS\nD=M\n@" + arg2 + "\nA=D+A\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1");
                //push that
                this.outputWriter.write("@THAT\nD=M\n@" + arg2 + "\nA=D+A\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1");
                //push static
                this.outputWriter.write(outputFile.getName() + "." + arg2 + "\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1");
                //push temp
                int index = arg2 + 5;
                this.outputWriter.write("@R5\nD=M\n@" + index + "\nA=D+A\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1");

            }catch(IOException e){
                System.out.println("");
            }
        }
    }
    public void writePop(String arg1, int arg2){
        try {
            //write command as comment
            this.outputWriter.write("//pop" + arg1 + arg2);
            //push constant
            this.outputWriter.write("@LCL\nD=M\n@arg2\nD=D+A\n@SP\nA=M\nM=D\n@SP\nM=M+1");
            //push local
            this.outputWriter.write("");
            //push argument
            this.outputWriter.write("");
            //push this
            this.outputWriter.write("");
            //push that
            this.outputWriter.write("");
            //push static
            this.outputWriter.write("");
            //push pointer
            this.outputWriter.write("");
            //push temp
            this.outputWriter.write("");


        }catch (IOException e){
            System.out.println("");
        }
    }
    }

    public void close(){

    }
}
