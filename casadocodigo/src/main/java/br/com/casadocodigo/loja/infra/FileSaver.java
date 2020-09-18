package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

    public String write(String baseFolder, MultipartFile file) {

        try {
            
            String realPath = "";
            String path = realPath + "/" + file.getOriginalFilename();
            String filePath = baseFolder + "/" + file.getOriginalFilename();

            File abc = new File(path);
            file.transferTo(Path.of(abc.toURI()));


            return filePath;
        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
        
    }

}
