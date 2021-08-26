import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class DictioinalLoader {
    List<String> dictionary;

    DictioinalLoader(String patch) {
      try {
         this.dictionary =Files.readAllLines(Paths.get(String.valueOf(patch)));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   //Окончания
   String[] gerEnding(){
       return dictionary.get(1).split(" ");
   }
    // цифры 0-19 + "одна" , "две"
   String[] gerDig1(){
      return dictionary.get(2).split(" ");
   }
    // цифры 0-19
   String[] getDig20(){
      return dictionary.get(3).split(" ");
   }
    // цифры 100-900
   String[] gerDig100(){
      return dictionary.get(4).split(" ");
   }
    // цифры 1000-почти бесконечности (новемнонагинтиллион)
   String[] gerDigStandart(){
      return dictionary.get(5).split(" ");
   }
}
