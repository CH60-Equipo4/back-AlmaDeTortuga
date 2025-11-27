# 🐢 back-AlmaDeTortuga | Backend E-commerce de Totebags

## Descripción del Proyecto

Este repositorio aloja el **Backend** de la plataforma de comercio electrónico **Alma de Tortuga**, especializada en la venta de *totebags*. El proyecto implementa una API RESTful robusta y escalable utilizando el ecosistema **Spring Boot** para manejar toda la lógica de negocio, persistencia de datos y seguridad.

---

## 🛠️ Tecnologías y Herramientas

La aplicación está construida sobre las siguientes tecnologías principales:

| Herramienta | Versión | Tipo |
| :--- |:--------| :--- |
| **Java** | **17**  | Lenguaje de Programación (LTS) |
| **Spring Boot** | 3.5.7        | Framework principal |
| **Spring Data JPA** |         | Persistencia de datos |
| **MySQL** | 8.x     | Base de Datos Relacional |
| **Gradle** |         | Herramienta de Construcción |
| **Hibernate** |         | ORM (Mapeo Objeto-Relacional) |

---

## ✨ Características de la API

El Backend expone endpoints para gestionar los elementos clave de un e-commerce:

* **Gestión de Catálogo:** CRUD completo para la administración de *totebags* (nombre, precio, stock, descripción, etc.).
* **Gestión de Usuarios:** Registro, inicio de sesión y gestión de perfiles de clientes y administradores.
* **Gestión de Pedidos:** Creación de carritos de compra y seguimiento del ciclo de vida de los pedidos.
* **Seguridad:** Implementación de autenticación y autorización mediante tokens para proteger rutas sensibles.

---

## 🚀 Puesta en Marcha Local

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno de desarrollo.

### 📋 Prerrequisitos

* **Java Development Kit (JDK) 17** o superior.
* **MySQL Server** instalado y corriendo localmente (o acceso a una instancia remota).
* **Git** para clonar el repositorio.

### ⚙️ Configuración de la Base de Datos

1.  Crea una base de datos en tu servidor MySQL. Puedes nombrarla, por ejemplo, `alma_de_tortuga_db`.

2.  En el directorio `src/main/resources/`, crea o edita el archivo `application.properties` para configurar la conexión:

    ```properties
    # Configuración de la Base de Datos MySQL
    spring.datasource.url=jdbc:mysql://localhost:3306/alma_de_tortuga_db
    spring.datasource.username=tu_usuario_mysql
    spring.datasource.password=tu_contraseña
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    # Configuración de JPA/Hibernate
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
    ⚠️ **Importante:** Reemplaza `tu_usuario_mysql` y `tu_contraseña` con tus credenciales.

### ▶️ Ejecución del Servidor

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/CH60-Equipo4/back-AlmaDeTortuga.git](https://github.com/CH60-Equipo4/back-AlmaDeTortuga.git)
    cd back-AlmaDeTortuga
    ```

2.  **Ejecuta la aplicación usando Gradle:**
    ```bash
    ./gradlew bootRun
    ```

El servidor estará corriendo en `http://localhost:8080` (a menos que se especifique un puerto diferente en la configuración).

---

## 🔗 Endpoints Principales 

Documentación en Swagger: http://localhost:8080/swagger-ui/index.html#/

| Módulo | Método | Ruta de la API | Función |
| :--- | :--- | :--- | :--- |
| **Productos** | `GET` | `/api/products` | Recuperar todos los productos disponibles. |
| **Productos** | `POST` | `/api/products` | Crear un nuevo producto (Se requiere rol **Admin**). |
| **Autenticación** | `POST` | `/api/auth/register` | Registrar un nuevo usuario. |
| **Autenticación** | `POST` | `/api/auth/login` | Obtener token de acceso. |

---

## 👨‍💻 Desarrollado por

Este proyecto fue desarrollado por el equipo **Squirtle Developers**.

| Nombre                                |
|:---------------------------------| 
| Alonso Castellanos Vázquez       |
| Rosa Isela García Sainz          |
| Victor Hugo Hernández Cabello    |
| José Daniel Toledo Zepahua       |
| César Eduardo Corchado Hernández |
| Kimberly Deyanira Uriarte Meraz  |

