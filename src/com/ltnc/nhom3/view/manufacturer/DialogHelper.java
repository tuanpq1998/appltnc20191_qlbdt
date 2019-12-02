/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.manufacturer;

import com.ltnc.nhom3.service.ManufacturerService;
import java.awt.Frame;

public class DialogHelper {
    
    public static int showAddManufacturerForm(Frame parent, ManufacturerService manufacturerService) {
        dloForm form = new dloForm(parent, true, manufacturerService);
        form.setVisible(true);
        return form.returnedId;
    }

    public static int showEditManufacturerForm(Frame parent, ManufacturerService manufacturerService, int manufacturerId) {
        dloForm form = new dloForm(parent, true, manufacturerService, manufacturerId);
        form.setVisible(true);
        return form.returnedId;
    }
}
