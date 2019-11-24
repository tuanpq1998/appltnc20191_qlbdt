/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.utility;

import java.awt.Color;

/**
 *
 * @author admin
 */
public class ColorHelper {
    private static Color getColorFromInt(int colorHex) {
        return new Color(colorHex);
    }
    
    public static final Color MENU_PANEL_BG = getColorFromInt(0x333333);
    public static final Color MENU_PANEL_LINE = getColorFromInt(0x838383);
    public static final Color MENU_BTN_BG_HOVER = getColorFromInt(0x19478a);
    public static final Color MENU_BTN_BG_SELECTED = getColorFromInt(0x3e6db5);
    
    public static final Color SECTION_PANEL_BG = getColorFromInt(0xffffff);
    public static final Color SECTION_PANEL_LINE = getColorFromInt(0xa0a0a0);
    
    public static final Color SEARCH_SECTION_TEXT_NON_FOCUS = getColorFromInt(0x808080);
    public static final Color SEARCH_SECTION_TEXT_FOCUS = getColorFromInt(0x000000);
    
    public static final Color SECTION_BTN_BODER_NORMAL = getColorFromInt(0xababab);
    public static final Color SECTION_BTN_BODER_HOVER = getColorFromInt(0xa3bde3);
    public static final Color SECTION_BTN_BG_NORMAL = SECTION_PANEL_BG;
    public static final Color SECTION_BTN_BG_HOVER = getColorFromInt(0xd5e1f2);
    
}
