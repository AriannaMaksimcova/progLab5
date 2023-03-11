package tools;

import com.opencsv.CSVWriter;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import organizations.Organization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class WriteDataIntoFileClass {
    private File file;
    private Stack<Organization> organizations;

    public WriteDataIntoFileClass(File file, Stack<Organization> organizations) {
        this.file = file;
        this.organizations = organizations;
    }
    public void writeData(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            StatefulBeanToCsv<Organization> csvWriter = new StatefulBeanToCsvBuilder<Organization>((ICSVWriter) fileOutputStream)
                    .withSeparator(';').withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER).withLineEnd(CSVWriter.DEFAULT_LINE_END)
                    .withOrderedResults(false).build();
            csvWriter.write(organizations);

            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (CsvRequiredFieldEmptyException e) {
            System.out.println("Something went wrong. Check your data.");
        } catch (CsvDataTypeMismatchException e) {
            System.out.println("Something went wrong. Check your data.");
        } catch (IOException e) {
            System.out.println("Something went wrong. Check your data.");
        }
    }

}
