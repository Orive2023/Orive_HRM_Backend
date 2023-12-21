package com.orive.TimeSheet.ExcelToDatabase.Help;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.orive.TimeSheet.Entity.AttendanceEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExcelHelper {

	
	//check that file is of excel type or not
			public static boolean chechExcelFormat(MultipartFile file ) {
				
				String contentType = file.getContentType();
				
				if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}

			
			//convert excel to list of product
			
			public static List<AttendanceEntity> convertExcelToListOfAttendance(InputStream is){
				List<AttendanceEntity> list = new ArrayList<>();
				
				try 
				{
					XSSFWorkbook workbook = new XSSFWorkbook(is);
					for(int i=0; i<workbook.getNumberOfSheets(); i++)
					{
						System.out.println("sheet name: " + workbook.getSheetName(i));
					}
					XSSFSheet sheet = workbook.getSheet("Sheet1");
					if(sheet == null)
					{
						System.out.println("sheet with name 'Sheet1' not found in the workbook");
					}
					int rowNumber=0;
					Iterator<Row> iterator = sheet.iterator();
					
					while (iterator.hasNext()) 
					{
						Row row = iterator.next();
						
						if(rowNumber==0)
						{
							rowNumber++;
							continue;
						}
						
					Iterator<Cell> cells = row.iterator();
					
					int cellId=0;
					
					AttendanceEntity e = new AttendanceEntity();
					
					while(cells.hasNext()) 
					{
						Cell cell =  cells.next();
						
						switch (cellId) 
						{
						case 0:
							e.setAttendanceId((long)cell.getNumericCellValue());
							break;
						case 1:	
							e.setEmployeeName(cell.getStringCellValue());
							break;
//						case 2:
//							e.setClockIn(cell.getString);
//							break;
//						case 3:
//							e.setClockOut(cell.get);
//							break;
						case 4:
							e.setLate((long) cell.getNumericCellValue());
							break;
						case 5:
							e.setEarlyLeaving((long) cell.getNumericCellValue());
							break;
						case 6:
							e.setOverTime((long) cell.getNumericCellValue());
							break;
						case 7:
							e.setTotalWork((long) cell.getNumericCellValue());
							break;
						case 8:
							e.setTotalRest((long) cell.getNumericCellValue());
							break;
//						case 9:
//							e.setDate( cell.getDateCellValue());
//							break;
//						case 10:
//							e.setUploadDoc(cell.getSheet());
//							break;
						default:
							break;
						}
						cellId++;
					}
					list.add(e);
				}
					
					
				}catch (Exception e) 
				{
		               e.printStackTrace();
				}
					return list;
				}
}
