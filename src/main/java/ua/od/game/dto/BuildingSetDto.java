package ua.od.game.dto;

public class BuildingSetDto {
    Integer id;
    Integer setId;
    Integer buildingId;
    Float amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
