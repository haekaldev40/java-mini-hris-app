package minihris.example.mini_hris_project.modules.divisi.service;

import minihris.example.mini_hris_project.exception.ResourceNotFoundException;
import minihris.example.mini_hris_project.modules.divisi.dto.DivisiRequest;
import minihris.example.mini_hris_project.modules.divisi.dto.DivisiResponse;
import minihris.example.mini_hris_project.modules.divisi.entity.TrDivisi;
import minihris.example.mini_hris_project.modules.divisi.mapper.DivisiMapper;
import minihris.example.mini_hris_project.modules.divisi.repository.DivisiRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DivisiServiceImpl implements DivisiService {

    private final DivisiRepository divisiRepository;
    private final DivisiMapper divisiMapper;

    public DivisiServiceImpl(DivisiRepository divisiRepository, DivisiMapper divisiMapper) {
        this.divisiRepository = divisiRepository;
        this.divisiMapper = divisiMapper;
    }

    @Override
    public DivisiResponse createDivisi(DivisiRequest divisiRequest) {
        TrDivisi divisi = divisiMapper.toEntity(divisiRequest);
        return divisiMapper.toResponse(divisiRepository.save(divisi));
    }

    @Override
    public DivisiResponse getDivisiById(Long id) {
        TrDivisi divisi = divisiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Divisi not found with id: " + id));
        return divisiMapper.toResponse(divisi);
    }

    @Override
    public Page<DivisiResponse> getAllDivisi(Pageable pageable) {
        return divisiRepository.findAll(pageable).map(divisiMapper::toResponse);
    }

    @Override
    public DivisiResponse updateDivisi(Long id, DivisiRequest divisiRequest) {
        TrDivisi existingDivisi = divisiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Divisi not found with id: " + id));
        existingDivisi.setNamaDivisi(divisiRequest.getName());
        existingDivisi.setKodeDivisi(divisiRequest.getKodeDivisi());
        return divisiMapper.toResponse(divisiRepository.save(existingDivisi));
    }

    @Override
    public void deleteDivisi(Long id) {
        if (!divisiRepository.existsById(id)) {
            throw new ResourceNotFoundException("Divisi not found with id: " + id);
        }
        divisiRepository.deleteById(id);
    }
}