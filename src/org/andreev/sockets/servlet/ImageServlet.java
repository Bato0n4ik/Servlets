package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.andreev.sockets.service.ImageService;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/imagesForFirstServlet/*")
public class ImageServlet extends HttpServlet {

    private final ImageService imageService = ImageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var requestURI = req.getRequestURI();
        var imagePath = requestURI.replace("/imagesForFirstServlet", "");
        imageService.get(imagePath)
                .ifPresentOrElse(image -> {
            resp.setContentType("application/octet-stream");
            writeImage(image, resp);
            }, ()->resp.setStatus(404));
    }

    private void writeImage(InputStream image, HttpServletResponse resp) {
        try(image; var respOutputStream = resp.getOutputStream()){
            int value;
            while((value = image.read())!=-1){
                respOutputStream.write(value);
            }
        }
        catch(IOException exc){
            throw new RuntimeException(exc);
        }
    }
}
