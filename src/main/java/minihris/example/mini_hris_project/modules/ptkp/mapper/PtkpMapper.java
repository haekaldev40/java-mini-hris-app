package minihris.example.mini_hris_project.modules.ptkp.mapper;

import minihris.example.mini_hris_project.modules.ptkp.dto.PtkpRequest;
import minihris.example.mini_hris_project.modules.ptkp.dto.PtkpResponse;
import minihris.example.mini_hris_project.modules.ptkp.entity.TrPtkp;
import org.springframework.stereotype.Component;

@Component
public class PtkpMapper {
    public TrPtkp toEntity(PtkpRequest ptkpRequest) {
        TrPtkp ptkp = new TrPtkp();
        ptkp.setStatus(ptkpRequest.getStatus());
        ptkp.setKeterangan(ptkpRequest.getKeterangan());
        ptkp.setNilaiPtkp(ptkpRequest.getNilaiPtkp());
        return ptkp;
    }

    public PtkpResponse toResponse(TrPtkp ptkp) {
        return new PtkpResponse(
                ptkp.getId(),
                ptkp.getStatus(),
                ptkp.getKeterangan(),
                ptkp.getNilaiPtkp()
        );
    }
}