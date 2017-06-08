package by.htp.sportequip.command;

import static by.htp.sportequip.util.ConstantValue.*;

public class CommandChooser {

	public static CommandAction chooserAction(String action) {
		System.out.println(action);
		/*switch (action) {
		case ACTION_AUTHORIZE: // LOGIN 1 
			return new LoginCommandAction();
		case ACTION_MAKE_ORDER: // CREATE_ORDER
			return new OrderCreateAction();
		case ACTION_ORDER: // MAKE_ORDER
			return new MakeOrderAction();
		case ACTION_EQUIP: //EQUIPLIST
			return new EquipListCommandAction();
		case ACTION_HOMEPAGE: //HOMEPAGE
			return new HomePageCommandAction();
		case ACTION_QUITSESSION: //QUITSESSION
			return new QuipCommandAction();
		case ACTION_EQUIPPAGE: //EQUIPMENTPAGE
			return new EquipPageCommandAction();
		case ACTION_SLIDER: //SLIDER
			return new SliderPageAction();
		case ACTION_CONTACT: // CONTACT
			return new ContactCommandAction();
		}*/
		return null;
	}

}
