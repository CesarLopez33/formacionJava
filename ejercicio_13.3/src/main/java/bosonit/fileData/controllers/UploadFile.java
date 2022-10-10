package bosonit.fileData.controllers;

import bosonit.fileData.dtos.input.FileDataInputDTO;
import bosonit.fileData.dtos.output.FileDataOutputDTO;
import bosonit.fileData.dtos.output.FileOutputDTO;
import bosonit.fileData.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping("/upload")
public class UploadFile {
    @Autowired
    FileService fileService;

    @RequestMapping(value = "/{type}", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity uploadFile(@ModelAttribute FileDataInputDTO data, @PathVariable String type){
        //Comprobacion del tipo de fichero
        String filename = data.getFile().getOriginalFilename();
        if(!filename.substring(filename.lastIndexOf('.')+1).equals(type))
            return ResponseEntity.badRequest().body("El fihero tiene que se del mismo tipo que type: " + type);

        FileDataOutputDTO salida = fileService.subirFichero(data);
        String download = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/fileById/")
                .path(salida.getId().toString())
                .toUriString();
        salida.setDownloadURL(download);

        return ResponseEntity.ok().body(salida);
    }
}
