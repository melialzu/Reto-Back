# Biblioteca Digital Secretos Para Contar

## Project Katio

Este project de Spring Boot con JPA y MySQL/MongoDB está diseñado para ser una biblioteca o repositorio de libros digital para la Fundación Secretos Para contar.

# Integrantes

- Melissa Alvarez
- Felipe Alzate
- Samir Gil

# Entrega final de 15 de junio
# Tareas

### Usuarios

- [x] Crear un usuario, utilizar el registro.
- [ ] Login del usuario: debe regresar un token bearer. Al hacer login, debo poder usar el token para cualquier otra acción.
- [ ] Todas mis acciones deben quedar bajo llave, con la sola excepción de: Login, Signup.
- [x] Editar un usuario.
- [ ] Debo poder reiniciar mi clave, solo mi clave. Debo colocar la clave anterior, y dos veces la clave nueva.
- [x] Listar todos mis usuarios.
- [x] Listar todos mis usuarios por email, o identificación.
- [x] Agregar un username. No todos los usuarios tienen un correo hábil. Ambos campos son distintos, pero puede repetir la información.
- [ ] Manejar los perfiles (Roles) del usuario.

### Libros

- [x] Crear un libro.
- [x] Editar un libro.
- [x] Buscar libro por nombre, de forma relativa.
- [x] Buscar libro por autor, de forma relativa, por nombre y apellido del autor.
- [x] Buscar libro por editorial.
- [x] Buscar libro por género.
- [x] Buscar libro por fecha de publicación.
- [ ] Subir un libro en PDF a la biblioteca.
- [ ] Servir un libro en PDF al cliente.
- [ ] Agregar varios géneros a un libro.
- [ ] Los libros pueden tener varios autores.
- [ ] Agregar temas al libro.
- [ ] Un libro puede tener varios temas.
- [x] No pueden haber dos versiones del mismo libro.
- [ ] Agregar libros relacionados a un libro principal.

### Audiolibros

- [x] Crear un audiolibro.
- [ ] Editar un audiolibro.
- [x] Buscar audiolibro por nombre, de forma relativa.
- [x] Buscar audiolibro por autor, de forma relativa, por nombre y apellido del autor.
- [x] Buscar audiolibro por editorial.
- [x] Buscar audiolibro por género.
- [x] Buscar audiolibro por fecha de publicación.
- [ ] Subir un audiolibro en MP3/OGG a la biblioteca.
- [ ] Servir un audiolibro en MP3/OGG al cliente.
- [ ] Buscar un audiolibro por narrador.
- [x] Buscar un audiolibro por longitud.
- [ ] Agregar varios géneros a un libro.
- [ ] Los libros pueden tener varios autores.
- [ ] Agregar temas al libro.
- [ ] Un libro puede tener varios temas.
- [ ] No pueden haber dos versiones del mismo libro.

### Autores

- [x] Crear un autor.
- [x] Editar un autor.
- [x] Buscar un autor por nombre y apellido de forma relativa.
- [x] Buscar un autor por fecha de nacimiento.
- [x] Buscar un autor por país de procedencia.
- [x] Buscar todos los libros de un autor por relación.
- [ ] Buscar todos los audiolibros de un autor por relación.

### Narradores

- [ ] Crear un narrador.
- [ ] Editar un narrador.
- [ ] Buscar narrador por nombre.
- [ ] Buscar narrador por perfil de voz.
- [ ] Buscar libros narrados por el narrador por relación.

### Utils

- [ ] Manejo correcto de errores.
- [ ] Utilizar try catch donde sea necesario.
- [ ] Hacer rollback donde sea necesario.
- [ ] Usar el tipo correcto para mejorar la memoria.
- [ ] No hacer llamados innecesarios.
- [ ] Extraer funcionalidad repetida en su propia clase o método.

### Admin / Estadísticas

- [ ] Ver mis usuarios, editarlos y desactivarlos. (Meli)
- [ ] Asignar una clave de forma directa a un usuario a través de la edición. (Meli)
- [ ] El username y el email no son mutables. (Meli)
*********
- [ ] Agregar estadísticas al sitio.
- [ ] Cada vez que se descargue un libro, tener un contador que se encargue de llevar la cuenta.
- [ ] Cada vez que se reproduzca un audiolibro, tener un contador que se encargue de llevar la cuenta.
- [ ] Cada vez que se mire el perfil de un autor con sus libros, tener un contador que se encargue de llevar la cuenta. (Sam cada vez que se llame el servicio autor por nombre-apellido )
- [ ] Cada vez que se descargue un libro o se escuche un audiolibro, marcar el género en una tabla de contadores que lleve la cuenta.

- [ ] Última conexión al usuario. (meli)
- [ ] Llevar la cuenta de cuántos días distintos se conecta un usuario. Diferente a la última conexión.
- [ ] Agregar logs al sistema.
- [ ] Basada en las conexiones y la cuenta de las mismas, emitir una estadística que diga cuáles son los días más activos para el sistema.
- [ ] Llevar la cuenta de intentos fallidos al hacer login. Al llegar a 10, bloquear el usuario. Una vez se ingrese la clave correcta, reiniciar el contador a 0.
- [ ] Cambiar la longitud de duración del token a 24 horas.
- [ ] Actualizar su sistema a la última versión de Java y Spring.

## BONUS TRACKS (Actividades Extra Curriculares)

- Crear un front end en Angular o React que sea capaz de implementar todos los dominios.
    - Crear página de signup.
    - Crear página de login.
    - Crear módulo de libros.
        - Buscar.
        - Descargar.
    - Crear módulo de autores.
        - Buscar.
        - Listar.
    - Crear módulo de audiolibros.
        - Buscar.
        - Listar.
    - Crear módulo de admin con todas las funcionalidades implementadas del backend. Incluir lo que se considere necesario.

## BONUS TRACK EXCLUSIVE (Actividad Extra Extra Curricular, SUMA CUM LAUDE)

```csharp
// C# Dotnet 8
public void Main(String[] args)
{
    const string NET_VERSION = "8.0 (SDK 8.0.301)";
    const string LANGUAGE_VERSION = "C#";
    Console.WriteLine($"Escribir todo el backend en {NET_VERSION} y {LANGUAGE_VERSION}");
    return 0;
}

// Rust Language 1.78.0
use std::io;

fn main() {
    println!("Write this in Rust Language with Axum or Rocket.");
}

