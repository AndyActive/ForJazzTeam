package basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DictioinalLoader {
    private static final String patchToDictionary = "./src/main/resources/constant.txt";
    private static final String constantMessageErrorReadFile ="ошибка чтения файла/файл не найден";
    static DictioinalLoader dictioinalLoader;
    static {
        try {
            dictioinalLoader = new DictioinalLoader(patchToDictionary);
        } catch (IOException e) {
            System.out.println(constantMessageErrorReadFile);
        }
    }
    public static final String[] ending = {"а", "ов", "и"};
    public static final String[] digitalFrom1before19 = dictioinalLoader.getDigitalFrom1before19();
    public static final String[] digitalFrom20before100 = dictioinalLoader.getDigitalFrom20before100();
    public static final String[] digitalFrom100before1000 = dictioinalLoader.getDigitalFrom100before1000();
    public static final String[] digitalFrom1000 = dictioinalLoader.getDigitalFrom1000();
    List<String> dictionary;

    public DictioinalLoader(String patch) throws IOException {
         this.dictionary =Files.readAllLines(Paths.get(String.valueOf(patch)));
   }
    // цифры 0-19 + "одна" , "две"
   String[] getDigitalFrom1before19(){
      return dictionary.get(1).split(" ");
   }
    // цифры 0-19
   String[] getDigitalFrom20before100(){
      return dictionary.get(2).split(" ");
   }
    // цифры 100-900
   String[] getDigitalFrom100before1000(){
      return dictionary.get(3).split(" ");
   }
    // цифры 1000-почти бесконечности (новемнонагинтиллион)
   String[] getDigitalFrom1000(){
      return dictionary.get(4).split(" ");
   }
}
