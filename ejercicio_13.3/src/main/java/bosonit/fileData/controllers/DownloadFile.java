package bosonit.fileData.controllers;

import bosonit.fileData.dtos.output.FileOutputDTO;
import bosonit.fileData.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/download")
public class DownloadFile {
    @Autowired
    FileService fileService;

    @GetMapping("/fileByName/{filename}")
    public ResponseEntity obtenerFicheroPorNombre(@PathVariable String filename) {
        FileOutputDTO file = fileService.bajarFicheroNombre(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"file; filename=\""+file.getName()+"\"")
                .body(file.getResource());
    }

    @GetMapping("/fileById/{id}")
    public ResponseEntity obtenerFicheroPorId(@PathVariable Integer id) {
        FileOutputDTO file = fileService.bajarFicheroId(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"file; filename=\""+file.getName()+"\"")
                .body(file.getResource());
    }

}
