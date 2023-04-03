package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.model.Equipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
public class EquipmentDTO {


    private Long id;
    private String nameEquipment;
    private String quantitiofEquipment;

    public EquipmentDTO(Long id, String nameEquipment, String quantitiofEquipment) {
        this.id = id;
        this.nameEquipment = nameEquipment;
        this.quantitiofEquipment = quantitiofEquipment;
    }

    public EquipmentDTO equipmentDTO(Equipment equipment){
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.setNameEquipment(equipment.getNameEquipment());
        equipmentDTO.setQuantitiofEquipment(equipment.getQuantitiofEquipment());

        return equipmentDTO;
    }
}
