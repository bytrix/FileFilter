import java.io.File;
import java.util.Date;
import java.util.Calendar;
import com.filenameparser.FilenameParser;
import com.filenameparser.util.Util;

class Tester {
  public static final String PATH = "C:\\Users\\jack\\Desktop\\phone_album_4.1";
  public static void main(String[] args) {

    File foundDir = new File("found");
    foundDir.mkdir();

    File path = new File(PATH);
    int count = 0, total = 0;
    for(File file : path.listFiles()) {
      total++;
      String fileName = file.getName();
      FilenameParser filenameParser = new FilenameParser(fileName, 4, 14, 16);
      if(filenameParser.isFound) {
        System.out.println(fileName + "\t\t" + filenameParser.getCalendar().getTime() + "\t<-------------- FOUND!");
        Util.copyFile(file.toString(), "found\\" + fileName);
        count++;
      } else {
        System.out.println(fileName + "\t\t" + filenameParser.getCalendar().getTime());
      }
    }
    System.out.println("------------------------------------------------------------");
    System.out.println(total + " files searched,");
    System.out.println(count + " files found!");

  }
}
