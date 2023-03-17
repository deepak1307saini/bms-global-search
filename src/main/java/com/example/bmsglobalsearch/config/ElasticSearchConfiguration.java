package com.example.bmsglobalsearch.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.nodes.Client;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("com.example.bmsglobalsearch.repository")
public class ElasticSearchConfiguration {
    @Bean
    public ElasticsearchClient elasticsearchClient() {

        RestClient httpClient = RestClient.builder(new HttpHost("localhost", 9200)).build();

        ElasticsearchTransport transport = new RestClientTransport(httpClient, new JacksonJsonpMapper());

        ElasticsearchClient esClient = new ElasticsearchClient(transport);

        return esClient;
    }
//    @Bean
//    public Client client() throws Exception {
//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)  .
//        addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("elasticsearch.host"), 9200));     
//        return client;
//    }
//    @Bean
//
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());  }
//}

}
