package minihris.example.mini_hris_project.modules.ptkp.service;

import minihris.example.mini_hris_project.modules.ptkp.dto.PtkpRequest;
import minihris.example.mini_hris_project.modules.ptkp.dto.PtkpResponse;

import java.util.List;

public interface PtkpService {
    PtkpResponse createPtkp(PtkpRequest ptkpRequest);
    PtkpResponse getPtkpById(Long id);
    List<PtkpResponse> getAllPtkp();
    PtkpResponse updatePtkp(Long id, PtkpRequest ptkpRequest);
    void deletePtkp(Long id);
}