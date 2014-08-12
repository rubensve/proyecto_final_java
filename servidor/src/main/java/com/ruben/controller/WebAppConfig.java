
package com.ruben.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author rubens
 */

@EnableWebMvc
@Configuration
@ComponentScan("com.ruben.controller")
public class WebAppConfig extends WebMvcConfigurerAdapter{
    
}
