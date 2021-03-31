package com.xoriant.bsg.sendemail.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.xoriant.bsg.sendemail.model.ReportUser;

@Component
public class ExcelReader {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${mail.file.path}")
	private String excelFilePath;

	@Autowired
	private SendEmail sendEmail;

	@PostConstruct
	public void init(){
		logger.info("start excel reading");
		readExcel();
//		readExcelThankYou();
	}

	private void readExcel(){

		try(Workbook workbook = WorkbookFactory.create(new File(excelFilePath));){
			logger.info("read sheet from workbook");
			Sheet sheet = workbook.getSheetAt(0);

			List<ReportUser> reportUsers = new ArrayList<>();

			for (Row row: sheet) {
				if(row.getRowNum() > 1){
					ReportUser user = new ReportUser(
							row.getCell(0).getRichStringCellValue().toString(),
							row.getCell(1).getRichStringCellValue().toString(),
							row.getCell(2).getRichStringCellValue().toString(),
							row.getCell(3).getRichStringCellValue().toString()
							);
					reportUsers.add(user);
				}
			}
			List<ReportUser> filteredReportUsers = reportUsers.stream()
					.filter(user -> !StringUtils.isEmpty(user.getEmailAdd()))
					.filter(user -> !StringUtils.isEmpty(user.getUsersHavingAccess()))
					.map(user -> {
						return new ReportUser(
								user.getUsersHavingAccess().split(" ")[0],
								user.getCategory(),
								user.getReportName(),
								user.getEmailAdd()
								);
					}).collect(Collectors.toList());

			Map<String, List<ReportUser>> userMap = filteredReportUsers.stream()
					.collect(Collectors.groupingBy(user -> user.getEmailAdd()));

			for(Map.Entry<String, List<ReportUser>> entry : userMap.entrySet()){
				String emailId = entry.getKey();
//				String emailId = "shehzad.momin@xoriant.com";
				List<ReportUser> userDataList = entry.getValue();
				String user = userDataList.get(0).getUsersHavingAccess();

				StringBuilder emailBody = new StringBuilder();
				emailBody.append("Hi ").append(user).append(",<br><br>");
				emailBody.append("We have not received your response to the previous email. Request you to provide your inputs asap.<br><br>"
						+ "Following is the list of Reports which you have access to in SAS. We would like to know which of the following reports are being used by you.<br>"
						+ "We will plan to remove those reports which you mark as “Not used”. Additionally we request you to give criticality (High/Medium/Low) for each of those reports which you are using actively.");

				StringBuilder emailTable = new StringBuilder();
				emailTable.append("<table border='1'><tr><th>Category</th><th>Report Name</th></tr>");
				if(!userDataList.isEmpty()){
					for(ReportUser userData : userDataList){
						emailTable.append("<tr>");
						emailTable.append("<td>").append(userData.getCategory()).append("</td>");
						emailTable.append("<td>").append(userData.getReportName()).append("</td>");
						emailTable.append("</tr>");
					}
				}
				emailTable.append("</table>");

				StringBuilder thankYouMessage = new StringBuilder();
				thankYouMessage.append("<br>");
				thankYouMessage.append("Also, we would like to know if you are using any other reports which are not mentioned in the above list.");
				thankYouMessage.append("<br>");
				thankYouMessage.append("Kindly reply to the email with required information at the earliest. Thank you.");
				thankYouMessage.append("<br><br>");
				thankYouMessage.append("Regards,<br>SAS Support Team");

				emailBody.append("<br><br>");
				emailBody.append(emailTable);
				emailBody.append("<br>");
				emailBody.append(thankYouMessage);

				sendEmail.sendAttachmentMessage(emailId, emailBody.toString());

			}

			logger.info("total mail count [{}]",userMap.size());

		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private void readExcelThankYou(){

		try(Workbook workbook = WorkbookFactory.create(new File(excelFilePath));){
			logger.info("read sheet from workbook [{}]",excelFilePath);
			Sheet sheet = workbook.getSheetAt(1);

			List<ReportUser> reportUsers = new ArrayList<>();

			for (Row row: sheet) {
				if(row.getRowNum() > 0){
					ReportUser user = new ReportUser(
							row.getCell(0).getRichStringCellValue().toString(),
							row.getCell(1).getRichStringCellValue().toString(),
							row.getCell(2).getRichStringCellValue().toString(),
							row.getCell(3).getRichStringCellValue().toString()
							);
					reportUsers.add(user);
				}
			}
			List<ReportUser> filteredReportUsers = reportUsers.stream()
					.filter(user -> !StringUtils.isEmpty(user.getEmailAdd()))
					.filter(user -> !StringUtils.isEmpty(user.getUsersHavingAccess()))
					.map(user -> {
						return new ReportUser(
								user.getUsersHavingAccess().split(" ")[0],
								user.getCategory(),
								user.getReportName(),
								user.getEmailAdd()
								);
					}).collect(Collectors.toList());

			Map<String, List<ReportUser>> userMap = filteredReportUsers.stream()
					.collect(Collectors.groupingBy(user -> user.getEmailAdd()));

			for(Map.Entry<String, List<ReportUser>> entry : userMap.entrySet()){
				String emailId = entry.getKey();
				List<ReportUser> userDataList = entry.getValue();
				String user = userDataList.get(0).getUsersHavingAccess();

				StringBuilder emailBody = new StringBuilder();
				emailBody.append("Hi ").append(user).append(",<br><br>");
				emailBody.append("Thank you for responding to our request. Kindly let us know if there are any other SAS reports you are using, but not mentioned in the below list.");

				StringBuilder emailTable = new StringBuilder();
				emailTable.append("<table border='1'><tr><th>Category</th><th>Report Name</th></tr>");
				if(!userDataList.isEmpty()){
					for(ReportUser userData : userDataList){
						emailTable.append("<tr>");
						emailTable.append("<td>").append(userData.getCategory()).append("</td>");
						emailTable.append("<td>").append(userData.getReportName()).append("</td>");
						emailTable.append("</tr>");
					}
				}
				emailTable.append("</table>");

				StringBuilder thankYouMessage = new StringBuilder();
				thankYouMessage.append("<br>");
				thankYouMessage.append("Kindly reply to the email with required information by 30th of October. Thank you.");
				thankYouMessage.append("<br><br>");
				thankYouMessage.append("Regards,<br>SAS Support Team");

				emailBody.append("<br><br>");
				emailBody.append(emailTable);
				emailBody.append("<br><br>");
				emailBody.append(thankYouMessage);

				sendEmail.sendAttachmentMessage(emailId, emailBody.toString());

			}

			logger.info("total mail count [{}]",userMap.size());

		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
