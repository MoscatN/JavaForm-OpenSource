/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.web;

import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; 
 
import org.springframework.core.convert.converter.Converter;
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("games-photos", registry);
    }
     
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
         
        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
         
        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry)
    {
        registry.addConverter((Converter<?, ?>) new MultipartConverter()); 
    }
}
