Consigna:

Deberá implementarse la funcionalidad básica de una agenda:
- Se podrán almacenar datos sobre personas como también datos sobre empresas y los contactos de esta.
- Al agregar un contacto a la empresa, este debe haber sido anteriormente agregado a la agenda. 
- Una empresa podría tener varios contactos.
- Debe implementarse distintos tipos de buscadores de personas, por ejemplo buscar por nombre, o por ciudad.
- Agregar un buscador que permita encontrar personas en varias ciudades, por ejemplo todos los 'Juan Pérez' de 'Buenos Aires' y 'Córdoba'.
- La agenda tendrá que implementar el manejo de excepciones correctamente.
- Deberá diseñarse un Diagrama de Entidad Relación para la solución.
- Deberá ejecutarse por consola y se almacenarán los datos en memoria.

Implementación:

- Se implemento una agenda en Java nativo utilizando Hibernate con H2.
- Se añadió la librería Lombok.
- Se utilizó Maven como gestor de dependencias de este proyecto.
- Se realizaron dos excepciones "NotFoundException" y "UniqueNumberException" para manejar causas de errores particulares de esta implementación.
- Para utilizar la agenda correr el método main y utilizar por consola.

Menu:
-
![menu](https://i.gyazo.com/d2069b45a06139a451cc20f06b6620a6.png "menu")

addPerson:<br/>
![addPerson](https://i.gyazo.com/2be94b639ff7ed2dafbcfada3ab9b220.png "addPerson")

Filter by city:
![filter](https://i.gyazo.com/18e5e3eddd1169b1cb00ce05d18e97d4.png "filter")
