package bosonit.fileData.controllers;

import bosonit.storageService.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/setpath")
public class ChangePath {
    @Autowired
    StorageService storageService;

    @GetMapping
    public String setPath(@RequestParam String path){
        storageService.setRootLocation(path);
        storageService.init();
        return path;
    }
}
