# Prog-3-Guia-3
Integracion conceptos aprendidos

Actividades
El sistema debe contar con un único menú para todos los usuarios. Al intentar realizar una
acción, el sistema debe verificar que se tenga el permiso. En caso de que no se tenga, se
debe lanzar una excepción NoAutorizadoException y mostrar un mensaje apropiado.
1. Conectarse a la Base de Datos
● Importar la librería/dependencia de mysqlConnector
● Crear una clase DBConnection que maneje la conexión a la base de datos
MySQL.
2. Permitir la creación de un nuevo usuario
● El usuario debe poder registrarse con su nombre, apellido, DNI y email.
● Se deben generar automáticamente sus credenciales con un username único y su
password.
● Por defecto, el usuario tendrá el permiso de CLIENTE.
● El usuario puede crear una cuenta nueva de tipo CUENTA_CORRIENTE. Al
registrarse, se le debe crear automáticamente una CAJA_AHORRO.
● Restricción: Cada usuario puede tener solo una CAJA_AHORRO, pero puede poseer
múltiples CUENTA_CORRIENTE.
3. Permitir el inicio de sesión
● El sistema, previo a operar, debe permitirle al usuario iniciar sesión y validar sus
credenciales en la base de datos
● Usar Optional<Usuario> para representar el usuario autenticado..
4. Obtener todos los usuarios registrados
● Solo GESTORES y ADMINISTRADORES pueden listar los usuarios del sistema.
5. Buscar un usuario por DNI o email
● Solo GESTORES y ADMINISTRADORES pueden buscar usuarios en la base de
datos.
● Utilizar Optional<Usuario> para evitar valores nulos.
● Aplicar filter en un Stream para buscar por DNI o email.
6. Modificar los datos de un usuario
● CLIENTES pueden modificar solo sus propios datos (nombre, apellido, email).
● GESTORES pueden modificar los datos de cualquier CLIENTE.
ADMINISTRADORES pueden modificar los datos de cualquier usuario.
7. Eliminar un usuario
● GESTORES pueden eliminar solo CLIENTES.
● ADMINISTRADORES pueden eliminar cualquier usuario.
Elimina también las credenciales y cuentas asociadas (ON DELETE CASCADE).
8. Listar todas las cuentas de un usuario
● CLIENTES pueden listar sus propias cuentas.
● GESTORES y ADMINISTRADORES pueden listar las cuentas de cualquier usuario.
● Utilizar Stream para transformar los resultados en una colección.
9. Obtener el saldo total de un usuario
● CLIENTES pueden ver solo su saldo.
● GESTORES y ADMINISTRADORES pueden ver el saldo de cualquier usuario.
● Utilizar Stream y reduce para calcular el saldo total.
10. Realizar un depósito en una cuenta
● CLIENTES pueden depositar en sus propias cuentas.
● GESTORES pueden depositar en cuentas de CLIENTES.
● ADMINISTRADORES pueden depositar en cualquier cuenta.
● Utilizar Optional para verificar la existencia de la cuenta.
11. Realizar una transferencia entre cuentas
● CLIENTES pueden transferir entre sus propias cuentas o a otros usuarios.
● GESTORES y ADMINISTRADORES pueden transferir dinero entre cuentas de
diferentes usuarios.
● La transferencia debe validar saldo suficiente antes de ejecutarse.
● Implementar la lógica con Stream para evitar bucles explícitos.
12. Obtener la cantidad de usuarios por tipo de permiso
● GESTORES y ADMINISTRADORES pueden acceder a esta información.
● Contar cuántos usuarios hay en el sistema agrupados por su tipo de permiso
(CLIENTE, GESTOR, ADMINISTRADOR).
Utilizar Collectors.groupingBy y Collectors.counting() para obtener el
resultado en un Map<String, Long>.
13. Obtener la cantidad total de cuentas por tipo y mostrarlas
● GESTORES y ADMINISTRADORES pueden acceder a este dato.
Utilizar Collectors.groupingBy y Collectors.counting() para contar las
cuentas por tipo.
14. Obtener el usuario con mayor saldo total
● Solo ADMINISTRADORES pueden acceder a esta información.
● Utilizar Stream, mapToDouble y max para encontrar el usuario con el mayor saldo.
15. Listar los usuarios ordenados por su saldo total (de mayor a menor)
● Solo ADMINISTRADORES pueden acceder a esta información.
● Usar Stream para calcular el saldo total de cada usuario.
