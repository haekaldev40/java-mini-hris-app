package minihris.example.mini_hris_project.modules.ptkp.controller;

import minihris.example.mini_hris_project.common.CustomApiResponse;
import minihris.example.mini_hris_project.modules.ptkp.dto.PtkpRequest;
import minihris.example.mini_hris_project.modules.ptkp.dto.PtkpResponse;
import minihris.example.mini_hris_project.modules.ptkp.service.PtkpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ptkp")
public class PtkpController {

    private final PtkpService ptkpService;

    @Value("${app.version}")
    private String appVersion;

    public PtkpController(PtkpService ptkpService) {
        this.ptkpService = ptkpService;
    }

    @PostMapping
    public ResponseEntity<CustomApiResponse<PtkpResponse>> createPtkp(@RequestBody PtkpRequest ptkpRequest) {
        PtkpResponse createdPtkp = ptkpService.createPtkp(ptkpRequest);
        CustomApiResponse<PtkpResponse> response = CustomApiResponse.<PtkpResponse>builder()
                .result("Sukses")
                .detail("PTKP berhasil dibuat!")
                .path("/api/v1/ptkp")
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.CREATED.value())
                .version(appVersion)
                .data(createdPtkp)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomApiResponse<PtkpResponse>> getPtkpById(@PathVariable Long id) {
        PtkpResponse ptkp = ptkpService.getPtkpById(id);
        CustomApiResponse<PtkpResponse> response = CustomApiResponse.<PtkpResponse>builder()
                .result("Sukses")
                .detail("PTKP berhasil diambil!")
                .path("/api/v1/ptkp/" + id)
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(ptkp)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<CustomApiResponse<List<PtkpResponse>>> getAllPtkp() {
        List<PtkpResponse> ptkpList = ptkpService.getAllPtkp();
        CustomApiResponse<List<PtkpResponse>> response = CustomApiResponse.<List<PtkpResponse>>builder()
                .result("Sukses")
                .detail("Daftar PTKP berhasil diambil!")
                .path("/api/v1/ptkp")
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(ptkpList)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomApiResponse<PtkpResponse>> updatePtkp(@PathVariable Long id, @RequestBody PtkpRequest ptkpRequest) {
        PtkpResponse updatedPtkp = ptkpService.updatePtkp(id, ptkpRequest);
        CustomApiResponse<PtkpResponse> response = CustomApiResponse.<PtkpResponse>builder()
                .result("Sukses")
                .detail("PTKP berhasil diupdate!")
                .path("/api/v1/ptkp/" + id)
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .data(updatedPtkp)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomApiResponse<Void>> deletePtkp(@PathVariable Long id) {
        ptkpService.deletePtkp(id);
        CustomApiResponse<Void> response = CustomApiResponse.<Void>builder()
                .result("Sukses")
                .detail("PTKP berhasil dihapus!")
                .path("/api/v1/ptkp/" + id)
                .date(LocalDateTime.now().toString())
                .code(HttpStatus.OK.value())
                .version(appVersion)
                .build();
        return ResponseEntity.ok(response);
    }
}