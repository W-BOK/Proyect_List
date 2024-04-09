package co.edu.uptc.service.dtos;

import co.edu.uptc.service.exeptions.ProjectExeption;
import co.edu.uptc.service.exeptions.TypeMessage;
import co.edu.uptc.service.models.Place;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDto {
    private String name;
    private String Id;
    private String FisicalAddress;
    
    public static Place fromPlace(PlaceDto place){
        Place dto = new Place();
        dto.setFisicalAddress(place.getFisicalAddress());
        dto.setId(place.getId());
        dto.setName(place.getName());
        return dto;
    }

    public static void validaPlace(PlaceDto placeDto) throws ProjectExeption { 
        if (placeDto.getName() == null || 
        placeDto.getId() == null ||
        placeDto.getFisicalAddress() == null) {
            throw new ProjectExeption(TypeMessage.INFORMATION_INCOMPLETE);
        } 
    }
}
