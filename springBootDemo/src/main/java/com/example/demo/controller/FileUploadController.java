package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	private static String FILE_UPLOAD_SRC = "C:\\Temp\\fileuploadtest\\";
	
  @RequestMapping(method = RequestMethod.GET)
  public String handleGet () {
      return "file-upload";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String handlePost(@RequestParam("user-file") MultipartFile multipartFile, Model model) throws IOException {
      String name = multipartFile.getOriginalFilename();
      BufferedWriter w = Files.newBufferedWriter(Paths.get(FILE_UPLOAD_SRC + name));
      w.write(new String(multipartFile.getBytes()));
      w.flush();

      model.addAttribute("msg", "File has been uploaded:  "+name);
      return "response";
  }
}