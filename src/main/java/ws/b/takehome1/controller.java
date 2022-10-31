/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author LENOVO
 */
@Controller
public class controller {
    @RequestMapping("/biodata")
    //@ResponseBody
    public String getBiodata(@RequestParam(value="inputnama") String getName,
                           @RequestParam(value="inputtgl") String getDate,
                           @RequestParam(value="inputfoto") MultipartFile getFoto,
                           Model model)
    throws IOException{
        
        byte[] img = getFoto.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String link = "data:image/png;base64,".concat(base64Image);
        model.addAttribute("kirimanNama", getName);
        model.addAttribute("kirimanTgl", getDate);
        model.addAttribute("kirimanFoto", link);
        return "main";
    }
    
}

