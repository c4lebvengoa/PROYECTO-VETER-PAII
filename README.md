# Sistema de Gestión de Biblioteca

Este es un sistema completo de gestión de biblioteca desarrollado con Spring Boot en el backend y HTML/JavaScript/Bootstrap en el frontend.

## Características

- **Dashboard** con estadísticas en tiempo real
- **Gestión de Usuarios** - CRUD completo de usuarios de la biblioteca
- **Gestión de Libros** - CRUD completo con búsqueda y filtros
- **Gestión de Autores** - CRUD completo de autores
- **Gestión de Categorías** - CRUD completo de categorías de libros
- Interfaz moderna y responsiva con Bootstrap 5
- API RESTful completa
- Base de datos MySQL

## Tecnologías Utilizadas

### Backend
- Spring Boot 3.2.0
- Spring Data JPA
- Spring Web
- MySQL 8.0+
- Maven

### Frontend
- HTML5
- JavaScript ES6+
- Bootstrap 5.3.2
- Bootstrap Icons

## Requisitos Previos

1. **Java 21** o superior
2. **MySQL 8.0** o superior
3. **Maven 3.6** o superior

## Instalación y Configuración

### 1. Configurar la Base de Datos

1. Instalar MySQL si no lo tienes instalado
2. Crear un usuario root o configurar las credenciales en `application.properties`
3. La base de datos `biblioteca_db` se creará automáticamente

### 2. Configurar la Aplicación

1. Clonar o descargar el proyecto
2. Editar el archivo `src/main/resources/application.properties` si necesitas cambiar la configuración de la base de datos:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_password_aqui
```

### 3. Ejecutar la Aplicación

#### Opción 1: Usando Maven
```bash
mvn spring-boot:run
```

#### Opción 2: Ejecutar el JAR
```bash
mvn clean package
java -jar target/PROJECT-VETER-PAII-1.0-SNAPSHOT.jar
```

### 4. Acceder a la Aplicación

Una vez que la aplicación esté ejecutándose:

1. Abrir el navegador web
2. Ir a: `http://localhost:8080`
3. La aplicación estará lista para usar

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/biblioteca/
│   │       ├── BibliotecaApplication.java      # Clase principal
│   │       ├── controlador/                    # Controladores REST
│   │       │   ├── UsuarioControlador.java
│   │       │   ├── LibroControlador.java
│   │       │   ├── AutorControlador.java
│   │       │   ├── CategoriaControlador.java
│   │       │   └── DashboardControlador.java
│   │       ├── entidad/                        # Entidades JPA
│   │       │   ├── UsuarioBiblioteca.java
│   │       │   ├── Libro.java
│   │       │   ├── Autor.java
│   │       │   ├── CategoriaBiblioteca.java
│   │       │   └── Prestamo.java
│   │       └── repositorio/                    # Repositorios JPA
│   │           ├── UsuarioRepositorio.java
│   │           ├── LibroRepositorio.java
│   │           ├── AutorRepositorio.java
│   │           ├── CategoriaRepositorio.java
│   │           └── PrestamoRepositorio.java
│   └── resources/
│       ├── static/                             # Archivos estáticos
│       │   ├── index.html                      # Frontend HTML
│       │   └── script.js                       # JavaScript
│       └── application.properties              # Configuración
```

## API Endpoints

### Usuarios
- `GET /api/usuarios` - Listar todos los usuarios
- `GET /api/usuarios/{id}` - Obtener usuario por ID
- `POST /api/usuarios` - Crear nuevo usuario
- `PUT /api/usuarios/{id}` - Actualizar usuario
- `DELETE /api/usuarios/{id}` - Eliminar usuario (soft delete)

### Libros
- `GET /api/libros` - Listar todos los libros
- `GET /api/libros/{id}` - Obtener libro por ID
- `GET /api/libros/buscar` - Buscar libros con filtros
- `POST /api/libros` - Crear nuevo libro
- `PUT /api/libros/{id}` - Actualizar libro
- `DELETE /api/libros/{id}` - Eliminar libro

### Autores
- `GET /api/autores` - Listar todos los autores
- `GET /api/autores/{id}` - Obtener autor por ID
- `POST /api/autores` - Crear nuevo autor
- `PUT /api/autores/{id}` - Actualizar autor
- `DELETE /api/autores/{id}` - Eliminar autor

### Categorías
- `GET /api/categorias` - Listar todas las categorías
- `GET /api/categorias/{id}` - Obtener categoría por ID
- `POST /api/categorias` - Crear nueva categoría
- `PUT /api/categorias/{id}` - Actualizar categoría
- `DELETE /api/categorias/{id}` - Eliminar categoría

### Dashboard
- `GET /api/dashboard/estadisticas` - Obtener estadísticas del sistema

## Características del Frontend

- **Navegación por pestañas** sin recarga de página
- **Modales Bootstrap** para crear/editar entidades
- **Búsqueda y filtros** en tiempo real
- **Indicadores de carga** y manejo de errores
- **Interfaz responsiva** que funciona en móviles y escritorio
- **Validación de formularios** en el cliente y servidor

## Solución de Problemas

### Error de Conexión a MySQL
- Verificar que MySQL esté ejecutándose
- Verificar las credenciales en `application.properties`
- Verificar que el puerto 3306 esté disponible

### Puerto 8080 en uso
- Cambiar el puerto en `application.properties`:
```properties
server.port=8081
```

### Problemas de CORS
- Los controladores ya incluyen `@CrossOrigin(origins = "*")`
- Si persisten problemas, verificar la configuración del navegador

## Contribuir

1. Fork el proyecto
2. Crear una rama para nuevas características (`git checkout -b feature/AmazingFeature`)
3. Commit los cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para detalles.