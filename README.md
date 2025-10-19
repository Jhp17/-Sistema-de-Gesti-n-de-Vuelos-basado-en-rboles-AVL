
# ✈️ Sistema de Gestión de Vuelos con Árbol AVL

## 🧑‍💻 Integrantes
* **José Pérez**
* **Juan Noble**
* **Jhon Bayrón Oyola**

**Programa:** Ingeniería de Sistemas
**Institución:** Corporación Universitaria Remington
**Materia:** Estructuras de Datos
**Docente:** Leli 
**Fecha:** Octubre de 2025

---

## 🎯 Descripción del Proyecto

Este proyecto implementa un **Sistema de Gestión de Vuelos** en Java, utilizando la estructura de datos **Árbol AVL**.

El objetivo principal es almacenar, organizar y buscar información de vuelos de manera eficiente, garantizando que el árbol se mantenga **balanceado automáticamente** tras cada inserción o eliminación.

### Atributos del Vuelo
Cada nodo del árbol representa un vuelo con los siguientes atributos:
* **Número de Vuelo** ✈️ (Clave de búsqueda principal)
* **Origen** 🛫
* **Destino** 🛬
* **Hora de Salida** 🕒
* **Aerolínea** 🏢

### Funcionalidades del Sistema
El sistema permite:
1.  Registrar nuevos vuelos.
2.  Buscar vuelos por número o destino.
3.  Mostrar los recorridos del árbol en orden **Inorden**, **Preorden** y **Postorden**.
4.  Visualizar mensajes de **balanceo automático** y las rotaciones realizadas.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java
* **Entorno de Desarrollo:** NetBeans
* **Estructura de Datos:** Árbol AVL
* **Paradigma:** Programación Orientada a Objetos (POO)

---

## ⚙️ Funcionamiento y Demostración

El programa inicia insertando automáticamente **cinco vuelos de ejemplo** para demostrar cómo el árbol **mantiene su balance** después de cada operación.

**Ejemplo de Salida en Consola:**


✈️ Insertando vuelo 301 | Bogotá → Medellín | 08:30 | Avianca
⚠️ Desbalance detectado (Izquierda-Derecha)
🔄 Rotación izquierda en nodo 301
🔄 Rotación derecha en nodo 210

Esto indica que el sistema realiza las **rotaciones necesarias** (simples o dobles) para mantener el equilibrio del árbol. El usuario puede registrar más vuelos o realizar búsquedas desde el menú interactivo.

---

## ✨ Conclusiones

* Los **Árboles AVL** garantizan un **rendimiento óptimo** en la búsqueda, inserción y eliminación de datos.
* La implementación de esta estructura permitió comprender cómo las **rotaciones simples y dobles** son esenciales para mantener el árbol equilibrado.
* Este proyecto demuestra la importancia de las **estructuras de datos dinámicas y autoajustables** en la programación de sistemas que manejan grandes volúmenes de información.

---

## 🎬 Video Explicativo

Puedes ver la presentación y demostración del proyecto completo en el siguiente enlace:

[Ver video en YouTube](https://youtu.be/-kHw6QfTrD4?si=g4B-vFI4Qxt4qipl)

---

## 📁 Estructura del Proyecto


📦 ProyectoAVL
┣ 📂 src/
┃ ┣ 📜 Main.java      # Clase principal con el menú interactivo
┃ ┣ 📜 AVLTree.java   # Implementación del Árbol AVL y sus rotaciones
┃ ┗ 📜 Vuelo.java     # Clase modelo para el objeto Vuelo
┣ 📜 README.md
┗ 📜 .gitignore

---

## 🚀 Uso del Proyecto

1.  Clonar o descargar el repositorio.
2.  Abrir el proyecto en su IDE preferido (NetBeans).
3.  Ejecutar la clase principal `Main.java`.
4.  Observar en la consola la inserción inicial de vuelos, los balanceos y los recorridos.
5.  Probar las opciones de búsqueda y registro de nuevos vuelos desde el menú interactivo.

---

## 🧑‍💻 Créditos

Proyecto desarrollado por estudiantes de **Ingeniería de Sistemas** de la Corporación Universitaria Remington – 2025.

