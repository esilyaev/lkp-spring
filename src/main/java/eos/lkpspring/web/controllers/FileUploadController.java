package eos.lkpspring.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import eos.lkpspring.domain.services.IFileStorageService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("file")
@AllArgsConstructor
public class FileUploadController {
  private IFileStorageService fileStorageService;

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  String uploadFile(@RequestPart("file") MultipartFile file) {
    return fileStorageService.storeFile(file);
  }
}
