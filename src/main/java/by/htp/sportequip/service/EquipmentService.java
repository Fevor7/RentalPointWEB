package by.htp.sportequip.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sportequip.entity.Equipment;

public interface EquipmentService {

	List<Equipment> list();

	List<Equipment> listType(String type, String name);

	List<Equipment> filterPr(String min, String max, List<Equipment> equip);
}
