/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.utility;

import com.ltnc.nhom3.entity.Manufacturer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author admin
 */
public class DisplayHandler {

    final static SimpleDateFormat formatDateTimeFromSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final static SimpleDateFormat formatDateFromSQL = new SimpleDateFormat("yyyy-MM-dd");
    final static SimpleDateFormat formatToDisplayDate = new SimpleDateFormat("dd-MM-yyyy");
    final static SimpleDateFormat formatToDisplayDateTime = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

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
    
    public static String convertToDisplayManufacturerString(Manufacturer manufacturer) {
        if (manufacturer != null)
            return manufacturer.getName() + " (" + manufacturer.getCountry() + ")";
        else return null;
    }
}
