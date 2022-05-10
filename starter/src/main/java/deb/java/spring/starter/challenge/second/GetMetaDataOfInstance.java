package deb.java.spring.starter.challenge.second;

import org.springframework.web.client.RestTemplate;

public class GetMetaDataOfInstance {

    public static void getMetaDataOfAwsInstanceByRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //don't have any valid data - so can't test
        String metaDataJsonAsString = restTemplate.getForObject("http://169.254.169.254/latest/meta-data/", String.class);
        System.out.println(metaDataJsonAsString);
    }

    public static void main(String args[]) {
        getMetaDataOfAwsInstanceByRestTemplate();
    }
}
