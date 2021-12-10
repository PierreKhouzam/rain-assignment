package com.myapplication.utilities;

import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

        private static XSSFSheet excelWorkSheet;
        private static XSSFWorkbook excelWorkBook;
        private static org.apache.poi.ss.usermodel.Cell cell;


        public static void setExcelFile(String path) {
            try {
                FileInputStream excelFile = new FileInputStream(path);
                excelWorkBook = new XSSFWorkbook(excelFile);
            } catch (Exception e) {
                Log.error("Class Utils | Method setExcelFile | Exception desc : " + e.getMessage());
            }
        }

        public static String getCellData(int rowNum, int colNum, String sheetName) {
            try {
                excelWorkSheet = excelWorkBook.getSheet(sheetName);
                cell = excelWorkSheet.getRow(rowNum).getCell(colNum);
                DataFormatter formatter = new DataFormatter();
                return formatter.formatCellValue(cell);
            } catch (Exception e) {
                Log.error("Class Utils | Method setExcelFile | Exception desc : " + e.getMessage());
                return "";
            }
        }

        public static int getRowCount(String sheetName) {
            int iNumber = 0;
            try {
                excelWorkSheet = excelWorkBook.getSheet(sheetName);
                iNumber = excelWorkSheet.getLastRowNum() + 1;
            } catch (Exception e) {
                Log.error("Class Utils | Method setExcelFile | Exception desc : " + e.getMessage());
            }
            return iNumber;
        }

        public static List<String> getAllColumCells(int colNum, String sheetName) {
            try {
                excelWorkSheet = excelWorkBook.getSheet(sheetName);
                int rowNum;
                int totalRows = getRowCount(sheetName);
                List<String> listOfCells = new ArrayList<>();
                for(rowNum=1; rowNum<totalRows; rowNum++){
                    cell = excelWorkSheet.getRow(rowNum).getCell(colNum);
                    DataFormatter formatter = new DataFormatter();
                    listOfCells.add(formatter.formatCellValue(cell));
                }
                return listOfCells;
                } catch (Exception e) {
                Log.error("Class Utils | Method setExcelFile | Exception desc : " + e.getMessage());
                return null;
            }
        }
    }


