import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

enum COMMAND_TYPE{
    C_ARITHMETIC,
    C_POP,
    C_PUSH,
    C_LABEL,
    C_GOTO,
    C_IF,
    C_FUNCTION,
    C_RETURN,
    C_CALL

}
public class Parser {
    public int counter = 0;
    public Parser(File input) {
        this.file = new HashMap<>();

        try{
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String value = "";
                String Currline = scanner.nextLine();
            }
                if (!Currline.startsWith("//") && !Currline.isEmpty()) {
                    value = Currline.replaceAll("\\+s", "");
                    //removes comments in the line
                    if (value.contains("//")) {
                        value = value.substring(0, Currline.indexOf("//"));
                    }
            }
        }catch (IOException e){
            System.out.println();
        }
    }

    public boolean hasMoreLines() {

        return this.counter < this.file.size();
    }

    public void advance() {
        if (!hasMoreLines()) {
            throw new Error("There are no more lines");
        }
    }

    public COMMAND_TYPE commandType(){

    }

    public String arg1(){

    }
    public String arg2(){

    }
}
