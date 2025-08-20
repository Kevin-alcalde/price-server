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
- [Testing](#-testing)
- [Docker](#-docker)
- [Documentación API](#-documentación-api)
- [Base de Datos](#️-base-de-datos)
- [Arquitectura](#️-arquitectura)

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
git clone <tu-repositorio-url>
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
```bash
# Health check
curl http://localhost:8080/actuator/health

# Swagger UI
http://localhost:8080/swagger-ui/index.html
```

## 📡 API Endpoints

### 🏷️ Consultar Precio de Producto

**GET** `/product/prices`

Consulta el precio aplicable para un producto en una fecha específica.

#### Parámetros de Query:
| Parámetro   | Tipo     | Requerido | Descripción                           | Ejemplo              |
|-------------|----------|-----------|---------------------------------------|----------------------|
| `date`      | String   | ✅        | Fecha de aplicación (ISO format)     | `2020-06-14T10:00:00` |
| `productId` | Integer  | ✅        | Identificador de producto             | `35455`              |
| `brandId`   | Long     | ✅        | Identificador de marca                | `1`                  |

#### Ejemplo de Request:
```bash
curl -X GET "http://localhost:8080/product/prices?date=2020-06-14T10:00:00&productId=35455&brandId=1"
```

#### Ejemplo de Response:
```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 1,
  "startDate": "2020-06-14T00:00:00",
  "endDate": "2020-12-31T23:59:59",
  "price": 35.50,
  "currency": "EUR"
}
```

### 📊 Actuator Endpoints

| Endpoint                    | Descripción           |
|-----------------------------|-----------------------|
| `/actuator/health`          | Estado de salud       |
| `/actuator/info`            | Información del app   |
| `/actuator/metrics`         | Métricas de la app    |

## 🧪 Casos de Uso

La aplicación incluye los siguientes casos de uso de prueba:

### Test Case 1: 10:00 del día 14 del producto 35455 para la marca 1 (ZARA)
```bash
curl -X GET "http://localhost:8080/product/prices?date=2020-06-14T10:00:00&productId=35455&brandId=1"
```
**Resultado esperado**: `35.50 EUR`

### Test Case 2: 16:00 del día 14 del producto 35455 para la marca 1 (ZARA)
```bash
curl -X GET "http://localhost:8080/product/prices?date=2020-06-14T16:00:00&productId=35455&brandId=1"
```
**Resultado esperado**: `25.45 EUR`

### Test Case 3: 21:00 del día 14 del producto 35455 para la marca 1 (ZARA)
```bash
curl -X GET "http://localhost:8080/product/prices?date=2020-06-14T21:00:00&productId=35455&brandId=1"
```
**Resultado esperado**: `35.50 EUR`

### Test Case 4: 10:00 del día 15 del producto 35455 para la marca 1 (ZARA)
```bash
curl -X GET "http://localhost:8080/product/prices?date=2020-06-15T10:00:00&productId=35455&brandId=1"
```
**Resultado esperado**: `30.50 EUR`

### Test Case 5: 21:00 del día 16 del producto 35455 para la marca 1 (ZARA)
```bash
curl -X GET "http://localhost:8080/product/prices?date=2020-06-16T21:00:00&productId=35455&brandId=1"
```
**Resultado esperado**: `38.95 EUR`

### Test Case 6: Producto no encontrado
```bash
curl -X GET "http://localhost:8080/product/prices?date=2020-06-14T10:00:00&productId=99999&brandId=1"
```
**Resultado esperado**: `404 Not Found`

### Test Case 7: Fecha inválida
```bash
curl -X GET "http://localhost:8080/product/prices?date=invalid-date&productId=35455&brandId=1"
```
**Resultado esperado**: `400 Bad Request`

## 🧪 Testing

### Ejecutar Tests
```bash
# Todos los tests
mvn test

# Tests específicos
mvn test -Dtest=PriceFinderTest
mvn test -Dtest=DateRequestedTest

# Tests con coverage
mvn test jacoco:report
```

### Tipos de Tests
- **Unit Tests**: Pruebas de clases individuales
- **Integration Tests**: Pruebas del controlador completo
- **Value Objects Tests**: Pruebas de objetos de valor

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

## 🗄️ Base de Datos

La aplicación utiliza H2 Database en memoria con datos precargados.

### Acceso a H2 Console
- **URL**: http://localhost:8080/h2-console
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: *(vacío)*

### Estructura de Datos

#### Tabla PRICES
```sql
CREATE TABLE PRICES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    BRAND_ID BIGINT NOT NULL,
    START_DATE TIMESTAMP NOT NULL,
    END_DATE TIMESTAMP NOT NULL,
    PRICE_LIST INTEGER NOT NULL,
    PRODUCT_ID INTEGER NOT NULL,
    PRIORITY INTEGER NOT NULL,
    PRICE DECIMAL(10,2) NOT NULL,
    CURR VARCHAR(3) NOT NULL
);
```

## 🏛️ Arquitectura

El proyecto sigue principios de **Arquitectura Hexagonal** y **Domain-Driven Design**:

```
src/main/java/com/gft/inditext/pricing_server/
├── application/          # Casos de uso y servicios de aplicación
├── domain/              # Lógica de negocio
│   ├── entity/          # Entidades del dominio
│   ├── repository/      # Interfaces de repositorio
│   ├── service/         # Servicios del dominio
│   ├── valueobject/     # Objetos de valor
│   └── exception/       # Excepciones del dominio
└── infrastructure/      # Adaptadores e infraestructura
    ├── controller/      # Controladores REST
    ├── repository/      # Implementaciones JPA
    ├── config/          # Configuración
    └── exception/       # Manejo de excepciones global
```

## 🔧 Configuración

### Profiles Disponibles
- **default**: Configuración local con H2
- **docker**: Configuración para contenedores
- **test**: Configuración para testing

### Variables de Entorno
```bash
SPRING_PROFILES_ACTIVE=default
SERVER_PORT=8080
SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb
SPRING_H2_CONSOLE_ENABLED=true
LOGGING_LEVEL_ROOT=INFO
```

## 🤝 Contribución

1. Fork el proyecto
2. Crea una feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la branch (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para detalles.

## 📞 Contacto

**Desarrollador**: Kevin  
**Email**: tu-email@ejemplo.com  
**Proyecto**: [Pricing Server](https://github.com/tu-usuario/pricing-server)

---

⭐ **¡No olvides darle una estrella al proyecto si te ha sido útil!** ⭐