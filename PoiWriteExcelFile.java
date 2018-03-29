
package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

public class PoiWriteExcelFile {

    public String CreateSheet1(Vector col, Vector Row, String dept, String year, String shift, String name) {
        String pathh = System.getProperty("user.dir") + File.separator + "ATTENDANCE EXLE" + File.separator + dept + File.separator + year + File.separator + shift + File.separator + name;

        System.out.println("path" + pathh);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFWorkbook workbook1 = new HSSFWorkbook();
        HSSFSheet defaulterSheet = workbook1.createSheet();

        //Style for workbook
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        HSSFFont font = workbook.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setFontHeightInPoints((short) 14);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);

        HSSFCellStyle style1 = workbook.createCellStyle();
        style1.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        HSSFFont font1 = workbook.createFont();
        font1.setFontName(HSSFFont.FONT_ARIAL);
        font1.setFontHeightInPoints((short) 11);
        font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style1.setFont(font1);

        HSSFCellStyle style2 = workbook.createCellStyle();
        style1.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        HSSFFont font2 = workbook.createFont();
        font2.setFontName(HSSFFont.FONT_ARIAL);
        font2.setFontHeightInPoints((short) 11);
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style2.setFont(font2);
        style2.setBorderBottom((short) 1);
        style2.setBorderLeft((short) 1);
        style2.setBorderRight((short) 1);
        style2.setBorderTop((short) 1);
        style2.setAlignment(CellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(CellStyle.ALIGN_CENTER);

        HSSFCellStyle rowStyle = workbook.createCellStyle();
        style1.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        rowStyle.setFont(font2);
        rowStyle.setBorderBottom((short) 1);
        rowStyle.setBorderLeft((short) 1);
        rowStyle.setBorderRight((short) 1);
        rowStyle.setBorderTop((short) 1);
        rowStyle.setAlignment(CellStyle.ALIGN_CENTER);
        rowStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);

