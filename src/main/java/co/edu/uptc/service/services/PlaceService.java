package co.edu.uptc.service.services;

import java.util.List;

import co.edu.uptc.SimpleList;
import co.edu.uptc.service.models.Place;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceService {
    private static List<Place> places; 

    public PlaceService(){
        places = initValues();
    }

    public void addPlace(Place place){
        places.add(place);
    }

    public void removePlace(String id){
        for(Place place : places){
            if(place.getId().equals(id)){
                places.remove(place);
                return;
            }
        }
    }

    public void refactorPlace(Place refactorizedPlace) {
        for(Place place : places){
            if(place.getId().equals(refactorizedPlace.getId())){
                place.setName(refactorizedPlace.getName());
                place.setFisicalAddress(refactorizedPlace.getFisicalAddress());
                place.setId(refactorizedPlace.getId());
                return;
            }
        }
    }

    public List<Place> initValues(){
        List<Place> auxList = new SimpleList<>();
        Place central = new Place();
        central.setName("Ed. Central");
        central.setFisicalAddress("Centro");
        central.setId("C");
        Place  library = new Place();
        library.setName("Ed. Biblioteca");
        library.setFisicalAddress("Centro");
        library.setId("B");
        Place admin = new Place();
        admin.setName("Ed. Administrativo");
        admin.setFisicalAddress("Centro");
        admin.setId("S");
        Place veterinary = new Place();
        veterinary.setName("Ed Veterinaria");
        veterinary.setFisicalAddress("Este");
        veterinary.setId("V");
        Place posgrados = new Place();
        posgrados.setName("Ed Posgrados");
        posgrados.setFisicalAddress("Sur");
        posgrados.setId("P");
        Place restaurant = new Place();
        restaurant.setName("Restaurante");
        restaurant.setFisicalAddress("Oeste");
        restaurant.setId("T");
        Place lab = new Place();
        lab.setName("Laboratorio");
        lab.setFisicalAddress("Norte");
        lab.setId("N");

        auxList.add(central);
        auxList.add(library);
        auxList.add(admin);
        auxList.add(veterinary);
        auxList.add(posgrados);
        auxList.add(restaurant);
        auxList.add(lab);

        return auxList;
    }

    public List<Place> getPlaces(){
        return places;
    }
}
