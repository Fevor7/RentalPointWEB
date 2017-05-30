package by.htp.sportequip.util;

public final class ConstantValue {
	
	private ConstantValue(){}
	
	public static final String ACTION_AUTHORIZE = "login";
	public static final String ACTION_MAKE_ORDER = "create_order";
	public static final String ACTION_ORDER = "make_order";
	public static final String ACTION_EQUIP = "equipList";
	public static final String ACTION_HOMEPAGE = "homePage";
	public static final String ACTION_QUITSESSION = "quitSession";
	public static final String ACTION_EQUIPPAGE = "equipmentPage";
	public static final String ACTION_SLIDER = "slider";
	public static final String ACTION_CONTACT = "contact";
	
	public static final String PAGE_ADMIN_MAIN = "/admin.jsp";
	public static final String PAGE_USER_MAIN = "/equipList.jsp";
	public static final String PAGE_ORDER_CREATE = "/order.jsp";
	public static final String PAGE_HOMEPAGE = "/homepage.jsp"; 
	public static final String PAGE_ORDER_LIST = "/orderlist.jsp";
	public static final String PAGE_EQUIPPAGE = "/equipmentPage.jsp";
	public static final String PAGE_SLIDER = "/slider.html";
	public static final String PAGE_CONTACT = "/contact.html";
	
	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_LIST_EQ = "list_eq";
	public static final String REQUEST_PARAM_LIST_ORDER = "list_order";
	public static final String REQUEST_PARAM_ERROR_MSG = "error_msg";
	
	public static final String REQUEST_PARAM_EQUIP_ALL="all";
	public static final String REQUEST_PARAM_EQUIP_TYPE = "type";
	public static final String REQUEST_PARAM_EQUIP_NAME = "name";
	public static final String REQUEST_PARAM_EQUIP_FILTER = "filter";
	public static final String REQUEST_PARAM_EQUIP_FILTER_MIN = "filterPrMin";
	public static final String REQUEST_PARAM_EQUIP_FILTER_MAX = "filterPrMax";
	
	public static final String PARAM_USER_ID = "user_id";
	public static final String PARAM_EQUIPMENT_ID = "equip_id";
	public static final String PARAM_DATE_START = "date_start";
	public static final String PARAM_DATE_END = "date_end";
	
	public static final String SESSION_NAMEATTR_USER = "user";
	public static final String SESSION_NAMEATTR_PAGE = "page";
	public static final String SESSION_NAMEATTR_EQUIPTYPE = "equipType";
	
	public static final String SESSION_ATTRIBUTE_EQUIP_ALL = "equipAll";
	public static final String SESSION_ATTRIBUTE_EQUIPMENT = "EQ";
	public static final String SESSION_ATTRIBUTE_ACCECCORY = "EC";
	public static final String SESSION_ATTRIBUTE_SLIDER = "slider";
	public static final String SESSION_ATTRIBUTE_CONTACT = "contact";
	
	public static final String SQL_STATEMENT_SELECT_USERS = "select * from user";
	public static final String SQL_STATEMENT_SELECT_USER = "select * from user where login = ? and password = ?";
	public static final String SQL_STATEMENT_ORDER_CREATE = "INSERT INTO mysport.order (id_user, id_equipment, date_start, date_end) VALUE(?, ?, ?, ?)";
	public static final String SQL_STATEMENT_SELECT_ORDER = "select id_order, id_user, id_equipment, date_start, date_end from mysport.order";
	public static final String SQL_STATEMENT_SELECT_EQUIP = "select * from mysport.equipment";
	public static final String SQL_STATEMENT_SELECT_EQUIP_TYPE = "select * from mysport.equipment where equipment.type = ?";
	public static final String SQL_STATEMENT_SELECT_EQUIP_NAME = "select * from mysport.equipment where equipment.name = ?";
}