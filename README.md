# Challenge Devsu

![img.png](img.png) 
<hr>

<div data-test="QuestionInstructionsContent" class="css-1gx99p8 eua3guj4"><div class="css-15zf1ij e2s64ho0"><div>
<p><strong>Prueba Técnica/Práctica&nbsp;&nbsp;</strong></p>
<p><strong>Arquitectura Microservicio</strong></p>
<p><strong>Indicaciones generales&nbsp;</strong></p>
<ul>
<li><span style="font-weight: 400;">Aplique todas las buenas prácticas de programación, patrones de diseño (ejemplo: Repository), etc. que considere necesario (se tomará en cuenta este punto para la calificación).</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">El manejo de entidades se debe manejar JPA / Entity Framework Core.&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Se debe aplicar un manejo de excepciones.</span></li>
<li><span style="font-weight: 400;">Se debe realizar como mínimo una prueba unitaria. </span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">La solución se debe desplegar y funcionar en Docker.&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Posterior a la entrega de este ejercicio, dependiendo de los resultados, se podrá agendar una entrevista técnica donde deberás defender la solución planteada.&nbsp;</span></li>
</ul>
<p><strong>Herramientas y tecnologías utilizadas&nbsp;</strong></p>
<ul>
<li><span style="font-weight: 400;">&nbsp;<span>Si aplicaste para una posición con<strong> Java</strong>, utilizar </span></span><span style="font-weight: 400;"><strong>Java spring boot. </strong>Si aplicaste para una posición con<strong><span> .NET, </span></strong>utilizar <strong>NetCore 5 o superior / Asp 4.8 o inferior&nbsp;</strong></span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">IDE de su preferencia&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Base de Datos Relacional&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Postman v9.13.2 (validador de API) / Karate DSL&nbsp;</span></li>
</ul>
<p><strong>Requerimiento de Microservicios y Funcionalidades</strong><span style="font-weight: 400;"> </span></p>
<p><strong><span style="font-weight: 400;">Separar en 2 microservicios, agrupando (Cliente, Persona) y (Cuenta, Movimientos) donde se contemple una comunicación asincrónica entre los 2 microservicios. Cumplir las funcionalidades: F1, F2, F3, F4, F5 deseable la funcionalidad F6. </span></strong></p>
<p><strong>*Consideraciones Adicionales (para obtener la máxima puntuación):</strong></p>
<p><span style="font-weight: 400;">Si quieres sobresalir, además de cumplir con los requisitos mencionados anteriormente, se espera la implementación de las funcionalidades F6 y F7.&nbsp;</span></p>
<p><strong><span style="font-weight: 400;">La solución debe contemplar (no necesariamente implementado) factores como: rendimiento, escalabilidad, resiliencia</span><span style="font-weight: 400;">.</span></strong></p>
<h3><strong>Generación de Api Rest “Application Programming Interface” </strong></h3>
<h4><span style="font-weight: 400;">Manejar los verbos: Get, Post, Put, Patch, Delete</span>&nbsp;</h4>
<p><span style="font-weight: 400;"><strong>Persona</strong>&nbsp;</span></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Implementar la clase persona con los siguientes datos: nombre, género, edad,&nbsp; identificación, dirección, teléfono&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Debe manera su clave primaria (PK)&nbsp;&nbsp;</span></li>
</ul>
<p><strong>Cliente&nbsp;</strong></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Cliente debe manejar una entidad, que herede de la clase persona.&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Un cliente tiene: clienteid, contraseña, estado.&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">El cliente debe tener una clave única. (PK)&nbsp;</span></li>
</ul>
<p><strong>Cuenta&nbsp;</strong></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Cuenta debe manejar una entidad.&nbsp;&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Una cuenta tiene: número cuenta, tipo cuenta, saldo Inicial, estado. </span></li>
<li><span style="font-weight: 400;">Debe manejar su clave única.&nbsp;</span></li>
</ul>
<p><strong>Movimientos&nbsp;</strong></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Movimientos debe manejar una entidad.&nbsp;&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Un movimiento tiene: Fecha, tipo movimiento, valor, saldo.&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Debe manejar su clave única.&nbsp;</span></li>
</ul>
<p><span style="font-weight: 400;"><strong>Funcionalidades del API</strong>&nbsp;</span></p>
<p><span style="font-weight: 400;">Los API’s debe tener las siguientes operaciones:&nbsp;</span></p>
<p><strong>F1: </strong><span style="font-weight: 400;">Generación de CRUDS (Crear, editar, actualizar y eliminar registros - Entidades: Cliente,&nbsp; Cuenta y Movimiento).&nbsp;</span></p>
<p><span style="font-weight: 400;">Los nombres de los endpoints a generar son:&nbsp;</span></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">/cuentas&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">/clientes&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">/movimientos&nbsp;</span></li>
</ul>
<p><strong>F2: </strong><span style="font-weight: 400;">Registro de movimientos: al registrar un movimiento en la cuenta se debe tener en cuenta&nbsp; lo siguiente:&nbsp;</span></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Para un movimiento se pueden tener valores positivos o negativos.&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Al realizar un movimiento se debe actualizar el saldo disponible.&nbsp;&nbsp;</span></li>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Se debe llevar el registro de las transacciones realizadas.&nbsp;</span></li>
</ul>
<p><strong>F3: </strong><span style="font-weight: 400;">Registro de movimientos: Al realizar un movimiento el cual no cuente con saldo, debe&nbsp; alertar mediante el siguiente mensaje “Saldo no disponible”&nbsp;</span></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Defina, según su expertise, la mejor manera de capturar y mostrar el error.&nbsp;</span></li>
</ul>
<p><strong>F4: </strong><span style="font-weight: 400;">Reportes: Generar un reporte de “Estado de cuenta” especificando un rango de fechas y&nbsp; cliente.&nbsp;</span></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">Este reporte debe contener:</span></li>
</ul>
<p><span style="font-weight: 400;">o </span><span style="font-weight: 400;">Cuentas asociadas con sus respectivos saldos&nbsp;&nbsp;</span></p>
<p><span style="font-weight: 400;">o </span><span style="font-weight: 400;">Detalle de movimientos de las cuentas&nbsp;&nbsp;</span></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">El endpoint que se debe utilizar para esto debe ser el siguiente:&nbsp;</span></li>
</ul>
<p><span style="font-weight: 400;">o </span><span style="font-weight: 400;">(/reportes?fecha=rango fechas &amp; cliente)&nbsp;</span></p>
<ul>
<li><span style="font-weight: 400;"> </span><span style="font-weight: 400;">El servicio del reporte debe retornar la información en formato JSON&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span></li>
<li><span style="font-weight: 400;">Defina, según su expertise, la mejor manera de solicitar y retornar esta&nbsp; información.&nbsp;</span></li>
</ul>
<p><strong>F5: </strong><span style="font-weight: 400;">Pruebas unitarias: Implementar 1 prueba unitaria para la entidad de dominio Cliente. </span></p>
<p><strong>F6: </strong><span style="font-weight: 400;">Pruebas de Integración: Implementar 1 prueba de integración.&nbsp;</span></p>
<p><strong>F7: </strong><span style="font-weight: 400;">Despliegue de la solución en contenedores.&nbsp;</span></p>
<h3><span style="font-weight: 400;"><strong>Casos de Uso (Ejemplos)</strong>&nbsp;</span></h3>
<ol>
<li><span style="font-weight: 400;"> Creación de Usuarios.&nbsp;</span></li>
</ol>
<table width="684" style="height: 243px;">
<tbody>
<tr>
<td>
<p><strong>Nombres&nbsp;</strong></p>
</td>
<td>
<p><strong>Dirección&nbsp;</strong></p>
</td>
<td>
<p><strong>Teléfono&nbsp;</strong></p>
</td>
<td>
<p><strong>Contraseña estado</strong></p>
</td>
<td>
<p><strong>estado</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">Jose Lema&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Otavalo sn y principal&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">098254785&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">1234&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">Marianela Montalvo&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Amazonas y NNUU&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">097548965&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">5678&nbsp;</span></p>
</td>
<td><span style="font-weight: 400;">True</span></td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">Juan Osorio&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">13 junio y Equinoccial&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">098874587&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">1245&nbsp;</span></p>
</td>
<td><span style="font-weight: 400;">True</span></td>
</tr>
</tbody>
</table>
<br>
<ol start="2">
<li><span style="font-weight: 400;"> Creación de Cuentas de Usuario.&nbsp;&nbsp;</span></li>
</ol>
<table width="664" style="height: 349px;">
<tbody>
<tr>
<td>
<p><strong>Numero Cuenta&nbsp;</strong></p>
</td>
<td>
<p><strong>Tipo&nbsp;</strong></p>
</td>
<td>
<p><strong>Saldo&nbsp;&nbsp;</strong></p>
<p><strong>Inicial&nbsp;</strong></p>
</td>
<td>
<p><strong>Estado&nbsp;</strong></p>
</td>
<td>
<p><strong>Cliente</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">478758&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Ahorros&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">2000&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Jose Lema</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">225487&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Corriente&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">100&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Marianela Montalvo</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">&nbsp;495878</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Ahorros&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">0&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Juan Osorio</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">&nbsp;496825</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Ahorros&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">540&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Marianela Montalvo</span></p>
</td>
</tr>
</tbody>
</table>
<br><br>
<ol start="3">
<li><span style="font-weight: 400;"> Crear una nueva Cuenta Corriente para Jose Lema&nbsp;</span></li>
</ol>
<table width="615" style="height: 171px;">
<tbody>
<tr>
<td>
<p><strong>Numero Cuenta&nbsp;</strong></p>
</td>
<td>
<p><strong>Tipo&nbsp;</strong></p>
</td>
<td>
<p><strong>Saldo&nbsp;&nbsp;</strong></p>
<p><strong>Inicial&nbsp;</strong></p>
</td>
<td>
<p><strong>Estado&nbsp;</strong></p>
</td>
<td>
<p><strong>Cliente</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">585545&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Corriente&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">1000&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Jose Lema</span></p>
</td>
</tr>
</tbody>
</table>
<br><br>
<ol start="4">
<li><span style="font-weight: 400;"> Realizar los siguientes movimientos</span></li>
</ol>
<table width="651" style="height: 369px;">
<tbody>
<tr>
<td>
<p><strong>Numero Cuenta&nbsp;</strong></p>
</td>
<td>
<p><strong>Tipo&nbsp;</strong></p>
</td>
<td>
<p><strong>Saldo&nbsp;&nbsp;</strong></p>
<p><strong>Inicial&nbsp;</strong></p>
</td>
<td>
<p><strong>Estado&nbsp;</strong></p>
</td>
<td>
<p><strong>Movimiento</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">478758&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Ahorros&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">2000&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Retiro de 575</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">225487</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Corriente</span></p>
</td>
<td>
<p><span style="font-weight: 400;">&nbsp;100</span></p>
</td>
<td>
<p><span style="font-weight: 400;"> True</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Deposito de 600</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">495878&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Ahorros&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">0&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Deposito de 150</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">496825&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Ahorros&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">540&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Retiro de 540</span></p>
</td>
</tr>
</tbody>
</table>
<br><br>
<ol start="5">
<li><span style="font-weight: 400;"> Listado de Movimiento, por fechas x usuario.&nbsp;</span></li>
</ol>
<table>
<tbody>
<tr>
<td>
<p><strong>Fecha&nbsp;</strong></p>
</td>
<td>
<p><strong>Cliente</strong></p>
</td>
<td>
<p><strong>Numero&nbsp;&nbsp;</strong></p>
<p><strong>Cuenta&nbsp;</strong></p>
</td>
<td>
<p><strong>Tipo&nbsp;</strong></p>
</td>
<td>
<p><strong>Saldo Inicial&nbsp;</strong></p>
</td>
<td>
<p><strong>Estado&nbsp;</strong></p>
</td>
<td>
<p><strong>Movimiento&nbsp;</strong></p>
</td>
<td>
<p><strong>Saldo&nbsp;&nbsp;</strong></p>
<p><strong>Disponible</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">10/2/2022&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Marianela Montalvo&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">225487&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Corriente&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">100&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">600&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">700</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">8/2/2022&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Marianela Montalvo&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">496825&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Ahorros&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">540&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">True&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">-540&nbsp;</span></p>
</td>
<td>
<p><span style="font-weight: 400;">0</span></p>
</td>
</tr>
</tbody>
</table>
<br><br>
<p><span style="font-weight: 400;">Ejemplo Json:&nbsp;</span></p>
<p><span style="font-weight: 400;">{&nbsp;</span></p>
<p><span style="font-weight: 400;">"Fecha":"10/2/2022",&nbsp;</span></p>
<p><span style="font-weight: 400;">"Cliente":"Marianela Montalvo",&nbsp;</span></p>
<p><span style="font-weight: 400;">"Numero Cuenta":"225487"&nbsp;</span></p>
<p><span style="font-weight: 400;">"Tipo":"Corriente",&nbsp;</span></p>
<p><span style="font-weight: 400;">"Saldo Inicial":100,&nbsp;</span></p>
<p><span style="font-weight: 400;">"Estado":true,&nbsp;</span></p>
<p><span style="font-weight: 400;">"Movimiento":600,&nbsp;</span></p>
<p><span style="font-weight: 400;">"Saldo Disponible":700&nbsp;</span></p>
<p><span style="font-weight: 400;">}&nbsp;</span></p>
<br>
<h3><strong>Instrucciones de despliegue / Entregables</strong></h3>
<ul>
<li>
<h3><strong>Generar el script de base datos, entidades y esquema datos, con el nombre&nbsp; BaseDatos.sql.&nbsp;</strong></h3>
</li>
<li>
<h3><strong>Incluir archivo Json, de Aplicación Postman, para validación de los endpoints. (http://{servidor}:{puerto}/api/{metodo}...{Parámetros})&nbsp;</strong></h3>
</li>
<li>
<h3><strong>En el caso de usar Karate (Si aplicaste para una posición con Java):Incluir el set de pruebas en el proyecto JAVA, garantizando que se ejecuten junto a todos los tests.</strong></h3>
</li>
</ul>
<ul>
<li><span style="font-weight: 400;"> </span>
<h3><strong>Crear un repositorio público en Github con todos los archivos generados y colocar la URL al repositorio en los comentarios de este ejercicio.</strong></h3>
</li>
<li>
<h3><strong>Adicional, Subir un .zip o .rar con todos los archivos generados.</strong></h3>
</li>
</ul>
</div>
<p><span style="font-weight: 400;">&nbsp;</span></p>
<p><span style="font-weight: 400;">&nbsp;¡</span><span style="font-weight: 400;">Muchos éxitos en su prueba!<br></span></p></div></div>