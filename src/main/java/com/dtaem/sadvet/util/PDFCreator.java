package com.dtaem.sadvet.util;
import com.dtaem.sadvet.model.bean.EmailDetailsBean;
import com.dtaem.sadvet.model.entity.Receta;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PDFCreator {

    private float total=Float.valueOf(0);
    public void createPDF(EmailDetailsBean details, String date) {
        total=Float.valueOf(0);
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(details.getAttachment()));
            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);


            Paragraph paraTitulo = new Paragraph("RECETA MEDICA", font);
            document.add(paraTitulo);
            Paragraph paraDate = new Paragraph("Fecha: " + date, font);
            document.add(paraDate);

            PdfPTable table = new PdfPTable(4); // 2 columnas.
            PdfPCell cell1 = new PdfPCell(new Phrase("Producto"));
            PdfPCell cell2 = new PdfPCell(new Phrase("Cantidad"));
            PdfPCell cell3 = new PdfPCell(new Phrase("Precio"));
            PdfPCell cell4 = new PdfPCell(new Phrase("Subtotal"));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);

            details.getProductos().forEach(
                    receta -> addCells(table,receta)
            );
            document.add(table);

            Paragraph paraTotal = new Paragraph("Total: $" + total, font);
            document.add(paraTotal);
            document.close();

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addCells(PdfPTable table, Receta receta){
        table.addCell(receta.getNombre());
        table.addCell(Objects.toString(receta.getCantidad()));
        table.addCell("$"+Objects.toString(receta.getPrecio()));
        table.addCell("$"+Objects.toString(receta.getSubtotal()));
        total+=receta.getSubtotal();
    }
    public void deleteFile(String path) {
        File file = new File(path);

        if (file.delete()) {
            System.out.println("El archivo fue borrado exitosamente");
        } else {
            System.out.println("Hubo un error al intentar borrar el archivo");
        }
    }
}