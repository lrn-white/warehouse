package com.liu.warehouse.commons.excel;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.List;

import com.liu.warehouse.model.MenuExcel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFromDB {

    public final static String outputFile = "D:/test.xlsx";

    public void ReadExcel(List<MenuExcel> menuExcels) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("菜单");
            XSSFRow row = sheet.createRow((short) 0);
            XSSFCell cell = null;
            cell = row.createCell((short) 0);
            cell.setCellValue("菜名");
            cell = row.createCell((short) 1);
            cell.setCellValue("单价");
            cell = row.createCell((short) 2);
            cell.setCellValue("原材料名");
            cell = row.createCell((short) 3);
            cell.setCellValue("数量");

            int i = 1;
            for (MenuExcel menuExcel: menuExcels) {
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(menuExcel.getDishName());
                cell = row.createCell(1);
                cell.setCellValue(menuExcel.getTotalPrice());
                cell = row.createCell(2);
                cell.setCellValue(menuExcel.getMaterialName());
                cell = row.createCell(3);
                cell.setCellValue(menuExcel.getAmount());
                i++;
            }
            FileOutputStream FOut = new FileOutputStream(outputFile);
            workbook.write(FOut);
            FOut.flush();
            FOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}