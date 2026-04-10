![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![iOS](https://img.shields.io/badge/iOS-000000?style=for-the-badge&logo=ios&logoColor=white)
![JVM](https://img.shields.io/badge/JVM-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-Hexagonal-00F2FF?style=for-the-badge)
![UI](https://img.shields.io/badge/UI-Compose%20Multiplatform-blueviolet?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)
![Engine](https://img.shields.io/badge/Engine-Custom%20Recursive%20Parser-orange?style=for-the-badge)
# 🦅 💻 Raven-Calculator v0.9
**Calculadora multipropósito desarrollada en Kotlin Multiplatform y Compose Multiplatform**

Raven-Calculator busca  ofrecer una amplia variedad de herramientas de cálculo matemático y disponibilidad

## 🛠️ Arquitectura y Stack Técnico
El proyecto sigue los principios de **Clean Architecture** (Arquitectura Hexagonal) para garantizar que la lógica de negocio sea independiente de la interfaz y de agentes externos.

* **Core Engine**: Analizador sintáctico por **Descenso Recursivo** desarrollado desde cero (evitando dependencias externas).
* **UI Framework**: Compose Multiplatform para una interfaz nativa en Android y Desktop (JVM).
* **Design System**: Sistema de temas dinámico basado en la paleta técnica propia "Raven" (Dark/Light).
* **Patrón de UI**: MVVM (Model-View-ViewModel) con estados reactivos.

## 🚀 Características V0.9
- **Modo Estándar/Científico**: Evaluación de expresiones complejas con precedencia de operadores y funciones trigonométricas.
- **Modo Geométrico**: Cálculo reactivo de áreas y perímetros con validación de datos en tiempo real y ayudas visuales vectoriales.

## 📱 Soporte Multiplataforma (Targets)
Gracias al uso de **Kotlin Multiplatform**, Raven-Calculator compila de forma nativa para:
- **Desktop (JVM)**: Probado en entornos Linux.
- **Android**: Compatible con API 24 en adelante.
- **iOS**: Aplicación nativa gracias a el motor de renderizado de Compose para una experiencia fluida en iPhone.

## 🏗️ Estructura del Proyecto
```text
composeApp/
├── commonMain/
│   ├── kotlin/.../application/      # Casos de Uso (Orquestación)
│   ├── kotlin/.../domain/           # Lógica pura, modelos y servicios
│   └── kotlin/.../infrastructure/   # Adaptadores de UI, Temas y Componentes
```

## ☕ Soporte y Contribución

Este proyecto es de código abierto. Si encuentras útil esta herramienta o la arquitectura implementada:

* Contribuye: Siéntete libre de hacer un Fork y proponer mejoras vía Pull Request.
* Proximas Fases: Graficación, Bases de Datos, Modo Desarrollo

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Puedes usar, copiar y modificar el software para cualquier propósito, siempre que incluyas el aviso de copyright original. 
**El software se proporciona "tal cual", sin garantías de ningún tipo.**

#### Copyright (c) 2026 Alejandro González Hernández
