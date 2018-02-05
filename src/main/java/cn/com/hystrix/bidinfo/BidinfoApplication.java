package cn.com.hystrix.bidinfo;

import cn.com.hystrix.bidinfo.elasticsearch.ElasticsearchListener;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.thymeleaf.spring4.view.ThymeleafView;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BidinfoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BidinfoApplication.class, args);
	}

	@Bean(name="page-content")
	@Scope("prototype")
	public ThymeleafView someViewBean() {
		ThymeleafView view = new ThymeleafView("index"); // templateName = 'index'
		view.setMarkupSelector("page-content");
		return view;
	}

	@Bean
	public RestHighLevelClient elasticsearchClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.1.169", 9200, "http")));
        return client;
    }

	public UserDetailsService userDetailsService () {
		return null;
	}
}
