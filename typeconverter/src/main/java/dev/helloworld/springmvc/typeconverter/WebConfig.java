package dev.helloworld.springmvc.typeconverter;

import dev.helloworld.springmvc.typeconverter.converter.IntegerToStringConverter;
import dev.helloworld.springmvc.typeconverter.converter.IpPortToStringConverter;
import dev.helloworld.springmvc.typeconverter.converter.StringToIntegerConverter;
import dev.helloworld.springmvc.typeconverter.converter.StringToIpPortConverter;
import dev.helloworld.springmvc.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        registry.addFormatter(new MyNumberFormatter());
    }
}
