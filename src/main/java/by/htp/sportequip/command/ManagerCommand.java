package by.htp.sportequip.command;

import java.util.HashMap;
import java.util.Map;

public class ManagerCommand {
	
	private static Map<EnumCommand, CommandAction> map = new HashMap<EnumCommand, CommandAction>();
	static {
		map.put(EnumCommand.HOMEPAGE, new HomePageCommandAction());
		map.put(EnumCommand.LOGIN, new LoginCommandAction());
		map.put(EnumCommand.QUITSESSION, new QuipCommandAction());
		map.put(EnumCommand.EQUIPMENTPAGE, new EquipPageCommandAction());
		map.put(EnumCommand.EQUIPLIST, new EquipListCommandAction());
		map.put(EnumCommand.SLIDER, new SliderPageAction());
		map.put(EnumCommand.CONTACT, new ContactCommandAction());
		map.put(EnumCommand.CREATE_ORDER, new OrderCreateAction());
	}
	public static CommandAction getActionCommand(String action){
		EnumCommand enumCom = EnumCommand.change(action);
		return map.get(enumCom);
	}
}
