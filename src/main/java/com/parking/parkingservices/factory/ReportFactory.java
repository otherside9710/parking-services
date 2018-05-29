package com.parking.parkingservices.factory;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.export.JRXlsExporter;

@Component
public class ReportFactory {

    public static final String MYACPRINTBODEGAS = "myacprintbodegas";
    public static final String FACTURA = "factura";

    public static int PDF_FORMAT = 1;
    public static int XLS_FORMAT = 2;

    private static final String REPORT_FOLDER = "reports";

    public void complile(String reportName) throws JRException {
        JasperCompileManager.compileReportToFile(
                REPORT_FOLDER + "/" + reportName + ".jrxml",
                REPORT_FOLDER + "/" + reportName + ".jasper"
        );
    }

    public void makeFactory(HttpServletResponse response, HashMap<String, Object> parameters, String reportName, String rawJsonData) throws JRException, IOException {
        makeFactory(response,  null, parameters, reportName, rawJsonData);
    }

    public void makeFactory(HttpServletResponse response, HttpServletRequest request, HashMap<String, Object> parameters, String reportName, String rawJsonData, int export_type) throws JRException, IOException {
        if (!rawJsonData.equals("[]")) {
            complile(reportName);
            File file = new File(REPORT_FOLDER + "/" + reportName + ".jasper");
            JRDataSource dataSource;
            JasperReport report = (JasperReport) JRLoader.loadObject(file);

            if (!rawJsonData.equals("") && !rawJsonData.equals("[]")) {
                ByteArrayInputStream jsonDataStream = new ByteArrayInputStream(rawJsonData.getBytes("UTF-8"));
                dataSource = new JsonDataSource(jsonDataStream);
            } else {
                dataSource = new JREmptyDataSource();
            }

            if (export_type == PDF_FORMAT) {
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);

                response.setContentType("application/factory;charset=UTF-8");
                response.setHeader("Content-disposition", "inline");
                response.setHeader("Content-disposition", "attachment; filename=" + reportName + ".pdf");
                final ServletOutputStream outStream = response.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
            } else if (export_type == XLS_FORMAT) {
                JRXlsExporter exporterXLS = new JRXlsExporter();
                JasperPrint fillReport = JasperFillManager.fillReport(report, parameters, dataSource);
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmsss");
                    response.setContentType("application/vnd.ms-excel;charset=UTF-8");
                    response.setHeader("Content-disposition", "attachment; filename=" + reportName + "-" +(dateFormat.format(new Date())) + ".xls");

                    exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT, fillReport);
                    exporterXLS.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                    exporterXLS.exportReport();

                } catch (IOException | JRException e) {
                    System.out.println(e);
                }
            }
        }

    }

    public void makeFactory(HttpServletResponse response, HttpServletRequest request, HashMap<String, Object> parameters, String reportName, String rawJsonData) throws JRException, IOException {
        int format = PDF_FORMAT;
        if (parameters.containsKey("type") && parameters.get("type").toString().equalsIgnoreCase("excel")){
            format = XLS_FORMAT;
        }
        makeFactory(response, request, parameters, reportName, rawJsonData, format);
    }
}
