package eos.lkpspring.domain.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFileStorageService {
  public String storeFile(MultipartFile file);

  public Resource loadFileAResource(String fileName);
}
