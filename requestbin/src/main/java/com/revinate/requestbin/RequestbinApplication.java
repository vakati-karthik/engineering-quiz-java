package com.revinate.requestbin;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static org.apache.commons.lang3.CharEncoding.UTF_8;

@SpringBootApplication
public class RequestbinApplication {

    public static final ObjectMapper MAPPER = new ObjectMapper()
        .setSerializationInclusion(NON_NULL)
        .registerModule(new JSR310Module())
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public static void main(String[] args) {
		SpringApplication.run(RequestbinApplication.class, args);
	}

    @Bean
    @Primary
    public ObjectMapper mapper() {
        return MAPPER;
    }

    @Bean
    @Primary
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        converters.replaceAll(converter -> {
            if (converter instanceof StringHttpMessageConverter) {
                return new StringHttpMessageConverter(Charset.forName(UTF_8));
            } else {
                return converter;
            }
        });
        converters.add(new MappingJackson2HttpMessageConverter(MAPPER));

        return restTemplate;
    }

}
