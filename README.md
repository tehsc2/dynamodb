# dynamodb
POC dynamodb aws

# Requisitos básicos

- Baixe o aws cli
- Baixe o docker
- Baixe a imagem do dynamo no dockerhub

# Comandos Utilizados

Para configurar o accessKey e secretKey e região no aws cli
```
aws configure
```
Após baixar a imagem do dynamo no docker, rode localmente:
```
docker run -p 8000:8000 -v $(pwd)/local/dynamodb:/data/ amazon/dynamodb-local -jar DynamoDBLocal.jar -sharedDb
```
Para verificar as tabelas que estão rodando localmente:
```
aws dynamodb list-tables --endpoint-url http://localhost:8000
```
Para criar uma tabela:
```
aws dynamodb --endpoint-url http://localhost:8000 create-table --table-name ProductInfo --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
```
Para ver como sua tabela foi criada:
```
aws dynamodb describe-table --table-name ProductInfo
```
Para adicionar um item na sua tabela:
```
aws dynamodb put-item --endpoint-url http://localhost:8000 --table-name ProductInfo --item '{"id": {"S": "1"}, "cost": {"S": "200.0"}, "msrp": {"S": "123"}}'
```
Para recuperar um item da sua tabela:
```
aws dynamodb get-item --endpoint-url http://localhost:8000 --table-name ProductInfo --key '{"id": {"S": "1"}}'
```
