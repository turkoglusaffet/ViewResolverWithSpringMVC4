package com.myapp.viewresolver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.myapp.model.Car;

public class ExcelView extends AbstractExcelView {
 
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
 
    	Car car = (Car) model.get("car");
    	
        Sheet sheet = workbook.createSheet("sheet 1");
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        Row row = null;
        Cell cell = null;
        int rowCount = 0;
        int colCount = 0;
 
        // Create header cells
        row = sheet.createRow(rowCount++);
 
        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Name");
 
        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Model");
 
        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Feature");
 
        // Create data cells
        row = sheet.createRow(rowCount++);
        colCount = 0;
        row.createCell(colCount++).setCellValue(car.getName());
        row.createCell(colCount++).setCellValue(car.getModel());
 
        StringBuffer feature = new StringBuffer("");
        for (String txt : car.getFeature()) {
        	feature.append(txt);
        	feature.append(" ");
        }
        row.createCell(colCount++).setCellValue(feature.toString());
 
        for (int i = 0; i < 3; i++)
            sheet.autoSizeColumn(i, true);
 
    }
 
}
