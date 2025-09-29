# Mini-Tienda-JDBC

Sistema CRUD (Create, Read, Update, Delete) para gestión de productos desarrollado en Java con interfaz gráfica usando JOptionPane y conexión a base de datos MySQL.

## 📋 Descripción

Aplicación de escritorio que permite administrar un inventario de productos con las siguientes funcionalidades:
- Crear nuevos productos
- Listar todos los productos
- Buscar producto por ID
- Actualizar información de productos
- Eliminar productos

## 🛠️ Tecnologías Utilizadas

- **Java** (JDK 8 o superior)
- **MySQL** (Base de datos)
- **JDBC** (Conector MySQL)
- **Swing** (JOptionPane para interfaz gráfica)

## 📂 Estructura del Proyecto

    src/
    ├── Main.java
    ├── controller/
    │   └── PoductoController.java
    ├── database/
    │   └── ConfigDB.java
    ├── entity/
    │   └── Producto.java
    ├── interfaces/
    │   └── Repositorio.java
    └── model/
        └── ProductoModel.java

## 🗂️ Arquitectura

El proyecto sigue una arquitectura en capas:

- **Entity**: Define la estructura de los datos (Producto)
- **Database**: Maneja la configuración y conexión a la base de datos
- **Interfaces**: Define contratos para operaciones CRUD
- **Model**: Implementa la lógica de acceso a datos
- **Controller**: Maneja la lógica de negocio y comunicación con el usuario
- **Main**: Punto de entrada de la aplicación

## 📊 Modelo de Datos

### Tabla: Producto

| Campo       | Tipo        | Descripción                |
|-------------|-------------|----------------------------|
| id_producto | INT         | Identificador único (PK)   |
| nombre      | VARCHAR     | Nombre del producto        |
| precio      | DECIMAL     | Precio del producto        |
| stock       | INT         | Cantidad disponible        |

## ⚙️ Configuración

### Requisitos Previos

1. Java JDK 8 o superior instalado
2. MySQL Server instalado y en ejecución
3. Driver JDBC de MySQL (mysql-connector-java)

### Configuración de Base de Datos

Edita el archivo `src/database/ConfigDB.java` con tus credenciales:

    String url = "jdbc:mysql://tu-servidor:puerto/tu-base-de-datos";
    String user = "tu-usuario";
    String password = "tu-contraseña";

### Script de Base de Datos

Ejecuta el siguiente script SQL para crear la tabla necesaria:

    CREATE DATABASE IF NOT EXISTS defaultdb;
    USE defaultdb;

    CREATE TABLE Producto (
        id_producto INT AUTO_INCREMENT PRIMARY KEY,
        nombre VARCHAR(100) NOT NULL,
        precio DECIMAL(10, 2) NOT NULL,
        stock INT NOT NULL
    );

## 🚀 Instalación y Ejecución

### 1. Clonar o descargar el proyecto

    git clone <url-del-repositorio>
    cd nombre-del-proyecto

### 2. Agregar el Driver JDBC de MySQL

Descarga el driver desde MySQL Connector/J y agrégalo al classpath del proyecto.

### 3. Compilar el proyecto

    javac -d bin src/**/*.java

### 4. Ejecutar la aplicación

    java -cp bin Main

O desde tu IDE favorito (IntelliJ IDEA, Eclipse, NetBeans):
- Abre el proyecto
- Configura el driver JDBC en las dependencias
- Ejecuta la clase `Main.java`

## 💻 Uso

Al ejecutar la aplicación, se mostrará un menú con las siguientes opciones:

    1. Crear Producto
    2. Listar productos
    3. Encontrar Producto por ID
    4. Eliminar producto
    5. Actualizar producto
    6. Leave

### Crear Producto
Ingresa el nombre, precio y stock del nuevo producto.

### Listar Productos
Muestra todos los productos registrados en la base de datos.

### Buscar por ID
Ingresa el ID del producto que deseas consultar.

### Actualizar Producto
Ingresa el ID del producto y modifica sus datos (nombre, precio, stock).

### Eliminar Producto
Ingresa el ID del producto que deseas eliminar. Se solicitará confirmación antes de eliminar.

## 🔧 Funcionalidades Principales

### ProductoController
Maneja las interacciones del usuario:
- `crear()`: Crea un nuevo producto
- `listar()`: Lista todos los productos
- `encontrarPorId()`: Busca un producto específico
- `actualizar()`: Modifica un producto existente
- `eliminar()`: Elimina un producto

### ProductoModel
Implementa las operaciones CRUD:
- `listar()`: Retorna lista de productos
- `porId(Integer id)`: Busca producto por ID
- `crear(Object pr)`: Inserta nuevo producto
- `editar(Object pr)`: Actualiza producto existente
- `eliminar(Integer id)`: Elimina producto por ID

## 🔐 Seguridad

**⚠️ IMPORTANTE**: Este proyecto contiene credenciales de base de datos en texto plano. Para uso en producción:

1. Utiliza variables de entorno para las credenciales
2. Implementa un archivo de configuración externo (.properties)
3. Nunca subas credenciales a repositorios públicos
4. Considera usar un gestor de secretos

## 📝 Mejoras Futuras

- Implementar validación de datos de entrada
- Agregar manejo de excepciones más robusto
- Crear interfaz gráfica con JavaFX o Swing completo
- Implementar patrón DAO más estructurado
- Agregar logs de operaciones
- Implementar pool de conexiones
- Agregar pruebas unitarias

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Haz fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la Licencia MIT.

## ✉️ Contacto

Para preguntas o sugerencias, por favor abre un issue en el repositorio.

---

**Desarrollado con ☕ y Java**
