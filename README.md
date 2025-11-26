# App Tecnologia Movil

AppTecnologia es una aplicación para Android desarrollada en Kotlin con Jetpack Compose que explora los conceptos de APIs, IAs, y bases de datos con Room.

## Integrantes

- JORGE ALEJANDRO MAGAÑA HERNANDEZ
- ORLANDO MORFIN LAZO DE LA VEGA

## Fecha y Grupo
LDSM405
04/12/2025

## Características

*   **Navegación Intuitiva:** Interfaz de usuario limpia con una barra de navegación inferior para cambiar entre las diferentes secciones de la aplicación.
*   **Sección de APIs:** Muestra una lista de las APIs más utilizadas en el desarrollo de Android.
*   **Gestión de IAs:** Permite a los usuarios agregar, editar y eliminar información sobre diferentes Inteligencias Artificiales.
*   **Base de Datos Local:** Utiliza Room para persistir los datos de las IAs, asegurando que la información esté disponible incluso después de cerrar la aplicación.

## Tecnologías Utilizadas

*   **Lenguaje:** [Kotlin](https://kotlinlang.org/)
*   **Interfaz de Usuario:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
*   **Base de Datos:** [Room](https://developer.android.com/training/data-storage/room)
*   **Navegación:** [Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
*   **Carga de Imágenes:** [Coil](https://coil-kt.github.io/coil/)
*   **Íconos:** [Material Icons Extended](https://developer.android.com/jetpack/compose/resources#icons)
*   **Procesador de Anotaciones:** [KSP](https://kotlinlang.org/docs/ksp-overview.html)

## Estructura del Proyecto

*   `app/src/main/java/com/example/apptecnologia/data`: Contiene la entidad de la base de datos (`IAEntity`), el DAO (`IADao`), y la clase de la base de datos (`AppDatabase`).
*   `app/src/main/java/com/example/apptecnologia/viewmodel`: Incluye el `IAViewModel` que se encarga de la lógica de negocio y la comunicación con la base de datos.
*   `app/src/main/java/com/example/apptecnologia/ui`: Componentes de la interfaz de usuario de Jetpack Compose.
*   `app/src/main/java/com/example/apptecnologia/MainActivity.kt`: El punto de entrada principal de la aplicación.

## Instalación y Ejecución

1.  Clona el repositorio: `git clone https://github.com/tu_usuario/AppTecnologia.git`
2.  Abre el proyecto en Android Studio.
3.  Sincroniza el proyecto con los archivos de Gradle.
4.  Ejecuta la aplicación en un emulador o en un dispositivo físico.

