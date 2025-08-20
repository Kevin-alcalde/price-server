# 🏷️ GFT Inditex - Pricing Server

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-green)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)
![H2](https://img.shields.io/badge/Database-H2-yellow)

Servicio REST para consultar precios de productos de Inditex basado en fecha, producto y marca.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías](#️-tecnologías)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación y Ejecución](#-instalación-y-ejecución)
- [API Endpoints](#-api-endpoints)
- [Casos de Uso](#-casos-de-uso)
- [Docker](#-docker)

## ✨ Características

- ✅ API REST para consultar precios por fecha, producto y marca
- ✅ Validación de parámetros de entrada
- ✅ Manejo de excepciones personalizado
- ✅ Base de datos H2 en memoria con datos de prueba
- ✅ Documentación automática con Swagger/OpenAPI
- ✅ Arquitectura hexagonal (Domain-Driven Design)
- ✅ Tests unitarios e integración
- ✅ Containerización con Docker
- ✅ Health checks y actuator endpoints

## 🛠️ Tecnologías

- **Java 17** - Lenguaje de programación
- **Spring Boot 3.4.0** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **H2 Database** - Base de datos en memoria
- **Maven** - Gestión de dependencias
- **JUnit 5** - Testing
- **Mockito** - Mocking para tests
- **Swagger/OpenAPI** - Documentación de API
- **Docker** - Containerización
- **Lombok** - Reducción de boilerplate

## 📦 Requisitos Previos

- **Java 17** o superior
- **Maven 3.8+** 
- **Docker** (opcional, para containerización)
- **Git** (para clonar el repositorio)

## 🚀 Instalación y Ejecución

### 📥 Clonar el Repositorio
```bash
git clone https://github.com/Kevin-alcalde/price-server.git
cd pricing-server
```

### 🔧 Ejecutar Localmente

#### Opción 1: Con Maven
```bash
# Compilar y ejecutar tests
mvn clean test

# Ejecutar la aplicación
mvn spring-boot:run
```

#### Opción 2: Con JAR
```bash
# Construir el JAR
mvn clean package

# Ejecutar el JAR
java -jar target/pricing-server-0.0.1-SNAPSHOT.jar
```

### 🐳 Ejecutar con Docker

#### Opción 1: Docker simple
```bash
# Construir la imagen
docker build -t inditex-pricing-server .

# Ejecutar el contenedor
docker run -p 8080:8080 inditex-pricing-server
```

#### Opción 2: Docker Compose
```bash
# Levantar todos los servicios
docker-compose up --build

# En modo detached (background)
docker-compose up -d --build
```

### ✅ Verificar que funciona

# Swagger UI
http://localhost:8080/swagger-ui/index.html
```

## 📡 API Endpoints

### 🏷️ Consultar Precio de Producto

**POST** `/product/prices`

Consulta el precio aplicable para un producto en una fecha específica.

#### Parámetros de Query:
| Parámetro   | Tipo     | Requerido | Descripción                           | Ejemplo              |
|-------------|----------|-----------|---------------------------------------|----------------------|
| `date`      | String   | ✅        | Fecha de aplicación (ISO format)     | `2020-06-14T10:00:00` |
| `productId` | Integer  | ✅        | Identificador de producto             | `35455`              |
| `brandId`   | Long     | ✅        | Identificador de marca                | `1`                  |

## 🐳 Docker

### Construcción y Ejecución
```bash
# Build
docker build -t inditex-pricing-server .

# Run
docker run -p 8080:8080 inditex-pricing-server

# Con variables de entorno
docker run -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=docker \
  -e SERVER_PORT=8080 \
  inditex-pricing-server
```

### Docker Compose
```bash
# Levantar servicios
docker-compose up -d

# Ver logs
docker-compose logs -f

# Parar servicios
docker-compose down
```

## 📚 Documentación API

Una vez que la aplicación esté ejecutándose, puedes acceder a:

- **Swagger UI**: http://localhost:8080/swagger-ui/index.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs



