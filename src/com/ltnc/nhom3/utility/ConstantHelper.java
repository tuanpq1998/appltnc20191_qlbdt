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
public class ConstantHelper {

    private static Color getColorFromInt(int colorHex) {
        return new Color(colorHex);
    }
    
    public static final Color MENU_PANEL_BG = getColorFromInt(0x333333);
    public static final Color MENU_PANEL_LINE = getColorFromInt(0x838383);
    public static final Color MENU_BTN_BG_HOVER = getColorFromInt(0x19478a);
    public static final Color MENU_BTN_BG_SELECTED = getColorFromInt(0x3e6db5);
    public static final Color MENU_BTN_DISABLED = getColorFromInt(0x666666);
    
    public static final Color SECTION_PANEL_BG = getColorFromInt(0xffffff);
    public static final Color SECTION_PANEL_LINE = getColorFromInt(0xa0a0a0);
    
    public static final Color SEARCH_SECTION_TEXT_NON_FOCUS = getColorFromInt(0x808080);
    public static final Color SEARCH_SECTION_TEXT_FOCUS = getColorFromInt(0x000000);
    
    public static final Color SECTION_BTN_BODER_NORMAL = getColorFromInt(0xababab);
    public static final Color SECTION_BTN_BODER_HOVER = getColorFromInt(0xa3bde3);
    public static final Color SECTION_BTN_BG_NORMAL = SECTION_PANEL_BG;
    public static final Color SECTION_BTN_BG_HOVER = getColorFromInt(0xd5e1f2);
    
    public static final String PAGINATION_TEXT = "%d/%d";
    
    public static final String CONFIRM_DIALOG_TITLE = "Xác nhận";
    public static final String CONFIRM_DIALOG_MESSAGE = "Bạn có chắc chắn?";
    public static final String CONFIRM_LOGOUT_DIALOG_TITLE = CONFIRM_DIALOG_TITLE;
    public static final String CONFIRM_LOGOUT_DIALOG_MESSAGE = "Xác nhận đăng xuất?";
    public static final String ADD_DONE_DIALOG_MESSAGE = "Tạo thành công!";
    public static final String UPDATE_INFO_DONE_DIALOG_MESSAGE = "Cập nhật thông tin thành công!";
    public static final String UPDATE_INFO_PRICE_DONE_DIALOG_MESSAGE = "Cập nhật thông tin & đơn giá thành công!";
    public static final String ADD_MANUFACTURER_DIALOG_TITLE = "Thêm hãng sản xuất";
    public static final String EDIT_MANUFACTURER_DIALOG_TITLE = "Sửa hãng sản xuất";
    public static final String EDIT_PRODUCT_HEADING = "Sửa sản phẩm";
    public static final String CREATE_TAB_NOT_ALLOWED_MESSAGE = "Số tab mới đã đạt tối đa!";

    public static final String LOGOUT_BTN_TEXT = "Đăng xuất (%s)";
    
    public static final String PRODUCT_LIST_HEADING = "Danh sách sản phẩm";
    public static final String PRODUCT_LIST_SEARCH_HEADING = "Kết quả cho '%s'";    
    
    public static final String CUSTOMER_LIST_HEADING = "Danh sách khách hàng";
    public static final String CUSTOMER_LIST_SEARCH_HEADING = PRODUCT_LIST_SEARCH_HEADING;  
    public static final String CUSTOMER_EDIT_HEADING = "Sửa thông tin khách";
    public static final String CUSTOMER_ADD_HEADING = "Thêm khách hàng";
    
    public static final String EMPLOYEE_LIST_HEADING = "Danh sách nhân viên";
    public static final String EMPLOYEE_LIST_SEARCH_HEADING = PRODUCT_LIST_SEARCH_HEADING;
    public static final String EMPLOYEE_EDIT_HEADING = "Sửa thông nhân viên";
    public static final String EMPLOYEE_ADD_HEADING = "Thêm nhân viên";
    public static final String EMPLOYEE_FILED_REQUIRED_MESSAGE = "Hãy điền đầy đủ thông tin!";
    public static final String EMPLOYEE_USERNAME_HAS_EXISTED_MESSAGE = "Tên đã tồn tại!";
    public static final String EMPLOYEE_IDENTITY_CARD_PHONE_NUMBER_ONLY_MESSAGE = "Số CMND và điện thoại chỉ gồm chữ số!";
    public static final String EMPLOYEE_ADD_DONE_MESSAGE = "<html><p>" + ADD_DONE_DIALOG_MESSAGE 
            + "</p><p>Tài khoản mới: tên=<b>%s<b>, mật khẩu=<b>%s<b></p></html>.";
    public static final String EMPLOYEE_RESET_PASSWORD_DONE_MESSAGE = "<html><p>Đặt lại thành công!</p>"
            + "<p>Mật khẩu mới: <b>%s</b>.</p></html>";
    public static final String EMPLOYEE_GENDER_MALE = "Nam";
    public static final String EMPLOYEE_GENDER_FEMALE = "Nữ";
    public static final String EMPLOYEE_ENABLE_ACTIVE_STATUS_BTN_TEXT = "Mở lại";
    public static final String EMPLOYEE_DISABLE_ACTIVE_STATUS_BTN_TEXT = "Khóa";
    
    public static final String BILL_LIST_HEADING = "Danh sách hóa đơn";
    public static final String BILL_DETAIL_HEADING = "Chi tiết hóa đơn";
    
    public static final String LOADING_TEXT ="Đang tải ...";
    public static final String EXPAND_MENU_TEXT = "Mở rộng";
    public static final String COLLAPSE_MENU_TEXT = "Thu gọn";
    
    public static final String ACCOUNT_INFO_HEADING = "Thông tin tài khoản";
    public static final String ROLE_ADMIN_TEXT = "Quản trị viên";
    public static final String ROLE_NON_ADMIN_TEXT = "Nhân viên";
    public static final String ACCOUNT_ACTIVE_TEXT = "Đang hoạt động";
    public static final String ACCOUNT_DEACTIVE_TEXT = "Bị khóa";
    
    public static final String DOT_TEXT = "\u25BA";
    public static final String NO_RESULT_MESSAGE = "Danh sách trống";
    public static final String NO_INFORMATION_MESSAGE = "(không có)";
    public static final String PRODUCT_AVAILABEL_MESSAGE = "Còn hàng";
    public static final String PRODUCT_NOT_AVAILABEL_MESSAGE = "Hết hàng";
    public static final String MANUFACTURER_NAME_HAS_EXISTED_MESSAGE = EMPLOYEE_USERNAME_HAS_EXISTED_MESSAGE;
    public static final String MANUFACTURER_FIELD_REQUIRED_MESSAGE = EMPLOYEE_FILED_REQUIRED_MESSAGE;
    
    public static final String LOGIN_FIELD_REQUIRED_MESSAGE = MANUFACTURER_FIELD_REQUIRED_MESSAGE;
    public static final String LOGIN_WRONG_INFO_MESSAGE = "Tên hoặc mật khẩu sai!";
    
    public static final String CUSTOMER_FIELD_REQUIRED_MESSAGE = MANUFACTURER_FIELD_REQUIRED_MESSAGE;
    
    public static final String CHANGE_PASS_FIELD_REQUIRED_MESSAGE = MANUFACTURER_FIELD_REQUIRED_MESSAGE;
    public static final String CHANGE_PASS_WRONG_RENEW_PASSWORD_MESSAGE = "Nhắc lại mật khẩu sai!";
    public static final String CHANGE_PASS_WRONG_CURRENT_PASSWORD_MESSAGE = "Sai mật khẩu hiện tại!";
    public static final String CHANGE_PASS_DONE_MESSAGE = "Đổi mật khẩu thành công!";
    public static final String CHANGE_PASS_DONE_TITLE = "Thông báo";

    public static final String ADD_PRODUCT_FIELD_REQUIRED_MESSAGE = MANUFACTURER_FIELD_REQUIRED_MESSAGE;
    public static final String ADD_PRODUCT_FIELD_REQUIRED_TITLE = CHANGE_PASS_DONE_TITLE;
    public static final String UPDATE_DONE_DIALOG_MESSAGE = "Đã cập nhật thông tin!";

    public static final String COMBOBOX_SELECT_MANUFACTURER = "-- Chọn --";
    
    public static final String[] TBL_PRODUCT_TITLES
            = new String[]{"ID", "Tên", "Đơn giá", "Ngày ra mắt", "Trạng thái"};
    public static final int[] TBL_PRODUCT_WIDTHS = {40, 400, 165, 120, 120};
    
    public static final String[] TBL_CUSTOMER_TITLES
            = new String[]{"ID", "Tên", "Địa chỉ", "Điện thoại"};
    public static final int[] TBL_CUSTOMER_WIDTHS = {40, 280, 280, 115};
    
    public static final String[] TBL_BILLDETAIL_TITLES
            = new String[]{"STT", "Sản phẩm", "Đơn giá", "Số lượng", "Thành tiền", "IMEI"};
    public static final int[] TBL_BILLDETAIL_WIDTHS = {40, 220, 130, 80, 130, 160};
    
    public static final String[] TBL_EMPLOYEE_TITLES 
            = new String[]{"ID", "Tài khoản", "Điện thoại", "Giới tính", "CMND", "Trạng thái"};
    public static final int[] TBL_EMPLOYEE_WIDTHS = {40, 140, 160, 120, 140, 160};
    
    public static final String[] TBL_PRICE_TITLES
            = new String[]{"","Mức giá", "Ngày bắt đầu", "Ngày kết thúc"};
    public static final int[] TBL_PRICE_WIDTHS = {20, 140, 130, 130};
    
    public static final String[] TBL_BILL_TITLES 
            = new String[]{"ID", "Khách hàng", "Ngày tạo", "TK tạo", "Tổng tiền"};
    public static final int[] TBL_BILL_WIDTHS = {40, 200, 160, 160, 200};
    
    public static final String LBL_TOTAL_ADD_BILL = "Tổng số lượng: %s - Tổng tiền: %s";
    
    public static final int ITEM_PER_PAGE = 15;
    public static final int ITEM_BILLDETAIL_PER_PAGE = 5;
    
    public static final int STT_BTN_HOVER = 1;
    public static final int STT_BTN_NORMAL = 0;
    public static final int STT_BTN_SELECTED = 2;
    
    public static final int MAIN_FRAME_INIT_MODE = 0;
    public static final int MAIN_FRAME_PRODUCT_MODE = 1;
    public static final int MAIN_FRAME_CUSTOMER_MODE = 2;
    public static final int MAIN_FRAME_BILL_MODE = 3;
    public static final int MAIN_FRAME_EMPLOYEE_MODE = 4;
    
}
