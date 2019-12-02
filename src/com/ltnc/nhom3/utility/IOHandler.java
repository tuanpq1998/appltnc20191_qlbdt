/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.utility;

import com.ltnc.nhom3.entity.Manufacturer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class IOHandler {

    final static SimpleDateFormat formatDateTimeFromSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final static SimpleDateFormat formatDateFromSQL = new SimpleDateFormat("yyyy-MM-dd");
    final static SimpleDateFormat formatToDisplayDate = new SimpleDateFormat("dd-MM-yyyy");
    final static SimpleDateFormat formatToDisplayDateTime = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    public static String convertToDisplayPriceString(double value) {
        return NumberFormat.getNumberInstance(Locale.GERMAN).format(value) + " VNĐ";
    }

    public static String convertToDisplayDate(String dateFromSQL) {
        Date date = null;
        try {
            date = formatDateFromSQL.parse(dateFromSQL);
            return formatToDisplayDate.format(date);
        } catch (Exception e) {
        }
        return dateFromSQL;
    }

    public static String convertToDisplayDateTime(String datetimeFromSQL) {
        Date date = null;
        try {
            date = formatDateTimeFromSQL.parse(datetimeFromSQL);
            return formatToDisplayDateTime.format(date);
        } catch (Exception e) {
        }
        return datetimeFromSQL;
    }

    public static String convertToDisplayManufacturerString(Manufacturer manufacturer) {
        if (manufacturer != null) {
            return manufacturer.getName() + " (" + manufacturer.getCountry() + ")";
        } else {
            return null;
        }
    }

    public static String convertToStringSQLDate(Date date) {
        return formatDateFromSQL.format(date);
    }

    public static String convertToStringSQLDateTime(Date date) {
        return formatDateTimeFromSQL.format(date);
    }

    public static Date covertStringSQLToDate(String dateFromSQL) {
        try {
            return formatDateFromSQL.parse(dateFromSQL);
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

}
