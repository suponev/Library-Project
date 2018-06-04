package ru.library.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.library.dao.FileDao;
import ru.library.entity.ImageEntity;

import java.io.IOException;
import java.util.Base64;

@Service
public class FileUploadService {

    private final FileDao fileDao;

    public FileUploadService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Transactional
    public Long savePublishImage(MultipartFile file) throws IOException {
        ImageEntity entity = new ImageEntity();
        entity.setBase64(Base64.getEncoder().encodeToString(file.getBytes()));
        return fileDao.saveImage(entity);
    }

    @Transactional
    public String getPublishImage(Long id) {
        return fileDao.getImage(id).get().getBase64();
    }

}
