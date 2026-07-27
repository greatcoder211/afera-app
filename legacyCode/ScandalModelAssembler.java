package pl.afera.aferaapp.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import pl.afera.aferaapp.model.entity.Scandal;

import java.util.Map;

public class ScandalModelAssembler implements RepresentationModelAssembler<Scandal, EntityModel<Scandal>> {

    //the method certainly has to be renamed
    public Map<Scandal, String> mapScandalToEndpoint(Scandal scandal){
        return Map.of(scandal, "localhost:8080/scandals/"+scandal.getId());
    }

    @Override
    public EntityModel<Scandal> toModel(Scandal scandal) {
//TODO: fill
    }
}
