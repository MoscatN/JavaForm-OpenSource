/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

public class MultipartConverter implements Converter<MultipartFile, String>{
    @Override
    public String convert(MultipartFile source)
    {
        try{
            return new String(source.getBytes(), StandardCharsets.UTF_8);
        }catch (IOException e){
            throw new RuntimeException("Fail to convert multipart file to string");
        }
    }
}
