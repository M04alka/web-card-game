package ua.od.game.controller.impl;

import ua.od.game.controller.UpgradeController;
import ua.od.game.dto.UpgradeDto;
import ua.od.game.service.UpgradeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/upgrade")
public class UpgradeControllerImpl implements UpgradeController {
    @Inject
    public UpgradeService upgradeService;


    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<UpgradeDto> getAllUpgradeList() {
        List<UpgradeDto> upgradeList = upgradeService.getAllUpgradeList();
        return upgradeList;
    }

}
