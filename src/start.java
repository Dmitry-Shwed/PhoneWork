import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import java.io.*;
import java.util.*;



public class start {

    public static void main(String[] args) throws Exception {
        String filename = "C:\\Users\\DimaS_1\\Desktop\\111.xls";

// Запускаем диалоговое окно


//создаем файл для записи телефонов на пробивку
        final File file = new File(filename);

        if (file.exists()) {
            final File parentFolder = new File(file.getAbsolutePath()
                    .substring(0, file.getAbsolutePath().lastIndexOf(
                            File.separator)));
            File file2 = new File(parentFolder.getAbsolutePath(), "FIO.txt");
            file2.createNewFile();
        }
        else
        {
            System.out.println("Файл не существует.");
        }



        int Data_COLUMN_NUMBER = 0;
        int TimeOfCall_COLUMN_NUMBER = 1;
        int AbonentPHONE_COLUMN_NUMBER = 2;
        int SobesedPHONE_COLUMN_NUMBER = 3;
        int TypeOfCall_COLUMN_NUMBER = 4;
        int ImeI_COLUMN_NUMBER = 5;
        int SotaTower_COLUMN_NUMBER = 6;
        ArrayList <String> needFio = new ArrayList<>();


        HSSFWorkbook workBook = new HSSFWorkbook(new FileInputStream(filename));
        HSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> rows = sheet.rowIterator();




        while(rows.hasNext())
        {
            HSSFRow row = (HSSFRow) rows.next();
            //получаем значение ячеек по номерам столбцов
            HSSFCell dataCall = row.getCell(Data_COLUMN_NUMBER);
            //получаем строковое значение из ячейки
            Date data = dataCall.getDateCellValue();

            HSSFCell addressCell = row.getCell(TimeOfCall_COLUMN_NUMBER);
            String timing = addressCell.getStringCellValue();

            HSSFCell phoneNumberCell = row.getCell(AbonentPHONE_COLUMN_NUMBER);
            String AbonentNumber = phoneNumberCell.getStringCellValue();

            HSSFCell SobesedphoneNumberCell = row.getCell(SobesedPHONE_COLUMN_NUMBER);
            String SobesedNumber = SobesedphoneNumberCell.getStringCellValue();

            if(needFio.contains(SobesedNumber))
            {

            }
            else {
                needFio.add(SobesedNumber);
            }

            HSSFCell TypeOfCallNumberCell = row.getCell(TypeOfCall_COLUMN_NUMBER);
            String TypeOfCall = TypeOfCallNumberCell.getStringCellValue();


            HSSFCell ImeINumberCell = row.getCell(ImeI_COLUMN_NUMBER);
            String ImeI = ImeINumberCell.getStringCellValue();


            HSSFCell SotaTowerCell = row.getCell(SotaTower_COLUMN_NUMBER);
            String Sota = SotaTowerCell.getStringCellValue();


           System.out.print("|" + data);
           System.out.print("|" + timing);
           System.out.print("|" + SobesedNumber);
           System.out.print("|" + AbonentNumber);
           System.out.print("|" + TypeOfCall);
           System.out.print("|" + ImeI);
           System.out.println("|" + Sota);


        }

        System.out.print(needFio);

        //запись в файл
        try
        {
            OutputStream f = new FileOutputStream("/home/dimas/Desktop/Folder/FIO.txt", true); //требуется склеить путь и имя файла
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for(int i = 0; i < needFio.size(); i++)
            {
                out.write(needFio.get(i) + "\n");
                out.flush();
            }
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }

    }

    // FileReder readTheFile =new FileReder();
    //readTheFile.fileReaderFromFile(filename);

}
