package co.edu.uptc.service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.service.dtos.PlaceDto;
import co.edu.uptc.service.exeptions.ProjectExeption;
import co.edu.uptc.service.models.Place;
import co.edu.uptc.service.services.PlaceService;


@RestController
@RequestMapping("/{placeMapp}")
public class PlaceController {
    PlaceService placeService = new PlaceService();

    @GetMapping()
    public ResponseEntity<Object> getPlaces() {
        return ResponseEntity.status(HttpStatus.OK).body(placeService.getPlaces());
    }

    @PostMapping()
    public ResponseEntity<Object> addPlace(@RequestBody PlaceDto placeDto) {
        try {
        PlaceDto.validaPlace(placeDto);
        placeService.addPlace(PlaceDto.fromPlace(placeDto));
        return ResponseEntity.status(HttpStatus.OK).body(placeService.getPlaces());
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }    
    }

    @DeleteMapping("/${deletePlaceMapp}")
    public ResponseEntity<Object> deletePlace(@PathVariable String id) {
        placeService.removePlace(id);
        return ResponseEntity.status(HttpStatus.OK).body(placeService.getPlaces());
    }
 
    
    @PutMapping("/{modifyMapp}")
    public ResponseEntity<Object> modifyPlace(@RequestBody PlaceDto placeDto){
        Place place = PlaceDto.fromPlace(placeDto);
        placeService.refactorPlace(place);
        return ResponseEntity.status(HttpStatus.OK).body(place);
    }
}
