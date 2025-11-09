package minihris.example.mini_hris_project.modules.ptkp.service;

import minihris.example.mini_hris_project.exception.ResourceNotFoundException;
import minihris.example.mini_hris_project.modules.ptkp.dto.PtkpRequest;
import minihris.example.mini_hris_project.modules.ptkp.dto.PtkpResponse;
import minihris.example.mini_hris_project.modules.ptkp.entity.TrPtkp;
import minihris.example.mini_hris_project.modules.ptkp.mapper.PtkpMapper;
import minihris.example.mini_hris_project.modules.ptkp.repository.PtkpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PtkpServiceImpl implements PtkpService {

    private final PtkpRepository ptkpRepository;
    private final PtkpMapper ptkpMapper;

    public PtkpServiceImpl(PtkpRepository ptkpRepository, PtkpMapper ptkpMapper) {
        this.ptkpRepository = ptkpRepository;
        this.ptkpMapper = ptkpMapper;
    }

    @Override
    public PtkpResponse createPtkp(PtkpRequest ptkpRequest) {
        TrPtkp ptkp = ptkpMapper.toEntity(ptkpRequest);
        return ptkpMapper.toResponse(ptkpRepository.save(ptkp));
    }

    @Override
    public PtkpResponse getPtkpById(Long id) {
        TrPtkp ptkp = ptkpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ptkp not found with id: " + id));
        return ptkpMapper.toResponse(ptkp);
    }

    @Override
    public List<PtkpResponse> getAllPtkp() {
        return ptkpRepository.findAll().stream()
                .map(ptkpMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PtkpResponse updatePtkp(Long id, PtkpRequest ptkpRequest) {
        TrPtkp existingPtkp = ptkpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ptkp not found with id: " + id));
        existingPtkp.setStatus(ptkpRequest.getStatus());
        existingPtkp.setKeterangan(ptkpRequest.getKeterangan());
        existingPtkp.setNilaiPtkp(ptkpRequest.getNilaiPtkp());
        return ptkpMapper.toResponse(ptkpRepository.save(existingPtkp));
    }

    @Override
    public void deletePtkp(Long id) {
        ptkpRepository.deleteById(id);
    }
}