# AUTOMATIZACIÓN DE PRUEBAS FUNCIONALES BOOKING.COM

### 📄 Contexto:

Booking.com es un agregador de tarifas de viaje y un metabuscador de viajes para reservas de
alojamiento. Booking.com forma parte de Booking Holdings Inc., y cuenta con más de 17.000 trabajadores
en 198 oficinas de 70 países de todo el mundo. Booking.com tiene su sede en Ámsterdam, Países Bajos.

### 🚩 Problemática:

Cada vez que se hacen cambios en la aplicación móvil de Booking.com se deben efectuar todo un conjunto
de pruebas manuales de los casos de prueba ya diseñados en sus Test Suite, con el objetivo de verificar
que ninguna funcionalidad disponible para los usuarios haya sido alterada o impactada por los nuevos
cambios implementados y desplegados en producción.

### 💡 Propuesta:

Para mejorar la rapidez y asegurar que la aplicación móvil funcione correctamente 
tras hacerle modificaciones, se propone implementar conjuntos de pruebas automatizadas
enfocadas en la interfaz y las funcionalidades que esta ofrece. 
Esto permite realizar pruebas de manera frecuente y rápida, facilitando la detección de la mayoría de los errores 
durante la etapa de desarrollo.

***

# ✅ PLAN DE PRUEBAS FUNCIONAL

### RESUMEN

> **FEATURE TEST PLAN**: Booking | Accommodation Service | Flujo E2E para la creación de una reserva de alojamiento en
> la app de booking.com
>
>*Como usuario de booking,  
Quiero realizar una reserva de alojamiento en el aplicativo  
Para agendar un lugar donde hospedarme en mi próximo viaje*

* Este Plan se llevará a cabo a nivel de **Pruebas funcionales y Pruebas de Regresión**.
* Este Plan se llevará a cabo con **Appium** para la automatizacion, **cucumber** como herramienta de desarrollo BDD y **Java** como lenguaje de programación
* Este Plan se realizará para determinar **qué pruebas se harán** y **cómo se realizarán las pruebas.**

### OBJETIVO

Validar las funcionalidades básicas que puede realizar un usuario al realizar la creación de una reserva de alojamiento,
usando Appium para automatizar el proceso y el lenguaje Gherkin para la escritura de los escenarios de prueba.

### SUPUESTOS

* La app se encuentra siempre en funcionamiento.
* Acceso a la apk de la aplicación.
* Herramientas de pruebas como AndroidStudio, Appium Server y Appium Desktop correctamente instalados y configurados.
* Conocimientos en Mobile Testing.

### COBERTURA

* Posibilidad de acceder y probar la función de reserva en un servicio de hospedaje.
* Aunque se enfocará en esto, se permiten pruebas extra si ofrecen beneficios para comprobar otras capacidades.
* Adherirse a las directrices empresariales relacionadas con las reservas de alojamiento en la aplicación.
* Incluir al menos una trayectoria de éxito (HAPPY PATH) y una de fallo (UNHAPPY PATH).
* Los escenarios fuera de los flujos establecidos para prueba no serán objeto de validación.

### RIESGOS

| Riesgo                                                    | Mitigación                                                                                                             |
|:----------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| No tener acceso a la apk del aplicativo                   | Solicitar al dev el envío de la apk.                                                                                   |
| No se tiene un dispositivo mobile real para pruebas       | Utilizar un emulador para la conexión.                                                                                 |
| No se puede realizar la conexión con el dispositivo       | Utilizar una plataforma de testeo móvil como (BrowserStack, Lambda Test, etc                                           |
| No se puede inspeccionar el dispositivo por 'secure' flag | Imprimir el Código Fuente de la pantalla con el comando **driver.getPageSource()** y realice la inspección con este código |

***

### RECURSOS

* **Android Studio**: como herramienta de apoyo para emular un dispositivo mobile.
* **Appium Server**: como herramienta para crear una sesión que permita interactuar con los dispositivos finales de las aplicaciones móviles.
* **Uiautomatorviewer** : para la inspección y localización de elementos
* **Plan de pruebas**: Documento para la planificación de las pruebas.
* **APK**: Link de descarga del apk de [Booking.com](https://drive.google.com/file/d/1ruY_5qcqWlsE3-W3rgXpFyyMiO59wFUc/view?usp=sharing)

### CONFIGURACIÓN DEL AMBIENTE

* Las pruebas serán ejecutadas en un dispositivo **Android**.
* El dispositivo móvil será emulado desde **Android Studio**


### CONSIDERACIONES DE LAS PRUEBAS

- [ ] Para el destino buscar la Ciudad de CUSCO. 
- [ ] Para las fechas de estadía seleccionar desde el 14/02 al 28/02 del 2024. 
- [ ] Seleccionar 1 habitación, 2 adultos y 1 niño de 5 años.
- [ ] Seleccionar el item 2 de los resultados de la búsqueda, elegir la habitación y reservar la primera opción.
- [ ] Elegir forma de pago tarjeta de crédito.
- [ ] Validar en todos los pasos posibles el costo de la reserva.
- [ ] Automatizar las funcionalidades del flujo completo de la reserva.
- [ ] Considerar la creación de escenarios Happy Paths y UnHappy Paths.
- [ ] Considerar en la automatización todas las aserciones posibles.

### FLUJOS A PROBAR (dentro de alcance)

Test diseñados para validar los escenarios **Happy Paths** 😃
***
> **✨ FEATURE**: Accommodation Reserve | Creación de un servicio completo de alojamiento
> - [x] Validate entry data for the accommodation search
>
> - [x] Validate selection of accommodation results
>
> - [x] Validate the customer information form
>
> - [x] Validate the payment method and finalize the reservation
***
Test diseñados para validar los escenarios **UNHappy Paths** 🤡

> **✨ FEATURE**: UnHappy Paths | Accommodation without selecting destination
> - [x] Validate that it is not possible to make a reservation without entering a destination
***

### CRITERIOS DE SALIDA
> ✅ Las pruebas han terminado y no hay defectos funcionales  
> ✅ Todos los defectos restantes tienen una severidad baja

### ENTEGRABLES DE PRUEBAS

> ☑️ El plan de pruebas actual, la ruta de su ubicación es: `resources/Deliverables/plan_de_pruebas.markdown`  
> ☑️ El informe del resultado de pruebas, la ruta de su ubicación es: `target/`   
> ☑️ El repositorio en GitHub: [test_automation_mobile_booking](https://github.com/FranceCastillo/test_automation_mobile_booking)
***

### ❗ INFORMACIÓN ADICIONAL

> *Considerar que si las pruebas se ejecutan luego del 14/02/2024 se debe cambiar las fechas de check-in y check-out ya que, no se pueden realizar la busqueda con fechas del pasado*
> > *Toda la información relacionada a la estructura del proyecto e instalacion se especifica en el archivo README.md*
***