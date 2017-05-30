package by.htp.sportequip.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.sportequip.dao.EquipmentDao;
import by.htp.sportequip.dao.EquipmentDaoImpl;
import by.htp.sportequip.entity.Equipment;

import static by.htp.sportequip.util.ConstantValue.*;

public class EquipmentServiceImpl implements EquipmentService{
	private EquipmentDao dao;
	
	public EquipmentServiceImpl(){
		dao = new EquipmentDaoImpl();
	}
	@Override
	public List<Equipment> list() {
		return dao.fetchAllEquip();
	}
	public List<Equipment> listType(String type, String name) {
		List<Equipment> equip = null;
		if((REQUEST_PARAM_EQUIP_ALL).equals(name)){
			equip = dao.fetchTypeEquip(type,SQL_STATEMENT_SELECT_EQUIP_TYPE);
		} else {
			equip = dao.fetchTypeEquip(name,SQL_STATEMENT_SELECT_EQUIP_NAME);
		}
		return equip;
	}
	@Override
	public List<Equipment> filterPr(String min, String max, List<Equipment> equip) {
		double minPr = Double.parseDouble(min);
		double maxPr = Double.parseDouble(max);
		for (int i=(equip.size()-1); i>=0;i--){
			if((equip.get(i).getPrice()<minPr)||(equip.get(i).getPrice()>maxPr)) {
				equip.remove(i);
			}
		}
		return equip;
	}
	
}
