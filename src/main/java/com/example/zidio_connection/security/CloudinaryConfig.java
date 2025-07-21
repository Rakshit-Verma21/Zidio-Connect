package com.example.zidio_connection.security;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig
{
    @Bean
    public Cloudinary cloudnary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name","your_cloud_name",
                "api_key","your_api_key","api_secret",
                "our_api_secret","secure",true));
    }


}
