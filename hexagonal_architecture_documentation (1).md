
# 📘 **Documentación Completa de la Estructura de Carpetas para Arquitectura Hexagonal (Ports & Adapters) en Java Spring Boot**

Esta documentación define la **estructura de carpetas** ideal para una aplicación **Java Spring Boot** basada en la **arquitectura hexagonal (Ports & Adapters)**. Se aplica **DDD (Domain-Driven Design)** y los principios de **SOLID**, con una clara separación entre las capas de **entrada, núcleo y salida**.

El objetivo principal es mantener la lógica de negocio independiente de la infraestructura, facilitando la **escalabilidad**, **mantenibilidad** y **testabilidad** de la aplicación.

---

## 🏗️ **Estructura General de la Aplicación**
```
src
 └── main
     └── java
         └── com.example.miapp
             ├── application
             │    ├── bussiness
             │    │     ├──  impl
             │    │     │     ├── ProductImpl.java
             │    │     └── interface
             │    │           ├── ProductBussiness.java
             │    ├── usecase
             │    │     ├── CreateProductUseCaseImpl.java
             │    ├── dto
             │    │     ├── CreateProductDto.java
             │    └── exception
             │          ├── ProductNotFoundException.java
             │
             ├── domain
             │    ├── model
             │    │     ├── Product.java
             │    ├── port
             │    │     ├── inbound
             │    │     │     ├── CreateProductUseCase.java
             │    │     └── outbound
             │    │           ├── ProductRepositoryPort.java
             │    └── exception
             │          ├── ProductNotFoundException.java
             │
             └── infrastructure
                  ├── inadapter
                  │    ├── controller // API REST
                  │    │       ├── ProductController.java
                  │    ├── websocket // Maneja la comunicación en tiempo real
                  │    │       ├── ProductWebSocketHandler.java
                  │    └── scheduled // Tareas programadas
                  │          ├── ProductScheduledTask.java
                  │
                  ├── outadapter
                  │    ├── persistence
                  │    │    ├── adapter
                  │    │    │     ├── ProductJpaAdapter.java
                  │    │    ├── repository
                  │    │    │     ├── ProductJpaRepository.java
                  │    │    ├── entity
                  │    │    │     ├── ProductEntity.java
                  │    │    └── mapper
                  │    │          ├── ProductMapper.java
                  │    │
                  │    ├── api
                  │    │    ├── providerA  // Nombre de proveedor de WS externo(s)
                  │    │         ├── adapter
                  │    │         │     ├── ProductClientAdapter.java // pasar a DTO de la aplicación o modelo de dominio
                  │    │         ├── config
                  │    │         │     ├── RetrofitConfig.java // Configuración de la librería Retrofit para la llamada a la API
                  │    │         ├── definition
                  │    │         │     ├── ServiceCallProductApiSoap.java // Definición del llamado a la API de entrada y salida.
                  │    │         ├── call
                  │    │         │     ├── CallProductServicesHttp.java // Ejecución de la api.
                  ├── configuration
                  │    └── SwaggerConfig.java
                  │
                  │
                  └── shared
                      └── exception
```

---

## 📂 **1. application**
> **Propósito**: Orquestar la lógica de negocio sin lógica técnica.

**Subcarpetas:**
- **usecase**: Contiene los casos de uso que orquestan la lógica de negocio.
- **dto**: Objetos de transferencia de datos que se utilizan para enviar y recibir información.
- **exception**: Excepciones de la **lógica de aplicación**, como validaciones de entrada o errores de acceso.

**Ejemplos de Excepciones:**
- **InvalidInputException**
- **UnauthorizedAccessException**

**Ejemplo de Estructura:**
```
application
 ├── usecase
      ├── CreateProductUseCase.java
 ├── dto
      ├── CreateProductDto.java
 └── exception
      ├── ProductNotFoundException.java
```
---

## 📂 **2. domain**
> **Propósito**: Contiene la **lógica de negocio pura** e independiente de la infraestructura.

**Subcarpetas:**
- **model**: Entidades y objetos de valor que representan el núcleo de la lógica de negocio.
- **port**: 
  - **inbound**: Define los **puertos de entrada**.
  - **outbound**: Define los **puertos de salida**.
- **exception**: Excepciones relacionadas con la **lógica de negocio**.

**Ejemplos de Excepciones:**
- **OrderNotFoundException**
- **InsufficientBalanceException**

**Ejemplo de Estructura:**
```
domain
 ├── model
      ├── Product.java
 ├── port
 │    ├── inbound
            ├── CreateProductUseCase.java
 │    └── outbound
            ├── ProductRepositoryPort.java
 └── exception
      ├── ProductNotFoundException.java
```

---

## 📂 **3. infrastructure**
> **Propósito**: Contiene los adaptadores de entrada y salida, configuración, seguridad y elementos compartidos.

---

### 📂 **3.1 inadapter**
> **Responsabilidad**: Puntos de entrada al sistema (API REST, eventos, CLI, gRPC, etc.).

**Subcarpetas:**
- **controller**: API REST.
- **websocket**: Maneja la comunicación **en tiempo real**.
- **scheduled**: Define tareas **cron programadas**.

**Ejemplo de Estructura:**
```
inadapter
 ├── controller
      ├── ProductController.java
 ├── websocket
      ├── ProductWebSocketHandler.java
 └── scheduled
      ├── ProductScheduledTask.java
```

---

## 🚀 **Conclusión**
- La **arquitectura hexagonal** permite la **separación de la lógica de negocio y la infraestructura**.
- Se definen excepciones personalizadas en **application, domain, infrastructure y shared**.
- La estructura permite la **escalabilidad, reutilización y facilidad de prueba**.
