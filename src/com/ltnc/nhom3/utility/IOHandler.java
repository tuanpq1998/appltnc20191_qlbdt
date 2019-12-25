/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.utility;

import com.ltnc.nhom3.entity.Manufacturer;
import com.ltnc.nhom3.view.frmMainWindow;
import com.ltnc.nhom3.view.product.pnlDetail;
import java.awt.Image;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

/**
 *
 * @author admin
 */
public class IOHandler {

    final static SimpleDateFormat FORMAT_DATE_TIME_FROM_SQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final static SimpleDateFormat FORMAT_DATE_FROM_SQL = new SimpleDateFormat("yyyy-MM-dd");
    final static SimpleDateFormat FORMAT_TO_DISPLAY_DATE = new SimpleDateFormat("dd/MM/yyyy");
    final static SimpleDateFormat FORMAT_TO_DISPLAY_DATE_TIME = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    public static String convertToDisplayPriceString(double value) {
        return NumberFormat.getNumberInstance(Locale.GERMAN).format(value) + " VNĐ";
    }

    public static String convertToDisplayDate(String dateFromSQL) {
        Date date = null;
        try {
            date = FORMAT_DATE_FROM_SQL.parse(dateFromSQL);
            return FORMAT_TO_DISPLAY_DATE.format(date);
        } catch (Exception e) {
            Logger.getLogger(IOHandler.class.getName()).log(Level.SEVERE, null, e);
        }
        return dateFromSQL;
    }
    
    public static String convertToDisplayDate(Date date) {
        return FORMAT_TO_DISPLAY_DATE.format(date);
    }

    public static String convertToDisplayDateTime(String datetimeFromSQL) {
        Date date = null;
        try {
            date = FORMAT_DATE_TIME_FROM_SQL.parse(datetimeFromSQL);
            return FORMAT_TO_DISPLAY_DATE_TIME.format(date);
        } catch (Exception e) {
            Logger.getLogger(IOHandler.class.getName()).log(Level.SEVERE, null, e);
        }
        return datetimeFromSQL;
    }
    
    public static String convertToDisplayDateTime(Date date) {
        return FORMAT_TO_DISPLAY_DATE_TIME.format(date);
    }

    public static String convertToDisplayManufacturerString(Manufacturer manufacturer) {
        if (manufacturer != null) {
            return manufacturer.getName() + " (" + manufacturer.getCountry() + ")";
        } else {
            return null;
        }
    }

    public static String convertToStringSQLDate(Date date) {
        return FORMAT_DATE_FROM_SQL.format(date);
    }

    public static String convertToStringSQLDateTime(Date date) {
        return FORMAT_DATE_TIME_FROM_SQL.format(date);
    }

    public static Date covertStringSQLToDate(String dateFromSQL) {
        try {
            return FORMAT_DATE_FROM_SQL.parse(dateFromSQL);
        } catch (ParseException ex) {
            Logger.getLogger(IOHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean isContainsNonNumberCharacter(String text) {
        String regex = "[^0-9]+";
        return Pattern.compile(regex).matcher(text).find();
    }

    public static String generatePassword(String username) {
        return username.replaceAll("\\s+", "").toLowerCase();
    }
    
    public static List<Image> getIconList() {
        List<Image> images = new ArrayList<>();
        try {
            images.add(ImageIO.read(IOHandler.class.getResourceAsStream("/icons/icon.png")));
            images.add(ImageIO.read(IOHandler.class.getResourceAsStream("/icons/icon-16x16.png")));
            images.add(ImageIO.read(IOHandler.class.getResourceAsStream("/icons/icon-20x20.png")));
            images.add(ImageIO.read(IOHandler.class.getResourceAsStream("/icons/icon-32x32.png")));
            images.add(ImageIO.read(IOHandler.class.getResourceAsStream("/icons/icon-40x40.png")));
            images.add(ImageIO.read(IOHandler.class.getResourceAsStream("/icons/icon-64x64.png")));
            images.add(ImageIO.read(IOHandler.class.getResourceAsStream("/icons/icon-128x128.png")));
        } catch (IOException ex) {
            Logger.getLogger(frmMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }
}
