src/main/java/com/img/app
├── application
│   ├── usecase
│   │   └── Todo
    │   │   ├── TodoCreateUseCase.java        // Lógica del caso de uso
    │   │   └── TodoServiceUseCase.java       // Lógica del caso de uso
│   └── service
│       └── TodoService.java             // Lógica de negocio
├── domain
│   ├── model
│   │   └── Todo.java                    // Modelo de dominio
│   └── repository
│       └── TodoRepositoryPort.java      // Puerto que define las operaciones
├── infrastructure
│   ├── adapter
│   │   ├── in/web
│   │   │   └── TodoController.java      // Controlador REST
│   │   └── out/persistence
│   │   │   ├── TodoRepositoryAdapter.java // Adaptador que conecta con la BD
│   │   │
│   │   └── api
│   │   │   └── truora       // Nombre de proveedor de WS externo(s)
│   │   │       └── definitions      // Definiciones de WS externo
│   │   │           └── CallTruoraUserApi.java
│   │   │       └── dto              // DTO de WS externo
│   │   │           └── CallTruoraUserApiResponse.java
│   │   │           └── CallTruoraUserApiiRequest.java
│   │   │       └── service
│   │   │           └── CallTruoraUserApiService.java       // Lógica de servicio.
│   ├── config
│   │   ├── JpaConfig.java               // Configuración JPA
│   │   └── LoggingConfig.java           // Configuración de logging
│   └── persistence
│   │   └── entity                       // Capa donde se encuentra la entidad
│   │       └── TodoEntity.java          // Entidad JPA
│       └── repository
│           └── TodoRepositoryJpa.java  // Implementación JPA
└── TuAppApplication.java                // Clase principal que arranca la aplicación
