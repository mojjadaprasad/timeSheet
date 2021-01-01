package org.tc.timesheet.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tc.timesheet.model.TimeSheetModel;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "DATE", " ", "TASK", "TYPE", "EFFORTS", "COMMENTS" };

	public static ByteArrayInputStream tutorialsToExcel(Map<String, Object> employeeMap) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Set<String> employeeNames = employeeMap.keySet();
			for (String employeeName : employeeNames) {
				CellStyle mergeStyle = workbook.createCellStyle();
				mergeStyle.setFillForegroundColor(IndexedColors.BLUE1.getIndex());
				Font font = workbook.createFont();
				font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
				mergeStyle.setFont(font);
				mergeStyle.setAlignment(HorizontalAlignment.CENTER);
				mergeStyle.setVerticalAlignment(VerticalAlignment.CENTER);
				mergeStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				List<TimeSheetModel> list = (List<TimeSheetModel>) employeeMap.get(employeeName);
				float totalWorkingDays = getTotalDaysWorked(list);
				String sheetName = employeeName + " (" + totalWorkingDays + ")";
				Sheet sheet = workbook.createSheet(sheetName);
				CellStyle cellStyle = workbook.createCellStyle();
				CreationHelper createHelper = workbook.getCreationHelper();
				cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
				cellStyle.setAlignment(HorizontalAlignment.FILL);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
				// Header
				Row headerRow = sheet.createRow(0);
				headerRow.setHeightInPoints(2 * sheet.getDefaultRowHeightInPoints());
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
				for (int col = 0; col < HEADERs.length; col++) {
					Cell cell = headerRow.createCell(col);
					cell.setCellValue(HEADERs[col]);
					sheet.autoSizeColumn(col);
					cell.setCellStyle(mergeStyle);
					sheet.setColumnWidth(col, 25 * 180);
				}
				int rowIdx = 1;
				for (TimeSheetModel list1 : list) {
					Row row = sheet.createRow(rowIdx++);
					Cell cell = row.createCell(0);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(list1.getDate());
					row.createCell(1).setCellValue(simpleDateFormat.format(list1.getDate()));
					row.createCell(2).setCellValue(list1.getAssignment().getProjectName());
					row.createCell(3).setCellValue(list1.getAssignment().getTask());
					row.createCell(4).setCellValue(list1.getHours());
					row.createCell(5).setCellValue(list1.getComments());

				}
				sheet.addMergedRegion(new CellRangeAddress(rowIdx + 1, rowIdx + 1, 1, 3));
				Row row = sheet.createRow(rowIdx + 1);
				Cell cell = row.createCell(1);
				row.createCell(0).setCellStyle(mergeStyle);
				cell.setCellValue("Total Present Days");
				cell.setCellStyle(mergeStyle);
				Cell cell2 = row.createCell(4);
				cell2.setCellValue(totalWorkingDays);
				mergeStyle.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
				cell2.setCellStyle(mergeStyle);
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	private static float getTotalDaysWorked(List<TimeSheetModel> list) {
		int fullDays = 0;
		int halfDays = 0;
		float totalWorkingDays;

		for (TimeSheetModel model : list) {
			int hours = model.getHours();
			if (hours == 8) {
				fullDays++;
			}
			if (hours == 4) {
				halfDays++;
			}
		}
		totalWorkingDays = (float) (fullDays + (halfDays * 0.5));
		return totalWorkingDays;

	}
}
