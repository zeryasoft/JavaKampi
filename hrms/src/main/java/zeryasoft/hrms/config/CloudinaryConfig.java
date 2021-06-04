package zeryasoft.hrms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import zeryasoft.hrms.core.utilities.CloudinaryManager;
import zeryasoft.hrms.core.utilities.CloudinaryService;

@Configuration
public class CloudinaryConfig {
	@Value("${cld.access-key}")
	String apiKey;
	
	@Value("${cld.secret-key}")
	String apiSecretKey;
	
	
	@Bean
    public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dc6ur0zsn",
                "api_key", apiKey,
                "api_secret", apiSecretKey));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }
}
