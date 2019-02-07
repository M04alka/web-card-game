package ua.od.game.service.impl;

import ua.od.game.dto.BuildingSetDto;
import ua.od.game.dto.ResourceSetDto;
import ua.od.game.dto.UpgradeDto;
import ua.od.game.model.BuildingSetEntity;
import ua.od.game.model.ResourceSetEntity;
import ua.od.game.model.UpgradeEntity;
import ua.od.game.repository.dao.UpgradeDao;
import ua.od.game.repository.dao.impl.UpgradeDaoImpl;
import ua.od.game.service.UpgradeService;

import java.util.ArrayList;
import java.util.List;

public class UpgradeServiceImpl implements UpgradeService {

    public UpgradeDao upgradeDao;
    public UpgradeEntity upgradeEntity;

    @Override

    public List<UpgradeDto> getAllUpgradeList() {
        upgradeDao = new UpgradeDaoImpl();
        ArrayList<UpgradeDto> upradeList = new ArrayList<>();
        List<UpgradeEntity> allUpgrades = upgradeDao.getAllUpgradeList();
        allUpgrades.forEach(UpgradeEntity ->
                upradeList.add(new UpgradeDto()
                               {{
                                   setId(UpgradeEntity.getId());
                                   setName(UpgradeEntity.getName());
                                   setDescription(UpgradeEntity.getDescription());
                                   setDefaultNumber(UpgradeEntity.getDefaultNumber());
                                   setBuildingSetList(fillBuildingSetList(UpgradeEntity.getBuildingSetList()));
                                   setResourceSetList(fillResourceSetList(UpgradeEntity.getResourceSetList()));
                               }}
                ));

        return upradeList;
    }

    private List<ResourceSetDto> fillResourceSetList(List<ResourceSetEntity> resourceSetEntities) {
        List<ResourceSetDto> resourceSetDtos = new ArrayList<>();
        resourceSetEntities.forEach(resourceSetEntity -> resourceSetDtos.add(new ResourceSetDto() {
            {
                setId(resourceSetEntity.getId());
                setSetId(resourceSetEntity.getSetId());
                setResourceId(resourceSetEntity.getResourceId());
                setAmount(resourceSetEntity.getAmount());
            }
        }));
        return resourceSetDtos;
    }

    private List<BuildingSetDto> fillBuildingSetList(List<BuildingSetEntity> buildinSetLists) {
        List<BuildingSetDto> buildingSetDtos = new ArrayList<>();
        buildinSetLists.forEach(buildingSetEntity -> buildingSetDtos.add(new BuildingSetDto() {
            {
                setId(buildingSetEntity.getId());
                setSetId(buildingSetEntity.getSetId());
                setBuildingId(buildingSetEntity.getBuildingId());
                setAmount(buildingSetEntity.getAmount());
            }
        }));
        return buildingSetDtos;
    }
}
