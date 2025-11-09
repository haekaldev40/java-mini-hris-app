package minihris.example.mini_hris_project.modules.jabatan.mapper;

import minihris.example.mini_hris_project.modules.jabatan.dto.JabatanRequest;
import minihris.example.mini_hris_project.modules.jabatan.dto.JabatanResponse;
import minihris.example.mini_hris_project.modules.jabatan.entity.TrJabatan;
import org.springframework.stereotype.Component;

@Component
public class JabatanMapper {
    public JabatanResponse toResponse(TrJabatan jabatan) {
        JabatanResponse response = new JabatanResponse();
        response.setId(jabatan.getId());
        response.setKodeJabatan(jabatan.getKodeJabatan());
        response.setNamaJabatan(jabatan.getNamaJabatan());
        return response;
    }

    public TrJabatan toEntity(JabatanRequest request) {
        TrJabatan jabatan = new TrJabatan();
        jabatan.setKodeJabatan(request.getKodeJabatan());
        jabatan.setNamaJabatan(request.getNamaJabatan());
        return jabatan;
    }

    public void updateEntity(TrJabatan jabatan, JabatanRequest request) {
        jabatan.setKodeJabatan(request.getKodeJabatan());
        jabatan.setNamaJabatan(request.getNamaJabatan());
    }
}