package com.jianglibo.nutchbuilder;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jianglibo.nutchbuilder.config.ApplicationConfig;

/**
 * @author jianglibo@gmail.com
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "appmisc.in-testing=true"})
public abstract class Tbase extends M3958TsBase {

    protected MockMvc mvc;
    
	@Autowired
	protected TestRestTemplate restTemplate;
    
    @Autowired
    protected TestUtil testUtil;
    
    @Autowired
    protected ApplicationConfig applicationConfig;
    
    @Autowired
    protected ApplicationContext context;


    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    protected ObjectMapper objectMapper;

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    
//	@TestConfiguration
//	static class Config {
//		// does't work
//		@Bean
//		public TestRestTemplate testTemplate() {
//			return new TestRestTemplate();
//		}
//	}
//
    @Before
    public void before() {
//        mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }

    public Pageable createApageable(int page, int size) {
        return new PageRequest(page, size);
    }

    public Pageable createApageable(int size) {
        return createApageable(0, size);
    }

    public Pageable createApageable() {
        return createApageable(10);
    }
    
 

    public String getRestUri(String uri) {
        if (!uri.startsWith("/")) {
            uri = "/" + uri;
        }
        return getApiPrefix() + uri;
    }

    public String getApiPrefix() {
        return "/api/v1";
    }
}
