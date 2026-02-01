FernanPop v2 – Manual de Usuario
<img width="1024" height="1536" alt="Fernanpop" src="https://github.com/user-attachments/assets/c7cdd749-63de-4d48-845f-eed7fc1439d7" />


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
<img width="1814" height="512" alt="386256659-74b6704e-60e6-4178-ae80-d17462e029b3" src="https://github.com/user-attachments/assets/14c0c81f-da7e-4c6a-ba05-b8a2eff01573" />

Descargar e instalar el paquete correspondiente a tu sistema operativo y seguir las instrucciones del instalador.
<img width="569" height="23" alt="idk-25_linux-aarch64_bin tar gz" src="https://github.com/user-attachments/assets/53dde56b-e9a6-460b-b358-12ecaeec367a" />


3. Instalación y ejecución del software
Descarga la carpeta comprimida .zip del proyecto.
Descomprime la carpeta.
Ejecuta el archivo .bat incluido para iniciar el programa.


⚠️ Advertencia: Al abrir el .bat, Windows Defender puede bloquear la ejecución. Selecciona “Más información” → “Ejecutar de todas formas” para permitir que el software se ejecute correctamente.

 
<img width="658" height="610" alt="Windows protegió su PC" src="https://github.com/user-attachments/assets/022b87ee-f0ed-46ae-8cfa-0c2650832e2d" />
<img width="657" height="604" alt="Windows protegió su PC" src="https://github.com/user-attachments/assets/196fa33d-6a44-474b-b7cb-2af1e281403f" />


El programa se abrirá en la consola CMD y mostrará la pantalla de inicio de sesión.

4. Funcionamiento del software
Inicio de sesión y registro
Al iniciar, se solicita email y contraseña.

<img width="392" height="233" alt="Bienvenido al programa FernanPop" src="https://github.com/user-attachments/assets/d02a2a90-3125-4e97-9a2f-c5e5b9fb5761" />

 

Si el usuario ya existe y ha validado su email, se accede al menú principal.
Si el usuario no ha validado su email, se enviará automáticamente un token de verificación por email, que debe introducir antes de continuar.
Se permiten 3 intentos de login antes de volver al menú principal.
El menú principal permite volver al login sin cerrar la aplicación.

Menú principal
Una vez iniciado sesión, se presentan las siguientes opciones:
<img width="498" height="340" alt="Ment de usuanio" src="https://github.com/user-attachments/assets/0074012b-ad19-4007-adc5-4d4ca5acf18c" />

Opción 1: Mostrar datos de usuario
Muestra el email, el nombre y si el correo ha sido validado.


Opción 2: Modificar datos personales
Permite actualizar nombre, email y contraseña.
Si se cambia el email, se enviará un nuevo token para validación.
El usuario deberá validar nuevamente el correo para poder iniciar sesión con el nuevo email.

 <img width="390" height="114" alt="Escribe tu nuevo nombre Nachito" src="https://github.com/user-attachments/assets/cd30ad65-978e-4f21-88d3-188fb586c998" />

<img width="256" height="86" alt="Email= holaquetal@gmail com" src="https://github.com/user-attachments/assets/6e6e1be0-ffff-4ae4-9704-064cd8d8365a" />


Opción 3: Ver productos a la venta
Muestra los productos actuales que el usuario tiene a la venta.
Si no hay productos, se indica que la lista está vacía.

 <img width="315" height="32" alt="No tienes ningún producto en venta" src="https://github.com/user-attachments/assets/f8f191ba-ec7d-4915-bfe4-01a90ee64d99" />

<img width="165" height="83" alt="Producto 1" src="https://github.com/user-attachments/assets/f9bd1e55-6757-4d39-90b7-2c83ba65ac07" />


Opción 4: Añadir un producto a la venta
Permite introducir un nombre y un precio para un nuevo producto.
Una vez añadido, se enviará automáticamente un correo al usuario con los datos del producto.
Además, se enviará una notificación al administrador vía Telegram con los detalles del producto.


<img width="429" height="125" alt="Nombre del producto ar1" src="https://github.com/user-attachments/assets/2beb1ddf-408c-4b37-adc6-7e25d4ec75bb" />


<img width="221" height="168" alt="Hola nacho," src="https://github.com/user-attachments/assets/6a7e66ce-a747-48a3-b2a2-2ae5f44a597f" />

<img width="221" height="108" alt="Nuevo producto añadido por nacho" src="https://github.com/user-attachments/assets/1ae8eec9-fc03-4b5f-b424-63754a519014" />



Opción 5: Ver todas las ventas de todos los usuarios
Muestra los productos que cada usuario tiene a la venta.
Si un usuario no tiene productos, se indica que su lista de ventas está vacía.


<img width="563" height="138" alt="Usuario carlosbarroso@fernandosmartos con no tiene productos en venta" src="https://github.com/user-attachments/assets/0a7471fe-2842-473e-999c-c903f39f21fc" />

Opción 6: Histórico de ventas
Muestra los productos vendidos por el usuario.
Si no se ha vendido ningún producto, se indica que no hay ventas registradas.

 <img width="268" height="32" alt="No has vendido ningún producto" src="https://github.com/user-attachments/assets/15a79007-1e9c-421c-903c-57e3a7b1aa09" />

<img width="218" height="54" alt="Producto 1 Boli" src="https://github.com/user-attachments/assets/b88a009b-d5a0-439f-9a83-f93d2f63ae22" />

Opción 7: Histórico de compras
Muestra los productos comprados por el usuario.
Si no se ha comprado ningún producto, se indica que no hay compras registradas.

 <img width="218" height="31" alt="Ningún producto comprado" src="https://github.com/user-attachments/assets/29c34f89-21eb-4472-b7a9-a6f52d03a711" />
<img width="218" height="54" alt="Producto 1 Boli" src="https://github.com/user-attachments/assets/6d2f8e39-9528-4856-930e-0f6eb570c9a1" />


Opción 8: Borrar o comprar productos
Borrar un producto: Permite eliminar un producto de la lista de ventas.
Comprar un producto: Selecciona un producto para comprarlo.
Al comprar un producto, se enviará un correo al vendedor notificando la venta.
Además, el administrador recibe una notificación por Telegram del producto comprado.

 <img width="390" height="136" alt="Producto 1" src="https://github.com/user-attachments/assets/496bb7e7-9ddc-46c1-873e-9ff6d0b734cf" />


<img width="390" height="112" alt="Producto 1 Boli" src="https://github.com/user-attachments/assets/4c579fe8-2866-406e-8d4b-0dbb5d02109b" />

Opción 9: Cerrar sesión
Cierra la sesión del usuario y vuelve al menú de inicio de sesión sin cerrar la aplicación.

 <img width="249" height="72" alt="Cerrando sesión" src="https://github.com/user-attachments/assets/71b5364f-1d6b-4755-a2ec-6b37d4be9562" />

 <img width="392" height="233" alt="Bienvenido al programa FernanPop" src="https://github.com/user-attachments/assets/8ad043a9-120b-4937-a9c9-2557e12c944a" />



5. Creadores
Este programa ha sido creado por Jose Ignacio y David.
