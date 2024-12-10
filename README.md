
# 📘 **Instrucciones para Ejecutar la Aplicación Localmente**

Este proyecto sigue la **arquitectura hexagonal (Ports & Adapters)** con **Spring Boot**, **Java 17+**, y se adhiere a principios de **DDD (Domain-Driven Design)**. Esta guía te mostrará cómo ejecutar la aplicación localmente.

---

## ⚙️ **Requisitos Previos**
Antes de ejecutar la aplicación, asegúrate de tener los siguientes requisitos instalados:

1. **Java 17+**: [Descargar e instalar Java](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
2. **Maven 3.8+**: [Descargar e instalar Maven](https://maven.apache.org/download.cgi)
3. **PostgreSQL / MySQL**: Base de datos relacional (opcional si se usa H2 en modo local).
4. **Docker**: Necesario si deseas ejecutar la base de datos en contenedor.
5. **Git**: [Instalar Git](https://git-scm.com/downloads)

---

## 📂 **Estructura de la Carpeta Principal**
```
com.example.miapp
 ├── application
 │    ├── usecase
 │    ├── dto
 │    └── exception
 │
 ├── domain
 │    ├── model
 │    ├── port
 │    │    ├── inbound
 │    │    └── outbound
 │    └── exception
 │
 └── infrastructure
      ├── inadapter
      │    ├── controller
      │    └── eventlistener
      │
      ├── outadapter
      │    ├── persistence
      │    │    ├── adapter
      │    │    ├── repository
      │    │    ├── entity
      │    │    └── mapper
      │
      ├── configuration
      │    └── ApplicationProperties.java
      │
      ├── security
      │    └── SecurityConfig.java
      │
      └── shared
          └── exception
```

**Explicación de la estructura:**
- **application**: Contiene los casos de uso.
- **domain**: Contiene la lógica de negocio y los puertos.
- **infrastructure**: Contiene los adaptadores de entrada y salida.

---

## 🔧 **Configuración del Entorno Local**

1. **Clonar el Repositorio**
   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio
   ```

2. **Configurar Variables de Entorno (.env)**
   Crea un archivo `.env` en la raíz del proyecto con la siguiente configuración:

   ```env
   DB_HOST=localhost
   DB_PORT=5432
   DB_NAME=miappdb
   DB_USER=miappuser
   DB_PASSWORD=miapppassword

   SERVER_PORT=8080
   JWT_SECRET=supersecreto
   ```

3. **Configurar `application.properties`**
   Edita el archivo `src/main/resources/application.properties` con la siguiente configuración:

   ```properties
   spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
   spring.datasource.username=${DB_USER}
   spring.datasource.password=${DB_PASSWORD}
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   server.port=${SERVER_PORT}
   jwt.secret=${JWT_SECRET}
   ```

---

## 🚀 **Iniciar la Aplicación**

### 🔥 **Opción 1: Ejecutar con Maven**
```bash
mvn clean install
mvn spring-boot:run
```

### 🔥 **Opción 2: Usar el JAR generado**
1. Compilar la aplicación:
   ```bash
   mvn clean package
   ```

2. Ejecutar el JAR:
   ```bash
   java -jar target/miapp-0.0.1-SNAPSHOT.jar
   ```

### 🔥 **Opción 3: Usar Docker (opcional)**
Si prefieres usar **Docker**, crea un archivo `Dockerfile` con el siguiente contenido:

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/miapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Construir y ejecutar la imagen Docker:
```bash
docker build -t miapp:latest .
docker run -p 8080:8080 --name miapp miapp:latest
```

---

## 📡 **Acceso a la Aplicación**

1. **Acceso a la API REST**:
   - **URL Base**: [http://localhost:8080](http://localhost:8080)

2. **Acceso a la Documentación Swagger**:
   - **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🛠️ **Comandos Útiles**

| **Comando**         | **Acción**                      |
|------------------- |-----------------------------------|
| `mvn clean install` | Compila y verifica el proyecto.  |
| `mvn spring-boot:run` | Ejecuta la aplicación.        |
| `java -jar target/miapp-0.0.1-SNAPSHOT.jar` | Ejecuta el JAR generado. |
| `docker build -t miapp .` | Crea la imagen Docker.    |
| `docker run -p 8080:8080 miapp` | Ejecuta la imagen Docker. |

---

## 🚦 **Pruebas Unitarias y de Integración**

Para ejecutar las pruebas de la aplicación, usa el siguiente comando:
```bash
mvn test
```

Los reportes de pruebas se encuentran en la carpeta `target/surefire-reports/`.

---

## 🛠️ **Solución de Problemas**

| **Error**                      | **Posible Causa**           | **Solución**                 |
|---------------------------------|----------------------------|------------------------------|
| `Connection refused`             | La base de datos no está corriendo. | Asegúrate de que PostgreSQL esté activo. |
| `Port 8080 already in use`      | El puerto 8080 está en uso. | Cambia el puerto en el `.env`. |
| `Access Denied`                  | Error de autenticación.      | Verifica las credenciales en el `.env`. |

---

## 📦 **Tecnologías Utilizadas**
- **Java 17**: Lenguaje de programación.
- **Spring Boot**: Framework para la creación de aplicaciones.
- **Spring Data JPA**: Para la persistencia en base de datos.
- **Spring Security**: Para la autenticación y autorización.
- **PostgreSQL**: Base de datos relacional (puede ser MySQL).
- **Swagger**: Para la documentación de la API.
- **Docker**: Para contenedores.

---

## 📄 **Licencia**
Este proyecto está bajo la **Licencia MIT**. Puedes consultar más detalles en el archivo `LICENSE`.

---

## 📞 **Soporte**
Si necesitas ayuda o tienes alguna pregunta, por favor abre un **issue** en el repositorio o contacta con el equipo de desarrollo.

**¡Gracias por usar esta aplicación!** 🚀
