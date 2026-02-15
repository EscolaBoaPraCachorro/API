# =============================
# Etapa 1: Build com Maven + JDK 21
# =============================
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Diretório de trabalho
WORKDIR /app

# Copia APENAS o pom.xml primeiro (melhora cache do Docker)
COPY pom.xml .

# Baixa dependências primeiro (cache eficiente)
RUN mvn dependency:go-offline -DskipTests

# Copia o código fonte
COPY src ./src

# Build do projeto com retry em caso de falha de download
RUN mvn clean package -DskipTests \
    -Dmaven.wagon.http.retryHandler.count=3 \
    -Dmaven.wagon.httpconnectionManager.ttlSeconds=25

# Stage 2: Imagem final
FROM openjdk:17-jdk-alpine
WORKDIR /API
COPY --from=build /app/target/API-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
CMD ["java", "-jar", "API-0.0.1-SNAPSHOT.jar"]