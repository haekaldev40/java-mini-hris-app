package minihris.example.mini_hris_project.modules.jabatan.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import minihris.example.mini_hris_project.common.CustomApiResponse;
import minihris.example.mini_hris_project.common.PaginatedData;
import minihris.example.mini_hris_project.modules.jabatan.dto.JabatanRequest;
import minihris.example.mini_hris_project.modules.jabatan.dto.JabatanResponse;
import minihris.example.mini_hris_project.modules.jabatan.service.JabatanService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/jabatan")
@RequiredArgsConstructor
public class JabatanController {

    private final JabatanService jabatanService;
    @Value("${app.version}")
    private String appVersion;

    @PostMapping
    public ResponseEntity<CustomApiResponse<JabatanResponse>> createJabatan(@Valid @RequestBody JabatanRequest request, HttpServletRequest httpServletRequest) {
        JabatanResponse response = jabatanService.createJabatan(request);
        CustomApiResponse<JabatanResponse> customResponse = CustomApiResponse.<JabatanResponse>builder()
                .result("Sukses")
                .detail("Jabatan berhasil dibuat!")
                .path(httpServletRequest.getRequestURI())
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.CREATED.value())
                .version(appVersion)
                .data(response)
                .build();
        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomApiResponse<JabatanResponse>> getJabatanById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        JabatanResponse response = jabatanService.getJabatanById(id);
        CustomApiResponse<JabatanResponse> customResponse = CustomApiResponse.<JabatanResponse>builder()
                .result("Sukses")
                .detail("Jabatan berhasil ditemukan!")
                .path(httpServletRequest.getRequestURI())
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(response)
                .build();
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CustomApiResponse<PaginatedData<JabatanResponse>>> getAllJabatan(Pageable pageable, HttpServletRequest httpServletRequest) {
        Page<JabatanResponse> page = jabatanService.getAllJabatan(pageable);
        PaginatedData<JabatanResponse> paginatedData = PaginatedData.<JabatanResponse>builder()
                .page(page.getNumber())
                .limit(page.getSize())
                .total(page.getTotalElements())
                .list(page.getContent())
                .build();
        CustomApiResponse<PaginatedData<JabatanResponse>> customResponse = CustomApiResponse.<PaginatedData<JabatanResponse>>builder()
                .result("Sukses")
                .detail("Jabatan berhasil ditemukan!")
                .path(httpServletRequest.getRequestURI())
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(paginatedData)
                .build();
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomApiResponse<JabatanResponse>> updateJabatan(@PathVariable Long id, @Valid @RequestBody JabatanRequest request, HttpServletRequest httpServletRequest) {
        JabatanResponse response = jabatanService.updateJabatan(id, request);
        CustomApiResponse<JabatanResponse> customResponse = CustomApiResponse.<JabatanResponse>builder()
                .result("Sukses")
                .detail("Jabatan berhasil diupdate!")
                .path(httpServletRequest.getRequestURI())
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(response)
                .build();
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomApiResponse<Object>> deleteJabatan(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        jabatanService.deleteJabatan(id);
        CustomApiResponse<Object> customResponse = CustomApiResponse.builder()
                .result("Success")
                .detail("Jabatan deleted successfully")
                .path(httpServletRequest.getRequestURI())
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(null)
                .build();
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
}