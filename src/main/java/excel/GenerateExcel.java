package excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateExcel {

    private static final List<ExcelFile> excelFile = new ArrayList<ExcelFile>();
    private static final String[] columns = {"name", "email", "issue_date"};
    private static final String fileName = "automation.xls";

    public static void main(String[] args) throws IOException {
        excelFile.add(new ExcelFile("First Last name", "email@email.com", "2021-10-26"));

        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNum = 1;
        for (ExcelFile excelFile : excelFile) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(excelFile.name);
            row.createCell(1).setCellValue(excelFile.email);
            row.createCell(2).setCellValue(excelFile.issue_date);
        }

        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();
    }

}
