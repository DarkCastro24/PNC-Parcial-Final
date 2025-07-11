# Parcial Final Programación N-Capas – (Seguridad con Spring Security + JWT)

Este repositorio contiene un proyecto para evaluar y practicar los conceptos de seguridad en aplicaciones Spring Boot usando JWT, roles y Docker.

### Estudiantes
- **Nombre del estudiante 1**: Diego Eduardo Castro Quintanilla 00117322
- **Nombre del estudiante 2**: Katherin Gabriela Perez Baires 00141621
- Sección: 01
---

## IMPORTANTE!!! COMO EJECUTAR EL SISTEMA 

1. **Clonar el proyecto**  
   ```bash
   git clone https://github.com/DarkCastro24/PNC-Parcial-Final.git
   Abrir el proyecto con el IDE IntelliJ 
   ```

2. **Crear la base de datos y ajustar credenciales**  
   - Crea una base de datos PostgreSQL llamada `supportdb` unicamente crearla sin agregar ninguna tabla.  
   - Abrir el archivo `src/main/resources/application.yml` y actualiza las credenciales de conexión (usuario, contraseña, URL solo si es necesario yo tengo por defecto puerto 5432).  
   - Abre `docker-compose.yml` y coloca allí las mismas credenciales en la sección de Postgres indispensable para que funcione la ejecucion con docker.

3. **Ejecutar la aplicacion con docker**  
   Tienes **dos** opciones para generar el archivo .jar que levante el sistema con docker:

   a) **Desde IntelliJ IDEA**  
   - En el panel lateral, haz click en el ícono de Maven (M), expande `parcial-final-n-capas` → **Lifecycle** → `package`.  
   - Se generará el JAR `parcial-final-n-capas-0.0.1-SNAPSHOT.jar` en la carpeta `target`.  
   - Comenzara a cargar y cuando termine el JAR se generara en la carpeta target 

   b) **Con la terminal**
   - **Indispensable para esta opción:** tener instalado Maven de manera Global en el sistema operativo.  
   - Genera el JAR localmente:  
     ```bash
     mvn clean package -DskipTests
     ```  
   - Ahora una vez terminada cualquiera de las dos opciones anteriores para levantar los contenedores ejecutamos el siguiente comando en la terminal:  
     ```bash
     docker-compose up --build
     ```  
     > **Importante:** Docker debe estar en ejecución y las credenciales de Postgres ya configuradas en `docker-compose.yml`.

4. **Acceder a la aplicación**  
   - La aplicacion corre en el puerto **8080**.  
   - URL base del proyecto: `http://localhost:8080`

5. **Probar la API**  
   - Importa la colección Postman que está en la carpeta raíz del repositorio (Afuera de la carpeta del proyecto).  
   - Al abrirla, configura la variable de entorno `{{baseUrl}}` con el valor `http://localhost:8080`.  
   - Solo las rutas `login` y `register` (colección **Auth**) son públicas:  
     1. **Register User** (crea un usuario TECH por defecto).  
     2. **Login** (obtén el token JWT).  
   - Para el resto de rutas protegidas:  
     - En Postman, en **Authorization**, selecciona **Bearer Token** y usa la variable `{{token}}`.  
     - Las rutas disponibles dependen del rol (`TECH` o `USER`).  
     - Para probar como `USER`, crea uno con **Register User** usando este JSON de ejemplo ;)
       ```json
       {
         "nombre": "David Hurtado",
         "correo": "jdhurtado@uca.edu.sv",
         "password": "1234",
         "rol": "USER"
       }
       ```
    - Y para probar el inicio de sesión en **Login**
    ```json
       {
        "correo": "jdhurtado@uca.edu.sv",
        "password": "1234"
        }
    ```

## Sistema de Soporte Técnico

### Descripción
Simula un sistema donde los usuarios pueden crear solicitudes de soporte (tickets) y los técnicos pueden gestionarlas. Actualmente **no tiene seguridad implementada**.

Su tarea es **agregar autenticación y autorización** utilizando **Spring Security + JWT**, y contenerizar la aplicación con Docker.

### Requisitos generales

- Proyecto funcional al ser clonado y ejecutado con Docker.
- Uso de PostgreSQL (ya incluido en docker-compose).
- Seguridad implementada con JWT.
- Roles `USER` y `TECH`.
- Acceso restringido según el rol del usuario.
- Evidencia de funcionamiento (colección de Postman/Insomnia/Bruno o capturas de pantalla).

**Nota: El proyecto ya tiene una estructura básica de Spring Boot con endpoints funcionales para manejar tickets. No es necesario modificar la lógica de negocio, solo agregar seguridad. Ademas se inclye un postman collection para probar los endpoints. **

_Si van a crear mas endpoints como el login o registrarse recuerden actualizar postman/insomnia/bruno collection_

### Partes de desarrollo

#### Parte 1: Implementar login con JWT
- [ ] Crear endpoint `/auth/login`.
- [ ] Validar usuario y contraseña (puede estar en memoria o en BD).
- [ ] Retornar JWT firmado.

#### Parte 2: Configurar filtros y validación del token
- [ ] Crear filtro para validar el token en cada solicitud.
- [ ] Extraer usuario desde el JWT.
- [ ] Añadir a contexto de seguridad de Spring.

#### Parte 3: Proteger endpoints con Spring Security
- [ ] Permitir solo el acceso al login sin token.
- [ ] Proteger todos los demás endpoints.
- [ ] Manejar errores de autorización adecuadamente.

#### Parte 4: Aplicar roles a los endpoints

| Rol   | Acceso permitido                                 |
|--------|--------------------------------------------------|
| USER  | Crear tickets, ver solo sus tickets              |
| TECH  | Ver todos los tickets, actualizar estado         |

- [ ] Usar `@PreAuthorize` o reglas en el `SecurityFilterChain`.
- [ ] Validar que un USER solo vea sus tickets.
- [ ] Validar que solo un TECH pueda modificar tickets.

#### Parte 5: Agregar Docker
- [ ] `Dockerfile` funcional para la aplicación.
- [ ] `docker-compose.yml` que levante la app y la base de datos.
- [ ] Documentar cómo levantar el entorno (`docker compose up`).

#### Parte 6: Evidencia de pruebas
- [ ] Probar todos los flujos con Postman/Insomnia/Bruno.
- [ ] Mostrar que los roles se comportan correctamente.
- [ ] Incluir usuarios de prueba (`user`, `tech`) y contraseñas.