        HSSFCellStyle colStyle = workbook.createCellStyle();
        colStyle.setBorderBottom((short) 1);
        colStyle.setBorderLeft((short) 1);
        colStyle.setBorderRight((short) 1);
        colStyle.setBorderTop((short) 1);
        colStyle.setAlignment(CellStyle.ALIGN_CENTER);
        colStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);

        //Style for workbook1
        HSSFCellStyle d_style = workbook1.createCellStyle();
        d_style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        HSSFFont d_font = workbook1.createFont();
        d_font.setFontName(HSSFFont.FONT_ARIAL);
        d_font.setFontHeightInPoints((short) 14);
        d_font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        d_style.setFont(d_font);

        HSSFCellStyle d_style1 = workbook1.createCellStyle();
        d_style1.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        HSSFFont d_font1 = workbook.createFont();
        d_font1.setFontName(HSSFFont.FONT_ARIAL);
        d_font1.setFontHeightInPoints((short) 11);
        d_font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        d_style1.setFont(d_font1);

        HSSFCellStyle d_style2 = workbook1.createCellStyle();
        style1.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        HSSFFont d_font2 = workbook1.createFont();
        d_font2.setFontName(HSSFFont.FONT_ARIAL);
        d_font2.setFontHeightInPoints((short) 11);
        d_font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        d_style2.setFont(d_font2);
        d_style2.setBorderBottom((short) 1);
        d_style2.setBorderLeft((short) 1);
        d_style2.setBorderRight((short) 1);
        d_style2.setBorderTop((short) 1);
        d_style2.setAlignment(CellStyle.ALIGN_CENTER);
        d_style2.setVerticalAlignment(CellStyle.ALIGN_CENTER);

        HSSFCellStyle d_rowStyle = workbook1.createCellStyle();
        d_style1.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        d_rowStyle.setFont(d_font2);
        d_rowStyle.setBorderBottom((short) 1);
        d_rowStyle.setBorderLeft((short) 1);
        d_rowStyle.setBorderRight((short) 1);
        d_rowStyle.setBorderTop((short) 1);
        d_rowStyle.setAlignment(CellStyle.ALIGN_CENTER);
        d_rowStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);

        HSSFCellStyle d_colStyle = workbook1.createCellStyle();
        d_colStyle.setBorderBottom((short) 1);
        d_colStyle.setBorderLeft((short) 1);
        d_colStyle.setBorderRight((short) 1);
        d_colStyle.setBorderTop((short) 1);
        d_colStyle.setAlignment(CellStyle.ALIGN_CENTER);
        d_colStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);

        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell1 = row1.createCell(3);
        cell1.setCellValue(new HSSFRichTextString("       MIT POLYTECHNIC PUNE"));
        cell1.setCellStyle(style);
        row1.setHeight(Short.parseShort("470"));

        HSSFRow row2 = sheet.createRow(1);
        HSSFCell cell2 = row2.createCell(2);
        if(dept.equalsIgnoreCase("CO"))
        {
        cell2.setCellValue(new HSSFRichTextString("DEPARTMENT OF COMPUTER ENGINEERING"));
        }else if(dept.equalsIgnoreCase("IF"))
        {
            cell2.setCellValue(new HSSFRichTextString("DEPARTMENT OF INFORMATION TECHNOLOGY"));
        }else if(dept.equalsIgnoreCase("ME"))
        {
            cell2.setCellValue(new HSSFRichTextString("DEPARTMENT OF MECHNICAL ENGINEERING"));
        }else if(dept.equalsIgnoreCase("Civil"))
        {
            cell2.setCellValue(new HSSFRichTextString("DEPARTMENT OF CIVIL ENGINEERING"));
        } else if(dept.equalsIgnoreCase("E&TC"))
        {
            cell2.setCellValue(new HSSFRichTextString("DEPARTMENT OF ELECTRONICS & TELECOMMUNICATION ENGINEERING"));
        }
        
        
        cell2.setCellStyle(style);
        row2.setHeight(Short.parseShort("470"));

        HSSFRow row3 = sheet.createRow(3);
        HSSFCell cell4 = row3.createCell(1);
        cell4.setCellValue(new HSSFRichTextString("Overall Attendance"));
        cell4.setCellStyle(style1);
        row3.setHeight(Short.parseShort("300"));

        HSSFRow d_row1 = defaulterSheet.createRow(2);
        HSSFCell d_cell1 = d_row1.createCell(3);
        d_cell1.setCellValue(new HSSFRichTextString("       DEFAULTER LIST"));
        d_cell1.setCellStyle(d_style);
        d_row1.setHeight(Short.parseShort("470"));

        //for subject
        Vector subCol = new Vector();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 3; i < col.size(); i++) {
            if (!subCol.contains(col.get(i))) {
                subCol.add(col.get(i));
            } else {
                arr.add((String) col.get(i));
            }
        }

        subCol.add("PERCENTAGE");
        arr.add("PERCENTAGE");
        HSSFRow row4 = sheet.createRow(5);
        HSSFRow d_row4 = defaulterSheet.createRow(5);

        int cnt = 0;
        int ii = 2;
        while (ii <= (subCol.size() + arr.size())) {

            HSSFCell cellA1 = row4.createCell((short) ii);
            HSSFCell d_cellA1 = d_row4.createCell((short) ii);

            cellA1.setCellValue(subCol.get(cnt).toString());
            d_cellA1.setCellValue(subCol.get(cnt).toString());

            cellA1.setCellStyle(style2);
            d_cellA1.setCellStyle(d_style2);
            if (arr.contains(subCol.get(cnt))) {
                sheet.addMergedRegion(new CellRangeAddress(
                        5, // mention first row here
                        5, //mention last row here, it is 1 as we are doing a column wise merging
                        ii, //mention first column of merging
                        ii + 1 //mention last column to include in merge
                ));
                defaulterSheet.addMergedRegion(new CellRangeAddress(
                        5, // mention first row here
                        5, //mention last row here, it is 1 as we are doing a column wise merging
                        ii, //mention first column of merging
                        ii + 1 //mention last column to include in merge
                ));
                ii += 2;
            } else {
//                sheet.setColumnWidth(ii, 900);
                ii++;

            }
            row4.setRowStyle(style2);
            d_row4.setRowStyle(d_style2);

            cnt++;
        }

        Vector subCol1 = new Vector();
        subCol1.add("Roll No");
        subCol1.add("Student Name");

        for (int i = 0; i < subCol.size(); i++) {
            if (i != subCol.size() - 1) {
                if (arr.contains(subCol.get(i))) {
                    subCol1.add("TH");
                    subCol1.add("PR");
                } else {
                    subCol1.add("TH");
                }

            } else {
                subCol1.add("");
                subCol1.add("");
            }
        }

        HSSFRow row5 = sheet.createRow(6);
        HSSFRow d_row5 = defaulterSheet.createRow(6);

        for (int i = 0; i < subCol1.size(); i++) {
            HSSFCell cellA1 = row5.createCell((short) i);
            HSSFCell d_cellA1 = d_row5.createCell((short) i);

            cellA1.setCellValue(subCol1.get(i).toString());
            d_cellA1.setCellValue(subCol1.get(i).toString());

            cellA1.setCellStyle(style2);
            d_cellA1.setCellStyle(d_style2);

            if (i == subCol1.size() - 2) {
                sheet.addMergedRegion(new CellRangeAddress(
                        6, // mention first row here
                        6, //mention last row here, it is 1 as we are doing a column wise merging
                        i, //mention first column of merging
                        i + 1 //mention last column to include in merge
                ));

                defaulterSheet.addMergedRegion(new CellRangeAddress(
                        6, // mention first row here
                        6, //mention last row here, it is 1 as we are doing a column wise merging
                        i, //mention first column of merging
                        i + 1 //mention last column to include in merge
                ));
                break;
            }
        }

        row5.setRowStyle(style2);
        row5.setHeight(Short.parseShort("400"));
        sheet.setColumnWidth(1, 9000);
        d_row5.setRowStyle(d_style2);
        d_row5.setHeight(Short.parseShort("400"));
        defaulterSheet.setColumnWidth(1, 9000);

        ArrayList<ArrayList> newRows = new ArrayList<>();
        for (int i = 0; i < Row.size(); i++) {
            Vector get = (Vector) Row.get(i);
            ArrayList newrow = new ArrayList();
            newrow.add((String) get.get(2));
            newrow.add(get.get(0) + " " + get.get(1));
            for (int j = 3; j < get.size(); j++) {
                newrow.add(get.get(j));
//                newrow.add("0");
            }
            newRows.add(newrow);
        }

        int rowIndex = 7, d_rowIndex = 7;
        ArrayList<ArrayList> defaulterList = new ArrayList<>();
        for (int i = 0; i < newRows.size(); i++) {
            ArrayList<String> defaulterRow = new ArrayList<>();

            HSSFRow rows = sheet.createRow(rowIndex);
            ArrayList get = newRows.get(i);
            int j = 0;
            int t_att = 0;
            for (j = 0; j < get.size(); j++) {
                HSSFCell cellA1 = rows.createCell((short) j);
                cellA1.setCellValue(get.get(j).toString());
                cellA1.setCellStyle(colStyle);
                if (j > 1) {
                    t_att += Integer.parseInt(get.get(j).toString());
                }
            }
            sheet.addMergedRegion(new CellRangeAddress(
                    rowIndex, // mention first row here
                    rowIndex, //mention last row here, it is 1 as we are doing a column wise merging
                    j, //mention first column of merging
                    j + 1 //mention last column to include in merge

            ));

            double per = t_att / ((subCol.size() - 1)+arr.size()-1);
            if (per < 75) {
                for (j = 0; j < get.size(); j++) {
                    defaulterRow.add(String.valueOf(get.get(j)));
                }
                defaulterRow.add(String.valueOf(per));
                defaulterList.add(defaulterRow);
            }
            HSSFCell cellA1 = rows.createCell((short) j);
            cellA1.setCellValue(String.valueOf(per));
            cellA1.setCellStyle(colStyle);
            rows.setRowStyle(colStyle);
            rowIndex++;
        }

        //defaulter sheet
        for (int i = 0; i < defaulterList.size(); i++) {

            HSSFRow rows = defaulterSheet.createRow(d_rowIndex);
            ArrayList get = defaulterList.get(i);
            int j = 0;
            for (j = 0; j < get.size() - 1; j++) {
                HSSFCell cellA1 = rows.createCell((short) j);
                cellA1.setCellValue(get.get(j).toString());
                cellA1.setCellStyle(d_colStyle);

            }
            defaulterSheet.addMergedRegion(new CellRangeAddress(
                    d_rowIndex, // mention first row here
                    d_rowIndex, //mention last row here, it is 1 as we are doing a column wise merging
                    j, //mention first column of merging
                    j + 1 //mention last column to include in merge

            ));
            HSSFCell cellA1 = rows.createCell((short) j);
            cellA1.setCellValue(get.get(j).toString());
            cellA1.setCellStyle(d_colStyle);

            rows.setRowStyle(d_colStyle);
            d_rowIndex++;
        }

        FileOutputStream fos = null;
        try {
            File file = new File(pathh);
            file.mkdirs();
            FileOutputStream fileOut = new FileOutputStream(pathh + File.separator + "Class" + ".xls");
            workbook.write(fileOut);
            FileOutputStream fileOut1 = new FileOutputStream(pathh + File.separator + "DefaulterClass" + ".xls");
            workbook1.write(fileOut1);
            fileOut.flush();
            fileOut.close();
            fileOut1.flush();
            fileOut1.close();
            return "Report Generated Successfully !!!";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public String CreateSheet(Vector col, Vector Row, String dept, String year, String shift, String name) {
        try {
            String path = System.getProperty("user.dir");//D:\\

            String pathh = path + File.separator + "ATTENDANCE EXLE" + File.separator + dept + File.separator + year + File.separator + shift + File.separator + name;
            File f = new File(pathh);
            f.mkdirs();
            if (!f.exists()) {
                try {
                    f.mkdir();
                } catch (SecurityException se) {
                }
            }

            FileOutputStream fileOut = new FileOutputStream(pathh + File.separator + "Class" + ".xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Worksheet");

//            for (int j = 0; j < col.size(); j++) {
//                Vector rowcount = (Vector) Row.get(j);
            HSSFRow row11 = worksheet.createRow((short) 0);
            int cellid = 0;
            for (int i = 0; i < col.size(); i++) {

                HSSFCell cellA1 = row11.createCell((short) i);
                cellA1.setCellValue(col.get(i).toString());
                HSSFCellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
                cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cellA1.setCellStyle(cellStyle);
//                    Cell cell = worksheet.createRow(cellid++);
//            cell.setCellValue((String)obj);
            }
            // index from 0,0... cell A1 is cell(0,0)
            for (int j = 0; j < Row.size(); j++) {
                Vector rowcount = (Vector) Row.get(j);
                HSSFRow row1 = worksheet.createRow((short) j + 1);
                for (int i = 0; i < rowcount.size(); i++) {
                    HSSFCell cellA1 = row1.createCell((short) i);
                    cellA1.setCellValue(rowcount.get(i).toString());
                    HSSFCellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
//                    cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                    cellA1.setCellStyle(cellStyle);
                }
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            return "Report Generated Successfully !!!";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Report Generate Unsuccessful !!!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Report Generate Unsuccessful !!!";
        }

    }

    public static void main(String[] args) {
//        Column Data Excel :  [name, last, roll, a , English, b , English]
//Row Data Excel :  [[Aa, Aa, 1, 100, 60], [Bb, Bb, 2, 80, 100], [Cc, Cc, 3, 40, 40]]
        Vector col = new Vector();
        col.add("name");
        col.add("last");
        col.add("roll");
        col.add("a");
        col.add("English");
        col.add("b");
        col.add("English");

        Vector<Vector> rows = new Vector<>();
        Vector row = new Vector();
        row.add("Aa");
        row.add("Aa");
        row.add("1");
        row.add("100");
        row.add("60");
        rows.add(row);
//        CreateSheet1(col, rows, null, null, null, null);

    }

}
