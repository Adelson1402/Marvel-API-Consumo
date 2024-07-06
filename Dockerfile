# Etapa de construção
FROM  maven:3.8.2-jdk-11 AS build AS build

# Atualizar e instalar o JDK e Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Copiar todo o código para o contêiner
COPY . /app
WORKDIR /app

# Construir a aplicação
RUN mvn clean install

# Etapa de execução
FROM openjdk:11-jdk-slim

# Expor a porta 8080
#EXPOSE 8080

# Copiar o arquivo jar gerado da etapa de construção
COPY --from=build /app/target/consumoApiMarvel-0.0.1-SNAPSHOT.jar /app/app.jar

# Definir o ponto de entrada para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
