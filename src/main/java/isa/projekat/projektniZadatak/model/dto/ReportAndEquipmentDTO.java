package isa.projekat.projektniZadatak.model.dto;

import java.util.List;

public class ReportAndEquipmentDTO {

    private ReportDTO report;
    private List<EquipmentDTO> equipment;

    public ReportAndEquipmentDTO() {}

    public ReportDTO getReport() {
        return report;
    }

    public void setReport(ReportDTO report) {
        this.report = report;
    }

    public List<EquipmentDTO> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<EquipmentDTO> equipment) {
        this.equipment = equipment;
    }
}
