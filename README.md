# springboot-secretsmanager-localstack
Spring boot application integrated with secretsmanager and localstack

1. First one we need run docker-compose to create local secretsmanager.
   1. docker-compose up -d

2. Run application.
   1. maven install
   2. java -jar springboot-secretsmanager-localstack

3. Go to /postman and import collection to tests.