package eos.lkpspring.domain.services.impl;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import eos.lkpspring.domain.services.IFileStorageService;

@Service
public class FIleStorageServiceImpl implements IFileStorageService {

  private Path fileStorageLocation;

  public FIleStorageServiceImpl() {
    this.fileStorageLocation = Paths.get("uploads/").toAbsolutePath().normalize();
    try {
      Files.createDirectories(fileStorageLocation);
    } catch (Exception e) {
      throw new RuntimeException("Failed to create directory");
    }
  }

  @Override
  public String storeFile(MultipartFile file) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
      if (fileName.contains("..")) {
        throw new RuntimeException("Bad name for file");
      }

      Path targetLocation = fileStorageLocation.resolve(fileName);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

      return fileName;

    } catch (Exception e) {
      throw new RuntimeException("Failed to store file");
    }
  }

  @Override
  public Resource loadFileAResource(String fileName) {
    try {
      Path filePath = fileStorageLocation.resolve(fileName).normalize();
      Resource resource = new UrlResource(filePath.toUri());
      if (resource.exists()) {
        return resource;
      } else {
        throw new RuntimeException("File not found");
      }
    } catch (MalformedURLException ex) {
      throw new RuntimeException("File not found");
    }
  }

}
