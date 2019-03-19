package tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Li
 * @date 2019/3/19-19:58
 */
public class FileTool {

    public static void write(String value, String file_name){
        File file = new File(file_name);
        PrintWriter output = null;
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            output = new PrintWriter(file_name);
            output.print(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            output.close();
        }
    }
}
