package minihris.example.mini_hris_project.modules.divisi.controller;

import minihris.example.mini_hris_project.common.CustomApiResponse;
import minihris.example.mini_hris_project.common.PaginatedData;
import minihris.example.mini_hris_project.modules.divisi.dto.DivisiRequest;
import minihris.example.mini_hris_project.modules.divisi.dto.DivisiResponse;
import minihris.example.mini_hris_project.modules.divisi.service.DivisiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/divisi")
public class DivisiController {

    private final DivisiService divisiService;

    @Value("${app.version}")
    private String appVersion;

    public DivisiController(DivisiService divisiService) {
        this.divisiService = divisiService;
    }

    @PostMapping
    public ResponseEntity<CustomApiResponse<DivisiResponse>> createDivisi(@RequestBody DivisiRequest divisiRequest) {
        DivisiResponse createdDivisi = divisiService.createDivisi(divisiRequest);
        CustomApiResponse<DivisiResponse> response = CustomApiResponse.<DivisiResponse>builder()
                .result("Success")
                .detail("Divisi created successfully")
                .path("/api/v1/divisi")
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.CREATED.value())
                .version(appVersion)
                .data(createdDivisi)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomApiResponse<DivisiResponse>> getDivisiById(@PathVariable Long id) {
        DivisiResponse divisi = divisiService.getDivisiById(id);
        CustomApiResponse<DivisiResponse> response = CustomApiResponse.<DivisiResponse>builder()
                .result("Success")
                .detail("Divisi retrieved successfully")
                .path("/api/v1/divisi/" + id)
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(divisi)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<CustomApiResponse<PaginatedData<DivisiResponse>>> getAllDivisi(Pageable pageable) {
        Page<DivisiResponse> divisiPage = divisiService.getAllDivisi(pageable);
        PaginatedData<DivisiResponse> paginatedData = PaginatedData.<DivisiResponse>builder()
                .page(divisiPage.getNumber())
                .limit(divisiPage.getSize())
                .total(divisiPage.getTotalElements())
                .list(divisiPage.getContent())
                .build();
        CustomApiResponse<PaginatedData<DivisiResponse>> response = CustomApiResponse.<PaginatedData<DivisiResponse>>builder()
                .result("Success")
                .detail("Divisi list retrieved successfully")
                .path("/api/v1/divisi")
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(paginatedData)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomApiResponse<DivisiResponse>> updateDivisi(@PathVariable Long id, @RequestBody DivisiRequest divisiRequest) {
        DivisiResponse updatedDivisi = divisiService.updateDivisi(id, divisiRequest);
        CustomApiResponse<DivisiResponse> response = CustomApiResponse.<DivisiResponse>builder()
                .result("Success")
                .detail("Divisi updated successfully")
                .path("/api/v1/divisi/" + id)
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(updatedDivisi)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomApiResponse<Void>> deleteDivisi(@PathVariable Long id) {
        divisiService.deleteDivisi(id);
        CustomApiResponse<Void> response = CustomApiResponse.<Void>builder()
                .result("Success")
                .detail("Divisi deleted successfully")
                .path("/api/v1/divisi/" + id)
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .build();
        return ResponseEntity.ok(response);
    }
}