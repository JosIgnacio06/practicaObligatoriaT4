FernanPop v2 – Manual de Usuario

FernanPop es un programa de software de compra y venta pensado para que los usuarios puedan intercambiar productos de forma rápida, sencilla y segura. Esta versión incluye notificaciones automáticas por correo electrónico y Telegram para los administradores del sistema.

ÍNDICE
Descripción
Requisitos
Instalación y ejecución del software
Funcionamiento del software
Creadores

1. Descripción
FernanPop permite a los usuarios registrarse, iniciar sesión, gestionar productos en venta, comprar productos de otros usuarios y mantener un historial de ventas y compras. Además, el sistema envía correos electrónicos de verificación y notificaciones al administrador vía Telegram para mantener un control seguro y actualizado de la actividad de los usuarios.

2. Requisitos
Para ejecutar FernanPop se necesitan los siguientes requisitos mínimos:
Tener instalado Java Development Kit (JDK) actualizado.
El JDK incluye el intérprete Java, clases Java y herramientas de desarrollo que permiten ejecutar aplicaciones Java en cualquier sistema.
Página oficial de descarga: JDK Oracle

Descargar e instalar el paquete correspondiente a tu sistema operativo y seguir las instrucciones del instalador.


3. Instalación y ejecución del software
Descarga la carpeta comprimida .zip del proyecto.
Descomprime la carpeta.
Ejecuta el archivo .bat incluido para iniciar el programa.

⚠️ Advertencia: Al abrir el .bat, Windows Defender puede bloquear la ejecución. Selecciona “Más información” → “Ejecutar de todas formas” para permitir que el software se ejecute correctamente.

 


El programa se abrirá en la consola CMD y mostrará la pantalla de inicio de sesión.

4. Funcionamiento del software
Inicio de sesión y registro
Al iniciar, se solicita email y contraseña.


 

Si el usuario ya existe y ha validado su email, se accede al menú principal.
Si el usuario no ha validado su email, se enviará automáticamente un token de verificación por email, que debe introducir antes de continuar.
Se permiten 3 intentos de login antes de volver al menú principal.
El menú principal permite volver al login sin cerrar la aplicación.

Menú principal
Una vez iniciado sesión, se presentan las siguientes opciones:

Opción 1: Mostrar datos de usuario
Muestra el email, el nombre y si el correo ha sido validado.


Opción 2: Modificar datos personales
Permite actualizar nombre, email y contraseña.
Si se cambia el email, se enviará un nuevo token para validación.
El usuario deberá validar nuevamente el correo para poder iniciar sesión con el nuevo email.

 


Opción 3: Ver productos a la venta
Muestra los productos actuales que el usuario tiene a la venta.
Si no hay productos, se indica que la lista está vacía.

 


Opción 4: Añadir un producto a la venta
Permite introducir un nombre y un precio para un nuevo producto.
Una vez añadido, se enviará automáticamente un correo al usuario con los datos del producto.
Además, se enviará una notificación al administrador vía Telegram con los detalles del producto.






Opción 5: Ver todas las ventas de todos los usuarios
Muestra los productos que cada usuario tiene a la venta.
Si un usuario no tiene productos, se indica que su lista de ventas está vacía.


Opción 6: Histórico de ventas
Muestra los productos vendidos por el usuario.
Si no se ha vendido ningún producto, se indica que no hay ventas registradas.

 

Opción 7: Histórico de compras
Muestra los productos comprados por el usuario.
Si no se ha comprado ningún producto, se indica que no hay compras registradas.

 

Opción 8: Borrar o comprar productos
Borrar un producto: Permite eliminar un producto de la lista de ventas.
Comprar un producto: Selecciona un producto para comprarlo.
Al comprar un producto, se enviará un correo al vendedor notificando la venta.
Además, el administrador recibe una notificación por Telegram del producto comprado.

 

Opción 9: Cerrar sesión
Cierra la sesión del usuario y vuelve al menú de inicio de sesión sin cerrar la aplicación.

 

5. Creadores
Este programa ha sido creado por Jose Ignacio y David.
