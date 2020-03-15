package br.com.dynamodblocal.dynamodblocal.repositories;

import br.com.dynamodblocal.dynamodblocal.entity.ProductInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ProductInfoRepository extends
        CrudRepository<ProductInfo, String> {
}