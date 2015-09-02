package com.exposit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.domain.service.ModuleService;
import com.exposit.domain.service.OrderService;
import com.exposit.domain.service.ShipmentService;
import com.exposit.domain.service.StorageModuleUnitService;
import com.exposit.repository.dao.StorageModuleUnitDao;
import com.exposit.web.dto.StorageModuleUnitDto;

@Service
public class StorageModuleUnitServiceImpl implements StorageModuleUnitService {

	@Autowired
	private StorageModuleUnitDao storageModuleUnitDao;
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private OrderService orderService;

	@Override
	public List<StorageModuleUnit> getStorageModuleUnits() {
		return storageModuleUnitDao.findAll();
	}

	@Override
	public StorageModuleUnit getStorageModuleUnitById(Integer id) {
		return storageModuleUnitDao.findById(id);
	}

	@Override
	public void update(StorageModuleUnit storageModuleUnit) {
		storageModuleUnitDao.update(storageModuleUnit);
	}

	@Override
	public List<StorageModuleUnitDto> getStorageModuleUnitDtos() {
		List<StorageModuleUnitDto> dtos = new ArrayList<StorageModuleUnitDto>();
		for (StorageModuleUnit storageModuleUnit : this.getStorageModuleUnits()) {
			Module module = moduleService.getModule(storageModuleUnit);
			StorageModuleUnitDto dto = new StorageModuleUnitDto.Builder(
					storageModuleUnit.getId(), storageModuleUnit.getCount(),
					module.getModuleType().toString(), module.getCost(),
					module.getId(), storageModuleUnit.getFullMargin(), module.getImage()).build();
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void addModulesInStorage(Shipment shipment) {
		for (ShipmentUnit shipmentUnit : shipmentService
				.getShipmentUnitsByShipment(shipment)) {
			Module module = moduleService.getModule(shipmentUnit);

			StorageModuleUnit storageModuleUnit = this
					.getStorageModuleUnit(module);

			storageModuleUnit.setCount(storageModuleUnit.getCount()
					+ shipmentUnit.getCount());
			this.update(storageModuleUnit);

		}

	}

	@Override
	public StorageModuleUnit getStorageModuleUnit(Module module) {
		return storageModuleUnitDao.getStorageModuleUnit(module);
	}

	@Override
	public void holdModulesWhileConfirmOrder(Order order) {
		HashMap<Module, Integer> modulesInOrder = moduleService
				.getModulesInOrder(order);
		for (Module module : modulesInOrder.keySet()) {
			StorageModuleUnit storageModuleUnit = this
					.getStorageModuleUnit(module);
			storageModuleUnit.setCount(storageModuleUnit.getCount()
					- modulesInOrder.get(module));
			this.update(storageModuleUnit);
		}
	}
}
