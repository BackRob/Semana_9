# Semana_9

Proyecto desarrollado en **Java** utilizando **Maven** y **Swing**, enfocado en la gestión de clientes, guías, vehículos, tours y reservas para una agencia turística.

---

## 📑 Tabla de Contenidos

1. #descripción
2. #características-principales
3. #casos-de-uso
4. #tecnologías-utilizadas
5. #inicio-rápido
6. [Estructura-del-proyecto
7. #autores

---

## 📝 Descripción

**Semana_9** es una aplicación de escritorio desarrollada en Java que permite administrar los recursos necesarios para una agencia de turismo.

El sistema permite:

- Registrar clientes.
- Registrar guías turísticos.
- Registrar vehículos.
- Registrar tours.
- Crear reservas.
- Controlar la disponibilidad de recursos según la fecha seleccionada.
- Aplicar reglas de negocio para validar reservas.

La aplicación utiliza una interfaz gráfica construida con Swing y una arquitectura basada en Programación Orientada a Objetos.

---

## ✨ Características Principales

### 👤 Gestión de Clientes

- Registro de clientes.
- Búsqueda por RUT.
- Prevención de clientes duplicados.
- Control de disponibilidad por fecha.

### 🧭 Gestión de Guías

- Registro de guías turísticos.
- Búsqueda por RUT.
- Control automática de disponibilidad.
- Validación de cantidad mínima de guías por reserva.

### 🚗 Gestión de Vehículos

- Registro de vehículos.
- Búsqueda por patente.
- Disponibilidad por fecha.
- Control de capacidad máxima de pasajeros.

### 🏕️ Gestión de Tours

- Registro de tours.
- Búsqueda por nombre.
- Asociación de múltiples tours a una reserva.
- Prevención de tours duplicados dentro de una reserva.

### 📅 Gestión de Reservas

- Creación de reservas por fecha.
- Asociación de clientes, guías, vehículos y tours.
- Visualización completa de reservas registradas.

---

## 📋 Reglas de Negocio

### Clientes

- Una reserva debe contener al menos un cliente.
- Un cliente no puede estar asignado a más de una reserva en la misma fecha.

### Tours

- Toda reserva debe contener al menos un tour.

### Vehículos

- Son opcionales.
- Si se utilizan vehículos, la capacidad total debe ser suficiente para todos los clientes registrados en la reserva.

### Guías

- Si la reserva no posee vehículos, debe existir al menos un guía.
- Si la reserva posee vehículos, debe existir al menos un guía por cada vehículo registrado.

---

## 🎯 Casos de Uso

- Administración de clientes para una agencia turística.
- Gestión de vehículos y guías disponibles.
- Creación y planificación de reservas.
- Simulación de asignación de recursos turísticos.
- Práctica de conceptos de Programación Orientada a Objetos y Java Swing.

---

## 🛠️ Tecnologías Utilizadas

- Java 23
- Maven
- Swing
- IntelliJ IDEA
- Programación Orientada a Objetos
- Manejo de Excepciones Personalizadas

---

## ⚡ Inicio Rápido

### Clonar el repositorio

```bash
git clone https://github.com/BackRob/Semana_9.git
```

### Entrar al proyecto

```bash
cd Semana_9
```

### Compilar con Maven

```bash
mvn install
```

### Ejecutar la aplicación

Ejecutar la clase:

```text
app.main
```

---

## 📁 Estructura del Proyecto

```text
.
├── pom.xml
└── src
    └── main
        └── java
            ├── Exceptions
            │   ├── DatosDuplicados.java
            │   ├── DuracionInvalida.java
            │   ├── ListaVaciaException.java
            │   ├── NoExisteCoincidencia.java
            │   └── RecursoNoDisponible.java
            │
            ├── app
            │   └── main.java
            │
            ├── iu
            │   ├── TipoVentana.java
            │   ├── VentanaPrincipal.java
            │   └── VentanaSecundaria.java
            │
            ├── model
            │   ├── Cliente.java
            │   ├── Guia.java
            │   ├── IRegistrable.java
            │   ├── Persona.java
            │   ├── Reserva.java
            │   ├── Tour.java
            │   └── Vehiculo.java
            │
            └── util
                ├── GestorDatos.java
                └── TipoDato.java
```

---

## 👨‍💻 Autor

**Brian Vallejos**

Proyecto desarrollado como parte de la Semana 9 del curso de Programación Orientada a Objetos en Java.