package FileInputOutputReadWrite;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelOperations {

    public static void main(String[] args) throws IOException {

        String filePath = "Testing_Kavya.xlsx";

        // ─────────────────────────────
        // STEP 1: INSERT DATA
        // ─────────────────────────────
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {

            // Sheet 1: LoginTestData
            XSSFSheet sheet1 = workbook.createSheet("LoginTestData");

            sheet1.createRow(0).createCell(0).setCellValue("Username");
            sheet1.getRow(0).createCell(1).setCellValue("Password");
            sheet1.getRow(0).createCell(2).setCellValue("ExpectedResult");

            sheet1.createRow(1).createCell(0).setCellValue("admin");
            sheet1.getRow(1).createCell(1).setCellValue("admin@123");
            sheet1.getRow(1).createCell(2).setCellValue("Login Success");

            sheet1.createRow(2).createCell(0).setCellValue("kavya");
            sheet1.getRow(2).createCell(1).setCellValue("kavya@456");
            sheet1.getRow(2).createCell(2).setCellValue("Login Success");

            sheet1.createRow(3).createCell(0).setCellValue("wronguser");
            sheet1.getRow(3).createCell(1).setCellValue("wrong@pass");
            sheet1.getRow(3).createCell(2).setCellValue("Login Failed");

            // Sheet 2: FullStackTestingSyllabus
            XSSFSheet sheet2 = workbook.createSheet("FullStackTestingSyllabus");

            sheet2.createRow(0).createCell(0).setCellValue("Topic");
            sheet2.getRow(0).createCell(1).setCellValue("Category");

            sheet2.createRow(1).createCell(0).setCellValue("Functional Testing");
            sheet2.getRow(1).createCell(1).setCellValue("Manual");

            sheet2.createRow(2).createCell(0).setCellValue("API Testing");
            sheet2.getRow(2).createCell(1).setCellValue("Postman / RestAssured");

            sheet2.createRow(3).createCell(0).setCellValue("Selenium Automation");
            sheet2.getRow(3).createCell(1).setCellValue("Automation");

            sheet2.createRow(4).createCell(0).setCellValue("SQL");
            sheet2.getRow(4).createCell(1).setCellValue("Database Testing");

            // Sheet 3: BugReport
            XSSFSheet sheet3 = workbook.createSheet("BugReport");

            sheet3.createRow(0).createCell(0).setCellValue("BugID");
            sheet3.getRow(0).createCell(1).setCellValue("Summary");
            sheet3.getRow(0).createCell(2).setCellValue("Severity");
            sheet3.getRow(0).createCell(3).setCellValue("Status");

            sheet3.createRow(1).createCell(0).setCellValue("BUG_001");
            sheet3.getRow(1).createCell(1).setCellValue("Login button not clickable");
            sheet3.getRow(1).createCell(2).setCellValue("Critical");
            sheet3.getRow(1).createCell(3).setCellValue("Open");

            sheet3.createRow(2).createCell(0).setCellValue("BUG_002");
            sheet3.getRow(2).createCell(1).setCellValue("Password field accepts spaces");
            sheet3.getRow(2).createCell(2).setCellValue("Major");
            sheet3.getRow(2).createCell(3).setCellValue("In Progress");

            sheet3.createRow(3).createCell(0).setCellValue("BUG_003");
            sheet3.getRow(3).createCell(1).setCellValue("Error message not displayed");
            sheet3.getRow(3).createCell(2).setCellValue("Minor");
            sheet3.getRow(3).createCell(3).setCellValue("Fixed");

            // Write to file
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            System.out.println("Excel file created: " + filePath);
            System.out.println("======================================================");
        }

        // ─────────────────────────────
        // STEP 2: READ & PRINT DATA
        // ─────────────────────────────
        FileInputStream fis = new FileInputStream(filePath);

        try (XSSFWorkbook workbook1 = new XSSFWorkbook(fis)) {

            // Read Sheet 1: LoginTestData
            XSSFSheet loginSheet = workbook1.getSheet("LoginTestData");
            System.out.println("Sheet: LoginTestData");
            System.out.println("======================================================");

            for (int i = 0; i <= loginSheet.getLastRowNum(); i++) {
                String username = loginSheet.getRow(i).getCell(0).getStringCellValue();
                String password = loginSheet.getRow(i).getCell(1).getStringCellValue();
                String expected = loginSheet.getRow(i).getCell(2).getStringCellValue();
                System.out.println(username + " | " + password + " | " + expected);
            }

            System.out.println("======================================================");

            // Read Sheet 2: FullStackTestingSyllabus
            XSSFSheet syllabusSheet = workbook1.getSheet("FullStackTestingSyllabus");
            System.out.println("Sheet: FullStackTestingSyllabus");
            System.out.println("======================================================");

            for (int i = 0; i <= syllabusSheet.getLastRowNum(); i++) {
                String topic    = syllabusSheet.getRow(i).getCell(0).getStringCellValue();
                String category = syllabusSheet.getRow(i).getCell(1).getStringCellValue();
                System.out.println(topic + " | " + category);
            }

            System.out.println("======================================================");

            // Read Sheet 3: BugReport
            XSSFSheet bugSheet = workbook1.getSheet("BugReport");
            System.out.println("Sheet: BugReport");
            System.out.println("======================================================");

            for (int i = 0; i <= bugSheet.getLastRowNum(); i++) {
                String bugID    = bugSheet.getRow(i).getCell(0).getStringCellValue();
                String summary  = bugSheet.getRow(i).getCell(1).getStringCellValue();
                String severity = bugSheet.getRow(i).getCell(2).getStringCellValue();
                String status   = bugSheet.getRow(i).getCell(3).getStringCellValue();
                System.out.println(bugID + " | " + summary + " | " + severity + " | " + status);
            }

            System.out.println("======================================================");
            System.out.println("All sheets read and printed successfully!");
        }
    }
}