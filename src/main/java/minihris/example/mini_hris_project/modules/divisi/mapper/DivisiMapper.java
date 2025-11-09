package minihris.example.mini_hris_project.modules.divisi.mapper;

import minihris.example.mini_hris_project.modules.divisi.dto.DivisiRequest;
import minihris.example.mini_hris_project.modules.divisi.dto.DivisiResponse;
import minihris.example.mini_hris_project.modules.divisi.entity.TrDivisi;
import org.springframework.stereotype.Component;

@Component
public class DivisiMapper {
    public DivisiResponse toResponse(TrDivisi divisi) {
        return new DivisiResponse(divisi.getId(), divisi.getNamaDivisi(), divisi.getKodeDivisi());
    }

    public TrDivisi toEntity(DivisiRequest divisiRequest) {
        TrDivisi divisi = new TrDivisi();
        divisi.setNamaDivisi(divisiRequest.getName());
        divisi.setKodeDivisi(divisiRequest.getKodeDivisi());
        return divisi;
    }
}