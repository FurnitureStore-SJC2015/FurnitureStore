package com.exposit.service.dobrilko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.StorageModuleUnitService;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.zanevsky.ModuleService;
import com.exposit.repository.dao.dobrilko.StorageModuleUnitDao;
import com.exposit.web.dto.dobrilko.StorageModuleUnitDto;

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
