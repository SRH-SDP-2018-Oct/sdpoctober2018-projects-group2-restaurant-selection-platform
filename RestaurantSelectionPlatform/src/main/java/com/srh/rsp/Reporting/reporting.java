package com.srh.rsp.Reporting;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;

import javax.swing.JOptionPane;
import LogException.WriteExceptionToFile;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Date;

public class reporting {
	WriteExceptionToFile log = new WriteExceptionToFile();

	public void RestaurantReport() {
		try {
			Date date = new Date();
			java.util.Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-13");
			java.sql.Date dateFrom = new java.sql.Date(fromDate.getTime());
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_selection", "root","Aa1Bb2Cc3Dd4#");
			JasperDesign jd = JRXmlLoader.load("D:\\1st Sem\\Restaurant_Selection_Platform\\sdpoctober2018-projects-group2-restaurant-selection-platform\\RestaurantSelectionPlatform\\src\\main\\java\\com\\srh\\rsp\\Reporting\\Restaurant_Owner.jrxml");
			JRDesignQuery query = new JRDesignQuery();
			query.setText("Select restaurant_Id, reservation_Id,customer_Id,reservation_Status,booking_Date	from restaurant_reservation where booking_Date >="+dateFrom+" and booking_Date < "+dateFrom+"");
			jd.setQuery(query);
			JasperReport jr = JasperCompileManager.compileReport(jd);
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp);
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			log.appendToFile(e);

		}
	}

	public void CustomerReport() {
		try {
			Date date = new Date();
			java.util.Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-13");
			java.sql.Date dateFrom = new java.sql.Date(fromDate.getTime());
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_selection", "root","Aa1Bb2Cc3Dd4#");
			JasperDesign jd = JRXmlLoader.load("D:\\1st Sem\\Restaurant_Selection_Platform\\sdpoctober2018-projects-group2-restaurant-selection-platform\\RestaurantSelectionPlatform\\src\\main\\java\\com\\srh\\rsp\\Reporting\\CustomerReport.jrxml");
			JRDesignQuery query = new JRDesignQuery();
			query.setText("Select customer_Id,User_Name from customer_login where time_Stamp >="+dateFrom+" and time_Stamp <"+dateFrom+"");
			jd.setQuery(query);
			JasperReport jr = JasperCompileManager.compileReport(jd);
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp);
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			log.appendToFile(e);

		}
	}

}