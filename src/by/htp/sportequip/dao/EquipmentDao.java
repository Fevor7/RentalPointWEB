package by.htp.sportequip.dao;

import java.util.List;

import by.htp.sportequip.entity.Equipment;

public interface EquipmentDao {
	List<Equipment> fetchAllEquip();
	List<Equipment> fetchTypeEquip(String type,String select);
}
