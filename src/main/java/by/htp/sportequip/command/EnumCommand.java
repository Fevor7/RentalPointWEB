package by.htp.sportequip.command;

public enum EnumCommand {
	LOGIN, 
	CREATE_ORDER, 
	EQUIPLIST, 
	HOMEPAGE, 
	QUITSESSION, 
	EQUIPMENTPAGE, 
	SLIDER, 
	CONTACT;
	
	public static EnumCommand change(String action){
		action = action.toUpperCase();
		EnumCommand enumCom = EnumCommand.valueOf(action);
		return enumCom;
	}
}
