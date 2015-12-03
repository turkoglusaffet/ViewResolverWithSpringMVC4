package com.myapp.viewresolver;

import java.awt.Color;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.myapp.model.Car;
 
public class PdfView extends AbstractPdfView {
 
    @Override
    protected void buildPdfDocument(Map<String, Object> model,
            Document document, PdfWriter writer, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
 
        Car car = (Car) model.get("car");
 
        PdfPTable table = new PdfPTable(3);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(Color.lightGray);
 
        table.addCell("Name");
        table.addCell("Model");
        table.addCell("Feature");
 
        table.addCell(car.getName());
        table.addCell(car.getModel());
 
        StringBuffer feature = new StringBuffer("");
        for (String ft : car.getFeature()) {
            feature.append(ft);
            feature.append(" ");
        }
        table.addCell(feature.toString());
        document.add(table);
 
    }

}